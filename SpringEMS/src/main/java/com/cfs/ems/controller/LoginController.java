package com.cfs.ems.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cfs.ems.model.*;
import com.cfs.ems.service.LoginService;
import com.cfs.ems.service.LoginServiceImpl;


@Controller
public class LoginController {


	@Autowired
	private LoginService loginService;

	public LoginController(LoginService loginService){

		this.loginService = loginService;

	}


	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		//		Login login = new Login();
		//		model.addAttribute("loginForm");
		return "login";


	}
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public ModelAndView welcome( Login login, @ModelAttribute Status status) throws Exception {
		//		LoginService loginService = new LoginServiceImpl() ;
		status = loginService.login(login);
		System.out.println(status.getEmpName());
		System.out.println(login.getUsername());




		if(status.getStatus()==1)
		{
			ModelAndView model = new ModelAndView();
			List< Status> message = new LinkedList<Status>();
			message.add(status);
			model.setViewName("dashboard");
			model.addObject("message", message);
			
//			model.addObject("status","Bro");
			return model;
		}

		else if (status.getStatus()==2)
		{
			ModelAndView model = new ModelAndView("ManagerHome");
			model.addObject("status",status);
			return model;
		}
		else if (status.getStatus()==3)
		{
			ModelAndView model = new ModelAndView("EmployeeHome");
			model.addObject("status",status);
			return model;
		}
		else
		{
			ModelAndView model = new ModelAndView("login");
			model.addObject("status",status);
			return model;
		}

	}
/*	
	@RequestMapping(value="/dashboard",method=RequestMethod.POST)
	public ModelAndView dashboard()
	*/




}
