package com.cesurg.banco.infra.Repository;

import com.cesurg.banco.core.domain.interfaces.ClienteRepository;
import com.cesurg.banco.core.domain.model.Cliente;
import com.cesurg.banco.core.domain.model.Erro;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    private List<Cliente> listaDeClientes = new CopyOnWriteArrayList<>();

    private long idAtual = 0;

    @Override
    public ResponseEntity<Erro> salvarCliente(Cliente cliente) {
        idAtual++;
        cliente.setId(idAtual);
        listaDeClientes.add(cliente);
        return null;
    }

    public List<Cliente> listarClientes(){
        return this.listaDeClientes;
    }
    @Override
    public void deletarCliente(long id){
        Cliente clienteParaDeletar = null;

        for(Cliente cliente : listaDeClientes){
            if(cliente.getId() == id){
            clienteParaDeletar = cliente;
            }
            listaDeClientes.remove(clienteParaDeletar);
        }
    }
    @Override
    public ResponseEntity<Erro> atualizarCliente(long id, Cliente clienteNovo){
        Cliente clienteExistente = buscarCliente(id);

        if( clienteNovo.getNome() != null && !clienteNovo.getNome().isEmpty()) {
            clienteExistente.setNome(clienteNovo.getNome());
        }
        if( clienteNovo.getSobrenome() != null && !clienteNovo.getSobrenome().isEmpty()) {
            clienteExistente.setSobrenome(clienteNovo.getSobrenome());
        }
        if( clienteNovo.getCpf() != null && !clienteNovo.getCpf().isEmpty()) {
            clienteExistente.setCpf(clienteNovo.getCpf());
        }
        return null;
    }

    @Override
    public Cliente buscarCliente(long id){
        for(Cliente cliente : listaDeClientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean verificarCpf(String cpf){

        for(Cliente cliente : listaDeClientes){
            if(cliente.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

}
