package listas;

public abstract class Lista<T> {
    protected int qtd;
    protected No<T> prim,ult;

    public Lista() {
        this.qtd = 0;
        this.prim = null;
        this.ult = null;
    }
}
