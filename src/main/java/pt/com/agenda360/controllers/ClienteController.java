package pt.com.agenda360.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.com.agenda360.controllers.dto.ClienteDTO;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.repositories.ClienteRepository;

@Controller
public class ClienteController {

    //endpoints - rotas



    @GetMapping(value = "/cadastrar-cliente")
    public String carregarPaginaCadastro(){

        return "page-cliente";
    }

    @PostMapping(value = "/cadastrar-cliente")
    public String cadastrarCliente(ClienteDTO clienteDto){
        Cliente cliente = clienteDto.converterParaCliente();
        //clienteRepository.insert(cliente);
        return "redirect:/cadastrar-cliente";
    }


}
