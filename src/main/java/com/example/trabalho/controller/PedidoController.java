package com.example.trabalho.controller;

import com.example.trabalho.dao.FornecedorDAO;
import com.example.trabalho.dao.PedidoDAO;
import com.example.trabalho.dao.ProdutoDAO;
import com.example.trabalho.model.Pedido;
import com.example.trabalho.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @GetMapping("/cadastrarPedido")
    public String cadastrarPedidoView(Model model){

        model.addAttribute("pedido", new Pedido());
        model.addAttribute("fornecedores", new FornecedorDAO().getFornecedores());
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());

        return "cadastrarPedido";
    }

    @PostMapping("/cadastrarPedido")
    public RedirectView cadastrarPedidoView(@ModelAttribute("pedido") Pedido pedido, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        System.out.println("codfor :"+ pedido.getCodfor());
        System.out.println("codprod: "+ pedido.getCodprod());
        System.out.println("qtd: "+ pedido.getQtd());

        if(new PedidoDAO().cadastrarPedido(pedido)){

            redirectView = new RedirectView("/pedido/cadastrarPedido", true);

        }
        else{

            redirectView = new RedirectView("/pedido/cadastrarPedido", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }
        return redirectView;
    }

    @GetMapping("/listarPedidos")
    public String listarProdutosView(Model model){

        System.out.println("TA ENTRANDO NA LISTAGEM DE pedidos");

        model.addAttribute("pedidos", new PedidoDAO().getPedidos());

        return "listaPedidos";
    }

    @PostMapping("/excluirPedido")
    public RedirectView excluirProdutoView(@RequestParam("codpedido")int codpedido, RedirectAttributes redirectAttributes){
        RedirectView redirectView = null;

        new PedidoDAO().deletarPedido(codpedido);

        redirectView = new RedirectView("/pedido/listarPedidos", true);

        return redirectView;
    }

    @GetMapping("/editarPedido")
    public String editarUsuarioView(@RequestParam("codpedido")int codpedido, Model model){

        System.out.println("ENTROU GET EDIT PROD");

        model.addAttribute("pedido", new PedidoDAO().getPedido(codpedido));
        model.addAttribute("fornecedores", new FornecedorDAO().getFornecedores());
        model.addAttribute("produtos", new ProdutoDAO().getProdutos());

        return "editarPedido";
    }

    @PostMapping("/editarPedido")
    public RedirectView editarFornecedorView(@ModelAttribute("pedido") Pedido pedido, RedirectAttributes redirectAttributes){

        System.out.println("CODPEDIDO" + pedido.getCodpedido());

        RedirectView redirectView = null;

        new PedidoDAO().editarPedido(pedido);

        redirectView = new RedirectView("/pedido/listarPedidos", true);

        return redirectView;
    }

}
