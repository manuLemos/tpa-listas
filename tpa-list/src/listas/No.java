package listas;

public class No<T> {
    private No<T> prox;
    private T valor;

    public No(T valor) {
        this.prox = null;
        this.valor = valor;
    }

    public No<T> getProx() {
        return prox;
    }
    public void setProx(No<T> prox) { this.prox = prox; }
    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
}
