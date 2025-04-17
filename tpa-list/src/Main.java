import listas.ListaNaoOrdenada;
import listas.ListaOrdenada;
import teste.Comparador;
import teste.Aluno;


public class Main {
    public static void main(String[] args) {

        Comparador comparador = new Comparador();
        ListaOrdenada<Aluno> alunosOrdem = new ListaOrdenada<>(comparador);

        ListaNaoOrdenada<Aluno> alunosSemOrdem = new ListaNaoOrdenada<>();

        // Usando arquivo balanceado
        alunosOrdem.popularListaOrdenada("alunosBalanceados.txt");
        alunosSemOrdem.popularListaNaoOrdenada("alunosBalanceados.txt");

        //Usando arquivo ordenado (PIOR CASO)
        alunosOrdem.popularListaOrdenada("alunosOrdenados.txt");
        alunosSemOrdem.popularListaNaoOrdenada("alunosOrdenados.txt");

    }
}