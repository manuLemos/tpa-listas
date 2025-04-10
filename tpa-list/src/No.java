public class No<T> {
    private No<T> prox;
    private Object valor;

    public No (No prox, Object valor) {
        this.prox = null;
        this.valor = valor;
    }

    //public No getProx();

}
