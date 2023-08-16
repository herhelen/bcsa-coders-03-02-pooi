package aula04.exercicio.servico;

import aula04.exercicio.dominio.Prato;
import aula04.exercicio.repositorio.PratoRepositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PratoServico {

    private PratoRepositorio pratoRepositorio;

    private static int CONTADOR_ID_PRATO;

    public PratoServico(PratoRepositorio pratoRepositorio) {
        this.pratoRepositorio = pratoRepositorio;
    }

    public int criaPrato(int idRestaurante, String nome, double preco, String descricao) {
        Prato prato = new Prato(++CONTADOR_ID_PRATO, idRestaurante, nome, preco, descricao);
        this.pratoRepositorio.add(prato);

        return prato.getIdPrato();
    }

    public List<Prato> listaPratos() {
        return this.pratoRepositorio.findAll()
                .stream()
                .filter(f -> f instanceof Prato)
                .map(f -> (Prato) f)
                .collect(Collectors.toList());
    }

    protected Prato buscaPrato(String nomePrato) {
        return this.pratoRepositorio.get(nomePrato);
    }

    protected Prato buscaPrato(int idPrato) {
        Object temp = this.pratoRepositorio.get(idPrato);
        if(temp instanceof Prato) {
            return (Prato) temp;
        }
        return null;
    }

    public List<Prato> listaPratosRestaurante(int idRestaurante) {
        return this.listaPratos()
                .stream()
                .filter(f -> f.getIdRestaurante() == idRestaurante)
                .collect(Collectors.toList());
    }

    public List<Prato> listaPratosPorId(List<Integer> ids) {
        List<Prato> pratos = new ArrayList<>();
        Prato aux;
        for (Integer id: ids) {
            aux = this.buscaPrato(id);
            if(aux != null)
                pratos.add(aux);
        }

        return pratos;
    }

}
