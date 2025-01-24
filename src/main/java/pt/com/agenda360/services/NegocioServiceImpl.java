package pt.com.agenda360.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Negocio;
import pt.com.agenda360.repositories.NegocioRepository;

import java.util.Optional;

@Service
public class NegocioServiceImpl implements NegocioService {

    @Autowired
    private NegocioRepository negocioRepository;

    @Override
    public Negocio getNegocio(String id) {
        return negocioRepository.findById(id).orElse(null);
    }
}
