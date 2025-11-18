package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.usecase.ContaUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaUseCase contaUseCase;

    @PostMapping
    void criarConta(@RequestBody Conta conta){
        contaUseCase.criarConta(conta);
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
