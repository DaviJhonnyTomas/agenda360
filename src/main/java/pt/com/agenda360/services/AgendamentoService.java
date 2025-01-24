package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Agendamento;

import java.util.List;

@Service
public interface AgendamentoService {

    public List<Agendamento> getAgendamentosDoDia();
}
