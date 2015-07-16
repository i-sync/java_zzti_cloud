package com.zzti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public String index() {
		return "redirect:/gallery/list";
	}
}
