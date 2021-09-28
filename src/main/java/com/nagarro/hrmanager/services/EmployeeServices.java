package com.nagarro.hrmanager.services;

import java.util.Arrays;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.web.client.RestTemplate;

import com.nagarro.hrmanager.data.Employee;

public class EmployeeServices {
	
	public static List<Employee> getAllEmployees() {
		
		RestTemplate restTemplate = new RestTemplate();
		final String URI = "http://localhost:8090/employees";
		Employee[] employees = restTemplate.getForObject(URI, Employee[].class);
		List<Employee> list =  Arrays.asList(employees); 
		
		list.forEach(x-> {
			try {
				x.setDateOfBirth(convertDatefromSqlFormat(x.getDateOfBirth()));
			} catch (ParseException e) { 
				e.printStackTrace();
			}
		});
		
		return list;
	}
	
	public static String convertDatefromSqlFormat(String date) throws ParseException {
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dFormatFinal = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date d =  dFormat.parse(date);
        return dFormatFinal.format(d);
    }
	public static String convertDatetoSqlFormat(String date) throws ParseException {
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dFormatFinal = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date d =  dFormatFinal.parse(date);
        return dFormat.format(d) ;
    }
}
