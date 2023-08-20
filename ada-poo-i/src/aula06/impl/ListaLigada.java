package aula06.impl;

import aula06.contrato.Lista;

public class ListaLigada extends Lista {

    private int size;
    private Elemento inicio;

    public ListaLigada() {
        this.inicio = null;
    }

    @Override
    public void add(Object obj) {
        Elemento novo = new Elemento(obj);

        if(size == 0) {
            this.inicio = novo;
        } else {
            Elemento temp = this.inicio;
            while(temp.getProximo() != null) {
                temp = temp.getProximo();
            }
            temp.setProximo(novo);
        }
        this.size++;
    }

    @Override
    public Object get(int idx) {
        if(idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Posição %d inválida.", idx));
        }

        Elemento temp = this.inicio;
        for(int i = 0; i < idx; i++) {
            temp = temp.getProximo();
        }
        return temp.getValor();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void remove(int idx) {
        if(idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Posição %d inválida.", idx));
        }

        Elemento anterior = this.inicio;
        Elemento temp = this.inicio;
        for(int i = 0; i < idx; i++) {
            anterior = temp;
            temp = temp.getProximo();
        }

        anterior.setProximo(temp.getProximo());
        this.size--;
    }

    class Elemento {
        private Object valor;
        private Elemento proximo;

        public Elemento(Object valor) {
            this.valor = valor;
            this.proximo = null;
        }

        public Object getValor() {
            return this.valor;
        }

        public Elemento getProximo() {
            return this.proximo;
        }

        public void setProximo(Elemento proximo) {
            this.proximo = proximo;
        }
    }
}
