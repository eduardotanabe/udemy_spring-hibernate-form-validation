package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {
	
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	private Integer freePasses;  // foi modificado de int para Integer para aceitar null
	
	// quando adicionamos um valor inválido, como "jdkafjaljaklfj", no campo "Free passes" da página web, aparecerá uma mensagem gigante de erro.
	// Para contornar isso, foi adicionado uma mensagem customizada. Assim, foi necessário nesta aula (aual 160 do curso) a pasta resources dentro
	// da pasta src, adicionar o arquivo messages.properties com a mensagem customizada no interior da pasta criada e modificar o arquivo
	// spring-mvc-demo-servlet.xml q está na pasta WEB-INF	
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")   // o 5 do regexp refere-se a quantidade de caracteres q aceita
	private String postalCode;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	

}
