 <%@page import="util.*" %>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<form name="main" action="misc?mode=update" method="post">
<table width="25%" align="center" style="background-image:url('<%=theme%>');">
 <%for(Object  key : GameProperties.getInstance().getinMemoryProp().keySet())
	 {
	   out.println("<tr><td>"+key+"</td>");
	   out.println("<td>"+"<input type=\"text\" name=\""+key+"\" value=\""+GameProperties.getInstance().getinMemoryProp().get(key)+"\"/></td></tr>");
	   
	 }
	
	 %>
	 <tr><td clospan="2"><input type="submit" value="Update"/></td><tr> 
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>