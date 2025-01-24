package pt.com.agenda360.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.com.agenda360.entities.Agendamento;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendamentoRepository extends MongoRepository<Agendamento, String> {
    List<Agendamento> findAllByDataAndUsuario_id(LocalDate data, String id);
}
