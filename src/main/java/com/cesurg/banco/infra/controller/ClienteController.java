package com.cesurg.banco.infra.controller;

import com.cesurg.banco.core.domain.interfaces.ClienteUseCase;
import com.cesurg.banco.core.domain.model.Cliente;
import com.cesurg.banco.core.usecase.ClienteUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
   ClienteUseCase clienteUseCase;

    @PostMapping
    void salvarCliente(@RequestBody Cliente cliente){
        clienteUseCase.salvarCliente(cliente);
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
    void atualizarCliente(@PathVariable long id, @RequestBody Cliente clienteNovo){
        clienteUseCase.atualizarCliente(id, clienteNovo);
    }

}
