package pt.com.agenda360.controllers.dto;

import pt.com.agenda360.entities.Cliente;
import pt.com.agenda360.entities.Negocio;
import pt.com.agenda360.entities.Usuario;

public class ClienteDTO {
    // DTO (Data Transfer Object) é um padrão de projeto utilizado para transportar
    // dados entre diferentes camadas de uma aplicação, geralmente simplificando objetos
    // e evitando expor diretamente as entidades do domínio.
    // ctrl + \ -> auxilio da IA

     private String nome;
     private String telefone;
     private String email;
     private String nomeUsuario;
    private String senha;
    private String emailUsuario;
    private String telefoneUsuario;
    private String endereco;


    //fazer construtores e método de conversão de DTO para Entidade Cliente

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String telefone, String email, String nomeUsuario, String login, String senha,
                      int nif, String emailUsuario, String telefoneUsuario, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.emailUsuario = emailUsuario;
        this.telefoneUsuario = telefoneUsuario;
        this.endereco = endereco;

    }

    public Cliente converterParaCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);

        Usuario usuario = new Usuario();
        usuario.setNome(this.nomeUsuario);
        usuario.setSenha(this.senha);
        usuario.setEmail(this.emailUsuario);
        usuario.setTelefone(this.telefoneUsuario);
        usuario.setEndereco(this.endereco);

        cliente.setUsuario(usuario);
        return cliente;
    }

   

     public String getNome() {
         return nome;
     }
     public void setNome(String nome) {
         this.nome = nome;
     }
     public String getTelefone() {
         return telefone;
     }
     public void setTelefone(String telefone) {
         this.telefone = telefone;
     }
     public String getEmail() {
         return email;
     }
     public void setEmail(String email) {
         this.email = email;
     }

     public String getNomeUsuario() {
         return nomeUsuario;
     }
     public void setNomeUsuario(String nomeUsuario) {
         this.nomeUsuario = nomeUsuario;
     }

     public String getSenha() {
         return senha;
     }
     public void setSenha(String senha) {
         this.senha = senha;
     }

     public String getEmailUsuario() {
         return emailUsuario;
     }
     public void setEmailUsuario(String emailUsuario) {
         this.emailUsuario = emailUsuario;
     }
     public String getTelefoneUsuario() {
         return telefoneUsuario;
     }
     public void setTelefoneUsuario(String telefoneUsuario) {
         this.telefoneUsuario = telefoneUsuario;
     }
     public String getEndereco() {
         return endereco;
     }
     public void setEndereco(String endereco) {
         this.endereco = endereco;
     }




}
