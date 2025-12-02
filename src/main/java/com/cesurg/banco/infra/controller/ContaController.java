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
    ResponseEntity<Erro> criarContaCorrente(@RequestBody ContaCorrente conta){
        return contaUseCase.criarContaCorrente(conta);
    }

    @PostMapping("/poupanca")
    ResponseEntity<Erro> criarContaPoupanca(@RequestBody ContaPoupanca conta){
        return contaUseCase.criarContaPoupanca(conta);
    }

    @PostMapping("/credito")
    ResponseEntity<Erro> criarContaCredito(@RequestBody ContaCredito conta){
        return contaUseCase.criarContaCredito(conta);
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
    void deletarCliente(@PathVariable long id){
        contaUseCase.deletarConta(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Erro> atualizarConta(@PathVariable long id, @RequestBody Conta conta){
        return contaUseCase.atualizarConta(id,conta);
    }

    @PostMapping("/transferencias")
    public ResponseEntity<Erro> transferir(@RequestBody TransferenciaDTO dto){
        return contaUseCase.transferir(dto.origem(), dto.destino(), dto.valor());
    }

    @PostMapping("/{id}/aplicacoes")
    public ResponseEntity<Erro> aplicarPoupanca(@PathVariable long id, @RequestBody ValorDTO dto){
        return contaUseCase.aplicarPoupanca(id, dto.valor());}

    @PostMapping("/{id}/compras")
    public ResponseEntity<Erro> usarCredito(@PathVariable long id, @RequestBody ValorDTO dto){
        return contaUseCase.usarCredito(id, dto.valor());
    }
}