package aula02;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    /*
    * Parte 3: Classe Banco
    * Por fim, crie uma classe Banco que gerencie um conjunto de Conta.
    * Ela deve ter um método criarConta() que crie uma nova conta e a adicione ao conjunto
    * um método buscarConta() que retorne uma conta dado o seu número
    * um método depositar() que receba o número de uma conta e uma quantia, e faça o depósito nessa conta
    * e um método sacar() que faça o saque de uma conta.
    * */


    private int contadorNumeroConta;
    private List<Conta> contas;

    public Banco() {
        this.contadorNumeroConta = 0;
        this.contas = new ArrayList<Conta>();
    }

    public String criarConta(String nome, String cpf, String email) {
        String numeroConta = String.format("%04d", ++this.contadorNumeroConta);
        Cliente cliente = new Cliente(nome, cpf, email);
        Conta conta = new Conta(cliente, numeroConta);

        this.contas.add(conta);

        return conta.getNumeroDaConta();
    }

    public Conta buscarConta(String numeroDaConta) {
        for (Conta c: this.contas) {
            if(c.getNumeroDaConta().equals(numeroDaConta)) {
                return c;
            }
        }

        return null;
    }

    public void depositar(String numeroDaConta, double quantia) {
        Conta c = this.buscarConta(numeroDaConta);

        if(c != null) {
            c.depositar(quantia);
        }

    }

    public void sacar(String numeroDaConta, double quantia) {
        Conta c = this.buscarConta(numeroDaConta);

        if(c != null) {
            c.sacar(quantia);
        }

    }

    @Override
    public String toString() {
        return String.format("Banco[#contas='%d', contador='%d']",
            this.contas.size(),
            this.contadorNumeroConta);
    }

}
