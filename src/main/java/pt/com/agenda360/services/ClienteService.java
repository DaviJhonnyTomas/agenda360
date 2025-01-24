package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Cliente;

import java.util.List;

@Service
public interface ClienteService {

    public void cadastrar(Cliente cliente);

    public Cliente buscarPorId(String id);

    public List<Cliente> buscarTodos();

    public void remover(String id);

    public void atualizar(Cliente cliente);

}
