package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // aqui q adicionarei as regras e as l�gicas de valida��o
@Target( {ElementType.METHOD, ElementType.FIELD} )    // aqui seleciono quais tipos de elementos pode ser aplicado essa anota��o
@Retention(RetentionPolicy.RUNTIME)  // aqui marca por quanto tempo a anota��o ser� armazenada ou usada. Basicamente est� dizendo mantenha a anota��o em bytecode e tbm use em tempo de execu��o

public @interface CourseCode {

	// a estrutura b�sica da anota��o ser� da seguinte forma "@CourseCode(value"LUV", message="must start with LUV") a inten��o dessa anota��o � for�ar para que o usu�rio adicione no in�cio "LUV" no cmapo em que tiver essa anota��o 
	
	// define default course code 
	public String value() default "LUV";
	
	// define default error message
	public String message() default "must start with LUV";
	
	// define default groups. Aqui agrupar� restri��es de valida��es
	public Class<?>[] groups() default {};    // aqui n�o foi especificado um grupo espec�fico
	
	// define default payloads. Aqui poder� adicionar informa��es adicionais sobre o erro de valida��o 
	public Class<? extends Payload>[] payload() default {};
	
	
}
