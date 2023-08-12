package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Restaurante;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestauranteRepositorio {
    private List<Restaurante> lista;

    public RestauranteRepositorio() {
        lista = new ArrayList<>();
    }

    public void add(Restaurante restaurante) {
        this.lista.add(restaurante);
    }

    public Restaurante get(String nomeRestaurante) {
        for (Restaurante restaurante : this.lista) {
            if (restaurante.getNome().equals(nomeRestaurante))
                return restaurante;
        }
        return null;
    }

    public List<Restaurante> findAll() {
        return Collections.unmodifiableList(lista);
    }
}
