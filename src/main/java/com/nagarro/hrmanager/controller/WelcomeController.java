package com.nagarro.hrmanager.controller;

import static com.nagarro.hrmanager.model.HibernateConfig.session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;

import org.hibernate.internal.build.AllowSysOut;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.asm.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;
import com.nagarro.hrmanager.data.Employee;
import com.nagarro.hrmanager.data.Manager;
import com.nagarro.hrmanager.services.EmployeeServices;

/**
 * <p>
 * This class is controller for Welcome when user successfully signed in
 * </p>
 * 
 * @author ankitgaur
 *
 */
@Controller
public class WelcomeController {

	/**
	 * This function return the Model data and Views(JSP);
	 * 
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping("/employeeList")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {

		if (request.getSession().getAttribute(Constants.CANCEL) != null) { 
			request.getSession().removeAttribute(Constants.CANCEL);
			return new ModelAndView(ViewsNameConsts.EMPLOYEE_LIST);
		}

		String username = String.valueOf(request.getParameter("username"));
		String password = String.valueOf(request.getParameter(Constants.PASSWORD));
		String email = String.valueOf(request.getParameter(Constants.EMAIL));
		request.getSession().setAttribute("username", username);
		List<Manager> result = session.createQuery("FROM Manager where username='" + username + "'").list();

		// User is not Present in DATABASE
		if (result == null || result.size() == 0) {
			request.getSession().setAttribute(Constants.ERROR, Constants.USER_IS_NOT_PRESENT);
			return new ModelAndView(ViewsNameConsts.HOME);
		}
		// User is present but password is wrong
		else if (!result.get(0).getPassword().equals(password)) {
			request.getSession().setAttribute(Constants.ERROR, Constants.PASSWORD_INCORRECT_MESSAGE);
			return new ModelAndView(ViewsNameConsts.HOME);
		}
		// Username and password is correct it will redirect to Employee List page
		else {
			request.getSession().removeAttribute(Constants.ERROR);
			
			List<Employee> list = EmployeeServices.getAllEmployees();
			request.getSession().setAttribute("list", list);
			return new ModelAndView(ViewsNameConsts.EMPLOYEE_LIST);
		}
	}

}
