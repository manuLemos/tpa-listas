package teste;

import listas.*;
import teste.Aluno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorArquivos {

    public void lerNaoOrdenada(String NOME_ARQUIVO, ListaNaoOrdenada<Aluno> lista) {

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                lista.adicionar(new Aluno(nome,id,nota));

            }

            System.out.println("Elementos do arquivo adicionados com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro ao processar um dos valores numéricos: " + e.getMessage());
        }
    }

    public void lerOrdenada(String NOME_ARQUIVO, ListaOrdenada<Aluno> lista) {

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            int numRegistros = Integer.parseInt(reader.readLine().trim());
            System.out.println("Número de registros: " + numRegistros);

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                float nota = Float.parseFloat(partes[2]);

                lista.adicionar(new Aluno(nome,id,nota));
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