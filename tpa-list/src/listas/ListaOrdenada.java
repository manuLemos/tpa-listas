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

    public void adicionar(T novoValor) {
        No<T> novo = new No<>(novoValor);
        No<T> atual,ant;
        atual = this.prim;
        ant = null;

        if (this.prim == null) {
            this.prim = novo;
            this.ult = novo;
        }
        else {
            while (atual != null && comparador.compare(atual.getValor(), novoValor) < 0) {
                ant=atual;
                atual=atual.getProx();
            }
            if(ant==null) {
                novo.setProx(this.prim);
                this.prim=novo;
            }
            else if(atual==null){
                this.ult.setProx(novo);
                this.ult=novo;
            }
            else {
                ant.setProx(novo);
                novo.setProx(this.ult);
            }
        }
        this.qtd++;
    }
}
