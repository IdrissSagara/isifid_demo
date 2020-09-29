package com.isifid.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PagesController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		String name = request.getParameter("name") != null && !request.getParameter("name").isEmpty()
				? request.getParameter("name") : "World";
				
		System.out.println("\n\n\n" + name + "\n\n\n");
		
		return "home";
	}


	
	@GetMapping("/{number}")
	public String home(@PathVariable int number, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		int res;
		
		//System.out.println("\n\n\n" + number + "\n\n\n");
		
		if (number < 0) {
			// TODO: display a correct message 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			
		} else if (number % 2 == 0 && number > 50) {
			res = number;
			modelMap.put("number", res);
				
		} else if (number % 2 == 0 && number < 51) {
			res = fact(number);
			modelMap.put("number", res);
			
			
			
		}
		
		return "home";
	}
	
    public static int fact (int n) {
        int f = 1;
        for (int i=1; i<=n; i++)
        f=f*i;
        return(f);
    }

}
