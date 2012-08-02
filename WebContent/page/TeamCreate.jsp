<%@ page import="util.*" %>
<html>
<body>
<%
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";%>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend>Create Team</legend>
  <form action="team" method="post">
<table width="100%" style="background-image:url('<%=theme %>');">
<tr><td>Name:<td><td><input type="text" name="name"></td></tr>
<tr><td>Owner:<td><td><input type="text" name="owner"></td></tr>
<tr><td>Address:<td><td><input type="text" name="address"></td></tr>
<tr><td>Address:<td><td><input type="text" name="phone"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="create"></td></tr>
<input type="hidden" name="param" value="create"/>
</table>
</form>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>