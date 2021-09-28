package com.nagarro.hrmanager.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.constants.ViewsNameConsts;
import com.nagarro.hrmanager.data.Employee;
import com.nagarro.hrmanager.services.EmployeeServices;

/**
 * This class is used to save the edited existing data
 * 
 * @author ankitgaur
 *
 */
@Controller
public class SaveEdittedEmployeeData {

	@RequestMapping("/saveEdittedEmployeeData")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model m) {

		Employee employee = new Employee();

		String name = String.valueOf(request.getParameter(Constants.NAME));
		String dateOfBirth = String.valueOf(request.getParameter(Constants.DATE));
		String location = String.valueOf(request.getParameter(Constants.LOCATION));
		String email = String.valueOf(request.getParameter(Constants.EMAIL));

		employee.setEmployeeId(Integer.parseInt((String) request.getSession().getAttribute("employeeId")));
		employee.setDateOfBirth(dateOfBirth);
		employee.setEmployeeName(name);
		employee.setEmployeeEmail(email);
		employee.setLocation(location);
		System.out.println(employee);
		RestTemplate rr = new RestTemplate();
		
		rr.put("http://localhost:8090/employees/" + employee.getEmployeeId(), employee);
		List<Employee> list = EmployeeServices.getAllEmployees();
		request.getSession().setAttribute("list", list);

		return new ModelAndView(ViewsNameConsts.EMPLOYEE_LIST);
	}
}
