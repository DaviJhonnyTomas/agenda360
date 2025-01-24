package pt.com.agenda360.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HttpSession httpSession;

    @Override
    public void login(String email, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmailAndSenha(email, senha);

        if(usuarioOptional.isPresent()){
            Usuario usuario = usuarioOptional.get();

            httpSession.setAttribute("usuarioLogado", usuario);

        }
        else{
            throw new RuntimeException("Email ou senha incorretos.");
        }
    }

}
