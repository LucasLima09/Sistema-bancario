package com.cesurg.banco.core.domain.model;

import java.math.BigDecimal;

public class Conta {
    private long id;
    private String tipo;
    private BigDecimal saldo;
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

    public Conta(long id, String tipo, BigDecimal saldo, String agencia, String numero) {
        this.id = id;
        this.tipo = tipo;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numero = numero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
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
