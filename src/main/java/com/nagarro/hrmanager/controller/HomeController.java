package com.nagarro.hrmanager.controller;

import static com.nagarro.hrmanager.model.HibernateConfig.connectionSetup;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

/**
 * <p>This class is controller for Home page</p>
 * @author ankitgaur
 *
 */
@Controller
public class HomeController {

	
	/**
	 * This function return the Model data and Views(JSP);
	 * @param request
	 * @param response
	 * @param m
	 * @return
	 */
	@RequestMapping("/home")
	public String home(Model m) {
		connectionSetup();  
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(3);
		a.add(1);
		a.add(4);
		m.addAttribute("message", a);
		return "home";
	}

}
