package pt.com.agenda360.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.controllers.dto.AgendamentoDTO;
import pt.com.agenda360.entities.Agendamento;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.entities.Procedimento;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.AgendamentoRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private HttpSession httpSession;

    @Override
    public List<Agendamento> getAgendamentosDoDiaByIdUsuario() {
        LocalDate dataAtual = LocalDate.now();
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        List<Agendamento> agendamentos = agendamentoRepository.findAllByDataAndUsuario_id(dataAtual, usuario.getId());

        return agendamentos;
    }

    @Override
    public void cadastrar(AgendamentoDTO agendamentoDto) {
        if(agendamentoDto.getHora() != null && agendamentoDto.getData() != null && agendamentoDto.getIdCliente() != null && agendamentoDto.getIdsProcedimentos() != null) {
            if(agendamentoDto.getIdsProcedimentos().size() > 0) {
                if (!agendamentoDto.getData().isBefore(LocalDate.now()) && !agendamentoDto.getHora().isBefore(LocalTime.now())) {
                    Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

                    Usuario usuario = new Usuario();
                    usuario.setId(usuarioLogado.getId());

                    Agendamento agendamento = new Agendamento();

                    agendamento.setHora(agendamentoDto.getHora());
                    agendamento.setData(agendamentoDto.getData());
                    agendamento.setUsuario(usuario);

                    Cliente cliente = new Cliente();
                    cliente.setId(agendamentoDto.getIdCliente());

                    agendamento.setCliente(cliente);

                    List<Procedimento> procedimentos = new ArrayList<>(); //objetivo: mapear a lista
                    List<String> idsProcedimentos = agendamentoDto.getIdsProcedimentos(); //? procedimento

                    //String idProcedimento1 = idsProcedimentos.get(0);
                    //String idProcedimento2 = idsProcedimentos.get(1);
                    //Procedimento procedimento1 = new Procedimento();
                    //procedimento1.setId(idProcedimento1);
                    //Procedimento procedimento2 = new Procedimento();
                    //procedimento2.setId(idProcedimento2);

                    //procedimentos.add(procedimento1);
                    //procedimentos.add(procedimento2);

                    //mapeando a lista de procedimentos
                    for (int i = 0; i < idsProcedimentos.size(); i++) {
                        String idProcedimento = idsProcedimentos.get(i);
                        Procedimento procedimento = new Procedimento();
                        procedimento.setId(idProcedimento);
                        procedimentos.add(procedimento);
                    }
                    agendamento.setProcedimentos(procedimentos);


                    agendamentoRepository.insert(agendamento);
                } else {
                    throw new RuntimeException("Data ou hora anteriores. Escolha uma data futura");
                }
            }else{
                throw new RuntimeException("Não há serviços selecionados. Selecione pelo menos um serviço e tente novamente.");
            }
        }
        else{
            throw new RuntimeException("Todos os campos devem ser preenchidos.");
        }
    }

    @Override
    public List<Agendamento> getAllAgendamentosByIdUsuario(String id) {
        return agendamentoRepository.findAllByUsuario_id(id);
    }

}
