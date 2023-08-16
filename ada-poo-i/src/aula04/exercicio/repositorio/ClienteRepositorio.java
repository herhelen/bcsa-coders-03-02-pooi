package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Cliente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClienteRepositorio extends Repositorio {

    public ClienteRepositorio() {
        super();
        this.lista = new ArrayList<>();
    }

    @Override
    public void add(Object obj) {
        this.lista.add(obj);
    }

    @Override
    public Object get(int id) {
        for (Object obj : this.lista) {
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getIdCliente() == id)
                    return obj;
            }
        }
        return null;
    }

    @Override
    public List<Object> findAll() {
        return Collections.unmodifiableList(this.lista);
    }

    public Cliente get(String nomeCliente) {
        for (Object obj : this.lista) {
            if (obj instanceof Cliente) {
                Cliente cliente = (Cliente) obj;
                if (cliente.getNome().equals(nomeCliente))
                    return cliente;
            }
        }
        return null;
    }
}
