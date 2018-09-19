package com.smart.chapter3.service;

import com.smart.chapter3.dao.LoginLogDao;
import com.smart.chapter3.dao.UserDao;
import com.smart.chapter3.domain.LoginLog;
import com.smart.chapter3.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author niu 2018-09-03
 */
@Service // 标注服务bean
public class UserService {
	// 导入DAO bean
	@Autowired
	private UserDao userDao;
	@Autowired
	private LoginLogDao loginLogDao;

	public boolean hasMatchUser(String userName, String password) {
		int match = userDao.getMatchCount(userName, password);
		return match > 0;
	}

	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}

	@Transactional // 标注事务注解，让方法运行在事务中
	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
}
