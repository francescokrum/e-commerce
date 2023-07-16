<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
    <h1>HOME</h1>
</header>
    <div id="container">
    <div class="opcao">
        <h1>Funcionários</h1>
            <div class="button">
    <a href="/appmaven/usuario/listarFuncionarios"><button class="btn btn-primary" type="submit">Mostrar Funcionários</button></a>
    </div>
        <div class="button">
            <a href="/appmaven/usuario/cadastrarUsuario"><button class="btn btn-primary" type="submit">Cadastrar Funcionários</button></a>
        </div>
    </div>

    <div class="opcao">
        <h1>Fornecedores</h1>
    <div class="button">
        <a href="/appmaven/fornecedor/listarFornecedores"><button class="btn btn-primary" type="submit">Mostrar Fornecedores</button></a><br>
    </div>
        <div class="button">
            <a href="/appmaven/fornecedor/cadastrarFornecedor"><button class="btn btn-primary" type="submit">Cadastrar Fornecedor</button></a>
        </div>
    </div>

        <div class="opcao">
            <h1>Produto</h1>
            <div class="button">
    <a href="/appmaven/produto/listarProdutos"><button class="btn btn-primary" type="submit">Mostrar Produtos</button></a>
        </div>
            <div class="button">
                <a href="/appmaven/produto/cadastrarProduto"><button class="btn btn-primary" type="submit">Cadastrar Produto</button></a><br>
            </div>
        </div>

        <div class="opcao">
            <h1>Pedido</h1>
            <div class="button">
    <a href="/appmaven/pedido/listarPedidos"><button class="btn btn-primary" type="submit">Mostrar Pedidos</button></a>
        </div>
            <div class="button">
                <a href="/appmaven/pedido/cadastrarPedido"><button class="btn btn-primary" type="submit">Cadastrar Pedido</button></a><br>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
