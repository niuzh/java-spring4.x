package com.smart.chapter3.web;

import com.smart.chapter3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆业务
 * @author niu 2018-09-04
 */
@RestController //spring mvc提供
@EnableAutoConfiguration //boot提供
public class BbsDaemon {
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
}
