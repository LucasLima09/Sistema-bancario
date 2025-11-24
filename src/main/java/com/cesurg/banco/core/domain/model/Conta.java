package com.cesurg.banco.core.domain.model;

import java.math.BigDecimal;

public class Conta {
    private long id;
    private BigDecimal saldo;
    private BigDecimal credito;
    private String agencia;
    private String numero;

    private long clienteId;


    public void debitar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Valor inválido");
        }
        if (this.saldo.compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(valor);
    }

    public void creditar(BigDecimal valor){
        if(valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("O valor deve ser maior que zero");
        }
        this.saldo = this.saldo.add(valor);
    }

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
