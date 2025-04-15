package teste;

public class Aluno {
    private String nome;
    private int matricula;
    private float nota;

    public Aluno(String nome, int matricula, float nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nome + " - " + matricula + " - " + nota;
    }
}
