package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ClienteUseCase;
import com.cesurg.banco.core.domain.model.Cliente;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
   ClienteUseCase clienteUseCase;

    @PostMapping
    ResponseEntity<Erro> salvarCliente(@RequestBody Cliente cliente){
        return clienteUseCase.salvarCliente(cliente);
    }

    @GetMapping
    List<Cliente> listarClientes(){
        return clienteUseCase.listarClientes();
    }

    @DeleteMapping("/{id}")
    void deletarCliente(@PathVariable long id){
        clienteUseCase.deletarCliente(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Erro> atualizarCliente(@PathVariable long id, @RequestBody Cliente clienteNovo){
        return clienteUseCase.atualizarCliente(id, clienteNovo);
    }

    @GetMapping("/{id}")
    Cliente buscarCliente(@PathVariable long id){
        return clienteUseCase.buscarCliente(id);
    }
}
