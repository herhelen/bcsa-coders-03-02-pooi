package aula04.exercicio.repositorio;

import aula04.exercicio.dominio.Prato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PratoRepositorio extends Repositorio {

    public PratoRepositorio() {
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
            if (obj instanceof Prato) {
                Prato prato = (Prato) obj;
                if (prato.getIdPrato() == id)
                    return obj;
            }
        }
        return null;
    }

    @Override
    public List<Object> findAll() {
        return Collections.unmodifiableList(this.lista);
    }

    public Prato get(String nomePrato) {
        for (Object obj : this.lista) {
            if (obj instanceof Prato) {
                Prato prato = (Prato) obj;
                if (prato.getNome().equals(nomePrato))
                    return prato;
            }
        }
        return null;
    }

}
