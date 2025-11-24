package com.cesurg.banco.core.domain.model;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta{
    private BigDecimal saldoPoupanca;

    public ContaPoupanca(long id, BigDecimal saldo, BigDecimal credito, String agencia, String numero, BigDecimal saldoPoupanca) {
        super(id, saldo, credito, agencia, numero);
        this.saldoPoupanca = saldoPoupanca;
    }

    public BigDecimal getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public void setSaldoPoupanca(BigDecimal saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
    }
}
