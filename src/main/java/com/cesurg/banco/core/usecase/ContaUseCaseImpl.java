package com.cesurg.banco.core.usecase;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.*;
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
    public ResponseEntity<Erro> criarContaCorrente(@RequestBody ContaCorrente conta) {
        boolean jaExiste = contaRepository.verificarIdentificador(conta.getAgencia(),conta.getNumero());

        if(jaExiste){
            throw new RuntimeException("ERRO: Já existe uma conta com esse número vinculado a essa agência");
        }
        conta.setTipo("CORRENTE");
        return contaRepository.criarConta(conta);
    }

    @Override
    public ResponseEntity<Erro> criarContaPoupanca(@RequestBody ContaPoupanca conta) {
        boolean jaExiste = contaRepository.verificarIdentificador(conta.getAgencia(),conta.getNumero());

        if(jaExiste){
            throw new RuntimeException("ERRO: Já existe uma conta com esse número vinculado a essa agência");
        }
        conta.setTipo("POUPANCA");
        return contaRepository.criarConta(conta);
    }

    @Override
    public ResponseEntity<Erro> criarContaCredito(@RequestBody ContaCredito conta) {
        boolean jaExiste = contaRepository.verificarIdentificador(conta.getAgencia(),conta.getNumero());

        if(jaExiste){
            throw new RuntimeException("ERRO: Já existe uma conta com esse número vinculado a essa agência");
        }
        conta.setTipo("CREDITO");
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
    public Conta buscarConta(long id){
        return contaRepository.buscarConta(id);
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

    @Override
    public ResponseEntity<Erro> aplicarPoupanca(long id, BigDecimal valor){
        Conta conta = contaRepository.buscarConta(id);

        if(conta instanceof ContaPoupanca){

            ContaPoupanca poupanca = (ContaPoupanca) conta;

            poupanca.aplicarPoupanca(valor);

            contaRepository.atualizarConta(id, poupanca);
        }else{
            throw new RuntimeException("ERRO: Conta "+conta.getTipo()+" não aceita esse tipo de método");
        }
        return null;
    }

    @Override
    public ResponseEntity<Erro> usarCredito(long id, BigDecimal valor){

        Conta conta = contaRepository.buscarConta(id);

        if(conta instanceof ContaCredito) {
            ContaCredito credito = (ContaCredito) conta;

            credito.usarCredito(valor);

            contaRepository.atualizarConta(id, credito);
        }else{
            throw new RuntimeException("ERRO: Conta "+conta.getTipo()+" não aceita esse tipo de método");
        }
        return null;
    }
}
