package pt.com.agenda360.controllers.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AgendamentoDTO {

    private LocalTime hora;
    private LocalDate data;
    private String idCliente;
    private List<String> idsProcedimentos;



    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public List<String> getIdsProcedimentos() {
        return idsProcedimentos;
    }

    public void setIdsProcedimentos(List<String> idsProcedimentos) {
        this.idsProcedimentos = idsProcedimentos;
    }
}
