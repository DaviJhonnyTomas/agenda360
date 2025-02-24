package pt.com.agenda360.services;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.entities.Usuario;
import pt.com.agenda360.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired //injeção de dependencia -> o Spring Boot fica responsável por criar uma única instancia do clienteRepository
    private ClienteRepository clienteRepository;

    @Autowired
    private HttpSession httpSession;

    @Override
    public void cadastrar(Cliente cliente) {

        if(!cliente.getNome().isEmpty() && !cliente.getTelefone().isEmpty())  {
            String idUsuarioLogado = ((Usuario)httpSession.getAttribute("usuarioLogado")).getId();
            Usuario usuario = new Usuario();
            usuario.setId(idUsuarioLogado);
            cliente.setUsuario(usuario);
            clienteRepository.insert(cliente);
        }else{
            throw new RuntimeException("Falta informações do cliente.");
        }
    }


    @Override
    public Cliente buscarPorId(String id) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return List.of();
    }


    @Override
    public void atualizar(Cliente cliente) {

    }

    @Override
    public List<Cliente> getClientesByIdUsuario(String idUsuarioLogado) {
        //parou aqui
        List<Cliente> clientes = clienteRepository.findAllByUsuario_id(idUsuarioLogado);
        return clientes;
    }

    @Override
    public Cliente getById(String id) {
        return clienteRepository.findById(id).orElse(null);

    }

    @Override
    public void editar(Cliente cliente) {
        Usuario usuarioLogado = (Usuario) httpSession.getAttribute("usuarioLogado");

        Usuario usuario = new Usuario();
        usuario.setId(usuarioLogado.getId());

        cliente.setUsuario(usuario);

        clienteRepository.save(cliente);

    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }
    @Override
    public void excluir(String id) {
        clienteRepository.deleteById(id);
    }


}
