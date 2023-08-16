package aula07;

import aula07.exercicio.Pilha;
import aula07.exercicio.PilhaLinkedList;

public class TestePilha {
    public static void main(String[] args) {
        Pilha pilhas = new PilhaLinkedList();

        pilhas.push("TESTE");
        pilhas.push(1);
        pilhas.push(true);
        pilhas.push("ULTIMO");
        System.out.println(pilhas.pop());
        System.out.println(pilhas.peek());

    }

}
