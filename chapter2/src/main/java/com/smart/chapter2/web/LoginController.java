package com.smart.chapter2.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smart.chapter2.command.LoginCommand;
import com.smart.chapter2.domain.User;
import com.smart.chapter2.service.UserService;

/**
 * 登陆业务
 * @author niu 2018-09-04
 */
@Controller // 标注类为SpringMVC控制器
public class LoginController {
	@Autowired
	private UserService userService;

	/**
	 * 登陆页面
	 * @return
	 */
	@RequestMapping(value = {"/index","/"})
	public ModelAndView loginPage(HttpServletRequest request) {
		if(request.getSession().getAttribute("user")==null) {
			return new ModelAndView("login");
		}else {
			return new ModelAndView("main");
		}
	}

	/**
	 * 登陆检查页面
	 * @param request
	 * @param loginCommand
	 * @return
	 */
	@RequestMapping(value = "/loginCheck")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
		boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误。");
		} else {
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}
