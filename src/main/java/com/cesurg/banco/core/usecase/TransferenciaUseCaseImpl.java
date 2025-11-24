package com.cesurg.banco.core.usecase;

import com.cesurg.banco.core.domain.interfaces.ContaRepository;
import com.cesurg.banco.core.domain.interfaces.TransferenciaRepository;
import com.cesurg.banco.core.domain.interfaces.TransferenciaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferenciaUseCaseImpl implements TransferenciaUseCase {

    @Autowired
    ContaRepository contaRepository;

    @Override
    public ResponseEntity<Erro> transferir(long idOrigem, long idDestino, BigDecimal valor){

        Conta origem = contaRepository.buscarConta(idOrigem);
        Conta destino = contaRepository.buscarConta(idDestino);

        origem.debitar(valor);
        destino.creditar(valor);

        contaRepository.atualizarConta(idOrigem, origem);
        contaRepository.atualizarConta(idDestino, destino);
        return null;
    }
}
