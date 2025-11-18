package com.cesurg.banco.infra.Repository;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.model.Conta;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ContaRepositoryImpl implements ContaRepository {

    private List<Conta> listaDeContas = new CopyOnWriteArrayList<>();

    private long idAtual = 0;
    @Override
    public void criarConta(Conta conta) {
        idAtual++;
        conta.setId(idAtual);
        listaDeContas.add(conta);
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
    public void atualizarConta(long id, Conta novaConta) {
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
}
