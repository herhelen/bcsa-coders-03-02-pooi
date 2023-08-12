package aula04.exercicio;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.ClienteRepositorio;
import aula04.exercicio.repositorio.PratoRepositorio;
import aula04.exercicio.repositorio.RestauranteRepositorio;
import aula04.exercicio.servico.ClienteServico;
import aula04.exercicio.servico.RestauranteServico;

import java.util.ArrayList;
import java.util.List;

public class TesteRestaurante {

    public static void main(String[] args) {

        String nomeCliente = "Cliente Um";
        String nomeRestau = "Um";

        RestauranteServico restauranteServico = new RestauranteServico(new RestauranteRepositorio());
        ClienteServico clienteServico = new ClienteServico(new ClienteRepositorio());

        restauranteServico.criaRestaurante(nomeRestau, "Endereco A");

        for (Restaurante r: restauranteServico.listaRestaurantes()) {
            System.out.println(r);
        }

        restauranteServico.criaPrato(nomeRestau, "Prato 1", 10, "Prato Desc 1");
        restauranteServico.criaPrato(nomeRestau, "Prato 2", 30, "Prato Desc 2");
        restauranteServico.criaPrato(nomeRestau, "Prato 3", 99.9, "Prato Desc 3");
        restauranteServico.criaPrato(nomeRestau, "Prato 4", 15.5, "Prato Desc 4");

        List<Prato> pratos = new ArrayList<>();
        for (Prato p: restauranteServico.listaMenuRestaurante(nomeRestau)) {
            System.out.println(p);
            if(p.getIdPrato() % 2 == 0) {
                pratos.add(p);
            }
        }
        System.out.println(pratos);

        clienteServico.criaCliente(nomeCliente);
        for (Cliente c: clienteServico.listaClientes()) {
            System.out.println(c);
        }

        restauranteServico.fazPedido(nomeCliente, nomeRestau, "Endereco Entrega", pratos, clienteServico);
    }

}
