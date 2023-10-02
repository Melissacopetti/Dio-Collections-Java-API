package set.ordenacao;

import java.util.Objects;

public class Aluno implements Comparable<Aluno> {
    private String nome;
    private long matricula;
    private double nota;

    public Aluno(String nome, long matricula, double nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public Aluno() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return this.matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Aluno aluno))
            return false;
        return getMatricula() == aluno.getMatricula() && Objects.equals(getMatricula(), aluno.getMatricula());
    }

    @Override
    public String toString() {
        return "{" +
                " nome='" + getNome() + "'" +
                ", matricula='" + getMatricula() + "'" +
                ", nota='" + getNota() + "'" +
                "}";
    }

    @Override
    public int compareTo(Aluno a) {
        return this.nome.compareTo(a.getNome());
    }

}
