package pt.com.agenda360.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pt.com.agenda360.controllers.dto.ProcedimentoDTO;
import pt.com.agenda360.entities.Negocio;
import pt.com.agenda360.entities.Procedimento;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.services.NegocioService;
import pt.com.agenda360.services.ProcedimentoService;

import java.util.List;

@Controller
public class ProcedimentoController {

    @Autowired
    private HttpSession httpSession;

    @Autowired
    private NegocioService negocioService;

    @Autowired
    private ProcedimentoService procedimentoService;

    @GetMapping(value = "/cadastrar-procedimento")
    public String carregarPaginaCadastro(Model model){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
        Negocio negocio = negocioService.getNegocio(usuario.getNegocio().getId());
        model.addAttribute("nomeNegocio", negocio.getNome());
        List<Procedimento> procedimentos = procedimentoService.getProcedimentosByIdUsuario(usuario.getId());
        model.addAttribute("procedimentos", procedimentos);
        return "page-procedimentos";
    }
    @PostMapping(value = "/cadastrar-procedimento")
    public String cadastrarProcedimento(ProcedimentoDTO procedimentoDto) {
        Procedimento procedimento = procedimentoDto.converterParaProcedimento();
        procedimentoService.cadastrar(procedimento);

        return "redirect:/cadastrar-procedimento";
    }

    @GetMapping(value = "/editar-procedimento")
    public String carregarEditarProcedimento(@RequestParam String id, Model model){
        Procedimento procedimento = procedimentoService.getById(id);
        model.addAttribute("procedimento", procedimento);
        model.addAttribute("editarProcedimento", "editar");
        return "page-procedimentos";
    }
}
