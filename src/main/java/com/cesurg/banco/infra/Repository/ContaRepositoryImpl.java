package com.cesurg.banco.infra.Repository;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ContaRepositoryImpl implements ContaRepository {

    private List<Conta> listaDeContas = new CopyOnWriteArrayList<>();

    private long idAtual = 0;
    @Override
    public ResponseEntity<Erro> criarConta(Conta conta) {
        idAtual++;
        conta.setId(idAtual);
        listaDeContas.add(conta);
        return null;
    }

    @Override
    public void deletarConta(long id) {

        for(Conta conta : listaDeContas){
            if(conta.getId() == id){
                listaDeContas.remove(conta);
            }
        }
    }

    @Override
    public List<Conta> listarContas() {
        return this.listaDeContas;
    }

    @Override
    public ResponseEntity<Erro> atualizarConta(long id, Conta novaConta) {
        Conta contaExistente = buscarConta(id);
        //saldo credito agencia numero
        if(novaConta.getSaldo() != null){
            contaExistente.setSaldo(novaConta.getSaldo());
        }
        if(novaConta.getCredito() != null){
            contaExistente.setCredito(novaConta.getCredito());
        }
        if(novaConta.getAgencia() != null){
            contaExistente.setAgencia(novaConta.getAgencia());
        }
        if(novaConta.getNumero() != null){
            contaExistente.setNumero(novaConta.getNumero());
        }
        return null;
    }

    @Override
    public Conta buscarConta(long id){
        for (Conta conta : listaDeContas){
            if(conta.getId() == id){
                return conta;
            }
        }
        return null;
    }

    @Override
    public boolean verificarIdentificador(String agencia, String numero){
        for(Conta conta : listaDeContas){
            if(conta.getAgencia().equals(agencia) && conta.getNumero().equals(numero)){
                return true;
            }
        }
        return false;
    }
    @Override
    public ResponseEntity<Erro> transferir(long idOrigem, long idDestino, BigDecimal valor){

        Conta origem = buscarConta(idOrigem);
        Conta destino = buscarConta(idDestino);

        origem.debitar(valor);
        destino.creditar(valor);

        atualizarConta(idOrigem, origem);
        atualizarConta(idDestino, destino);
        return null;
    }
}
