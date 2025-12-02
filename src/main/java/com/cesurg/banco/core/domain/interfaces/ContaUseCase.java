package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.*;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ContaUseCase {
    ResponseEntity<Erro> criarContaCorrente(ContaCorrente conta);
    ResponseEntity<Erro> criarContaPoupanca(ContaPoupanca conta);
    ResponseEntity<Erro> criarContaCredito(ContaCredito conta);
    void deletarConta(long id);
    public List<Conta> listarContas();
    ResponseEntity<Erro> atualizarConta(long id, Conta novaConta);
    ResponseEntity<Erro> transferir(long idOrigem, long idDestino, BigDecimal valor);
    ResponseEntity<Erro> aplicarPoupanca(long id, BigDecimal valor);
    ResponseEntity<Erro> usarCredito(long id, BigDecimal valor);
    public Conta buscarConta(long id);
}
