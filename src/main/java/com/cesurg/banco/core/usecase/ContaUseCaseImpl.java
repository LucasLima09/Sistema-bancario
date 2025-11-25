package com.cesurg.banco.core.usecase;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ContaUseCaseImpl implements ContaUseCase {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public ResponseEntity<Erro> criarConta(@RequestBody Conta conta) {
        boolean jaExiste = contaRepository.verificarIdentificador(conta.getAgencia(),conta.getNumero());

        if(jaExiste){
            throw new RuntimeException("ERRO: Já existe uma conta com esse número vinculado a essa agência");
        }
        return contaRepository.criarConta(conta);
    }

    @Override
    public void deletarConta(long id) {
        contaRepository.deletarConta(id);
    }

    @Override
    public List<Conta> listarContas() {
        return contaRepository.listarContas();
    }

    @Override
    public ResponseEntity<Erro> atualizarConta(long id, Conta novaConta) {
        boolean jaExiste = contaRepository.verificarIdentificador(novaConta.getAgencia(),novaConta.getNumero());

        if(jaExiste){
            throw new RuntimeException("ERRO: Já existe uma conta com esse número vinculado a essa agência");
        }
        return contaRepository.atualizarConta(id, novaConta);
    }
    @Override
    public ResponseEntity<Erro> transferir(long idOrigem, long idDestino, BigDecimal valor){
        return contaRepository.transferir(idOrigem, idDestino, valor);
    }
}
