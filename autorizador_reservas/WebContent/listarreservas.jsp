<%@page import="com.empresa.backend.entities.Reserva"%>
<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>

<%
	List<Reserva>  reservas = (List<Reserva>) request.getAttribute("reservas");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Reservas</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
	
  <h1><a href="#">Gerenciamento de Reservas</a></h1>

</div>
<div id="menu">	
	<ul>
    <li><a href="index.jsp" accesskey="1" title="">Início</a></li>
	</ul>
</div>
<div id="content">
	<div id="colOne">
		
    <h2>Menu de Opções</h2>
		    <p>
		    	<a href="index.jsp">Inicio</a>
		    	<h3 class="hr"></h3>
		    	<a href="ServletListarReservas">Listar Reservas</a>
		    	<a href="ServletFazerReservas">Fazer Reservas</a>
		    </p>
		    <br/>

    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
    <p><a href="#"></a></p>
		<p><a href="#"><img src="images/img7.jpg" alt="" width="160" height="120" /></a></p>
	</div>
  <div id="colTwo">    
		<h2>Reservas efetuadas:</h2>
		<table>
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Serviço</th>
				<th>Horário</th>
				<th>Remover</th>
			</tr>
		</thead>
		<% if(reservas!=null){ 
			for(Reserva r : reservas) { %>
			<tr>
				<td><%=r.getImei() %> </td> 
				<td><%=r.getServico().getDescricao() %> </td>				
				<td><%=r.getDataReserva() %></td>
				<td>
					<form method="post" action="ServletRemoverReservas">
						<input type="hidden" name="id" value="<%= r.getIdReserva() %>"/>
						<input class="ls" type="submit" value="X"/>
					</form>
				</td>
			</tr>	
			<% } %>
		<% } %>
		</table>
	</div>
	<div id="colThree"> <a href="#"><img src="images/ad_120x600.jpg" alt="" width="120" height="600" /></a> </div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">
	<p>Copyright &copy; 2006 Salt &amp; Pepper. Designed by <a href="http://freecsstemplates.org"><strong>Free CSS Templates</strong></a></p>
</div>
</body>
</html>
