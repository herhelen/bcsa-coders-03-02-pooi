package aula04.exercicio.dominio;

public class Prato {
    private final int idPrato;
    private String nome;
    private double preco;
    private String descricao;

    public Prato(int idPrato, String nome, double preco, String descricao) {
        this.idPrato = idPrato;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getIdPrato() {
        return this.idPrato;
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
                "idPrato=" + this.idPrato +
                ", nome='" + this.nome + '\'' +
                ", preco=" + this.preco +
                ", descricao='" + this.descricao + '\'' +
                '}';
    }
}
