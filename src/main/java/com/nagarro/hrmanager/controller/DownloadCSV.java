package com.nagarro.hrmanager.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.nagarro.hrmanager.constants.Constants;
import com.nagarro.hrmanager.data.Employee;
import com.nagarro.hrmanager.services.EmployeeServices;

@Controller
public class DownloadCSV {
	
	@RequestMapping("/download")
    public void exportToCSV(HttpServletResponse response) throws IOException {
		System.out.println("download");
        response.setContentType(Constants.TEXT_CSV);
        DateFormat dateFormatter = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=EmployeeList" + currentDateTime + Constants.CSV_EXTENTION;
        response.setHeader(headerKey, headerValue);
         
        List<Employee> listUsers = EmployeeServices.getAllEmployees();
 
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader =   {"Employee ID", "Name"       , "Location",    "Email"    , "Date of Birth"};
        String[] nameMapping = {"employeeId", "employeeName", "location", "employeeEmail", "dateOfBirth"};
         
        csvWriter.writeHeader(csvHeader);
         
        for (Employee user : listUsers) {
            csvWriter.write(user, nameMapping);
        }
        
        csvWriter.close();
         
    }
	
}
