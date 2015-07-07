package com.zzti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	@RequestMapping("/info")
	public String about()
	{
		return "about";
	}
}
