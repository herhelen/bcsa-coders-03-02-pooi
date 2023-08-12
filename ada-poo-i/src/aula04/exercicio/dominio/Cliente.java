package aula04.exercicio.dominio;

public class Cliente {
    private final int idCliente;
    private String nome;

    public Cliente(int idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + this.idCliente +
                ", nome='" + this.nome + '\'' +
                '}';
    }
}
