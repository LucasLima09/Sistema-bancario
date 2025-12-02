package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ContaUseCase;
import com.cesurg.banco.core.domain.model.*;
import com.cesurg.banco.core.dto.TransferenciaDTO;
import com.cesurg.banco.core.dto.ValorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    ContaUseCase contaUseCase;

    @PostMapping("/corrente")
    ResponseEntity<Void> criarContaCorrente(@RequestBody ContaCorrente conta){
        contaUseCase.criarContaCorrente(conta);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/poupanca")
    ResponseEntity<Void> criarContaPoupanca(@RequestBody ContaPoupanca conta){
        contaUseCase.criarContaPoupanca(conta);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/credito")
    ResponseEntity<Void> criarContaCredito(@RequestBody ContaCredito conta){
        contaUseCase.criarContaCredito(conta);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public List<Conta> listarContas(){
        return contaUseCase.listarContas();
    }

    @GetMapping("/{id}")
    public Conta buscarConta(@PathVariable long id){
        return contaUseCase.buscarConta(id);
    }

    @DeleteMapping("/{id}")
    void deletarConta(@PathVariable long id){
        contaUseCase.deletarConta(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Conta> atualizarConta(@PathVariable long id, @RequestBody Conta conta){
        Conta contaAtualizada = contaUseCase.atualizarConta(id,conta);
        return ResponseEntity.ok(contaAtualizada);
    }

    @PostMapping("/transferencias")
    public ResponseEntity<Void> transferir(@RequestBody TransferenciaDTO dto){
        contaUseCase.transferir(dto.origem(), dto.destino(), dto.valor());
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/{id}/aplicacoes")
    public ResponseEntity<Void> aplicarPoupanca(@PathVariable long id, @RequestBody ValorDTO dto){
        contaUseCase.aplicarPoupanca(id, dto.valor());
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/{id}/compras")
    public ResponseEntity<Void> usarCredito(@PathVariable long id, @RequestBody ValorDTO dto){
        contaUseCase.usarCredito(id, dto.valor());
        return ResponseEntity.status(201).build();
    }
}