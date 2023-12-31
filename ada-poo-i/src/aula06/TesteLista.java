package aula06;

import aula06.contrato.Lista;
import aula06.impl.ArrayLista;
import aula06.impl.ListaLigada;

public class TesteLista {
    public static void main(String[] args) {
        Lista lista = new ArrayLista();
//        Lista lista = new ListaLigada();

        lista.add("Objeto 1");
        lista.add(2);
        lista.add(3.5);
        lista.add(null);
        lista.add(true);

        imprimeLista(lista);

        System.out.println(lista.get(3));

        try {
            lista.get(-1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lista.remove(3);

        for(int i = lista.size() - 1; i >= 0; i--) {
            lista.remove(i);
            imprimeLista(lista);
        }

    }

    public static void imprimeLista(Lista lista) {
        System.out.println("=============================");
        for(int i = 0; i < lista.size(); i++) {
            System.out.println(i + " " + lista.get(i));
        }
        System.out.println("=============================");
    }
}
