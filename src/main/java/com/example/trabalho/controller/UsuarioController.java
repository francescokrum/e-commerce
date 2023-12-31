package com.example.trabalho.controller;

import com.example.trabalho.dao.FornecedorDAO;
import com.example.trabalho.dao.UsuarioDAO;
import com.example.trabalho.model.Fornecedor;
import com.example.trabalho.model.Usuario;
import com.example.trabalho.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("/cadastrarUsuario")
    public String cadastrarUsuarioView(Model model){

        model.addAttribute("usuario", new Usuario());
        return "cadastrarUsuario";
    }

    @PostMapping("/cadastrarUsuario")
    public RedirectView cadastrarUsuarioView(@ModelAttribute("usuario")Usuario usuario, RedirectAttributes redirectAttributes) {

        RedirectView redirectView = null;

        boolean verifica;
        verifica = new UsuarioService().autenticarUsuario(usuario);

        if (verifica == true) {
            redirectView = new RedirectView("/usuario/cadastrarUsuario", true);
        } else if(verifica == false) {
            redirectView = new RedirectView("/appmaven/usuario/cadastrarUsuario");
            redirectAttributes.addFlashAttribute("msg_servidor", false);
        }

        System.out.println("Usuario:" + usuario);

        return redirectView;
    }

    @GetMapping("/loginUsuario")
    public String loginUsuarioView(Model model){
        model.addAttribute("usuario", new Usuario());

        return "loginUsuario";
    }

    @PostMapping("/loginUsuario")
    public RedirectView loginUsuarioView(@ModelAttribute("usuario")Usuario usuario, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        boolean verifica;

        verifica = new UsuarioService().autenticarLogin(usuario);

        if(verifica == false){

            redirectView = new RedirectView("/usuario/principal", true);


        }
        else{
            redirectView = new RedirectView("/usuario/loginUsuario", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);
        }

        return redirectView;
    }

    @GetMapping("/principal")
    public String principalView(Model model){

        model.addAttribute("usuario", new Usuario());

        return "principal";
    }

    @GetMapping("/listarFuncionarios")
    public String listarFuncionariosView(Model model){

        model.addAttribute("usuarios", new UsuarioDAO().getUsuarios());

        return "listaFuncionarios";
    }

    @PostMapping("/excluirFuncionario")
    public RedirectView excluirFornecedorView(@RequestParam("codusuario")int codusuario, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        if(new UsuarioDAO().deletarFuncionario(codusuario)){

            redirectView = new RedirectView("/usuario/listarFuncionarios", true);

        }else{

            redirectView = new RedirectView("/usuario/listarFuncionarios", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }
        return redirectView;
    }

    @GetMapping("/editarFuncionario")
    public String editarUsuarioView(@RequestParam("codusuario")int codusuario, Model model){

        model.addAttribute("usuario", new UsuarioDAO().getUsuario(codusuario));

        return "editarFuncionario";
    }

    @PostMapping("/editarFuncionario")
    public RedirectView editarFornecedorView(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes redirectAttributes){

        RedirectView redirectView = null;

        System.out.println("usuario: "+ usuario.getCodusuario() + usuario.getNome());

        if(new UsuarioDAO().editarFuncionario(usuario)){

            redirectView = new RedirectView("/usuario/listarFuncionarios", true);

        }else{

            redirectView = new RedirectView("/usuario/listarFuncionarios", true);
            redirectAttributes.addFlashAttribute("msg_servidor", false);

        }

        return redirectView;
    }


}
