package pt.com.agenda360.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Procedimento;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.ProcedimentoRepository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Procedimento> getProcedimentosByIdUsuario(String id) {
        return procedimentoRepository.findAllByUsuario_id(id);
    }

    @Override
    public Procedimento getById(String id) {
        Optional<Procedimento> procedimentoOptional = procedimentoRepository.findById(id);

        if(procedimentoOptional.isPresent()){
            Procedimento procedimento = procedimentoOptional.get();

            return procedimento;
        }else{
            throw new RuntimeException("Procedimento não encontrado.");
        }
    }

    @Override
    public void editar(Procedimento procedimento) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        Usuario usuario = new Usuario();
        usuario.setId(usuarioLogado.getId());

        procedimento.setUsuario(usuario);
        procedimentoRepository.save(procedimento);
    }
}
