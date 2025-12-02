package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface ContaRepository {
    ResponseEntity<Erro> criarConta(Conta conta);
    void deletarConta(long id);
    public List<Conta> listarContas();
    ResponseEntity<Erro> atualizarConta(long id, Conta novaConta);
    public Conta buscarConta(long id);
    boolean verificarIdentificador(String agencia, String numero);
    ResponseEntity<Erro> transferir(long idOrigem, long idDestino, BigDecimal valor);
}
