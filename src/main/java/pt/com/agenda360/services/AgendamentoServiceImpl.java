package pt.com.agenda360.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Agendamento;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.AgendamentoRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private HttpSession httpSession;

    @Override
    public List<Agendamento> getAgendamentosDoDia() {
        LocalDate dataAtual = LocalDate.now();
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        List<Agendamento> agendamentos = agendamentoRepository.findAllByDataAndUsuario_id(dataAtual, usuario.getId());

        return agendamentos;
    }
}
