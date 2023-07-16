<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Produto</title>
    <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
<h1>Editar Produto</h1>
</header>

<div id="titulo">
    <h1>Editar Produto</h1>
</div>

<div id="container">
<c:url var="editarProd" value="/produto/editarProduto"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${editarProd}" method="post" modelAttribute="produto">

    <form:input type="hidden" path="codprod" value="${produto.codprod}"/>

    <div id="campo">
    <form:label path="nomeprod">Nome do Produto:</form:label>
    <form:input type="text" path="nomeprod" value="${produto.nomeprod}"/><br>


    <div id="campo">
    <form:label path="preco">Preço:</form:label>
    <form:input type="text" path="preco" value="${produto.preco}"/><br>
    </div>

    <div class="button">
        <button type="submit" class="btn btn-primary" value="submit">Salvar</button>
        <a href="/appmaven/produto/listarProdutos" class="btn btn-primary">Voltar</a>
    </div>

</form:form>
</div>

<div id="aviso">
<c:if test="${not empty msg_servidor}">

    <h2>Produto já cadastrado!</h2>

</c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
