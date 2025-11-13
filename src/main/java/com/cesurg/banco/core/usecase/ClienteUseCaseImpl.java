package com.cesurg.banco.core.usecase;

import com.cesurg.banco.core.domain.interfaces.ClienteRepository;
import com.cesurg.banco.core.domain.interfaces.ClienteUseCase;
import com.cesurg.banco.core.domain.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteUseCaseImpl implements ClienteUseCase {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void salvarCliente(@RequestBody Cliente cliente){
        clienteRepository.salvarCliente(cliente);
    }

    @Override
    public List<Cliente> listarClientes(){
        return clienteRepository.listarClientes();
    }

    @Override
    public void deletarCliente(long id) {
        clienteRepository.deletarCliente(id);
    }

    @Override
    public void atualizarCliente(long id,Cliente clienteNovo) {
        clienteRepository.atualizarCliente(id, clienteNovo);
    }
}
