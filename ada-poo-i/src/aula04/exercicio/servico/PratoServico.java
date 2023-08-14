package aula04.exercicio.servico;

import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.PratoRepositorio;

import java.util.List;
import java.util.stream.Collectors;

public class PratoServico {

    private PratoRepositorio pratoRepositorio;

    private static int CONTADOR_ID_PRATO;

    public PratoServico(PratoRepositorio pratoRepositorio) {
        this.pratoRepositorio = pratoRepositorio;
    }

    public void criaPrato(String nomeRestaurante, String nome, double preco, String descricao, RestauranteServico restauranteServico) {
        Restaurante restaurante = restauranteServico.buscaRestaurante(nomeRestaurante);

        if(restaurante != null) {
            this.pratoRepositorio.add(new Prato(++CONTADOR_ID_PRATO, restaurante.getIdRestaurante(), nome, preco, descricao));
        }
    }

    public List<Prato> listaPratosRestaurante(String nomeRestaurante, RestauranteServico restauranteServico) {
        Restaurante restaurante = restauranteServico.buscaRestaurante(nomeRestaurante);
        if(restaurante != null) {
            return this.pratoRepositorio.findAll()
                    .stream()
                    .filter(f -> f.getIdRestaurante() == restaurante.getIdRestaurante())
                    .collect(Collectors.toList());
        }

        return null;
    }


}
