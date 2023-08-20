package aula06.impl;

import aula06.contrato.Lista;

public class ArrayLista extends Lista {

    private int size;
    private Object[] array;

    public ArrayLista() {
        this.array = new Object[15];
    }

    @Override
    public void add(Object obj) {
        this.array[this.size++] = obj;
    }

    @Override
    public Object get(int idx) {
        if(idx < 0 || idx >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Posição %d inválida.", idx));
        }
        return this.array[idx];
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

        for(int i = idx; i < this.size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.size--;
    }
}
