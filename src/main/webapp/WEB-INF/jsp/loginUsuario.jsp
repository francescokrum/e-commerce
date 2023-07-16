<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login Usuario</title>
</head>
<body>
<h2>Logar</h2>

<c:url var="loginUsuario" value="/usuario/loginUsuario"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${loginUsuario}" method="post" modelAttribute="usuario">

    <form:label path="login">Nome:</form:label>
        <form:input type="text" path="login"/><br>

    <form:label path="senha">Senha:</form:label>
        <form:input type="text" path="senha"/><br>

    <input type="submit" value="submit">

</form:form>

<c:if test="${not empty msg_servidor}">

    <h2>Usuário ou senha incorretos</h2>

</c:if>
</body>
</html>
