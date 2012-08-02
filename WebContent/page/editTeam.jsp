<%@page import="bean.*,util.*" %>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
TeamBean team = (TeamBean)request.getAttribute("Team");
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<fieldset>
  <legend>Edit Team</legend>
  <form action="team" method="post">
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td>Name:<td><td><input type="text" name="name" value="<%=team.getName()%>"></td></tr>
<tr><td>Owner:<td><td><input type="text" name="owner" value="<%=team.getOwner()%>"></td></tr>
<tr><td>Address:<td><td><input type="text" name="address"  value="<%=team.getAddress()%>"></td></tr>
<tr><td>Phone:<td><td><input type="text" name="phone" value="<%=team.getPhone()%>"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="update"></td></tr>
<input type="hidden" name="param" value="update"/>
<input type="hidden" name="id" value="<%=team.getId()%>"/>
</table>
</form>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>