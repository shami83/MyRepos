<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,bean.*,util.*" %>
 <%
 List result =(List)request.getAttribute("TeamList");
 int counter=0;
 String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
 theme="images/"+theme+"theme.jpg";
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend style="color:orange;font-size:20px;font-weight:bold">All Team</legend>
<table width ="100%" style="background-image:url('<%=theme%>');">
<tr>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Name</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Owner</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Address</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Phone Number</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Edit</td>
</tr>
<% for(Object obj : result){
	TeamBean bean = (TeamBean)obj;
	if(counter%2 == 0)
	{
		out.println("<tr bgcolor=\"#FFF284\">");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getName()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getOwner()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getAddress()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getPhone()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"team?param=edit&id="+bean.getId()+"\">"+"Edit"+"</a></td>");
		out.println("</tr>");
	}
	else
	{
		out.println("<tr>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getName()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getOwner()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getAddress()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getPhone()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\"><a href=\"team?param=edit&id="+bean.getId()+"\">"+"Edit"+"</a></td>");
		out.println("</tr>");
	}
	counter++;
%>

<tr>

</tr>
<%}%> 

</table>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>