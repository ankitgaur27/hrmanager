package com.nagarro.hrmanager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;

/**
 * This controller is user for logout
 * @author ankitgaur
 *
 */
@Controller
public class Logout {	
	@RequestMapping("/logout")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model m) { 
		request.getSession().removeAttribute("username");
		request.getSession().invalidate();
		return new ModelAndView(ViewsNameConsts.HOME);
	}
}
