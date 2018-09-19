/**
 * 
 */
package com.smart.chapter3.dao;

import com.smart.chapter3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 访问User的DAO
 * 
 * @author niu 2018-08-31
 */
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final static String match_count_sql = "select count(*) from t_user where user_name=? and password=?";
	private final static String update_login_info_sql = " update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";

	public int getMatchCount(String userName, String password) {
		return jdbcTemplate.queryForObject(match_count_sql, new Object[] { userName, password }, Integer.class);
	}

	public User findUserByUserName(final String userName) {
		String sqlStr = " SELECT user_id,user_name,credits " + " FROM t_user WHERE user_name =? ";
		final User user = new User();
		jdbcTemplate.query(sqlStr, new Object[] { userName }, new RowCallbackHandler() {

			public void processRow(ResultSet rs) throws SQLException {
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(userName);
				user.setCredits(rs.getInt("credits"));
			}
		});
		return user;
	}

	public void updateLoginInfo(User user) {
		jdbcTemplate.update(update_login_info_sql,
				new Object[] { user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId() });
	}
}
