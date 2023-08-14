package aula04.exercicio.servico;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.dominio.Pedido;
import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.RestauranteRepositorio;

import java.util.List;

public class RestauranteServico {

    private RestauranteRepositorio restauranteRepositorio;
    private static int CONTADOR_ID_RESTAURANTE;

    private static int CONTADOR_ID_PEDIDO;


    public RestauranteServico(RestauranteRepositorio restauranteRepositorio) {
        this.restauranteRepositorio = restauranteRepositorio;
    }

    public void criaRestaurante(String nome, String endereco) {
        Restaurante restaurante = new Restaurante(++CONTADOR_ID_RESTAURANTE, nome, endereco);
        this.restauranteRepositorio.add(restaurante);
    }

    public List<Restaurante> listaRestaurantes() {
        return this.restauranteRepositorio.findAll();
    }

    protected Restaurante buscaRestaurante(String nomeRestaurante) {
        return this.restauranteRepositorio.get(nomeRestaurante);
    }

    public List<Prato> listaMenuRestaurante(String nomeRestaurante, PratoServico pratoServico) {
        return pratoServico.listaPratosRestaurante(nomeRestaurante, this);
    }

    public void fazPedido(String nomeCliente, String nomeRestaurante, String enderecoEntrega, List<Prato> pratos, ClienteServico clienteServico) {
        Cliente cliente = clienteServico.buscaCliente(nomeCliente);
        Restaurante restaurante = this.buscaRestaurante(nomeRestaurante);
        Pedido pedido = new Pedido(++CONTADOR_ID_PEDIDO, restaurante.getIdRestaurante(), cliente.getIdCliente(), enderecoEntrega, pratos);

        System.out.println(pedido);
    }

    // listar os pedidos do restau usando PedidoServico (PedidoRepositorio)

}
