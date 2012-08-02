 <%@page import="util.*" %>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<form name="main" action="adminLoginDelegator" method="post">
<table width="25%" align="center" style="background-image:url('<%=theme%>');">
<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
<tr><td colspan="2"><input type="submit" value="sign in"></td></tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>