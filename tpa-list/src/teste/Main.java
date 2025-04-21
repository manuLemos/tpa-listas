package teste;

import listas.ListaNaoOrdenada;
import listas.ListaOrdenada;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicialização das variáveis principais
        int resposta = 0;

        // Instanciando os objetos utilizados no programa
        LeitorArquivos leitor = new LeitorArquivos();
        Comparador comparador = new Comparador();
        ListaNaoOrdenada<Aluno> listaNaoOrdenada = new ListaNaoOrdenada<>();
        ListaOrdenada<Aluno> listaOrdenada = new ListaOrdenada<>(comparador);

        // Medindo o tempo de inserção dos elementos na lista NÃO ordenada
        long inicioNaoOrd = System.nanoTime();
        leitor.lerNaoOrdenada("alunosOrdenados.txt",listaNaoOrdenada); // <-- Arquivo que irá alimentar a lista
        long fimNaoOrd = System.nanoTime();
        double tempoNaoOrd = (fimNaoOrd - inicioNaoOrd);
        System.out.printf("Tempo inserção não ordenada: %.6f segundos%n",tempoNaoOrd/1000000000);

        // Medindo o tempo de inserção dos elementos na lista ORDENADA
        long inicioOrd = System.nanoTime();
        leitor.lerOrdenada("alunosOrdenados.txt", listaOrdenada); // <-- Arquivo que irá alimentar a lista
        long fimOrd = System.nanoTime();
        double tempoOrd = (fimOrd - inicioOrd);
        System.out.printf("Tempo inserção ordenada: %.6f segundos%n", tempoOrd / 1000000000);

        // Loop do menu principal com opções de busca e encerramento
        while (resposta != 3) {
            System.out.println("Escolha uma opção (1,2 ou 3):\n");
            System.out.println("\n[1] Pesquisar na Lista Não-Ordenada");
            System.out.println("\n[2] Pesquisar na Lista Ordenada");
            System.out.println("\n[3] Sair");

            // Leitura da opção do usuário
            Scanner entrada = new Scanner(System.in);
            System.out.println("Digite a opção: ");
            resposta = entrada.nextInt();

            switch (resposta) {

                case 1:
                    // Pesquisa na lista NÃO ordenada
                    System.out.print("Digite a matrícula para pesquisa: ");
                    int matricula1 = entrada.nextInt();
                    Aluno pesquisaNaoOrd = new Aluno("",matricula1,0);

                    // Medindo o tempo da busca
                    long inicioPesqNaoOrdenada = System.nanoTime();
                    pesquisaNaoOrd = listaNaoOrdenada.pesquisar(pesquisaNaoOrd);
                    long fimPesqNaoOrdenada = System.nanoTime();
                    double tempoPesqNaoOrdenada = fimPesqNaoOrdenada-inicioPesqNaoOrdenada;
                    System.out.printf("Tempo de pesquisa: %.6f segundos%n", (tempoPesqNaoOrdenada)/1000000000);

                    // Exibindo o resultado da busca
                    if (pesquisaNaoOrd == null){
                        System.out.println("\nAluno não encontrado");
                    }
                    else System.out.println(pesquisaNaoOrd);
                    break;

                case 2:
                    // Pesquisa na lista ORDENADA
                    System.out.print("\nDigite a matrícula para pesquisa: ");
                    int matricula2 = entrada.nextInt();
                    Aluno pesquisaOrd = new Aluno("",matricula2,0);

                    // Medindo o tempo da busca
                    long inicioPesqOrdenada = System.nanoTime();
                    pesquisaOrd = listaOrdenada.pesquisar(pesquisaOrd);
                    long fimPesqOrdenada = System.nanoTime();
                    double tempoPesqOrdenada = fimPesqOrdenada-inicioPesqOrdenada;
                    System.out.printf("Tempo de pesquisa: %.6f segundos%n",(tempoPesqOrdenada)/1000000000);

                    // Exibindo o resultado da busca
                    if (pesquisaOrd == null){
                        System.out.println("\nAluno não encontrado");
                    }
                    else System.out.println(pesquisaOrd);
                    break;

                case 3:
                    // Encerramento do programa
                    System.out.println("\nO programa será encerrado. Até mais! =)");
                    break;

                default:
                    // Tratamento de entrada inválida
                    System.out.println("\nEntrada invalida! Tente novamente.");
                    break;
            }
        }

    }
}
