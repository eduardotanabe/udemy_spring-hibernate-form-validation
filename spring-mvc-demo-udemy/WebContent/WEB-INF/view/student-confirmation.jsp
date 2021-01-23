<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>

	<title>Student Confirmation</title>

</head>
<body>

	The Student is confirmed: ${student.firstName} ${student.lastName}
	
	<br><br>
	
	Country: ${student.country}

	<br><br>
	
	Favorite Language: ${student.favoriteLanguage} <!-- o Spring estará executando student.getFavoriteLanguage() -->
	
	<br><br>
	
	Operating Systems:
	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}"> <!-- graças a chamada do JSTL da linha 2 é possível fazer essa iteração -->
			<li> ${temp} </li>
		</c:forEach>
	</ul>
	
	
	
</body>
</html>