package com.luv2code.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// add a initbinder ... to convert trim input strings
	// remove leading and traiing whitespace
	// resolve issue for our validation
	// Pre-process every String form data 
	// remove leading and trailing white space
	// if String only has white space ... trim it to null
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {   
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		
		theModel.addAttribute("customer", new Customer());
		
		return "customer-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(    // @Valid aplica as regras de validações do objeto Customer
			@Valid @ModelAttribute("customer") Customer theCustomer, 
			BindingResult theBindingResult){   // O resultado da validação vai para BindingResult
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		}
		else {
			return "customer-confirmation";
		}
	}
	
	
}
