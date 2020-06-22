<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
	
		<c:if test="${not empty contato}">
			Contato ${ contato } cadastrado com sucesso!
		</c:if>
		
		<c:if test="${empty contato}">
			Nenhum contato cadastrado!
		</c:if>

	</body>
</html>
