package com.example.trabalho.controller;

import com.example.trabalho.dao.FornecedorDAO;
import com.example.trabalho.dao.UsuarioDAO;
import com.example.trabalho.model.Fornecedor;
import com.example.trabalho.service.FornecedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @GetMapping("/cadastrarFornecedor")
    public String cadastrarFornecedorView(Model model){

        System.out.println("ENTROU NO GET DE CADASTRAR FORNECEDOR");
        model.addAttribute("fornecedor", new Fornecedor());

        return "cadastrarFornecedor";
    }

    @PostMapping("/cadastrarFornecedor")
    public RedirectView cadastrarFornecedorView(@ModelAttribute("fornecedor")Fornecedor fornecedor, RedirectAttributes redirectAttributes){

        System.out.println("ENTROU NO POST DE CADASTRAR FORNECEDOR");
        RedirectView redirectView = null;

        if(new FornecedorService().autenticaFornecedor(fornecedor)){
            redirectView = new RedirectView("/fornecedor/cadastrarFornecedor", true);
            System.out.println("CADASTROU FORNECEDOR");
        }
        else{
            redirectView = new RedirectView("/fornecedor/cadastrarFornecedor", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);
            System.out.println("NÃO CADASTROU");
        }
        return redirectView;
    }


    @GetMapping("/listarFornecedores")
    public String listarFornecedoresView(Model model){

        model.addAttribute("fornecedores", new FornecedorDAO().getFornecedores());

        return "listaFornecedores";
    }

    @PostMapping("/excluirFornecedor")
    public RedirectView excluirFornecedorView(@RequestParam("codfor")int codfor, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        System.out.println("codfor: "+codfor);

        if(new FornecedorDAO().deletarFornecedor(codfor)){

            redirectView = new RedirectView("/fornecedor/listarFornecedores", true);

        }else{

            redirectView = new RedirectView("/fornecedor/listarFornecedores", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }
        return redirectView;
    }

    @GetMapping("/editarFornecedor")
    public String editarFornecedorView(@RequestParam("codfor")int codfor, Model model){

        System.out.println("ENTROU GET EDIT FOR");

        model.addAttribute("fornecedor", new FornecedorDAO().getFornecedor(codfor));

        return "editarFornecedor";
    }

    @PostMapping("/editarFornecedor")
    public RedirectView editarFornecedorView(@ModelAttribute("fornecedor")Fornecedor fornecedor, RedirectAttributes redirectAttributes){

        System.out.println("ENTROU POST EDIT FOR");

        RedirectView redirectView = null;

        System.out.println("fornecedor: "+ fornecedor.getCodfor() + fornecedor.getNomefor() + fornecedor.getCep() + fornecedor.getCnpj());

        if(new FornecedorDAO().editarFornecedor(fornecedor)){

            redirectView = new RedirectView("/fornecedor/listarFornecedores", true);

        }else{

            redirectView = new RedirectView("/fornecedor/listarFornecedores", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }

        return redirectView;
    }
}
