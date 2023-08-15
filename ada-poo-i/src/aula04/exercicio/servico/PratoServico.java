package aula04.exercicio.servico;

import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
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
        return this.pratoRepositorio.findAll();
    }

    protected Prato buscaPrato(String nomePrato) {
        return this.pratoRepositorio.get(nomePrato);
    }

    protected Prato buscaPrato(int idPrato) {
        return this.pratoRepositorio.get(idPrato);
    }

    public List<Prato> listaPratosRestaurante(int idRestaurante) {
        return this.pratoRepositorio.findAll()
                .stream()
                .filter(f -> f.getIdRestaurante() == idRestaurante)
                .collect(Collectors.toList());
    }

    public List<Prato> listaPratosPorId(List<Integer> ids) {
//        return this.pratoRepositorio.findAll()
//                .stream()
//                .filter(f -> ids.contains(f.getIdPrato()))
//                .collect(Collectors.toList());
        List<Prato> pratos = new ArrayList<>();
        Prato aux;
        for (Integer id: ids) {
            aux = buscaPrato(id);
            if(aux != null)
                pratos.add(aux);
        }

        return pratos;
    }

}
