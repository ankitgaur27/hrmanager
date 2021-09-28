package com.nagarro.hrmanager.controller;


import static com.nagarro.hrmanager.model.HibernateConfig.*; 

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.NameConstants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;
import com.nagarro.hrmanager.data.Manager;
import com.oracle.wls.shaded.org.apache.bcel.classfile.Constant;

import net.bytebuddy.asm.Advice.This;
import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

/**
 * <p>This class is controller for forgot password</p>
 * @author ankitgaur
 *
 */

@Controller
public class ForgotPasswordController {

	/**
	 * This function return the Model data and Views(JSP);
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping("/forgotPassword")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model m) {
		
		if(request.getParameter(Constants.PASSWORD)==null) {
			request.getSession().setAttribute( Constants.ERROR,Constants.ENTER_NEW_PASSWORD);
			return new ModelAndView(ViewsNameConsts.FORGOT_PASSWORD);
		}
		
		String password = String.valueOf(request.getParameter(Constants.PASSWORD));
		String confirmPassword = String.valueOf(request.getParameter(Constants.CONFIRM_PASSWORD));
		
		String username = String.valueOf(request.getSession().getAttribute("username"));
		
		
		List<Manager> result =  session.createQuery("FROM Manager where username='"+username+"'").list();
		 
		//Password is not same
		if(!password.equals(confirmPassword)) {
			request.getSession().setAttribute(Constants.ERROR , Constants.FORGOT_PASSWORD_MESSAGE_VALUE);
			return new ModelAndView(ViewsNameConsts.FORGOT_PASSWORD);
		}
		
		//Password is same
		else {
			 Transaction transaction = session.beginTransaction();
			 Manager user = session.find(Manager.class, result.get(0).getId());
			 user.setPassword(confirmPassword);
		     session.update(user);
		     transaction.commit();
		     request.getSession().removeAttribute(Constants.ERROR); 
		     return new ModelAndView("home");
		}
	}

}
