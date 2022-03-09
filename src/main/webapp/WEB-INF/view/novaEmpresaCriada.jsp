<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:import url="logout-parcial.jsp"></c:import>
<c:if test="${not empty empresa }">
empresa ${empresa} cadastrada com sucesso
</c:if>
</body>
</html>