<%@page import="bean.*,util.*" %>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
PlayerBean player = (PlayerBean)request.getAttribute("Player");
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<fieldset>
  <legend>Edit Player</legend>
  <form action="player" method="post">
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td>Name:<td><td><input type="text" name="name" value="<%=player.getName()%>"></td></tr>
<tr><td>Category:<td><td><input type="text" name="cat" value="<%=player.getCategory()%>"></td></tr>
<tr><td>Grade:<td><td><input type="text" name="grd"  value="<%=player.getGrade()%>"></td></tr>
<tr><td>Image:<td><td><input type="text" name="img" value="<%=player.getImage()%>"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="update"></td></tr>
<input type="hidden" name="param" value="update"/>
<input type="hidden" name="id" value="<%=player.getId()%>"/>
</table>
</form>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>