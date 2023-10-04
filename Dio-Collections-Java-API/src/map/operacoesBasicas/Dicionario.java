package map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> dicionarioMap;

    public Dicionario(Map<String, String> dicionarioMap) {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras() {
        for (Map.Entry<String, String> entry : dicionarioMap.entrySet()) {
            String palavra = entry.getKey();
            String definicao = entry.getValue();
            System.out.println("Palavra: " + palavra + ", Definição: " + definicao);
        }
    }

    public String pesquisarPorPalavra(String palavra) {
        if (!dicionarioMap.isEmpty()) {
            return dicionarioMap.get(palavra);
        }
        return null;
    }

    public static void main(String[] args) {
        Map<String, String> palavrasDicionario = new HashMap<>();
        Dicionario dicionario = new Dicionario(palavrasDicionario);
        System.out.println("Adicionando palavras ao dicionário");
        dicionario.adicionarPalavra("maçaneta",
                "remate feito de materiais diversos, de formato esférico, mas também cônico ou piramidal, em barras verticais de sacadas, cabeceiras e camas");
        dicionario.adicionarPalavra("maçaneta",
                "aparelho elético composto de um recipiente com uma hélice de pás cortantes no fundo, a qual se aciona para triturar ou mistirar frutas, legumes, etc");
        dicionario.adicionarPalavra("liquidificador",
                "remate feito de materiais diversos, de formato esférico, mas também cônico ou piramidal, em barras verticais de sacadas, cabeceiras e camas");
        dicionario.adicionarPalavra("pirulito",
                "qualquer bala, chocolate ou torrão doce enfiado num palito, que se come sugando");
        dicionario.adicionarPalavra("pirulito",
                "qualquer bala, chocolate ou torrão doce enfiado num palito, que se come sugando");
        dicionario.adicionarPalavra("lanterna",
                "construção cilíndrica prismática que constitui a parte superior de uma cúpula, de um zimbório");
        System.out.println("Palavras com suas definições: ");
        dicionario.exibirPalavras();
        System.out.println();
        System.out.println("Excluindo palavra 'maçaneta");
        dicionario.removerPalavra("maçaneta'");
        dicionario.exibirPalavras();
        System.out.println();
        System.out.println("Pesquisar por palavra 'pirulito'");
        String palavraPesquisada = dicionario.pesquisarPorPalavra("pirulito");
        System.out.println(palavraPesquisada);
        System.out.println();
        dicionario.exibirPalavras();
    }

}