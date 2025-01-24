package pt.com.agenda360.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Negocio {

        @Id

        private String id;
        private String nome;
        private String email;
        private String telefone;
        private String endereco;
        private int nif;
        private int plano;
        private double valor;
        private Usuario usuarioAdm;
        private Estilo estilo;

        public Estilo getEstilo() {
                return estilo;
        }

        public void setEstilo(Estilo estilo) {
                this.estilo = estilo;
        }

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

        public String getEndereco() {
                return endereco;
        }

        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }

        public int getNif() {
                return nif;
        }

        public void setNif(int nif) {
                this.nif = nif;
        }

        public String getTelefone() {
                return telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public int getPlano() {
                return plano;
        }

        public void setPlano(int plano) {
                this.plano = plano;
        }

        public double getValor() {
                return valor;
        }

        public void setValor(double valor) {
                this.valor = valor;
        }

        public Usuario getUsuarioAdm() {
                return usuarioAdm;
        }

        public void setUsuarioAdm(Usuario usuarioAdm) {
                this.usuarioAdm = usuarioAdm;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
