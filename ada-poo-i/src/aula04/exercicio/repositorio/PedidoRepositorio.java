package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoRepositorio {
    private List<Pedido> lista;

    public PedidoRepositorio() {
        lista = new ArrayList<>();
    }

    public void add(Pedido pedido) {
        this.lista.add(pedido);
    }

    public Pedido get(int idPedido) {
        for (Pedido pedido : this.lista) {
            if (pedido.getIdPedido() == idPedido)
                return pedido;
        }
        return null;
    }

    public List<Pedido> findAll() {
        return Collections.unmodifiableList(lista);
    }
}
