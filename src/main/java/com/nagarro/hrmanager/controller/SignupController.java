package com.nagarro.hrmanager.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.*;
import com.nagarro.hrmanager.data.*; 

import static com.nagarro.hrmanager.model.HibernateConfig.*; 

import java.util.List; 


/**
 * <p>This class is controller for Signup for new user</p>
 * @author ankitgaur
 *
 */
@Controller
public class SignupController {


	/**
	 * This function return the Model data and Views(JSP);
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping("/signup")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
			
		connectionSetup();
		
		String username = String.valueOf(request.getParameter("username"));
		String password = String.valueOf(request.getParameter(Constants.PASSWORD));
		String email = String.valueOf(request.getParameter(Constants.EMAIL));
		
		
		
		if(request.getParameter("username") == null ) { 
			 return new ModelAndView("signup", "error", "Enter details");
		}
//
		List<Manager> result = session.createQuery("FROM Manager where username='" + username + "'").list();
		 
		if(username!=null && result.size()==0) {
			Transaction transaction = session.beginTransaction(); 
			Manager user = new Manager();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);

			session.save(user);
			
			transaction.commit(); 
			  
		    return new ModelAndView("home",  "message", "signup successfuly");
		}
		else {
			return new ModelAndView("signup", Constants.ERROR, Constants.USERNAME_ALREADY_TAKEN);
		}
	}

}
