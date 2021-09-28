package com.nagarro.hrmanager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;
import com.nagarro.hrmanager.data.Employee;
import com.nagarro.hrmanager.services.EmployeeServices;

/**
 * This is Controller Class, is used to add a new Employee
 * @author ankitgaur
 *
 */

@Controller
public class AddEmployeeForm {

	/**
	 * This invokes when form action sends to addEmployeeForm
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping("/addEmployeeForm")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model m) { 
		
		if(request.getParameter(Constants.NAME) == null) { 
			return new ModelAndView(ViewsNameConsts.ADD_EMPLOYEE_FORM);
		}
		else{ 
			Employee employee = new Employee();
			
			String name = String.valueOf(request.getParameter(Constants.NAME));
			String dateOfBirth = String.valueOf(request.getParameter(Constants.DATE));
			String location = String.valueOf(request.getParameter(Constants.LOCATION));
			String email = String.valueOf(request.getParameter(Constants.EMAIL));
			
			employee.setDateOfBirth(dateOfBirth);
			employee.setEmployeeName(name);
			employee.setEmployeeEmail(email);
			employee.setLocation(location);
			RestTemplate rr = new RestTemplate();
			ResponseEntity<Employee> createResponse = rr.postForEntity("http://localhost:8090/employees", employee, Employee.class);
			if(createResponse.getStatusCodeValue() == 200) {  
				List<Employee> list = EmployeeServices.getAllEmployees();
				request.getSession().setAttribute(Constants.LIST, list); 
				return new ModelAndView(ViewsNameConsts.EMPLOYEE_LIST);
			}
			else {
				return new ModelAndView(ViewsNameConsts.ADD_EMPLOYEE_FORM);
			}
		} 
		
	}
}
