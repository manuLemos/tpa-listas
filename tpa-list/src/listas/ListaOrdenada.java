package listas;

import java.util.Comparator;

public class ListaOrdenada <T> {
    private int qtd;
    private No<T> prim,ult;
    private Comparator<T> comparador;

    public ListaOrdenada(Comparator<T> comparador) {
        this.qtd = 0;
        this.prim = null;
        this.ult = null;
        this.comparador = comparador;
    }
}
