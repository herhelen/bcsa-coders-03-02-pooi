package aula02;

import java.util.Scanner;

public class TesteBanco {

    /*
    * Parte 4: Teste
    * Crie uma classe TesteBanco com um método main()
    * que imprime um menu para que o usuário possa executar operações como criar conta
    * depositar, sacar e exibir os dados de uma conta.
    * Para isso, você pode usar a classe Scanner para ler as opções do usuário e os dados necessários para cada operação.
    * */

    public static void imprimeMenu() {
        System.out.println("---------------------------------");
        System.out.println("Escolha uma das opções a seguir:");
        System.out.println("1. Abrir uma conta");
        System.out.println("2. Realizar um depósito");
        System.out.println("3. Realizar um saque");
        System.out.println("4. Exibir informações de uma conta");
        System.out.println("0. Sair");
        System.out.println("---------------------------------");
    }

    public static void executaMenu(int op, Scanner sc, Banco banco) {
        String nome, cpf, email, numeroConta;
        double quantia;
        Conta conta;

        switch (op) {
            case 0:
                System.out.println("Até a próxima!");
                break;
            case 1:
                System.out.println("---------------------------------");
                System.out.println("Opção 1: Abrir uma conta");
                System.out.println("Digite o nome do titular: ");
                nome = sc.nextLine();
                System.out.println("Digite o CPF do titular: ");
                cpf = sc.nextLine();
                System.out.println("Digite o email do titular: ");
                email = sc.nextLine();
                numeroConta = banco.criarConta(nome, cpf, email);
                System.out.println(String.format("Conta %s aberta com sucesso!", numeroConta));
                System.out.println(banco);
                System.out.println("---------------------------------");
                break;
            case 2:
                System.out.println("---------------------------------");
                System.out.println("Opção 2: Realizar um depósito");
                System.out.println("Digite o número da conta:");
                numeroConta = sc.nextLine();
                System.out.println("Digite a quantia desejada para o depósito: ");
                quantia = sc.nextDouble();
                sc.nextLine();
                banco.depositar(numeroConta, quantia);
                System.out.println("---------------------------------");
                break;
            case 3:
                System.out.println("---------------------------------");
                System.out.println("Opção 3: Realizar um saque");
                System.out.println("Digite o número da conta:");
                numeroConta = sc.nextLine();
                System.out.println("Digite a quantia desejada para o saque: ");
                quantia = sc.nextDouble();
                sc.nextLine();
                banco.sacar(numeroConta, quantia);
                System.out.println("---------------------------------");
                break;
            case 4:
                System.out.println("---------------------------------");
                System.out.println("Opção 4: Exibir informações de uma conta");
                System.out.println("Digite o número da conta:");
                numeroConta = sc.nextLine();
                conta = banco.buscarConta(numeroConta);

                if(conta != null) {
                    System.out.println(conta);
                } else {
                    System.out.println("Conta " + numeroConta + " não encontrada.");
                }

                System.out.println("---------------------------------");
                break;
            default:
                System.out.println(String.format("Opção %d inválida!", op));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int op = -1;
        Banco banco = new Banco();

        do {
            imprimeMenu();
            op = sc.nextInt();
            sc.nextLine();
            executaMenu(op, sc, banco);
        } while (op != 0);

        sc.close();
    }
}
