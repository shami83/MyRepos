<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="util.*"%>
<html>
<body>
<%
String mode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
String imgPath ="images/"+mode+"Ground.jpg";
%>
<jsp:include page="header.jsp"></jsp:include>
<table width="100%">
<tr><td><img src="<%=imgPath%>" width="100%"></td></tr>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>