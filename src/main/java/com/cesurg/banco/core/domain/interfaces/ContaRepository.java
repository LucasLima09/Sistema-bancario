package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.Conta;

import java.util.List;

public interface ContaRepository {
    void criarConta(Conta conta);
    void deletarConta(long id);
    public List<Conta> listarContas();
    void atualizarConta(long id, Conta novaConta);
    public Conta buscarConta(long id);
}
