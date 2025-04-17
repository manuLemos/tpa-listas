package listas;

import teste.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class ListaOrdenada <T> extends Lista<T>{
    private Comparator<T> comparador;

    public ListaOrdenada(Comparator<T> comparador) {
        super();
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

    public void popularListaOrdenada(String NOME_ARQUIVO) {

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                this.adicionar((T) new Aluno(nome,id,nota));
            }

            System.out.println("Elementos do arquivo adicionados com sucesso!");
            //printar o timer

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }
}
