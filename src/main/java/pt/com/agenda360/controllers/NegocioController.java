package pt.com.agenda360.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pt.com.agenda360.entities.Negocio;
import pt.com.agenda360.repositories.NegocioRepository;

@Controller
public class NegocioController {

    @Autowired
    private NegocioRepository negocioRepository;

    @PostMapping(value = "/cadastrar-negocio")
    public String cadastrarNegocio(@RequestBody Negocio negocio){
        negocioRepository.save(negocio);

        return "redirect:/login";
    }
}
