package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.*;

import java.math.BigDecimal;
import java.util.List;

public interface ContaUseCase {
    void criarContaCorrente(ContaCorrente conta);
    void criarContaPoupanca(ContaPoupanca conta);
    void criarContaCredito(ContaCredito conta);
    void deletarConta(long id);
    List<Conta> listarContas();
    Conta atualizarConta(long id, Conta novaConta);
    void transferir(long idOrigem, long idDestino, BigDecimal valor);
    void aplicarPoupanca(long id, BigDecimal valor);
    void usarCredito(long id, BigDecimal valor);
    Conta buscarConta(long id);
}
