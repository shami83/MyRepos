<%@ page language="java"%>
<%@ page import="java.util.*,util.*" %>

<%
String title = (String)request.getAttribute("title");
Map<String,String> map =(Map<String,String>)request.getAttribute("status");
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend><%=title%></legend>
  
<table width="100%" style="background-image:url('<%=theme%>');">
<%for(String key : map.keySet()){ %>
<tr><td><%=key%>:<td><td><%=map.get(key) %></td></tr>
<%}%>
</table>
</fieldset>
</body>
</html>