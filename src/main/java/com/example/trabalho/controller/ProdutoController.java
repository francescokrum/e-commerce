package com.example.trabalho.controller;

import com.example.trabalho.dao.ProdutoDAO;
import com.example.trabalho.dao.UsuarioDAO;
import com.example.trabalho.model.Produto;
import com.example.trabalho.model.Usuario;
import com.example.trabalho.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/cadastrarProduto")
    public String cadastrarProdutoView(Model model){

        System.out.println("CHAMOU O GET DE CADASTRAR PRODUTO");
        model.addAttribute("produto", new Produto());

        return"cadastrarProduto";
    }

    @PostMapping("/cadastrarProduto")
    public RedirectView cadastrarProdutoView(@ModelAttribute("produto")Produto produto, RedirectAttributes redirectAttributes){

        System.out.println(("CHAMOU O POST DE CADASTRAR PRODUTO"));
        RedirectView redirectView = null;

        if(new ProdutoService().autenticarProduto(produto)){
            redirectView = new RedirectView("/produto/cadastrarProduto", true);
            System.out.println("CADASTROU O PRODUTO");
        }
        else{
            redirectView = new RedirectView("/produto/cadastrarProduto", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);
            System.out.println("NÃO CADASTROU PRODUTO");
        }

        return redirectView;
    }

    @GetMapping("/listarProdutos")
    public String listarProdutosView(Model model){

        System.out.println("TA ENTRANDO NA LISTAGEM DE PRODUTOS");

        model.addAttribute("produtos", new ProdutoDAO().getProdutos());

        return "listaProduto";
    }

    @PostMapping("/excluirProduto")
    public RedirectView excluirProdutoView(@RequestParam("codprod")int codprod, RedirectAttributes redirectAttributes){
        RedirectView redirectView = null;

        if(new ProdutoDAO().deletarProduto(codprod)){

            redirectView = new RedirectView("/produto/listarProdutos", true);
        }
        else{
            redirectView = new RedirectView("/produto/listarProdutos", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);
        }

        return redirectView;
    }

    @GetMapping("/editarProduto")
    public String editarUsuarioView(@RequestParam("codprod")int codprod, Model model){

        System.out.println("ENTROU GET EDIT PROD");

        model.addAttribute("produto", new ProdutoDAO().getProduto(codprod));

        return "editarProduto";
    }

    @PostMapping("/editarProduto")
    public RedirectView editarFornecedorView(@ModelAttribute("produto") Produto produto, RedirectAttributes redirectAttributes){

        System.out.println("ENTROU POST EDIT FOR");

        RedirectView redirectView = null;

        System.out.println("produto: "+ produto.getCodprod() + produto.getNomeprod());

        if(new ProdutoDAO().editarProduto(produto)){

            redirectView = new RedirectView("/produto/listarProdutos", true);

        }else{

            redirectView = new RedirectView("/produto/listarProdutos", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }

        return redirectView;
    }

}
