package aula04.exercicio.dominio;

import java.util.List;

public class Pedido {
    private final int idPedido;
    private final int idRestaurante;
    private final int idCliente;
    private String enderecoEntrega;
    private List<Prato> pratos;
    private double valorTotal;

    public Pedido(int idPedido, int idRestaurante, int idCliente, String enderecoEntrega, List<Prato> pratos) {
        this.idPedido = idPedido;
        this.idRestaurante = idRestaurante;
        this.idCliente = idCliente;
        this.enderecoEntrega = enderecoEntrega;
        this.pratos = pratos;
        calculaValorTotal();
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public int getIdRestaurante() {
        return this.idRestaurante;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public String getEnderecoEntrega() {
        return this.enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<Prato> getPratos() {
        return this.pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
        calculaValorTotal();
    }

    public double getValorTotal() {
        return this.valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + this.idPedido +
                ", idRestaurante=" + this.idRestaurante +
                ", idCliente=" + this.idCliente +
                ", enderecoEntrega='" + this.enderecoEntrega + '\'' +
                ", pratos=" + this.pratos +
                ", valorTotal=" + this.valorTotal +
                '}';
    }

    private void calculaValorTotal() {
        this.valorTotal = 0;
        for (Prato aux: this.pratos) {
            this.valorTotal += aux.getPreco();
        }
    }

}
