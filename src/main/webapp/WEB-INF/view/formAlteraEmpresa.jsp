<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletNovaEmpresa" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import>

	<form action="${linkServletNovaEmpresa}" method="post">
		nome: <input type="text" name="nome" value="${empresa.nome }" /> data
		abertura: <input name="data"
			value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />
		<input type="hidden" name="id" value="${empresa.id }" /> <input
			type="hidden" name="acao" value="AlteraEmpresa" /> <input
			type="submit" />
	</form>

</body>
</html>