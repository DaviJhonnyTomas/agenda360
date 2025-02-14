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



    //fazer construtores e método de conversão de DTO para Entidade Cliente

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;

    }

    public Cliente converterParaCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.nome);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);

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






}
