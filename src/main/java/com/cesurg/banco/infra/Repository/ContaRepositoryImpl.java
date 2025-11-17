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

    }

    @Override
    public List<Conta> listarContas() {
        return null;
    }

    @Override
    public void atualizarConta(long id, Conta novaConta) {

    }
}
