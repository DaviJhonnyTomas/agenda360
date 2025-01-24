package pt.com.agenda360.services;

import org.springframework.stereotype.Service;
import pt.com.agenda360.entities.Negocio;

@Service
public interface NegocioService {

    public Negocio getNegocio(String id);
}
