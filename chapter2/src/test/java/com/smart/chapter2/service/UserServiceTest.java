package com.smart.chapter2.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.smart.chapter2.domain.User;
import com.smart.chapter2.service.UserService;

/**
 * TestNG单元测试框架
 * @author niu 2018-09-03
 */
@ContextConfiguration("classpath*:/smart-context.xml") // 启动Spring容器
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {
	@Autowired
	private UserService userService;

	@Test
	public void hasMatchUer() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "1111");
		assertTrue(b1);
		assertTrue(!b2);
	}

	@Test
	public void findUserByUserName() {
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(), "admin");
	}

	// testng 单元测试会自动回滚，不会保存数据
	@Test
	// @Rollback(false) 测试完毕事务是否回滚，默认回滚
	public void testAddLoginLog() {
		User user = userService.findUserByUserName("admin");
		user.setUserId(1);
		user.setUserName("admin");
		user.setLastIp("192.168.12.7");
		user.setLastVisit(new Date());
		userService.loginSuccess(user);
	}
}
