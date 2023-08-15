package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteRepositorio {
    private List<Cliente> lista;

    public ClienteRepositorio() {
        lista = new ArrayList<>();
    }

    public void add(Cliente cliente) {
        this.lista.add(cliente);
    }

    public Cliente get(String nomeCliente) {
        for (Cliente cliente : this.lista) {
            if (cliente.getNome().equals(nomeCliente))
                return cliente;
        }
        return null;
    }

    public Cliente get(int idCliente) {
        for (Cliente cliente : this.lista) {
            if (cliente.getIdCliente() == idCliente)
                return cliente;
        }
        return null;
    }

    public List<Cliente> findAll() {
        return Collections.unmodifiableList(lista);
    }
}
