package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import com.cesurg.banco.core.usecase.ContaUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaUseCase contaUseCase;

    @PostMapping
    ResponseEntity<Erro> criarConta(@RequestBody Conta conta){
        try {
            return contaUseCase.criarConta(conta);
        }catch (RuntimeException e){
            String textoErro = e.getMessage();

            Erro erro = new Erro(textoErro);

            return ResponseEntity.badRequest().body(erro);
        }
    }

    @GetMapping
    public List<Conta> listarContas(){
        return contaUseCase.listarContas();
    }

    @DeleteMapping("/{id}")
    void deletarCliente(@PathVariable long id){
        contaUseCase.deletarConta(id);
    }

    @PutMapping("/{id}")
    void atualizarConta(@PathVariable long id, @RequestBody Conta conta){
        contaUseCase.atualizarConta(id,conta);
    }

}
