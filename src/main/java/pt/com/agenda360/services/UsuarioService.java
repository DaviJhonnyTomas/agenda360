package pt.com.agenda360.services;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    public void login(String email, String senha);
}
