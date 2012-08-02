 <%@page import="util.*" %>
 <%
 String site = GameProperties.getInstance().getStringProperty(GameProperties.SITE);
 String siteFullName = GameProperties.getInstance().getStringProperty(GameProperties.SITE_FULLNAME);
 String theme = GameProperties.getInstance().getStringProperty(GameProperties.THEME);
 String ribon = theme+"ribon.jpg";
 theme ="images/"+theme+".jpg";
 String themeFont = GameProperties.getInstance().getStringProperty(GameProperties.THEMEFONT);
 ribon="images/"+ribon;
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table width="100%" height="120" style="background-image:url('<%=ribon%>');">
<tr><td>&nbsp;</td></tr>
</table>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td align="center"  style="font-family:arial;font-size:12px;color:<%=themeFont%>"><%=site %> site was created by Shamik Mitra for any further communication please call to +91 9830471739 or drop a email to mitrashamik@gmail.com.</td></tr>
<tr><td align="center"  style="font-family:arial;font-size:12px;color:<%=themeFont%>">Any unauthorized access or hacking and code thefting against Cyber Law.</td></tr>
<tr><td align="center" style="font-family:arial;font-size:15px;color:<%=themeFont%>">© Copyright 2011 <%=siteFullName%> All rights Reserved</td></tr>
</table>
</body>
</html>