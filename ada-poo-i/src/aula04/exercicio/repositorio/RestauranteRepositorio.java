package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestauranteRepositorio extends Repositorio {

    public RestauranteRepositorio() {
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
            if (obj instanceof Restaurante) {
                Restaurante restaurante = (Restaurante) obj;
                if (restaurante.getIdRestaurante() == id)
                    return obj;
            }
        }
        return null;
    }

    @Override
    public List<Object> findAll() {
        return Collections.unmodifiableList(this.lista);
    }

    public Restaurante get(String nomeRestaurante) {
        for (Object obj : this.lista) {
            if (obj instanceof Restaurante) {
                Restaurante restaurante = (Restaurante) obj;
                if (restaurante.getNome().equals(nomeRestaurante))
                    return restaurante;
            }
        }
        return null;
    }

}
