package teste;
import listas.ListaNaoOrdenada;
import listas.ListaOrdenada;
import teste.Comparador;
import teste.Aluno;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int resposta = 0;

        LeitorArquivos leitor = new LeitorArquivos();
        Comparador comparador = new Comparador();
        ListaNaoOrdenada<Aluno> listaNaoOrdenada = new ListaNaoOrdenada<>();
        ListaOrdenada<Aluno> listaOrdenada = new ListaOrdenada<>(comparador);

        //leitura e cálculo da não ordenada
        long inicioNaoOrd = System.nanoTime();
        leitor.lerNaoOrdenada("alunosBalanceados.txt",listaNaoOrdenada);
        long fimNaoOrd = System.nanoTime();
        double tempoNaoOrd = (fimNaoOrd - inicioNaoOrd);
        System.out.println("Tempo inserção não ordenada: "+tempoNaoOrd);

        //leitura e cálculo da ordenada
        long inicioOrd = System.nanoTime();
        leitor.lerOrdenada("alunosBalanceados.txt",listaOrdenada);
        long fimOrd = System.nanoTime();
        double tempoOrd = (fimOrd - inicioOrd);
        System.out.println("Tempo inserção ordenada: "+tempoOrd);

        //menu
        while (resposta !=3 ) {
            System.out.println("Escolha uma opção (1,2 ou 3):\n");
            System.out.println("\n[1] Pesquisar na Lista Não-Ordenada");
            System.out.println("\n[2] Pesquisar na Lista Ordenada");
            System.out.println("\n[3] Sair");

            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite a opção\n");
            resposta = entrada.nextInt();

            switch (resposta) {

                case 1:
                    System.out.print("Digite a matrícula para pesquisa: ");
                    int matricula1 = entrada.nextInt();
                    Aluno pesquisaNaoOrd = new Aluno("",matricula1,0);
                    long inicioPesqNaoOrdenada = System.nanoTime();
                    pesquisaNaoOrd = listaNaoOrdenada.pesquisar(pesquisaNaoOrd);
                    long fimPesqNaoOrdenada = System.nanoTime();
                    System.out.println("Tempo de pesquisa: "+ (fimPesqNaoOrdenada-inicioPesqNaoOrdenada));

                    if (pesquisaNaoOrd == null){
                        System.out.println("\nAluno não encontrado");
                    }
                    else System.out.println(pesquisaNaoOrd);
                    break;

                case 2:
                    System.out.print("\nDigite a matrícula para pesquisa: ");
                    int matricula2 = entrada.nextInt();
                    Aluno pesquisaOrd = new Aluno("",matricula2,0);
                    long inicioPesqOrdenada = System.nanoTime();
                    pesquisaOrd = listaOrdenada.pesquisar(pesquisaOrd);
                    long fimPesqOrdenada = System.nanoTime();
                    System.out.println("Tempo de pesquisa: "+(fimPesqOrdenada - inicioPesqOrdenada));

                    if (pesquisaOrd == null){
                        System.out.println("\nAluno não encontrado");
                    }
                    else System.out.println(pesquisaOrd);
                    break;

                case 3:
                    System.out.println("\nO programa será encerrado. Até mais! =)");
                    break;

                default:
                    System.out.println("\nEntrada invalida! Tente novamente.");
                    break;
            }
        }
    }
}