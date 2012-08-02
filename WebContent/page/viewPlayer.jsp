<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   <%@page import="java.util.*,bean.*,util.*" %>
 <%
 PlayerBean player =(PlayerBean)request.getAttribute("Player");
 List teams =(List)session.getAttribute("TEAMS");
 String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
 theme="images/"+theme+"theme.jpg";
 %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr>
<td>
	<table width="100%">
	<tr>
		<td width="1%" height="350" valign="top">
		<img src="image?id=<%=player.getId()%>" height="400" >
		</td>
		<td width="10px">&nbsp;</td>
		<td valign="top">
		<table width="100%">
		<tr>
		<td>
		<fieldset style="color:orange;font-size:20px;font-weight:bold">
          <legend style="color:orange;font-size:20px;font-weight:bold">Player Details</legend>
			<table width="100%" heigt="80%" valign="top">
			<tr>
			<td colspan="2" align="left">
			 <img src="<%=player.getAnchorImage()%>" height="200" >
			</td>
			</tr>
			<tr>
			<td style="font-family:arial;font-size:20px;color:red;font-weight:bold">Name : </td>
			<td style="font-family:arial;font-size:20px;color:red;font-weight:bold"><%=player.getName()%></td>
			</tr>
			<tr>
			<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Category : </td>
			<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold"><%=player.getCategory()%></td>
			</tr>
			<tr>
			<td style="font-family:arial;font-size:20px;color:green;font-weight:bold">Grade : </td>
			<td style="font-family:arial;font-size:20px;color:green;font-weight:bold"><%=player.getGrade()%></td>
			</tr>
			<tr>
			<td style="font-family:arial;font-size:20px;color:orange;font-weight:orange">Team : </td>
			<td style="font-family:arial;font-size:20px;color:orange;font-weight:orange"><%=player.getTeamName()%></td>
			</tr>
			</table>
			</fieldset>
		</td>
		</tr>
		<tr>
		<td>
		<fieldset style="color:orange;font-size:20px;font-weight:bold">
         <legend style="color:blue;font-size:20px;font-weight:bold">Assign to a team</legend>
	   <form action="player?param=assign" method="post">
		<table width="100%">
		<tr>
		<td>
			<select name="team">
	 	     <option value="0">N/A</option>
	 	      <%
			  for(Object obj : teams)
			  {
				  TeamBean tb =(TeamBean)obj;
				  out.println("<option value=\""+tb.getId()+"\">"+tb.getName()+"</option>");
			  }
			 
			  %>
		    </select>
		    <input type="hidden" name="id" value="<%=player.getId()%>">
	</td>
	<td><input type="submit" value="Assign"></tr>
		</table>
		</form>
		</fieldset>
		</td>
		</tr>
		</table>
		
	    </td>
      </tr>
      </table>
</td>
</tr>


</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>