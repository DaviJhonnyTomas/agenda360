package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Procedimento;

@Service
public interface ProcedimentoService {

    void cadastrar(Procedimento procedimento);

    //versionamento de código -> versões

    // primeira vez que enviou pro github -> 1° versão

    //arquivos em verde -> foram criados (novos) em comparação com a ultima versão do github

    // arquivos em azul -> foram alterados
}
