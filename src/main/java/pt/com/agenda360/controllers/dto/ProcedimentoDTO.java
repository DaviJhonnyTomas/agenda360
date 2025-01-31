package pt.com.agenda360.controllers.dto;

import pt.com.agenda360.entities.Procedimento;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ProcedimentoDTO {

    private String nome;
    private LocalTime duracao;
    private double valor;

    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("HH:mm");

    public ProcedimentoDTO(String nome, LocalTime duracao, double valor) {
        this.nome = nome;
        this.duracao = duracao;
        this.valor = valor;
    }

    public Procedimento converterParaProcedimento(){
        Procedimento procedimento = new Procedimento();
        procedimento.setNome(this.nome);
        procedimento.setDuracao(this.duracao);
        procedimento.setValor(this.valor);
        return procedimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalTime getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao)  {
        this.duracao = LocalTime.parse(duracao, FORMATADOR);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
