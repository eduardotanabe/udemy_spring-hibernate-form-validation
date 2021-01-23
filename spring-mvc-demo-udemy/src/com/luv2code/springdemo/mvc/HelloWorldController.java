package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // esse request é considerado como parent mapping. Os outros internos como sub mapping (relative). Portanto, para acessar o métodos abaixos deve ter o "/hello" antes de cada mapeamento dos método abaixo. Ex. /hello/showForm. Veja a tag "a" do arquivo main-menu.jsp
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	@RequestMapping("/showForm")
	public String showForm() { 
		return "helloworld-form";
	}
	
	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// new a controller method to read form data and 
	// add data to the model 
	@RequestMapping("/processFormTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		
		System.out.println("Usando o processo 2 do controller");
		
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add message to the model
		model.addAttribute("message", result);
				
		return "helloworld";
	}
	
	// repare na anotação @RequestParam que serve para buscar um parâmetro pela anotação, diferente do método acima	
	@RequestMapping("/processFormThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		// convert the data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend " + theName + " from V3";
		
		// add message to the model
		model.addAttribute("message", result);
				
		return "helloworld";
	}
	
}
