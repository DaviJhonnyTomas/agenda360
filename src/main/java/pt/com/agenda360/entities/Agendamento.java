package pt.com.agenda360.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Document

public class Agendamento {


        @Id
        private String id;

        private LocalTime hora;
        private LocalDate data;
        private Cliente cliente;
        private Usuario usuario;
        private List<Procedimento> procedimentos;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public LocalTime getHora() {
                return hora;
        }

        public void setHora(LocalTime hora) {
                this.hora = hora;
        }

        public LocalDate getData() {
                return data;
        }

        public void setData(LocalDate data) {
                this.data = data;
        }

        public Cliente getCliente() {
                return cliente;
        }

        public void setCliente(Cliente cliente) {
                this.cliente = cliente;
        }

        public Usuario getUsuario() {
                return usuario;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }

        public List<Procedimento> getProcedimentos() {
                return procedimentos;
        }

        public void setProcedimentos(List<Procedimento> procedimentos) {
                this.procedimentos = procedimentos;
        }
}
