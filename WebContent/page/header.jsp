 <%@page import="util.*" %>
<%
String login = (String)session.getAttribute("LOGIN");
String mode = GameProperties.getInstance().getStringProperty(GameProperties.GAME_MODE);
String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
String themeFont = GameProperties.getInstance().getStringProperty(GameProperties.THEMEFONT);
theme ="images/"+theme+".jpg";
String logoImg ="images/"+mode+"logo.jpg";
%>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr>
<td width="1%">
<img height="100" src="<%=logoImg%>">
</td>
<td align="right" valign="top" style="font-family:arial;font-size:12px;color:<%=themeFont%>">
<%
if(login != null)
{
%>
<a href="loginLandingPage.jsp" style="font-family:arial;font-size:12px;color:<%=themeFont%>">Home</a> |
<%}%>
<a href="adminlogin.jsp" style="font-family:arial;font-size:12px;color:<%=themeFont%>">Admin Login </a>|
Help | Created by  Shamik mitra ,Kinkar ch Dey.</td>
</tr>

</table>