<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleServicioManagerProxyid" scope="session" class="pe.edu.upc.servicio.ServicioManagerProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleServicioManagerProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleServicioManagerProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleServicioManagerProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        pe.edu.upc.servicio.ServicioManager getServicioManager10mtemp = sampleServicioManagerProxyid.getServicioManager();
if(getServicioManager10mtemp == null){
%>
<%=getServicioManager10mtemp %>
<%
}else{
        if(getServicioManager10mtemp!= null){
        String tempreturnp11 = getServicioManager10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String nombre_1id=  request.getParameter("nombre16");
            java.lang.String nombre_1idTemp = null;
        if(!nombre_1id.equals("")){
         nombre_1idTemp  = nombre_1id;
        }
        java.lang.String saludo13mtemp = sampleServicioManagerProxyid.saludo(nombre_1idTemp);
if(saludo13mtemp == null){
%>
<%=saludo13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(saludo13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>