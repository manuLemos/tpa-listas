package listas;

public class ListaNaoOrdenada<T> extends Lista<T>{

    public ListaNaoOrdenada() {
        super();
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

    public T pesquisar(T valor){
        No<T> aux = this.prim;

        while(aux != null){
            if(valor.equals(aux.getValor())){
                return aux.getValor();
            }
            aux = aux.getProx();
        }
        return null;
    }

    public String toString() {
        String retorno = "[ ";
        No<T> aux = this.prim;
        while (aux!=null) {
            retorno += aux.getValor();
            if(aux!=this.ult){
                retorno += ", ";
            }
            aux = aux.getProx();
        }
        return retorno+" ]";
    }


}
