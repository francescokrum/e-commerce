<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista de Pedidos</title>
    <link href="${pageContext.request.contextPath}/css/tabelas.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
<h1>LISTA DE PEDIDOS</h1>
</header>

<div id="container">
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID FORNECEDOR</th>
        <th>ID PRODUTO</th>
        <th>QUANTIDADE</th>
    </tr>
    </thead>
    <c:forEach var="pedido" items="${pedidos}">
        <tr>
            <td>${pedido.codfor}</td>
            <td>${pedido.codprod}</td>
            <td>${pedido.qtd}</td>
            <td>
                <form method="get" action="/appmaven/pedido/editarPedido">
                    <input type="hidden" name="codpedido" value="${pedido.codpedido}">
                    <a href="/appmaven/pedido/editarPedido"><button class="btn btn-primary" type="submit">Editar</button></a>
                </form>
            </td>
            <td>
                <form method="POST" action="/appmaven/pedido/excluirPedido">
                    <input type="hidden" name="codpedido" value="${pedido.codpedido}">
                    <button class="btn btn-danger" type="submit">Excluir</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
    <a href="/appmaven/usuario/principal"><button class="btn btn-primary" type="submit">Voltar</button></a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
