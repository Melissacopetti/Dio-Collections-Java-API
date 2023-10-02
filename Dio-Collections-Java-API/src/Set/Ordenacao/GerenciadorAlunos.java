package set.ordenacao;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double media) {
        Aluno novoAluno = new Aluno(nome, matricula, media);
        alunosSet.add(novoAluno);
    }

    public Set<Aluno> exibirAlunosPorNome() {
        return new TreeSet<>(alunosSet);
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> alunosPorNota = new TreeSet<>(new Comparator<Aluno>() {
            @Override
            public int compare(Aluno aluno1, Aluno aluno2) {
                return Double.compare(aluno1.getNota(), aluno2.getNota());
            }
        });
        alunosPorNota.addAll(alunosSet);
        return alunosPorNota;
    }

    public void removerAluno(long matricula) {
        Aluno alunoParaRemover = null;
        for (Aluno aluno : alunosSet) {
            if (aluno.getMatricula() == matricula) {
                alunoParaRemover = aluno;
                break;
            }
        }
        if (alunoParaRemover != null) {
            alunosSet.remove(alunoParaRemover);
        }
    }

    public void exibirAlunos() {
        for (Aluno aluno : alunosSet) {
            System.out.println(aluno);
        }
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();
        System.out.println("Adicionando alunos");
        gerenciador.adicionarAluno("Ana", 12345L, 9.5);
        gerenciador.adicionarAluno("Laura", 67890L, 8.0);
        gerenciador.adicionarAluno("Carlos", 54321L, 10);
        gerenciador.adicionarAluno("Renato", 54321L, 5.0);
        gerenciador.adicionarAluno("Carlos", 32198L, 6.5);
        System.out.println();

        System.out.println("Exibindo alunos por nome:");
        gerenciador.exibirAlunosPorNome().forEach(System.out::println);
         System.out.println();

        System.out.println("Exibindo alunos por nota:");
        gerenciador.exibirAlunosPorNota().forEach(System.out::println);
         System.out.println();

        System.out.println("Removendo aluno com matrícula 67890");
        gerenciador.removerAluno(67890L);
         System.out.println();

        System.out.println("Exibindo todos os alunos:");
        gerenciador.exibirAlunos();
    }
}



