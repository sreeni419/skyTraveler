package com.skytraveler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {

		return "index";

	}
	
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup() {
		return "register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/airportfinder", method = RequestMethod.GET)
	public String airportfinder() {

		return "airport_finder";

	}
	
	/*@RequestMapping(value="/flight", method=RequestMethod.GET)
	public String Flight() {
		return "flight";
	}*/

}
