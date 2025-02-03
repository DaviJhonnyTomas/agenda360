package pt.com.agenda360.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pt.com.agenda360.entities.Procedimento;

import java.util.List;

public interface ProcedimentoRepository extends MongoRepository<Procedimento, String> {
    List<Procedimento> findAllByUsuario_id(String id);
}
