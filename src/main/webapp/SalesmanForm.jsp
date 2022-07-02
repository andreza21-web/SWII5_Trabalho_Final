<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <html>

        <head>
            <title>Prova Final</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                crossorigin="anonymous">
           <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
                           integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
                           crossorigin="anonymous"></script>
        </head>

        <body>

            <header>

                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: rgb(144, 28, 126)">
                    <div class="container-fluid">
                        <a class="navbar-brand" style="color: white"> Prova Final </a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">

                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">

                                    <a class="nav-link dropdown-toggle" id="navbarDarkDropdownMenuLink" role="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                        Adicionar
                                    </a>

                                    <ul class="dropdown-menu dropdown-menu-dark"
                                        aria-labelledby="navbarDarkDropdownMenuLink">
                                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/newSalesman "
                                                class="nav-link"> Adicionar Vendedor </a></li>
                                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/newCustomer"
                                                class="nav-link">Adicionar Cliente</a></li>
                                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/newOrder"
                                                class="nav-link">Adicionar Pedido</a></li>
                                    </ul>

                                </li>

                                <li class="nav-item dropdown">

                                    <a class="nav-link dropdown-toggle" id="navbarDarkDropdownMenuLink" role="button"
                                        data-bs-toggle="dropdown" aria-expanded="false">
                                        Lista
                                    </a>

                                    <ul class="dropdown-menu dropdown-menu-dark"
                                        aria-labelledby="navbarDarkDropdownMenuLink">
                                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/listSalesman "
                                                class="nav-link"> Lista Vendedor </a></li>
                                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/listCustomer"
                                                class="nav-link">Lista Cliente</a></li>
                                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/listOrder"
                                                class="nav-link">Lista Pedido</a></li>
                                    </ul>

                                </li>
                                <ul class="navbar-nav">
                                    <li><a href="<%=request.getContextPath()%>/creditosAlunos.jsp"
                                            class="nav-link">Creditos da
                                            dupla</a></li>
                                </ul>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${salesman == null}">
                            <form action="insertSalesman" method="post">
                        </c:if>

                        <caption>
                            <h2 style="color: rgb(144, 28, 126)">

                                <c:if test="${salesman == null}">
                                    Adicionar Vendedor
                                </c:if>
                            </h2>
                        </caption>

                        <fieldset class="form-group">
                            <c:if test="${salesman != null}">
                                <input type="hidden" class="form-control" name="id"
                                    value="<c:out value='${order.id}' />" />
                            </c:if>
                        </fieldset>


                        <fieldset class="form-group">
                            <label>name:</label>
                            <input type="text" class="form-control" name="name" size="45"
                                value="<c:out value='${salesman.name}' />" />
                        </fieldset>

                        <fieldset class="form-group">
                            <label>city:</label>
                            <input type="text" class="form-control" name="city" size="45"
                                value="<c:out value='${salesman.city}' />" />
                        </fieldset>

                        <fieldset class="form-group">
                            <label>comission:</label>
                            <input type="number" class="form-control" name="commission"
                                value="<c:out value='${salesman.commission}' />" />
                        </fieldset>

                        <button type="submit" class="btn btn-info">Salvar</button>
                        </form>
                    </div>
                </div>
            </div>

        </body>

        </html>