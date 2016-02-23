package com.zzti.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.*;

@Controller
@RequestMapping("/about")
public class AboutController {
	// Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LogManager.getLogger(AboutController.class);
    
	@RequestMapping("/info")
	public String about() {
		return "about";
	}

	@RequestMapping("/loginfo")
	public String about(ModelMap model, HttpServletRequest request) {
		StringBuilder sb = new StringBuilder("the result:\r\n");
		Boolean getMethod = request.getMethod().equalsIgnoreCase("get") ? true
				: false;
		Enumeration<String> e = getMethod ? request.getAttributeNames()
				: request.getParameterNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			String value = getMethod ? request.getParameter(name) : request
					.getParameter(name);
			sb.append(String.format("%1$s \t:%2$s\r\n", name, value));
		}
		model.addAttribute("result", sb.toString());
		logger.info(sb.toString());
		return "about";
	}
}
