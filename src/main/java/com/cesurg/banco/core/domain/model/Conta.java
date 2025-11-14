package com.cesurg.banco.core.domain.model;

import java.math.BigDecimal;

public class Conta {
    private long id;
    private BigDecimal saldo;
    private BigDecimal credito;
    private String agencia;
    private String numero;

    private long clienteId;

    public Conta() {
    }

    public Conta(long id, BigDecimal saldo, BigDecimal credito, String agencia, String numero) {
        this.id = id;
        this.saldo = saldo;
        this.credito = credito;
        this.agencia = agencia;
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getCredito() {
        return credito;
    }

    public void setCredito(BigDecimal credito) {
        this.credito = credito;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }
}
