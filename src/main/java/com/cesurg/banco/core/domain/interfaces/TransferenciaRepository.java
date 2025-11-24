package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface TransferenciaRepository {
    public ResponseEntity<Erro> transferir(long idOrigem, long idDestino, BigDecimal valor);
}
