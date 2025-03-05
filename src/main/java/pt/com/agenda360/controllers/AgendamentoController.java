package pt.com.agenda360.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pt.com.agenda360.controllers.dto.AgendamentoDTO;
import pt.com.agenda360.entities.*;
import pt.com.agenda360.services.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private NegocioService negocioService;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping(value = "/agendamentos-do-dia")
    public String carregarAgendamentoDoDia(Model model){

        List<Agendamento> agendamentos = agendamentoService.getAgendamentosDoDiaByIdUsuario();
        model.addAttribute("agendamentos", agendamentos);

        return "page-agendamentos-do-dia";
    }
    @GetMapping(value = "/cadastrar-agendamento")
    public String carregarCadastrarAgendamento(Model model){
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");
        List<Agendamento> agendamentos = agendamentoService.getAllAgendamentosByIdUsuario(usuarioLogado.getId());
        model.addAttribute("agendamentos", agendamentos);

        List<Cliente> clientes = clienteService.getClientesByIdUsuario(usuarioLogado.getId());
        model.addAttribute("clientes", clientes);
        List<Procedimento> procedimentos = procedimentoService.getProcedimentosByIdUsuario(usuarioLogado.getId());
        model.addAttribute("procedimentos", procedimentos);
        return "page-agendamentos";
    }
    @PostMapping(value = "/cadastrar-agendamento")
    public String cadastrarAgendamento(AgendamentoDTO agendamentoDto){
        agendamentoService.cadastrar(agendamentoDto);
        return "redirect:/cadastrar-agendamento";
    }


}
