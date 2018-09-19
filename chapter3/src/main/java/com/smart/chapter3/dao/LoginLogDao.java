/**
 * 
 */
package com.smart.chapter3.dao;

import com.smart.chapter3.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 记录用户登陆日志
 * 
 * @author niu 2018-08-31
 */
@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// 保存登陆日志SQL
	private final static String INSERT_LOGIN_LOG_SQL = "INSERT INTO t_login_log(user_id,ip,login_datetime) VALUES(?,?,?)";

	public void insertLoginLog(LoginLog loginLog) {
		Object[] args = { loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate() };
		jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
	}
}
