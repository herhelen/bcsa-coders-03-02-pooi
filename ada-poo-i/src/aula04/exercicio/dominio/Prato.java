package aula04.exercicio.dominio;

public class Prato {
    private String nome;
    private double preco;
    private String descricao;

    public Prato(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "nome='" + this.nome + '\'' +
                ", preco=" + String.format("%.2f", this.preco) +
                ", descricao='" + this.descricao + '\'' +
                '}';
    }
}
