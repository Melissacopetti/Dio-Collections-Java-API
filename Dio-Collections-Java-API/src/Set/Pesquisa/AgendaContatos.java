package set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> contatoSet;

    public AgendaContatos(Set<Contato> contatoSet) {
        this.contatoSet = contatoSet;
    }

    public AgendaContatos() {
        this.contatoSet = new HashSet<>();
    }
    

    public void adicionarContato(String nome, int numero) {
        contatoSet.add(new Contato(nome, numero));
    }

    public void exibirContatos() {
        System.out.println(contatoSet);
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> contatoPorNome = new HashSet<>();
        for (Contato e : contatoSet) {
            if (e.getNome().startsWith(nome)) {
                contatoPorNome.add(e);
            }
        }
        return contatoPorNome;
    }

    /**
     * @param nome
     * @param novoNumero
     * @return
     */
    public Contato atualizarNumeroContato(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if (!contatoSet.isEmpty()) {
            for (Contato c : contatoSet) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumero(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
            return contatoAtualizado;
        } else {
            throw new RuntimeException("O conjunto está vazio.");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.exibirContatos();
        System.out.println("Adicionando contatos à agenda:");
        agendaContatos.adicionarContato("Maria", 1199884533);
        agendaContatos.adicionarContato("Maria", 1199884533);
        agendaContatos.adicionarContato("Maria", 1234342343);
        agendaContatos.adicionarContato("João", 1998484533);
        agendaContatos.adicionarContato("Pedro", 1199884533);
        agendaContatos.adicionarContato("Ana", 342231234);
        agendaContatos.exibirContatos();
        System.out.println();
        System.out.println("Pesquisa por nome 'Maria'");
        Set<Contato> resultadosPesquisa = agendaContatos.pesquisarPorNome("Maria");
        for (Contato contato : resultadosPesquisa) {
            System.out.println(contato);
        }
        System.out.println("Pesquisa por nome 'Marcos'");
        resultadosPesquisa = agendaContatos.pesquisarPorNome("Marcos");
        for (Contato contato : resultadosPesquisa) {
            System.out.println(contato);
        }
        System.out.println();
        System.out.println("Atualizando número por contato 'João'");
        Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("João", 234545667);
        if (contatoAtualizado != null) {
            System.out.println("Contato atualizado: " + contatoAtualizado);
        } else {
            System.out.println("Contato não encontrado.");
        }
        System.out.println("Contatos atualizados: ");
        agendaContatos.exibirContatos();
        contatoAtualizado = agendaContatos.atualizarNumeroContato("Beatriz", 234545667);
        if (contatoAtualizado != null) {
            System.out.println("Contato atualizado: " + contatoAtualizado);
        } else {
            System.out.println("Contato não encontrado.");
        }
        System.out.println("Contatos atualizados: ");
        agendaContatos.exibirContatos();

    }
}
