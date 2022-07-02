<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <title>Prova Final</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: rgb(144, 28, 126)">
            <div>
                <a class="navbar-brand" style="color: white"> Prova Final </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="creditosAlunos.jsp" class="nav-link">Creditos da dupla</a></li>
            </ul>
        </nav>
    </header>
    </br>

    </br>
    <div class="container col-md-6">
        <div class="d-flex justify-content-center">
            <a class="btn btn-info" style="margin-right: 15px" href="<%=request.getContextPath()%>/newCustomer" role="button">Adicionar
                Customer</a>
            <a class="btn btn-info" href="<%=request.getContextPath()%>/listCustomer" role="button">Listar
                Customer</a>
        </div>
    </div>
</body>
</html>