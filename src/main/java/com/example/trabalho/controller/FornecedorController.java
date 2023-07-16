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

        model.addAttribute("fornecedor", new Fornecedor());

        return "cadastrarFornecedor";
    }

    @PostMapping("/cadastrarFornecedor")
    public RedirectView cadastrarFornecedorView(@ModelAttribute("fornecedor")Fornecedor fornecedor, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        if(new FornecedorService().autenticaFornecedor(fornecedor)){
            redirectView = new RedirectView("/fornecedor/cadastrarFornecedor", true);
        }
        else{
            redirectView = new RedirectView("/fornecedor/cadastrarFornecedor", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);
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

        model.addAttribute("fornecedor", new FornecedorDAO().getFornecedor(codfor));

        return "editarFornecedor";
    }

    @PostMapping("/editarFornecedor")
    public RedirectView editarFornecedorView(@ModelAttribute("fornecedor")Fornecedor fornecedor, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        if(new FornecedorDAO().editarFornecedor(fornecedor)){

            redirectView = new RedirectView("/fornecedor/listarFornecedores", true);

        }else{

            redirectView = new RedirectView("/fornecedor/listarFornecedores", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }

        return redirectView;
    }
}
