package com.sandeep.SpringBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("welcome");
	}
}
