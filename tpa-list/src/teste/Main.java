package teste;
import listas.ListaNaoOrdenada;
import listas.ListaOrdenada;
import teste.Comparador;
import teste.Aluno;


public class Main {
    public static void main(String[] args) {

        LeitorArquivos leitor = new LeitorArquivos();




        Comparador comparador = new Comparador();
        ListaNaoOrdenada<Aluno> listaNaoOrdenada = new ListaNaoOrdenada<>();
        ListaOrdenada<Aluno> listaOrdenada = new ListaOrdenada<>(comparador);



        //leitura e cálculo da não ordenada
        long inicioNaoOrd = System.nanoTime();
        leitor.lerNaoOrdenada("alunosBalanceados.txt",listaNaoOrdenada);
        long fimNaoOrd = System.nanoTime();

        //leitura e cálculo da ordenada
        long inicioOrd = System.nanoTime();
        leitor.lerOrdenada("alunosBalanceados.txt",listaOrdenada);
        long fimOrd = System.nanoTime();

        double tempoNaoOrd = (fimNaoOrd - inicioNaoOrd);
        double tempoOrd = (fimOrd - inicioOrd);

        System.out.println("Tempo nao ordenada: "+tempoNaoOrd);
        System.out.println("Tempo ordenada: "+tempoOrd);
    }
}