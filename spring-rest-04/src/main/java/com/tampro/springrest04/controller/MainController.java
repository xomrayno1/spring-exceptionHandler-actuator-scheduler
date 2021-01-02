package com.tampro.springrest04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		String host = request.getServerName();
		
		String endpointBasePath = "/actuator";
	     
        StringBuilder sb = new StringBuilder();
         
        sb.append("<h2>Sprig Boot Actuator</h2>");
        sb.append("<ul>");
        // http://localhost:8090/actuator
        String url = "http://" + host + ":8090" + contextPath + endpointBasePath;
 
        sb.append("<li><a href='" + url + "'>" + url + "</a></li>");
 
        sb.append("</ul>");
         
        return sb.toString();
	}
}
