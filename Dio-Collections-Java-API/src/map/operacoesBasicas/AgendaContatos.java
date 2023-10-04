package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos(Map<String, Integer> agendaContatosMap) {
        this.agendaContatosMap = new HashMap<>();
    }

    public AgendaContatos() {
    }

    public void adicionarContato(String nome, Integer telefone) {
        agendaContatosMap.put(nome, telefone);
    };

    public void removerContato(String nome) {
        if (!agendaContatosMap.isEmpty()) {
            agendaContatosMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatosMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatosMap.isEmpty()) {
            agendaContatosMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();
        agendaContatos.exibirContatos();
        System.out.println();
        System.out.println("Adicionando contatos na agenda");
        agendaContatos.adicionarContato("Camila", 444454444);
        agendaContatos.adicionarContato("Camila", 444453334);
        agendaContatos.adicionarContato("Sandra", 22222);
        agendaContatos.adicionarContato("Gustavo", 422454);
        agendaContatos.adicionarContato("Márcia", 444454444);
        agendaContatos.adicionarContato("Angela", 7777744);
        agendaContatos.exibirContatos();
        System.out.println();
        System.out.println("Removendo contato 'Camila'");
        agendaContatos.removerContato("Camila");
        agendaContatos.exibirContatos();
        System.out.println();
        System.out.println("Pesquisando pelo nome 'Sandra'");
        agendaContatos.pesquisarPorNome("Sandra");
        System.out.println("Número de 'Sandra': " + agendaContatos.pesquisarPorNome("Sandra"));

    }

}
