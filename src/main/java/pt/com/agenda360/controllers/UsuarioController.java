package pt.com.agenda360.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.com.agenda360.controllers.dto.ClienteDTO;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.UsuarioRepository;
import pt.com.agenda360.services.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/login")
    public String carregarPaginaLogin(){
        return "page-login";
    }

    @PostMapping(value = "/cadastrar-usuario")
    public String cadastrarUsuario(@RequestBody Usuario usuario){

        usuarioRepository.insert(usuario);

        return "redirect:/login";

    }

    @PostMapping(value = "/login")
    public String login(String email, String senha, Model model){
        try { //tentar
            usuarioService.login(email, senha);
            return "redirect:/agendamentos-do-dia";
        }
        catch(RuntimeException exception){ //capturar
            model.addAttribute("erro", exception.getLocalizedMessage());
            return "redirect:/login";
        }
    }

}
