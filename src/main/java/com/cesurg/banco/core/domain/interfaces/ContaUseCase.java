package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContaUseCase {
    ResponseEntity<Erro> criarConta(Conta conta);
    void deletarConta(long id);
    public List<Conta> listarContas();
    void atualizarConta(long id, Conta novaConta);
}
