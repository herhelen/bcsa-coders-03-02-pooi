package aula07.exercicio;

import java.util.LinkedList;
import java.util.List;

public class PilhaLinkedList extends Pilha {

    private List<Object> pilha;

    public PilhaLinkedList() {
        this.pilha = new LinkedList<>();
    }

    @Override
    public void push(Object obj) {
        this.pilha.add(0, obj);
    }

    @Override
    public Object pop() {
        if(this.pilha.size() > 0) {
            return this.pilha.remove(0);
        }
        return null;
    }

    @Override
    public Object peek() {
        if(this.pilha.size() > 0) {
            return this.pilha.get(0);
        }
        return null;
    }
}
