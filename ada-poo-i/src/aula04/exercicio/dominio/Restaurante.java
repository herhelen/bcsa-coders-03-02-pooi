package aula04.exercicio.dominio;

public class Restaurante {
    private String nome;
    private String endereco;

    // pratos
    // pedidos

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nome='" + this.nome + '\'' +
                ", endereco='" + this.endereco + '\'' +
                '}';
    }
}
