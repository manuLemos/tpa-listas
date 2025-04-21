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


    public T pesquisar(T valor){
        No<T> aux = this.prim;

        while(aux != null) {
            int comparacao = comparador.compare(aux.getValor(), valor);

            if (comparacao == 0) {
                return aux.getValor();
            } else if (comparacao > 0) {
                // O valor atual é maior que o procurado - interrompe a busca
                return null;
            }

            aux = aux.getProx();
        }

        return null; // Chegou ao fim e não encontrou
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
