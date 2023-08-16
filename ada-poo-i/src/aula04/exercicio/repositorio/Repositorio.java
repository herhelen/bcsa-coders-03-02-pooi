package aula04.exercicio.repositorio;

import java.util.List;

public abstract class Repositorio {
    List<Object> lista;

    public abstract void add(Object obj);

    public abstract Object get(int id);

    public abstract List<Object> findAll();
}
