package aula04.exercicio.servico;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.dominio.Pedido;
import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.PedidoRepositorio;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoServico {

    private PedidoRepositorio pedidoRepositorio;
    private static int CONTADOR_ID_PEDIDO;

    public PedidoServico(PedidoRepositorio pedidoRepositorio) {
        this.pedidoRepositorio = pedidoRepositorio;
    }

    public int criaPedido(String enderecoEntrega, List<Prato> pratos, int idRestaurante, int idCliente) {
        Pedido pedido = new Pedido(++CONTADOR_ID_PEDIDO, idRestaurante, idCliente, enderecoEntrega, pratos);
        this.pedidoRepositorio.add(pedido);
        return pedido.getIdPedido();
    }

    protected Pedido buscaPedido(int idPedido) {
        return this.pedidoRepositorio.get(idPedido);
    }

    public List<Pedido> listaPedidos() {
        return this.pedidoRepositorio.findAll();
    }

    public List<Pedido> listaPedidosRestaurante(String nomeRestaurante, RestauranteServico restauranteServico) {
        Restaurante restaurante = restauranteServico.buscaRestaurante(nomeRestaurante);
        if(restaurante != null) {
            return this.pedidoRepositorio.findAll()
                    .stream()
                    .filter(f -> f.getIdRestaurante() == restaurante.getIdRestaurante())
                    .collect(Collectors.toList());
        }

        return null;
    }

    public List<Pedido> listaPedidosCliente(String nomeCleitne, ClienteServico clienteServico) {
        Cliente cliente = clienteServico.buscaCliente(nomeCleitne);
        if(cliente != null) {
            return this.pedidoRepositorio.findAll()
                    .stream()
                    .filter(f -> f.getIdCliente() == cliente.getIdCliente())
                    .collect(Collectors.toList());
        }

        return null;
    }
}
