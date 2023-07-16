<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Funcionário</title>
    <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<header>
    <h2>E-Commerce</h2>
</header>

<div id="titulo">
    <h1>Editar Funcionário</h1>
</div>

<div id="container">

<c:url var="editarFun" value="/usuario/editarFuncionario"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${editarFun}" method="post" modelAttribute="usuario">

    <form:input type="hidden" path="codusuario" value="${usuario.codusuario}"/>

    <div id="campo">
    <form:label path="nome">Nome:</form:label>
    <form:input type="text" path="nome" value="${usuario.nome}"/><br>
    </div>

    <div id="campo">
    <form:label path="cpf">CPF:</form:label>
    <form:input type="text" path="cpf" value="${usuario.cpf}"/><br>
    </div>

    <div id="campo">
    <form:label path="login">Login:</form:label>
    <form:input type="text" path="login" value="${usuario.login}"/><br>

    <form:label path="senha">Senha:</form:label>
    <form:input type="text" path="senha" value="${usuario.senha}"/><br>
    </div>

    <div id="campo">
    <form:label path="cargo">Cargo:</form:label>
    <form:input type="text" path="cargo" value="${usuario.cargo}"/><br>
    </div>

    <div id="campo">
    <form:label path="codper">Permissão:</form:label>
    <form:select path="codper" value="codper">

        <form:option value="1">Gerente</form:option>
        <form:option value="2">Funcionário</form:option>

    </form:select>
    </div>

    <div class="button">
        <button type="submit" class="btn btn-primary" value="submit">Salvar</button>
        <a href="/appmaven/usuario/listarFuncionarios" class="btn btn-primary">Voltar</a>
    </div>

</form:form>

</div>

<div id="aviso">
<c:if test="${not empty msg_servidor}">

    <h2>CNPJ já cadastrado!</h2>

</c:if>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
