package aula04.exercicio.servico;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.repositorio.ClienteRepositorio;

import java.util.List;

public class ClienteServico {

    private ClienteRepositorio clienteRepositorio;
    private static int CONTADOR_ID_CLIENTE;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public int criaCliente(String nome) {
        Cliente cliente = new Cliente(++CONTADOR_ID_CLIENTE, nome);
        this.clienteRepositorio.add(cliente);
        return cliente.getIdCliente();
    }

    protected Cliente buscaCliente(String nomeCliente) {
        return this.clienteRepositorio.get(nomeCliente);
    }

    public List<Cliente> listaClientes() {
        return this.clienteRepositorio.findAll();
    }
}
