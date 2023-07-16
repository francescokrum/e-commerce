<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Pedido</title>
    <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
<h1>Editar Pedido</h1>
</header>

<div id="titulo">
    <h1>Editar Pedido</h1>
</div>

<div id="container">
<c:url var="editarPedido" value="/pedido/editarPedido"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${editarPedido}" method="post" modelAttribute="pedido">

    <form:input type="hidden" path="codpedido" value="${pedido.codpedido}"/>

    <div id="campo">
    <form:label path="codfor">Fornecedor:</form:label>
    <form:select path="codfor">

        <c:forEach var="fornecedor" items="${fornecedores}">
            <form:option value="${fornecedor.codfor}">${fornecedor.nomefor}</form:option>
        </c:forEach>

    </form:select>
    </div>

    <div id="campo">
    <form:label path="codprod">Produto:</form:label>
    <form:select path="codprod">

        <c:forEach var="produto" items="${produtos}">
            <form:option value="${produto.codprod}">${produto.nomeprod}</form:option>
        </c:forEach>

    </form:select>
    </div>

    <div id="campo">
    <form:label path="qtd">Quantidade:</form:label>
    <form:input type="number" path="qtd"/><br>
    </div>

    <div class="button">
        <button type="submit" class="btn btn-primary" value="submit">Salvar</button>
        <a href="/appmaven/pedido/listarPedidos" class="btn btn-primary">Voltar</a>
    </div>

</form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
