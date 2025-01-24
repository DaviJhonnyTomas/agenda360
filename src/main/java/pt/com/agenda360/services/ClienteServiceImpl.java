package pt.com.agenda360.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.repositories.ClienteRepository;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired //injeção de dependencia -> o Spring Boot fica responsável por criar uma única instancia do clienteRepository
    private ClienteRepository clienteRepository;

    @Override
    public void cadastrar(Cliente cliente) {
        if(cliente.getNome() != null && cliente.getTelefone() != null && cliente.getEmail() != null && cliente.getUsuario() != null)  {
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
    public void remover(String id) {

    }

    @Override
    public void atualizar(Cliente cliente) {

    }
}
