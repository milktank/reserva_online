<%@page import="com.empresa.backend.entities.Reserva"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*" %>
<%@page import= "com.empresa.backend.entities.Servico"%>
<%@page import= "com.empresa.backend.dao.*" %>

<% int i; 
	ServicoDAO servDao = new ServicoDAO();
	Servico serv = servDao.getAll().get(0);
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
	
  <h1><a href="#">Fazer Reservas</a></h1>

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
		    	<a href="ServletCriarReservas">Fazer Reservas</a>
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

<form method="post" action="ServletFazerReservas">
	<table>
		<h2>Fazer Reserva</h2>
		
		<tr>
			<td>Imei</td>
			<tr>
			<td><input type="text" name="imei"/></td>
			</tr>
		</tr>
		
<!--	 data	-->
		<table>
			<thead>
				<tr>
					<th>Dia</th>
					<th>Mês</th>
					<th>Ano</th>
				</tr>
			</thead>
			<td>
					<select name="dia">
					<% for(i= 1; i< 31; i++) %>
						<option value=<%=i %>><%=i %></option>
					</select>
			</td>
			<td>
					<select name="mes">
					<% for(i= 1; i< 12; i++) %>
						<option value=<%=i %>><%=i %></option>
					</select>
			</td>
			<td>
					<select name="ano">
					<% for(i= 2010; i< 2100; i++) %>
						<option value=<%=i %>><%=i %></option>
					</select>
			</td>
			
		</table>
		
<!--		hora -->
	<table>
		<thead>
			<tr>
				<th>Hora</th>
			</tr>
		</thead>
		<td>
				<select name="hora">
					<option value="8">08:00</option>
					<option value="9">09:00</option>
					<option value="10">10:00</option>
					<option value="11">11:00</option>
					<option value="12">12:00</option>
				</select>
		</td>
				
	</table>
	
	<input type="hidden" name="id_servico" value="<%=serv.getId()%>"/>   
	<tr>
			<td></td>
			<td><input type="submit" value="Reservar"/></td>
		</tr>
		   
   </form>
   
</div>
	<div id="colThree"> <a href="#"><img src="images/ad_120x600.jpg" alt="" width="120" height="600" /></a> </div>
	<div style="clear: both;">&nbsp;</div>
</div>
<div id="footer">
	<p>Copyright &copy; 2006 Salt &amp; Pepper. Designed by <a href="http://freecsstemplates.org"><strong>Free CSS Templates</strong></a></p>
</div>
</body>
</html>
