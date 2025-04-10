package listas;

public class ListaNaoOrdenada<T> {
    private No<T> prim,ult;
    private int qtd;

    public ListaNaoOrdenada() {
        this.qtd = 0;
        this.prim = null;
        this.ult = null;
    }

    public void adicionar(T novoValor) {
        No<T> novo = new No<T>(novoValor) ;

        if (this.prim == null) {
            this.prim = novo;
            this.ult = novo;
        }
        else {
            this.ult.setProx(novo);
            this.ult = novo;
        }
        this.qtd++;
    }

}
