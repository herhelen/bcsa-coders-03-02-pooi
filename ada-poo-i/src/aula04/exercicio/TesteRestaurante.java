package aula04.exercicio;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.dominio.Pedido;
import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.ClienteRepositorio;
import aula04.exercicio.repositorio.PedidoRepositorio;
import aula04.exercicio.repositorio.PratoRepositorio;
import aula04.exercicio.repositorio.RestauranteRepositorio;
import aula04.exercicio.servico.ClienteServico;
import aula04.exercicio.servico.PedidoServico;
import aula04.exercicio.servico.PratoServico;
import aula04.exercicio.servico.RestauranteServico;

import java.util.ArrayList;
import java.util.List;

public class TesteRestaurante {

    public static void main(String[] args) {

        String nomeCliente = "Cliente Um";
        String nomeRestau = "Um";

        RestauranteServico restauranteServico = new RestauranteServico(new RestauranteRepositorio());
        ClienteServico clienteServico = new ClienteServico(new ClienteRepositorio());
        PratoServico pratoServico = new PratoServico(new PratoRepositorio());
        PedidoServico pedidoServico = new PedidoServico(new PedidoRepositorio());

        restauranteServico.criaRestaurante(nomeRestau, "Endereco A");

        for (Restaurante r: restauranteServico.listaRestaurantes()) {
            System.out.println(r);
        }

        pratoServico.criaPrato(nomeRestau, "Prato 1", 10, "Prato Desc 1", restauranteServico);
        pratoServico.criaPrato(nomeRestau, "Prato 2", 30, "Prato Desc 2", restauranteServico);
        pratoServico.criaPrato(nomeRestau, "Prato 3", 99.9, "Prato Desc 3", restauranteServico);
        pratoServico.criaPrato(nomeRestau, "Prato 4", 15.5, "Prato Desc 4", restauranteServico);


        List<Prato> pratos = new ArrayList<>();
        for (Prato p: restauranteServico.listaMenuRestaurante(nomeRestau, pratoServico)) {
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

        System.out.println(restauranteServico.fazPedido(nomeCliente, nomeRestau, "Endereco Entrega", pratos, clienteServico, pedidoServico));


        for(Pedido p: pedidoServico.listaPedidos()) {
            System.out.println(p);
        }

        for(Pedido p: pedidoServico.listaPedidosRestaurante(nomeRestau, restauranteServico)) {
            System.out.println(p);
        }

        for(Pedido p: pedidoServico.listaPedidosCliente(nomeCliente, clienteServico)) {
            System.out.println(p);
        }

    }

}
