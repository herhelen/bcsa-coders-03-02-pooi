package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Pedido;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoRepositorio extends Repositorio {

    public PedidoRepositorio() {
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
            if (obj instanceof Pedido) {
                Pedido pedido = (Pedido) obj;
                if (pedido.getIdPedido() == id)
                    return obj;
            }
        }
        return null;
    }

    @Override
    public List<Object> findAll() {
        return Collections.unmodifiableList(this.lista);
    }

}
