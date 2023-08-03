package aula01;

public class Agenda {

    /*
    * - Modele a classe AGENDA que contém um array de contatos como atributo e os seguintes métodos:
    - deletar(Contato);
    - buscar(String);
    *
    * */

    Contato[] contatos;

    public void deletar(Contato contato) {
        Contato[] lista = new Contato[this.contatos.length - 1];
        int i = 0;
        boolean deletou = false;

        for(Contato temp: this.contatos) {
            if(!temp.equals(contato)) {
                lista[i++] = temp;
            } else {
                deletou = true;
            }
        }

        if(deletou) {
            this.contatos = lista;
        }
    }

    public Contato buscar(String nome) {
        for(Contato contato: this.contatos) {
            if(contato.nome.equals(nome)) {
                return contato;
            }
        }

        return null;
    }

    public void imprimir() {
        System.out.println("----- Agenda -----");
        for(Contato contato: this.contatos) {
            contato.detalhar();
            System.out.println("---------------");
        }
    }
}
