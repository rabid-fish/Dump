package com.github.rabid_fish;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String getHello(ModelMap model) {
		model.addAttribute("message", "Hello from Spring MVC!");
		return "index";
	}

}
