package aula02;

public class Conta {

    /*
    * Parte 2: Classe Conta
    * Em seguida, crie uma classe Conta que possui um Cliente (o dono da conta), um numero (número da conta) e um saldo.
    * Essa classe deve ter um construtor para inicializar o cliente e o número da conta
    * (o saldo inicial deve ser zero), um método depositar(), que aumenta o saldo em uma certa quantia
    * um método sacar(), que diminui o saldo em uma certa quantia (se houver saldo suficiente)
    * e os métodos equals() e toString().
    * O método equals() deve comparar duas contas com base em seus números (duas contas são iguais se tiverem o mesmo número).
    * O método toString() deve retornar uma string contendo todas as informações da conta.
    * */

    Cliente titular;
    String numeroDaConta;
    double saldo;

    public Conta(Cliente titular, String numeroDaConta) {
        this.titular = titular;
        this.numeroDaConta = numeroDaConta;
        this.saldo = 0.0;
    }

    public void depositar(double quantia) {
        // todo: exception
        if(quantia > 0) {
            this.saldo += quantia;
        } else {
            System.out.println("QUANTIA INVÁLIDA");
        }

    }

    public void sacar(double quantia) {
        // todo: exception
        if(quantia > this.saldo) {
            System.out.println("SALDO INSUFICIENTE");
        } else {
            this.saldo -= quantia;
        }
    }

    @Override
    public boolean equals(Object c) {
        if(c instanceof Conta) {
            Conta conta = (Conta) c;
            return this.numeroDaConta.equals(conta.numeroDaConta);
        }
        return false;
    }

    @Override
    public String toString() {
       return String.format("Conta[titular='%s', numeroDaConta='%s', saldo='%.2f']",
            this.titular,
            this.numeroDaConta,
            this.saldo);
    }
}
