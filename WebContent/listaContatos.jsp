<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,agenda.modelo.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty contato}">
		Contato ${ contato } cadastrado com sucesso!
	</c:if>
	
	Lista de contatos: <br />
	
	<ul>
		<c:forEach items="${contatos}" var="contato">
			
			<li>
				${contato.id} -
				${contato.nome} -
				${contato.email} -
				${contato.endereco} -
				${contato.dataNascimento}
				<a href="/Agenda/mostraContato?id=${contato.id }">edita</a>
				<a href="/Agenda/removeContato?id=${contato.id }">remove</a>
			</li>
		</c:forEach>
	</ul>
	
</body>
</html>



