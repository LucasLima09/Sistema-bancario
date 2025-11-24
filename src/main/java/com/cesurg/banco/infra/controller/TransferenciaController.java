package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.TransferenciaUseCase;
import com.cesurg.banco.core.domain.model.Erro;
import com.cesurg.banco.infra.dto.TransferenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaUseCase transferenciaUseCase;

    @PostMapping
    public ResponseEntity<Erro> transferir(@RequestBody TransferenciaDTO dto){
        try {
            transferenciaUseCase.transferir(dto.origem(), dto.destino(), dto.valor());
        }catch (RuntimeException e){
            String textoErro = e.getMessage();

            Erro erro = new Erro(textoErro);

            return ResponseEntity.badRequest().body(erro);
        }
        return null;
    }

}
