import listas.ListaNaoOrdenada;
import listas.ListaOrdenada;
import teste.Comparador;
import teste.Aluno;

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("MANU",23,10);
        Aluno a2 = new Aluno("MARIA",123,8);
        Aluno a3 = new Aluno("MAISA",1,9);

        Comparador comparador = new Comparador();

        ListaOrdenada<Aluno> alunos = new ListaOrdenada<>(comparador);
        alunos.adicionar(a1);
        alunos.adicionar(a2);
        alunos.adicionar(a3);

        System.out.println(alunos);
    }
}