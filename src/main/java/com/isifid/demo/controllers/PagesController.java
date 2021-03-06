package com.isifid.demo.controllers;

import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import utils.Utils;

@Controller
public class PagesController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		
		// String name = request.getParameter("name") != null && !request.getParameter("name").isEmpty()
			//	? request.getParameter("name") : "World";
		return "home";
	}


	
	@GetMapping("/{factor}")
	public String home(@PathVariable String factor, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		int res , number = 0;
				
		try {
			number = Integer.parseInt(factor);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return "errorParsing";
		}
		
		if (number < 0) {
			// TODO: display a correct message 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "error404";
		} else if (number % 2 == 0 && number > 50) {
			res = number;
			modelMap.put("number", res);
				
		} else if (number % 2 == 0 && number < 51) {
			BigInteger resFact = Utils.factorielleGrandNombre(number);
			System.out.println(resFact);
			modelMap.put("number", resFact);
			
		} else if (number % 2 != 0) {
			
			List<Integer> myArray = Utils.suiteFibonacci(number);
			String myStringFormat = myArray.toString();
			myStringFormat = myStringFormat.replace("[", "(");
			myStringFormat = myStringFormat.replace("]", ")");
			modelMap.put("number", myStringFormat);
			
		}
		
		return "home";
	}
}
