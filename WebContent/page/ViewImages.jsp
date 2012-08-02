<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,bean.*,util.*,dao.*" %>
<jsp:include page="header.jsp"></jsp:include>
<%
List result =(List)request.getAttribute("imageList");
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
theme="images/"+theme+"theme.jpg";
%>
<html>
<body>
<fieldset>
  <legend style=font-family:arial;font-size:15px;color:blue;font-weight:bold">Images</legend>
 <table width="100%" style="background-image:url('<%=theme%>')">
 <tr>
 <td align="center"><a href="upload.jsp" style="font-family:arial;font-size:12px;color:blue;font-weight:bold;text-decoration:none">Upload a Image</a>
 <tr>
 <tr>
 <td>
 <%
 for(Object obj : result)
 {
	 ImageBean bean = (ImageBean)obj;
 %>
 <div style="valign:top;float: left; padding-right: 0px; padding-left: 0px; padding-bottom: 0px;border-top:0px solid #e5e5e5;padding-right:20px;padding-bottom:30px;">
 <div style="valign:top;background: transparent  no-repeat scroll left bottom; width: 170px;">
 <div style="valign:top;background: transparent no-repeat scroll right bottom; width:; ">
 <div style="valign:top;background: transparent  no-repeat scroll left top; ">
 <div style="valign:top;padding: 0px 0px; background: transparent no-repeat scroll right top; height: 220px">
  <div style="valign:top;margin: 0px 0px; overflow: hidden;">
	<table width ="100%">
	 <tr>
	  <td width="100%" height="20px" align="center" valign="middle" style="background-color:#FFE9FF;font-family:arial;font-size:11px;color:blue;font-weight:bold"><%=bean.getDisplayName() %></td> 
	 </tr>
	 <tr>
	   <td width="100%" align="center"  valign="middle" style="padding-bottom:10px;padding-top:10px"><img height="150" src="imgrender?id=<%=bean.getId()%>&category=image"/> </td>
	 </tr>
	 <tr>
	   <td width="100%" height="20px"  align="center"  valign="middle" style="background-color:#FFE9FF;font-family:arial;font-size:11px;color:blue;font-weight:bold"><a href="" style="text-decoration:none">Download</a> |<a href="" style="text-decoration:none">Edit</a></td>
	 </tr>
	</table>
  </div>
  </div>
  </div>
  </div>
  </div>
  </div>
 <%} %>
 </td>
 </tr>
 </table>
  </fieldset>
 <jsp:include page="footer.jsp"></jsp:include>
 </body>
 </html>