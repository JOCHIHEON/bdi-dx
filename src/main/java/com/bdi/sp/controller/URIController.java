package com.bdi.sp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URIController {
	private static final Logger logger = LoggerFactory.getLogger(URIController.class);
	
	@RequestMapping(value="/uri/**",method=RequestMethod.GET)
	public String goPage(HttpServletRequest req) {
		String rootPath = req.getContextPath();
		logger.debug("rootPath=>{}",rootPath);
		return req.getRequestURI().replace(rootPath+"/uri","");
				
	}

}
