package pt.com.agenda360.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pt.com.agenda360.entities.Agendamento;
import pt.com.agenda360.entities.Negocio;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.services.AgendamentoService;
import pt.com.agenda360.services.NegocioService;

import java.util.List;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private NegocioService negocioService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping(value = "/agendamentos-do-dia")
    public String carregarAgendamentoDoDia(Model model){
        List<Agendamento> agendamentos = agendamentoService.getAgendamentosDoDia();
        model.addAttribute("agendamentos", agendamentos);

        return "page-agendamentos-do-dia";
    }
}
