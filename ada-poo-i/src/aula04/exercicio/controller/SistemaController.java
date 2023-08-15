package aula04.exercicio.controller;

import aula04.exercicio.dominio.Cliente;
import aula04.exercicio.dominio.Pedido;
import aula04.exercicio.dominio.Prato;
import aula04.exercicio.dominio.Restaurante;
import aula04.exercicio.repositorio.ClienteRepositorio;
import aula04.exercicio.repositorio.PedidoRepositorio;
import aula04.exercicio.repositorio.PratoRepositorio;
import aula04.exercicio.repositorio.RestauranteRepositorio;
import aula04.exercicio.servico.ClienteServico;
import aula04.exercicio.servico.PedidoServico;
import aula04.exercicio.servico.PratoServico;
import aula04.exercicio.servico.RestauranteServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaController {

    private ClienteServico clienteServico;
    private PedidoServico pedidoServico;
    private PratoServico pratoServico;
    private RestauranteServico restauranteServico;
    private Scanner sc;

    public SistemaController() {
        this.clienteServico = new ClienteServico(new ClienteRepositorio());
        this.pedidoServico = new PedidoServico(new PedidoRepositorio());
        this.pratoServico = new PratoServico(new PratoRepositorio());
        this.restauranteServico = new RestauranteServico(new RestauranteRepositorio());
        this.sc = new Scanner(System.in);
    }

    private void imprimeListaRestaurante() {
        List<Restaurante> restaurantes = this.restauranteServico.listaRestaurantes();

        if(restaurantes != null) {
            for (Restaurante aux : restaurantes) {
                System.out.println(String.format("%d: %s", aux.getIdRestaurante(), aux.getNome()));
            }
        }
    }

    private void imprimeListaCliente() {
        List<Cliente> clientes = this.clienteServico.listaClientes();

        if(clientes != null) {
            for (Cliente aux : clientes) {
                System.out.println(String.format("%d: %s", aux.getIdCliente(), aux.getNome()));
            }
        }
    }

    private void imprimePratosRestaurate(int idRestaurante) {
        List<Prato> pratos =  this.restauranteServico.listaMenuRestaurante(idRestaurante, this.pratoServico);

        if(pratos != null) {
            for (Prato aux : pratos) {
                System.out.println(String.format("%d: %s ($ %.2f) - %s", aux.getIdPrato(), aux.getNome(),
                        aux.getPreco(), aux.getDescricao()));
            }
        }
    }

    private void imprimePedidos(List<Pedido> pedidos) {
        if(pedidos != null) {
            for (Pedido aux : pedidos) {
                System.out.println(String.format("Pratos do pedido %d ($ %.2f)", aux.getIdPedido(), aux.getValorTotal()));
                for (Prato paux : aux.getPratos()) {
                    System.out.println(String.format("%d: %s ($ %.2f)", paux.getIdPrato(), paux.getNome(), paux.getPreco()));
                }
            }
        }
    }

    private void imprimePedidosRestaurate(int idRestaurante) {
        imprimePedidos(this.pedidoServico.listaPedidosRestaurante(idRestaurante));
    }

    private void imprimePedidosCliente(int idCliente) {
        imprimePedidos(this.pedidoServico.listaPedidosCliente(idCliente));
    }

    private void imprimeMenuPrincipal() {
        System.out.println("---------------------------------");
        System.out.println("Escolha uma das opções a seguir:");
        System.out.println("1. Cadastrar um restaurante");
        System.out.println("2. Cadastrar um cliente");
        System.out.println("3. Adicionar um prato");
        System.out.println("4. Exibir lista de pratos de um restaurante");
        System.out.println("5. Fazer um pedido");
        System.out.println("6. Listar pedidos de um restaurante");
        System.out.println("7. Listar pedidos de um cliente");
        System.out.println("0. Sair");
        System.out.println("---------------------------------");
    }

    private void executaMenuCadastraRestaurante() {
        System.out.println("---------------------------------");
        System.out.println("Opção 1: Cadastrar um restaurante:");
        System.out.println("---------------------------------");
        System.out.println("Digite o nome do restaurante: ");
        String nome = this.sc.nextLine();
        System.out.println("Digite o endereço do restaurante: ");
        String endereco = this.sc.nextLine();
        int idRestaurante = this.restauranteServico.criaRestaurante(nome, endereco);
        System.out.println(String.format("Restaurante %s com id %d cadastrado com sucesso!", nome, idRestaurante));
        System.out.println("---------------------------------");
    }

    private void executaMenuCadastraCliente() {
        System.out.println("---------------------------------");
        System.out.println("Opção 2: Cadastrar um cliente:");
        System.out.println("---------------------------------");
        System.out.println("Digite o nome do cliente: ");
        String nome = this.sc.nextLine();
        int idCliente = this.clienteServico.criaCliente(nome);
        System.out.println(String.format("Cliente %s com id %d cadastrado com sucesso!", nome, idCliente));
        System.out.println("---------------------------------");
    }

    private void executaMenuAdicionaPrato() {
        System.out.println("---------------------------------");
        System.out.println("Opção 3: Adicionar um prato:");
        System.out.println("---------------------------------");
        imprimeListaRestaurante();
        System.out.println("Digite o id do restaurante: ");
        int idRestaurante = this.sc.nextInt();
        this.sc.nextLine();
        System.out.println("Digite o nome do prato: ");
        String nome = this.sc.nextLine();
        System.out.println("Digite o preço do prato: ");
        double preco = this.sc.nextDouble();
        this.sc.nextLine();
        System.out.println("Digite a descrição do prato: ");
        String desc = this.sc.nextLine();
        int idPrato = this.pratoServico.criaPrato(idRestaurante, nome, preco, desc);
        System.out.println(String.format("Prato %s com id %d adicionado com sucesso!", nome, idPrato));
        System.out.println("---------------------------------");
    }

    private void executaMenuExibePratosRestaurante() {
        System.out.println("---------------------------------");
        System.out.println("Opção 4: Exibir lista de pratos de um restaurante:");
        System.out.println("---------------------------------");
        imprimeListaRestaurante();
        System.out.println("Digite o id do restaurante: ");
        int idRestaurante = this.sc.nextInt();
        this.sc.nextLine();
        imprimePratosRestaurate(idRestaurante);
        System.out.println("---------------------------------");
    }

    private List<Integer> selecionaPratoPedido(int idRestaurante) {
        List<Integer> idPratos = new ArrayList<>();
        int idPrato = -1;

        while(idPrato != 0) {
            imprimePratosRestaurate(idRestaurante);
            System.out.println("Digite o id do prato desejado (digite 0 para parar de adicionar): ");
            idPrato = this.sc.nextInt();
            this.sc.nextLine();
            idPratos.add(idPrato);
        }

        return idPratos;
    }

    private void executaMenuFazPedido() {
        System.out.println("---------------------------------");
        System.out.println("Opção 5: Fazer um pedido:");
        System.out.println("---------------------------------");

        System.out.println("Digite o endereço de entrega: ");
        String enderecoEntrega = this.sc.nextLine();

        imprimeListaCliente();
        System.out.println("Digite o id do cliente: ");
        int idCliente = this.sc.nextInt();
        this.sc.nextLine();

        imprimeListaRestaurante();
        System.out.println("Digite o id do restaurante: ");
        int idRestaurante = this.sc.nextInt();
        this.sc.nextLine();

        List<Integer> idPratos = selecionaPratoPedido(idRestaurante);

        int idPedido = this.restauranteServico.fazPedido(enderecoEntrega, idPratos, idRestaurante, idCliente,
                this.pratoServico, this.pedidoServico);

        System.out.println(String.format("Pedido com id %d feito com sucesso!", idPedido));
        System.out.println("---------------------------------");
    }

    private void executaMenuListaPedidosRestaurante() {
        System.out.println("---------------------------------");
        System.out.println("Opção 6: Listar pedidos de um restaurante:");
        System.out.println("---------------------------------");

        imprimeListaRestaurante();
        System.out.println("Digite o id do restaurante: ");
        int idRestaurante = this.sc.nextInt();
        this.sc.nextLine();

        imprimePedidosRestaurate(idRestaurante);

        System.out.println("---------------------------------");
    }

    private void executaMenuListaPedidosCliente() {
        System.out.println("---------------------------------");
        System.out.println("Opção 7: Listar pedidos de um cliente:");
        System.out.println("---------------------------------");

        imprimeListaCliente();
        System.out.println("Digite o id do cliente: ");
        int idCliente = this.sc.nextInt();
        this.sc.nextLine();

        imprimePedidosCliente(idCliente);

        System.out.println("---------------------------------");
    }

    private void executaMenu(int op) {

        switch (op) {
            case 0:
                System.out.println("Até a próxima!");
                break;
            case 1:
                executaMenuCadastraRestaurante();
                break;
            case 2:
                executaMenuCadastraCliente();
                break;
            case 3:
                executaMenuAdicionaPrato();
                break;
            case 4:
                executaMenuExibePratosRestaurante();
                break;
            case 5:
                executaMenuFazPedido();
                break;
            case 6:
                executaMenuListaPedidosRestaurante();
                break;
            case 7:
                executaMenuListaPedidosCliente();
                break;
            default:
                System.out.println(String.format("Opção %d inválida!", op));
        }
    }

    public void inicia() {
        int op = -1;

        do {
            imprimeMenuPrincipal();
            op = this.sc.nextInt();
            this.sc.nextLine();
            executaMenu(op);
        } while (op != 0);

        this.sc.close();
    }


}
