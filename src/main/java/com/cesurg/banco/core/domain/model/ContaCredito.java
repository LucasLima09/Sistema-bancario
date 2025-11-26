package com.cesurg.banco.core.domain.model;

import java.math.BigDecimal;

public class ContaCredito extends Conta{

    private BigDecimal creditoLimite = BigDecimal.valueOf(1500);
    private BigDecimal creditoUsado = BigDecimal.ZERO;

    public ContaCredito() {
        super.setTipo("CREDITO");
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
