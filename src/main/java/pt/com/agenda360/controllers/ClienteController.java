package pt.com.agenda360.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import pt.com.agenda360.controllers.dto.ClienteDTO;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.entities.Procedimento;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.ClienteRepository;
import pt.com.agenda360.services.ClienteService;

import java.util.List;

@Controller
public class ClienteController {

    //endpoints - rotas

    //instanciar com injeção de dependecia
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping(value = "/cadastrar-cliente")
    public String carregarPaginaCadastro(Model model){
        //setar a lista dos clientes
        //(Usuario) .... -> conversão forçada (cast)
        String idUsuarioLogado = ((Usuario) httpSession.getAttribute("usuarioLogado")).getId();
        List<Cliente> clientes = clienteService.getClientesByIdUsuario(idUsuarioLogado);
        model.addAttribute("clientes", clientes);
        return "page-cliente";
    }

    @PostMapping(value = "/cadastrar-cliente")
    public String cadastrarCliente(ClienteDTO clienteDto, Model model){
        Cliente cliente = clienteDto.converterParaCliente();
        try {
            clienteService.cadastrar(cliente);
        } catch (RuntimeException ex) {
            model.addAttribute("erro", ex.getLocalizedMessage());
        }

        String idUsuarioLogado = ((Usuario) httpSession.getAttribute("usuarioLogado")).getId();
        List<Cliente> clientes = clienteService.getClientesByIdUsuario(idUsuarioLogado);
        model.addAttribute("clientes", clientes);

        return "page-cliente";
    }

    @GetMapping(value = "/editar-cliente")
    public String carregarEditarCliente(@RequestParam String id, Model model){
        Cliente cliente = clienteService.getById(id);
        System.out.println("Cliente: " + cliente.getId() + "\n " + cliente.getNome());
        model.addAttribute("cliente", cliente);
        List<Cliente> clientes = clienteService.getAll();
        model.addAttribute("clientes", clientes);
        return "page-cliente"; // return sem redirect informamos o nome de um template
    }

    @PostMapping(value = "/editar-cliente")
    public String editarCliente(Cliente cliente){
        clienteService.editar(cliente);
        return "redirect:/cadastrar-cliente"; //quando usamos redirect no return, sempre devemos informar uma rota após a "/"
    }
    @GetMapping(value = "excluir-cliente")
    public String carregarConfirmacaoExcluir(@RequestParam String id, Model model){
        model.addAttribute("idClienteConfirmacao", id);
        return "page-cliente";
    }
    @PostMapping(value = "excluir-cliente")
    public String excluirCliente(String id){
        clienteService.excluir(id);
        return "redirect:/cadastrar-cliente";
    }

}
