package pt.com.agenda360.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.com.agenda360.entities.Negocio;

@Repository
public interface NegocioRepository extends MongoRepository<Negocio, String> {
}
