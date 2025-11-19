package com.cesurg.banco.core.usecase;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContaUseCaseImpl implements ContaUseCase {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public ResponseEntity<Erro> criarConta(@RequestBody Conta conta) {
        boolean jaExiste = contaRepository.verificarIdentificador(conta.getAgencia(),conta.getNumero());

        if(jaExiste){
            throw new RuntimeException("ERRO: Já existe esse número vinculado a essa agência");
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
    public void atualizarConta(long id, Conta novaConta) {
        contaRepository.atualizarConta(id, novaConta);
    }
}
