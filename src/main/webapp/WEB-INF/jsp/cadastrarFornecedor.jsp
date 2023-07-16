<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastrar Fornecedor</title>
    <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<header>
    <h2>E-Commerce</h2>
</header>

<div id="titulo">
    <h1>Formulário de cadastro</h1>
</div>

<div id="container">
<c:url var="cadastrarFor" value="/fornecedor/cadastrarFornecedor"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${cadastrarFor}" method="post" modelAttribute="fornecedor">

    <div id="campo">
    <form:label path="nomefor">Nome:</form:label>
        <form:input type="text" path="nomefor"/><br>
    </div>

    <div id="campo">
    <form:label path="cep">CEP:</form:label>
        <form:input type="text" path="cep"/><br>
    </div>

    <div id="campo">
    <form:label path="cnpj">CNPJ:</form:label>
        <form:input type="text" path="cnpj"/><br>
    </div>

    <div class="button">
    <button type="submit" class="btn btn-primary" value="submit">Cadastrar</button>
    <a href="/appmaven/usuario/principal" class="btn btn-primary">Voltar</a>
    </div>

</form:form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

<div id="aviso">
    <c:if test="${not empty msg_servidor}">

        <h2>CNPJ já cadastrado!</h2>

    </c:if>
</div>

</body>
</html>
