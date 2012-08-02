<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,bean.*" %>
 <%
 List result =(List)request.getAttribute("result");
 boolean prev = (Boolean)request.getAttribute("prev");
 boolean next = (Boolean)request.getAttribute("next");
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <%@page import="util.*" %>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend>All Album</legend>
<table width ="100%" >
<% for(Object obj : result){
	AlbumBean bean = (AlbumBean)obj;

	String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
	theme="images/"+theme+"theme.jpg";

%>

<tr>
<table width="100%" style="border-bottom: 1px solid #37BCE2;background-image:url('<%=theme%>'); ">
<tr><td width="1%"><a href="imagedel?param=viewbyalbum&id=<%=bean.getId()%>"><img border="0" src="images/album.jpg"/></a></td>
<td width="10%">&nbsp;</td>
<td width="30%">
<table>
<tr><td valign="top" style="font-family:arial;font-size:15;text-decoration:none;font-weight:bold"><%=bean.getName()%></td></tr>
<tr><td bgcolor="#37BCE2" style="font-family:arial;font-size:15;text-decoration:none;font-weight:bold"><%=bean.getDescription()%></td></tr>
</table>
</td>
</tr>
</table>

</tr>
<%}%> 

</table>
</fieldset>
<table width="1%" align="right">
<tr>
<td>
<a href="album?param=viewAll&action=prev">Previous</a>
</td>
<td>
<a href="album?param=viewAll&action=next">Next</a>
</td>

</tr>
</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>