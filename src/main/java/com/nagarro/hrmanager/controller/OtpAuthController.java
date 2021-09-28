package com.nagarro.hrmanager.controller;


import static com.nagarro.hrmanager.model.HibernateConfig.connectionSetup;
import static com.nagarro.hrmanager.model.HibernateConfig.session;

import java.util.List;
import com.nagarro.hrmanager.email.Email;
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

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;


/**
 * <p>This class is controller for OTP send</p>
 * @author ankitgaur
 *
 */
@Controller
public class OtpAuthController {

	
	/**
	 * This function return the Model data and Views(JSP);
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping("/otpAuth")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model m  ) {
			
		  if(request.getParameter("username")==null) {
			  request.getSession().setAttribute( Constants.ERROR ,"Otp will be send on registered email ID");
			  return new ModelAndView("otpAuth");
		  }
		
		  String userName=String.valueOf(request.getParameter("username"));  
		  
	      
		  if(!session.isConnected()) {
			  connectionSetup();
		  }
		  
		  List<Manager> result = session.createQuery("FROM Manager where username='" + userName + "'").list();
	      
	      if(result.size()==0) {
	    	  return new ModelAndView("otpAuth" , Constants.ERROR,Constants.USER_IS_NOT_PRESENT); 
	      }
	      else {
	    	  	Transaction transaction = session.beginTransaction();
				Manager student = session.find(Manager.class, result.get(0).getId());
				int otp = randomNumberOTP();
				student.setOtp(otp);
				session.update(student);
				transaction.commit();

				String emailID = String.valueOf(result.get(0).getEmail());

				Email.sendEmail(emailID, otp);
				request.getSession().setAttribute("username",userName);
				request.getSession().setAttribute(Constants.ERROR,Constants.OTP_SENT);
	    	  return new ModelAndView(ViewsNameConsts.OTP_VERIFY); 
	      }
	      
	}
	private int randomNumberOTP() {
		int min = 10000;
		int max = 99999;
		int otp = (int) (Math.random() * (max - min + 1) + min);
		return otp;
	}

}
