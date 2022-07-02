<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Prova Final </title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: rgb(144, 28, 126)">
			<div>
				<a  class="navbar-brand" style="color: white"> Prova Final </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listSalesman"
					class="nav-link">Lista de Vendedores</a></li>
			</ul>
            <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listOrder"
					class="nav-link">Lista de Ordem de Venda</a></li>
			</ul>
            <ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listCustomer"
					class="nav-link">Lista de Clientes</a></li>
			</ul>

			<ul class="navbar-nav">
            	<li><a href="<%=request.getContextPath()%>/creditosAlunos.jsp"
            		class="nav-link">Creditos da dupla</a></li>
            </ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center" style="color: rgb(205, 35, 180)">ALUNOS</h3>
			<hr>
            <label style="color: rgb(144, 28, 126)">Andreza do Nascimento Pessoa Cb3012191</label>
            </br>
			<label style="color: rgb(144, 28, 126)" >Lidiane Souza Soares  CB3012026</label>
            </br>
		</div>
	</div>
</body>
</html>