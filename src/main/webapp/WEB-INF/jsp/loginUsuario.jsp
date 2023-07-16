<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Usuario</title>
    <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<header>
<h2>E-Commerce</h2>
</header>

<div id="titulo">
    <h1>Login</h1>
</div>

<div id="container">
<c:url var="loginUsuario" value="/usuario/loginUsuario"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${loginUsuario}" method="post" modelAttribute="usuario">

    <div id="campo">
    <form:label path="login">Nome:</form:label>
        <form:input type="text" path="login"/><br>
    </div>

    <div id="campo">
    <form:label path="senha">Senha:</form:label>
        <form:input type="password" path="senha"/><br>
    </div>

    <button type="submit" class="btn btn-primary" value="submit">Logar</button>

</form:form>

</div>

<c:if test="${not empty msg_servidor}">

    <h2>Usuário ou senha incorretos</h2>

</c:if>
</body>
</html>
