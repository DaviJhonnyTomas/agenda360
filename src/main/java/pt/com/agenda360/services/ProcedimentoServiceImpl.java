package pt.com.agenda360.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Procedimento;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.ProcedimentoRepository;

@Service
public class ProcedimentoServiceImpl implements ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    @Autowired
    private HttpSession httpSession;

    @Override
    public void cadastrar(Procedimento procedimento) {

        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        Usuario usuario = new Usuario();
        usuario.setId(usuarioLogado.getId());

        procedimento.setUsuario(usuario);
        procedimentoRepository.insert(procedimento);
    }
}
