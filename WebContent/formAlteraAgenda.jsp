<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/alteraContato" var="linkServletNovoContato"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovoContato }" method="post">
	
				
		Id: <input type="text" name="id" value="${contato.id }">
		Nome: <input type="text" name="nome" value="${contato.nome}" />
		Email: <input type="text" name="email" value="${contato.email }" />
		Endereço: <input type="text" name="endereco" value="${contato.endereco }" />
		Data Nascimento: <input type="text" name="data" value="${contato.dataNascimento }" />
		
		<input type="submit" />
		
	
	</form>

</body>
</html>