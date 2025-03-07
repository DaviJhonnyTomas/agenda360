package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.entities.Procedimento;

import java.util.List;

@Service
public interface ClienteService {

    public void cadastrar(Cliente cliente);

    public Cliente buscarPorId(String id);

    public List<Cliente> buscarTodos();

    public void atualizar(Cliente cliente);

    List<Cliente> getClientesByIdUsuario(String idUsuarioLogado);

    Cliente getById(String id);


    void editar(Cliente cliente);


    List<Cliente> getAll();

    void excluir(String id);
}
