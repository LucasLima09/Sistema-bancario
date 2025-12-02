package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.Conta;

import java.math.BigDecimal;
import java.util.List;

public interface ContaRepository {
    void criarConta(Conta conta);
    void deletarConta(long id);
    List<Conta> listarContas();
    Conta atualizarConta(long id, Conta novaConta);
    Conta buscarConta(long id);
    boolean verificarIdentificador(String agencia, String numero);
    void transferir(long idOrigem, long idDestino, BigDecimal valor);
}
