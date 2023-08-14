package aula04.exercicio.dominio;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private final int idRestaurante;
    private String nome;
    private String endereco;

    public Restaurante(int idRestaurante, String nome, String endereco) {
        this.idRestaurante = idRestaurante;
        this.nome = nome;
        this.endereco = endereco;
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

    @Override
    public String toString() {
        return "Restaurante{" +
                "idRestaurante=" + this.idRestaurante +
                ", nome='" + this.nome + '\'' +
                ", endereco='" + this.endereco + '\'' +
                '}';
    }
}
