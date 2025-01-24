package pt.com.agenda360.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Procedimento {



        @Id
        private String id;
        private String nome;
        private double duracao;
        private double valor;
        private Usuario usuario;

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public double getDuracao() {
                return duracao;
        }

        public void setDuracao(double duracao) {
                this.duracao = duracao;
        }

        public double getValor() {
                return valor;
        }

        public void setValor(double valor) {
                this.valor = valor;
        }

        public Usuario getUsuario() {
                return usuario;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }
}
