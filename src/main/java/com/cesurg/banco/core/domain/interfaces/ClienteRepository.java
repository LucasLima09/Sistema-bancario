package com.cesurg.banco.core.domain.interfaces;

import com.cesurg.banco.core.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository {
    void salvarCliente(Cliente cliente);
    public List<Cliente> listarClientes();
    void deletarCliente(long id);
    void atualizarCliente(long id, Cliente clienteNovo);
    Cliente buscarCliente(long id);
    public boolean verificarCpf(String cpf);
}
