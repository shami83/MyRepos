<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,bean.*,util.*" %>
 <%
 List result =(List)request.getAttribute("PlayerList");
 List teams =(List)session.getAttribute("TEAMS");
 Map<String,String> map =GameProperties.getInstance().getMapProperty(GameProperties.CATEGORY);
 int counter=0;
 String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
 theme="images/"+theme+"theme.jpg";
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function confirmDelete(delUrl) {
  if (confirm("Are you sure you want to delete")) {
    document.location = delUrl;
  }
}
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend style="color:orange;font-size:20px;font-weight:bold">Search Criteria</legend>
  <form action="player?param=viewAll" method="post">
  <table width="100%" style="background-image:url('<%=theme%>');">
  <tr>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">Name :</td><td><input type="text" name="name"/></td>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">Category :</td>
  <td>
  <select name="cat">
  <option value="default">-------</option>
  <%
  for(String key : map.keySet())
  {
	   out.println("<option value=\""+key+"\">"+key+"</option>");
  }
  %>
  </select>
  </td>
  </tr>
  <tr>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">Grade :</td><td><input type="text" name="grd"/></td>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">Team :</td>
  <td><select name="team">
  <option value="0">N/A</option>
  <option value="-1">ALL</option>
	  <%
	  for(Object obj : teams)
	  {
		  TeamBean tb =(TeamBean)obj;
		  out.println("<option value=\""+tb.getId()+"\">"+tb.getName()+"</option>");
	  }
	 
	  %>
	</select></td>
  </tr>
   <tr>
  	<td colspan="2" align="center"><a style="text-decoration:none;font-family:arial;font-size:15px;color:blue;font-weight:bold" href="player?param=changeView">Change View</a></td>
  	<td colspan="2" align="center"><input type="submit" value="search"/></td>
   </tr>
 
  </table>
  </form>
 </fieldset>
<fieldset>
  <legend style="color:orange;font-size:20px;font-weight:bold">All Player(<%=result!=null?result.size():"0" %>)</legend>
<table width ="100%" style="background-image:url('<%=theme%>');">
<tr>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Name</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Category</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Grade</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Team</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">View Details</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Edit</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Delete</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Profile Picture</td>
</tr>
<% for(Object obj : result){
	PlayerBean bean = (PlayerBean)obj;
	if(counter%2 == 0)
	{
		out.println("<tr bgcolor=\"#FFF284\">");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getName()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getCategory()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getGrade()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getTeamName()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"player?param=view&id="+bean.getId()+"\">"+"View"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"player?param=edit&id="+bean.getId()+"\">"+"Edit"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"javascript:confirmDelete('player?param=delete&id="+bean.getId()+"')\">"+"Delete"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><img height=\"70\" src=\"image?id="+bean.getId()+"\">"+"</img></td>");
		out.println("</tr>");
	}
	else
	{
		out.println("<tr>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getName()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getCategory()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getGrade()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\">"+bean.getTeamName()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:blue;font-weight:bold\"><a href=\"player?param=view&id="+bean.getId()+"\">"+"View"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"player?param=edit&id="+bean.getId()+"\">"+"Edit"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"javascript:confirmDelete('player?param=delete&id="+bean.getId()+"')\">"+"Delete"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><img height=\"70\" src=\"image?id="+bean.getId()+"\">"+"</img></td>");
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