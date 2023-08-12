package aula04.exercicio.dominio;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private final int idRestaurante;
    private String nome;
    private String endereco;
    private List<Prato> menuPratos;

    public Restaurante(int idRestaurante, String nome, String endereco) {
        this.idRestaurante = idRestaurante;
        this.nome = nome;
        this.endereco = endereco;
        this.menuPratos = new ArrayList<Prato>();
    }

    public Restaurante(int idRestaurante, String nome, String endereco, List<Prato> menuPratos) {
        this.idRestaurante = idRestaurante;
        this.nome = nome;
        this.endereco = endereco;
        this.menuPratos = menuPratos;
    }

    public int getIdRestaurante() {
        return this.idRestaurante;
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

    public List<Prato> getMenuPratos() {
        return this.menuPratos;
    }

    public void setMenuPratos(List<Prato> menuPratos) {
        this.menuPratos = menuPratos;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "idRestaurante=" + this.idRestaurante +
                ", nome='" + this.nome + '\'' +
                ", endereco='" + this.endereco + '\'' +
                ", menuPratos=" + this.menuPratos +
                '}';
    }
}
