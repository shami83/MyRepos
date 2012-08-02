<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,bean.*,util.*,dao.*" %>
<jsp:include page="header.jsp"></jsp:include>
<%
List result =(List)request.getAttribute("PlayerList");
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
map=map==null?new HashMap():map;
String teamID = (String)map.get("team");
teamID = teamID==null?"0":teamID;
TeamDao dao =new TeamDao();
TeamBean tbean = dao.findByID(new Integer(teamID.trim()));
String team=tbean==null?"ALL":tbean.getName();
theme="images/"+theme+"theme.jpg";
%>
<html>
<body>
<fieldset>
  <legend style=font-family:arial;font-size:15px;color:blue;font-weight:bold"><%=team %></legend>
 <table width="100%" style="background-image:url('<%=theme%>')">
 <tr>
 <td>
 <%
 for(Object obj : result)
 {
	 PlayerBean bean = (PlayerBean)obj;
 %>
 <div style="valign:top;float: left; padding-right: 0px; padding-left: 0px; padding-bottom: 0px;border-top:0px solid #e5e5e5;padding-right:20px;padding-bottom:30px;">
 <div style="valign:top;background: transparent  no-repeat scroll left bottom; width: 170px;">
 <div style="valign:top;background: transparent no-repeat scroll right bottom; width:; ">
 <div style="valign:top;background: transparent  no-repeat scroll left top; ">
 <div style="valign:top;padding: 0px 0px; background: transparent no-repeat scroll right top; height: 220px">
  <div style="valign:top;margin: 0px 0px; overflow: hidden;">
	<table width ="100%">
	 <tr>
	  <td width="100%" height="20px" align="center" valign="middle" style="background-color:#FFE9FF;font-family:arial;font-size:11px;color:blue;font-weight:bold"><%=bean.getName() %>(<%=bean.getGrade()%>)</td> 
	 </tr>
	 <tr>
	   <td width="100%" align="center"  valign="middle" style="padding-bottom:10px;padding-top:10px"><img height="150" src="image?id=<%=bean.getId()%>"/> </td>
	 </tr>
	 <tr>
	   <td width="100%" height="20px"  align="center"  valign="middle" style="background-color:#FFE9FF;font-family:arial;font-size:11px;color:blue;font-weight:bold"><%=bean.getCategory() %></td>
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