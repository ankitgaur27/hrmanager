package com.nagarro.hrmanager.controller;


import static com.nagarro.hrmanager.model.HibernateConfig.connectionSetup;
import static com.nagarro.hrmanager.model.HibernateConfig.session;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;
import com.nagarro.hrmanager.data.Manager;
import com.nagarro.hrmanager.email.Email;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;


/**
 * <p>This class is controller for OTP verify</p>
 * @author ankitgaur
 *
 */
@Controller
public class OtpController {

int s=10;
	
/**
 * This function return the Model data and Views(JSP);
 * @param request
 * @param response
 * @param m
 * @return
 */
	@RequestMapping("/otpVerify")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model m) {
			
		if(request.getParameter(Constants.OTP)==null) {
			request.getSession().setAttribute(Constants.ERROR ,Constants.ENTER_CORRECT_OTP);
			  return new ModelAndView(ViewsNameConsts.OTP_VERIFY); 
		  }
		
		  int otp=Integer.parseInt(request.getParameter(Constants.OTP));  
		  
		  String username  = String.valueOf(request.getSession().getAttribute("username"));
	      
		  if(!session.isConnected()) {
			  connectionSetup();
		  }
		  
		  
		  List<Manager> result = session.createQuery("FROM Manager where username='" + username + "'").list();
	      
	       if(result.get(0).getOtp() == otp) { 
	    	   request.getSession().removeAttribute(Constants.ERROR);
	    	  return new ModelAndView(ViewsNameConsts.FORGOT_PASSWORD);
	       }
	       else {
	    	   request.getSession().setAttribute(Constants.ERROR ,Constants.ENTER_CORRECT_OTP);
	    	   return new ModelAndView(ViewsNameConsts.OTP_VERIFY); 
	       }
	}

}
