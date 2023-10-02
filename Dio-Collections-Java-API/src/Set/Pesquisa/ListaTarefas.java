package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class ListaTarefas {
    private Set<Tarefa> tarefas;

    public ListaTarefas() {
        this.tarefas = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        tarefas.add(novaTarefa);
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefaParaRemover = null;
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefaParaRemover = tarefa;
                break;
            }
        }
        if (tarefaParaRemover != null) {
            tarefas.remove(tarefaParaRemover);
        }
    }

    public void exibirTarefas() {
        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }

    public int contarTarefas() {
        return tarefas.size();
    }

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (tarefa.isConcluida()) {
                tarefasConcluidas.add(tarefa);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                tarefasPendentes.add(tarefa);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.marcarComoConcluida();
                break;
            }
        }
    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getDescricao().equals(descricao)) {
                tarefa.marcarComoPendente();
                break;
            }
        }
    }

    public void limparListaTarefas() {
        tarefas.clear();
    }

    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        listaTarefas.exibirTarefas();

        System.out.println("Adicionando tarefas e descrição:");

        listaTarefas.adicionarTarefa("Lavar louça");
        listaTarefas.adicionarTarefa("Lavar tapete");
        listaTarefas.adicionarTarefa("Varrer chão");
        listaTarefas.adicionarTarefa("Fazer exercício");
        listaTarefas.adicionarTarefa("trocar toalha");

        listaTarefas.exibirTarefas();

        System.out.println();
        System.out.println("Removendo tarefa 'Fazer exercício'");
        listaTarefas.

                removerTarefa("Fazer exercício");
        listaTarefas.exibirTarefas();
        System.out.println();

        int numeroTarefas = listaTarefas.contarTarefas();
        System.out.println("Número de tarefas " + numeroTarefas);

        System.out.println();
        System.out.println("Marcando a tarefa 'Lavar louça' como concluída");
        listaTarefas.marcarTarefaConcluida("Lavar louça");

        System.out.println();
        System.out.println(" Marcando a tarefa 'Lavar tapete' como pendente");
        listaTarefas.marcarTarefaPendente("Lavar tapete");

        System.out.println();
        System.out.println("  Exibindo tarefas concluídas");

        Set<Tarefa> tarefasConcluidas = listaTarefas.obterTarefasConcluidas();
        System.out.println("Tarefas Concluídas:");
        for (Tarefa tarefa : tarefasConcluidas) {
            System.out.println(tarefa.getDescricao());
        }
        System.out.println();
        System.out.println(" Exibindo tarefas pendentes");

        Set<Tarefa> tarefasPendentes = listaTarefas.obterTarefasPendentes();
        System.out.println("Tarefas Pendentes:");
        for (Tarefa tarefa : tarefasPendentes) {
            System.out.println(tarefa.getDescricao());
        }

    }
}
