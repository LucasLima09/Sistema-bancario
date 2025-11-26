package com.cesurg.banco.core.domain.model;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{

    private BigDecimal saldoPoupanca = BigDecimal.ZERO;

    public ContaPoupanca(){
        super.setTipo("POUPANCA");
    }

    public ResponseEntity<Erro> aplicarPoupanca(BigDecimal valor){

        if(super.getSaldo().compareTo(valor)>=0){

            BigDecimal novoSaldo = super.getSaldo().subtract(valor);

            super.setSaldo(novoSaldo);
            this.saldoPoupanca = this.saldoPoupanca.add(valor);
        }else {
            throw new RuntimeException("ERRO: Saldo insuficiente para aplicar");
        }
        return null;
    }

    public BigDecimal getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public void setSaldoPoupanca(BigDecimal saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
    }
}
