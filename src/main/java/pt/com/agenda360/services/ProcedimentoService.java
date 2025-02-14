package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Procedimento;

import java.util.List;

@Service
public interface ProcedimentoService {

    void cadastrar(Procedimento procedimento);


    List<Procedimento> getProcedimentosByIdUsuario(String id);

    Procedimento getById(String id);

    void editar(Procedimento procedimento);
}
