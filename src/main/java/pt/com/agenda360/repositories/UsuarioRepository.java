package pt.com.agenda360.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pt.com.agenda360.entities.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    public Optional<Usuario> findByEmailAndSenha(String email, String senha);
}
