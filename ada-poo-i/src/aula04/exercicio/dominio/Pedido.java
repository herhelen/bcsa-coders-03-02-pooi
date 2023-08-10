package aula04.exercicio.dominio;

public class Pedido {
    // lista de pratos
    private String enderecoEntrega;

    public Pedido(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getEnderecoEntrega() {
        return this.enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "enderecoEntrega='" + this.enderecoEntrega + '\'' +
                '}';
    }
}
