package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.controllers.dto.AgendamentoDTO;
import pt.com.agenda360.entities.Agendamento;

import java.util.List;

@Service
public interface AgendamentoService {


    List<Agendamento> getAllAgendamentosByIdUsuario(String id);

    List<Agendamento> getAgendamentosDoDiaByIdUsuario();

    void cadastrar(AgendamentoDTO agendamentoDto);
}
