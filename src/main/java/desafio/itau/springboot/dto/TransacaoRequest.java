package desafio.itau.springboot.dto;

import desafio.itau.springboot.model.Transacao;
import jakarta.validation.constraints.NotNull;

import java.time.OffsetDateTime;

public class TransacaoRequest {

    @NotNull
    private double valor;

    @NotNull
    private OffsetDateTime dataHora;

    public TransacaoRequest(){

    }

    public TransacaoRequest(double valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }
}
