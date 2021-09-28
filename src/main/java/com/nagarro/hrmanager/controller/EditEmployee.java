package com.nagarro.hrmanager.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;
import com.nagarro.hrmanager.data.Employee;
import com.nagarro.hrmanager.services.EmployeeServices;


/**
 * This class is is used to edit the existing employees.
 * @author ankitgaur
 *
 */
@Controller
public class EditEmployee {

		/**
		 * This is mapped with the edit button on the list
		 * @param request
		 * @param response
		 * @param m
		 * @return
		 * @throws ParseException
		 */
	   @RequestMapping("/editEmployee")  
	   public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model m) throws ParseException { 
		 
		 
		String employeeId = request.getParameter(Constants.CODE).toString();
		request.getSession().setAttribute(Constants.EMPLOYEE_ID, employeeId);
		List<Employee> list = EmployeeServices.getAllEmployees();
		
		Employee employee = new Employee();
		
		for(Employee emp:list) {
			if(emp.getEmployeeId() == Integer.parseInt(employeeId)) {
				employee = emp;
				break;
			}
		}
		request.getSession().setAttribute(Constants.NAME, employee.getEmployeeName());
		request.getSession().setAttribute(Constants.LOCATION, employee.getLocation());
		request.getSession().setAttribute(Constants.EMAIL, employee.getEmployeeEmail());
		request.getSession().setAttribute(Constants.DOB, EmployeeServices.convertDatetoSqlFormat(employee.getDateOfBirth())); 
		System.out.println( EmployeeServices.convertDatetoSqlFormat(employee.getDateOfBirth()));
		System.out.println(employee);
		
		return new ModelAndView(ViewsNameConsts.EDIT_EMPLOYEES_DATA);
	}
}
