package pt.com.agenda360.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {

        @Id
        private String id;
        private String nome;
        private String senha;
        private String email;
        private String telefone;
        private String endereco;
        private Negocio negocio;
        private int tipo;


        public int getTipo() {
                return tipo;
        }
        public void setTipo(int tipo) {
                this.tipo = tipo;
        }

        public Negocio getNegocio() {
                return negocio;
        }

        public void setNegocio(Negocio negocio) {
                this.negocio = negocio;
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



        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }



        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getTelefone() {
                return telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public String getEndereco() {
                return endereco;
        }

        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }
}
