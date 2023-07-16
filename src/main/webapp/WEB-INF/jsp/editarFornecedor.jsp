<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Fornecedor</title>
    <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>

<header>
    <h2>E-Commerce</h2>
</header>

<div id="titulo">
    <h1>Editar Fornecedor</h1>
</div>
<div id="container">
<c:url var="editarFor" value="/fornecedor/editarFornecedor"/>

<%--@elvariable id="usuario" type=""--%>
<form:form action="${editarFor}" method="post" modelAttribute="fornecedor">

    <form:input type="hidden" path="codfor" value="${fornecedor.codfor}"/>

    <div id="campo">
    <form:label path="nomefor">Nome da empresa:</form:label>
    <form:input type="text" path="nomefor" value="${fornecedor.nomefor}"/><br>
    </div>

    <div id="campo">
    <form:label path="cep">CEP:</form:label>
    <form:input type="text" path="cep" value="${fornecedor.cep}"/><br>
    </div>

    <div id="campo">
    <form:label path="cnpj">CNPJ:</form:label>
    <form:input type="text" path="cnpj" value="${fornecedor.cnpj}"/><br>
    </div>

    <div class="button">
        <button type="submit" class="btn btn-primary" value="submit">Salvar</button>
        <a href="/appmaven/fornecedor/listarFornecedores" class="btn btn-primary">Voltar</a>
    </div>


</form:form>

</div>

<div id="aviso">
<c:if test="${not empty msg_servidor}">

    <h2>CNPJ já cadastrado!</h2>

</c:if>
</div>

</body>
</html>
