package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // aqui q adicionarei as regras e as lógicas de validação
@Target( {ElementType.METHOD, ElementType.FIELD} )    // aqui seleciono quais tipos de elementos pode ser aplicado essa anotação
@Retention(RetentionPolicy.RUNTIME)  // aqui marca por quanto tempo a anotação será armazenada ou usada. Basicamente está dizendo mantenha a anotação em bytecode e tbm use em tempo de execução

public @interface CourseCode {

	// a estrutura básica da anotação será da seguinte forma "@CourseCode(value"LUV", message="must start with LUV") a intenção dessa anotação é forçar para que o usuário adicione no início "LUV" no cmapo em que tiver essa anotação 
	
	// define default course code 
	public String value() default "LUV";
	
	// define default error message
	public String message() default "must start with LUV";
	
	// define default groups. Aqui agrupará restrições de validações
	public Class<?>[] groups() default {};    // aqui não foi especificado um grupo específico
	
	// define default payloads. Aqui poderá adicionar informações adicionais sobre o erro de validação 
	public Class<? extends Payload>[] payload() default {};
	
	
}
