package set.operacoesBasicas;

import java.util.Set;
import java.util.HashSet;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados(Set<Convidado> convidadoSet) {
        this.convidadoSet = convidadoSet;
    }

    public void adicionarConvidado(String nome, int codigoConvite) {
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }

    public void removerConvidadoPorCodigoConvite(int codigoConvite) {
        Convidado convidadoParaRemover = null;
        for (Convidado e : convidadoSet) {
            if (e.getCodigoConvite() == codigoConvite) {
                convidadoParaRemover = e;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados() {
        return convidadoSet.size();
    }

    public void exibirConvidados() {
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        Set<Convidado> convidados = new HashSet<>();
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados(convidados);
        System.out.println("Adicionando convidados:");
        // Adicionando convidados
        conjuntoConvidados.adicionarConvidado("João", 1);
        conjuntoConvidados.adicionarConvidado("Maria", 2);
        conjuntoConvidados.adicionarConvidado("Pedro", 3);
        conjuntoConvidados.adicionarConvidado("Paulo", 3);
        System.out.println();

        // Exibindo a lista de convidados
        System.out.println("Lista de Convidados:");
        conjuntoConvidados.exibirConvidados();
        System.out.println();

        // Removendo um convidado por código de convite
        System.out.println("Removido o convidado com o código '2'");
        conjuntoConvidados.removerConvidadoPorCodigoConvite(2);
        System.out.println();

        // Exibindo a lista atualizada de convidados
        System.out.println("\nLista de Convidados Atualizada:");
        conjuntoConvidados.exibirConvidados();
        System.out.println();

        // Contando o número de convidados
        int numeroDeConvidados = conjuntoConvidados.contarConvidados();
        System.out.println("\nNúmero de Convidados: " + numeroDeConvidados);
    }
}

