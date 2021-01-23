<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>

	<title>Student Registration form</title>

</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First name: <form:input path="firstName"/>
	
	<br><br>
	
	Last name: <form:input path="lastName"/>
	
	<br><br>
	
	<!-- Country: 
	<form:select path="country">  o path se refere ao nome do método sem o "set" 
		<form:option value="Brazil" label="Brazil"></form:option>
		<form:option value="France" label="France"></form:option>
		<form:option value="Germany" label="Germany"></form:option>
		<form:option value="India" label="India"></form:option>
		<form:option value="USA" label="USA"></form:option>
	</form:select> -->
	
	Puxando Country diretamente pela lista da class Student (ver a diferença no código no arquivo student-form.jsp):	
	<form:select path="country"> <!-- o path se refere ao nome do método sem o prefixo "get" e  o sufixo "option"-->
		<form:options items="${student.countryOptions}"/>
	</form:select>
	
	<br><br>
	
	Favorite Language:
	
	Java <form:radiobutton path="favoriteLanguage" value="Java"/> <!-- o path se refere ao nome do método sem o "set" -->
	C# <form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
	
	<br><br>
	
	Operating Systems:
	
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
	MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
	
	
	
	<br><br>
		
	<input type="submit" value="Submit">
	</form:form>



</body>
</html>