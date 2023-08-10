package aula02;

public class Cliente {

    /*
    * Parte 1: Classe Cliente
    * Crie uma classe Cliente que possua os seguintes atributos: nome, cpf e email.
    * Essa classe deve ter um construtor que inicialize todos esses valores, e os métodos equals() e toString().
    * O método equals() deve comparar dois clientes com base em seus CPFs (dois clientes são iguais se tiverem o mesmo CPF).
    * O método toString() deve retornar uma string contendo todas as informações do cliente.
    * */

    private String nome;
    private String cpf;
    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    @Override
    public boolean equals(Object cliente) {
        if(cliente instanceof Cliente) {
            Cliente clienteAComparar = (Cliente) cliente;
            return this.cpf.equals(clienteAComparar.cpf);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Cliente[nome='%s', cpf='%s', email='%s']",
                this.nome,
                this.cpf,
                this.email);
    }

}
