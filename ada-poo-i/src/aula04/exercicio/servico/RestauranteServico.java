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

    public RestauranteServico(RestauranteRepositorio restauranteRepositorio) {
        this.restauranteRepositorio = restauranteRepositorio;
    }

    public int criaRestaurante(String nome, String endereco) {
        Restaurante restaurante = new Restaurante(++CONTADOR_ID_RESTAURANTE, nome, endereco);
        this.restauranteRepositorio.add(restaurante);
        return restaurante.getIdRestaurante();
    }

    public List<Restaurante> listaRestaurantes() {
        return this.restauranteRepositorio.findAll();
    }

    protected Restaurante buscaRestaurante(String nomeRestaurante) {
        return this.restauranteRepositorio.get(nomeRestaurante);
    }

    protected Restaurante buscaRetaurante(int idRestaurante) {
        return this.restauranteRepositorio.get(idRestaurante);
    }

    public List<Prato> listaMenuRestaurante(String nomeRestaurante, PratoServico pratoServico) {
        Restaurante restaurante = buscaRestaurante(nomeRestaurante);
        if(restaurante != null)
            return pratoServico.listaPratosRestaurante(restaurante.getIdRestaurante());
        return null;
    }

    public List<Prato> listaMenuRestaurante(int idRestaurante, PratoServico pratoServico) {
        return pratoServico.listaPratosRestaurante(idRestaurante);
    }

    public int fazPedido(String nomeCliente, String nomeRestaurante, String enderecoEntrega,
                          List<Prato> pratos, ClienteServico clienteServico, PedidoServico pedidoServico) {
        Cliente cliente = clienteServico.buscaCliente(nomeCliente);
        Restaurante restaurante = this.buscaRestaurante(nomeRestaurante);
        return pedidoServico.criaPedido(enderecoEntrega, pratos, restaurante.getIdRestaurante(), cliente.getIdCliente());

    }

    public int fazPedido(String enderecoEntrega, List<Integer> idPratos, int idRestaurante, int idCliente,
                         PratoServico pratoServico, PedidoServico pedidoServico) {
        List<Prato> pratos = pratoServico.listaPratosPorId(idPratos);
        return pedidoServico.criaPedido(enderecoEntrega, pratos, idRestaurante, idCliente);
    }



}
