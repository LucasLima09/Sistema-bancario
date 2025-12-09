package com.cesurg.banco.core.domain.model;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class ContaCredito extends Conta{

    private BigDecimal creditoLimite = BigDecimal.valueOf(1500);
    private BigDecimal creditoUsado = BigDecimal.ZERO;

    public ContaCredito() {
        super.setTipo("CREDITO");
    }

    public void usarCredito(BigDecimal valor){

        if(valor.compareTo(BigDecimal.valueOf(0)) <= 0) {
            throw new RuntimeException("ERRO: O valor deve ser maior que 0");
        }
        if(valor.compareTo(creditoLimite) > 0){
            throw new RuntimeException("ERRO: O valor do produto é maior que o seu limite de crédito");
        }

        this.creditoUsado = this.creditoUsado.add(valor);

        if (creditoUsado.compareTo(creditoLimite) > 0) {
            this.creditoUsado = this.creditoUsado.subtract(valor);
            throw new RuntimeException("ERRO: Você não tem crédito suficiente");
        }

    }

    public BigDecimal getCreditoLimite() {
        return creditoLimite;
    }

    public void setCreditoLimite(BigDecimal creditoLimite) {
        this.creditoLimite = creditoLimite;
    }

    public BigDecimal getCreditoUsado() {
        return creditoUsado;
    }

    public void setCreditoUsado(BigDecimal creditoUsado) {
        this.creditoUsado = creditoUsado;
    }
}
