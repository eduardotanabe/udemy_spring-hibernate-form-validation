package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();  // aqui eu pego o valor que queira adicionar como prefixo, de acordo com a anota��o constru�da
	}
	
	@Override
	public boolean isValid(String theCode, // o argumento theCode foi recebido atrav�s do formul�rio HTML pelo usu�rio
			ConstraintValidatorContext theConstraintValidatorContext) {   // com o argumento poder� adicionar uma mesagem de erro a mais 	
		
		boolean result;
		
		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		} else {
			return true;   // como o campo n�o � obrigat�rio, aqui ficou true
		}
		
		return result;
	}

}
