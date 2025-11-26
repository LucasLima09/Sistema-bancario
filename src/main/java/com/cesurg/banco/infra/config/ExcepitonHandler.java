package com.cesurg.banco.infra.config;

import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepitonHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Erro> tratarErros(RuntimeException e){
        String textoErro = e.getMessage();

        Erro erro = new Erro(textoErro);

        return ResponseEntity.badRequest().body(erro);
    }
}
