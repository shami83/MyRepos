<%@ page import="util.*" %>
<html>
<body>
<%
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend>Create Player</legend>
  <form action="player" method="post">
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td>Name:<td><td><input type="text" name="name"></td></tr>
<tr><td>Category:<td><td><input type="text" name="cat"></td></tr>
<tr><td>Grade:<td><td><input type="text" name="grd"></td></tr>
<tr><td>Image:<td><td><input type="text" name="img"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="create"></td></tr>
<input type="hidden" name="param" value="create"/>
</table>
</form>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>