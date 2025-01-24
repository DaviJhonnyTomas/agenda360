package pt.com.agenda360.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.com.agenda360.entities.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
