<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista de Funcionários</title>
    <link href="${pageContext.request.contextPath}/css/tabelas.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
<h1>LISTA DE FUNCIONÁRIOS</h1>
</header>

<div id="container">
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">Nome</th>
        <th scope="col">CPF</th>
        <th scope="col">Login</th>
        <th scope="col">Senha</th>
        <th scope="col">Cargo</th>
    </tr>
    </thead>
    <c:forEach var="usuario" items="${usuarios}">
        <tbody>
        <tr>
            <td>${usuario.nome}</td>
            <td>${usuario.cpf}</td>
            <td>${usuario.login}</td>
            <td>${usuario.senha}</td>
            <td>${usuario.cargo}</td>
            <td>
                <form method="get" action="/appmaven/usuario/editarFuncionario">
                    <input type="hidden" name="codusuario" value="${usuario.codusuario}">
                    <a href="/appmaven/usuario/editarFuncionario"><button class="btn btn-primary" type="submit" >Editar</button></a>
                </form>
            </td>
            <td>
                <form method="POST" action="/appmaven/usuario/excluirFuncionario">
                    <input type="hidden" name="codusuario" value="${usuario.codusuario}">
                    <button class="btn btn-danger" type="submit">Excluir</button>
                </form>
            </td>

        </tr>
        </tbody>
    </c:forEach>
</table>
    <a href="/appmaven/usuario/principal"><button class="btn btn-primary" type="submit">Voltar</button></a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
