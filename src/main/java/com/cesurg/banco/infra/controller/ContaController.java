package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.Conta;
import com.cesurg.banco.core.domain.model.Erro;
import com.cesurg.banco.core.dto.TransferenciaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
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
    ResponseEntity<Erro> atualizarConta(@PathVariable long id, @RequestBody Conta conta){
        try {
            return contaUseCase.atualizarConta(id,conta);
        }catch (RuntimeException e){
            String textoErro = e.getMessage();

            Erro erro = new Erro(textoErro);

            return ResponseEntity.badRequest().body(erro);
        }
    }

    @PostMapping("/transferencias")
    public ResponseEntity<Erro> transferir(@RequestBody TransferenciaDTO dto){
        try {
            contaUseCase.transferir(dto.origem(), dto.destino(), dto.valor());
        } catch (RuntimeException e) {

            String textoErro = e.getMessage();

            Erro erro = new Erro(textoErro);

            return ResponseEntity.badRequest().body(erro);
        }
        return null;
    }

}
