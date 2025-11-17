package com.cesurg.banco.core.usecase;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaUseCaseImpl implements ContaRepository {

    @Autowired
    ContaUseCase contaUseCase;

    @Override
    public void criarConta(Conta conta) {

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
