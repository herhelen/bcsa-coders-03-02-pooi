package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Prato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PratoRepositorio {
    private List<Prato> lista;

    public PratoRepositorio() {
        lista = new ArrayList<>();
    }

    public void add(Prato prato) {
        this.lista.add(prato);
    }

    public Prato get(String nomePrato) {
        for (Prato prato : this.lista) {
            if (prato.getNome().equals(nomePrato))
                return prato;
        }
        return null;
    }

    public List<Prato> findAll() {
        return Collections.unmodifiableList(this.lista);
    }

    @Override
    public String toString() {
        return "PratoRepositorio{" +
                "lista=" + this.lista +
                '}';
    }
}
