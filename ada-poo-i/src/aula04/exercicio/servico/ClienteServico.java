package aula04.exercicio.servico;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.ClienteRepositorio;
import aula04.exercicio.repositorio.RestauranteRepositorio;

import java.util.List;

public class ClienteServico {

    private ClienteRepositorio clienteRepositorio;
    private static int CONTADOR_ID_CLIENTE;

    public ClienteServico(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public void criaCliente(String nome) {
        Cliente cliente = new Cliente(++CONTADOR_ID_CLIENTE, nome);
        this.clienteRepositorio.add(cliente);
    }

    protected Cliente buscaCliente(String nomeCliente) {
        return this.clienteRepositorio.get(nomeCliente);
    }

    public List<Cliente> listaClientes() {
        return this.clienteRepositorio.findAll();
    }
}
