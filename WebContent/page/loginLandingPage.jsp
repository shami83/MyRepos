 <%@page import="bean.*,util.*" %>
<html>
<body>
<%
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend>Utility links:</legend>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="AlbumCreate.jsp">Create Album</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to create a new Album</td></tr>

<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="album?param=viewAll">View All Album</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to view All Albums.</td></tr>

<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="PlayerCreate.jsp">Create Player</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to Create Player</td></tr>

<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="player?param=viewAll">View All Player</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to View & Search  all Players.</td></tr>

<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="TeamCreate.jsp">Create Team</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to Create Team</td></tr>

<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="team?param=viewAll">View All Team</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to View  all Teams.</td></tr>
</table>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>