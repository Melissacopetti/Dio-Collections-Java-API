package map.pesquisa;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    private Map<String, Integer> adicioarPalavraMap;

    public ContagemPalavras(Map<String, Integer> adicioarPalavraMap) {
        this.adicioarPalavraMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        adicioarPalavraMap.put(palavra, contagem);
    };

    public void removerPalavra(String palavra) {
        if (!adicioarPalavraMap.isEmpty()) {
            adicioarPalavraMap.remove(palavra);
        }
    }

    public int exibirContagemPalavras() {
        int totalContagem = 0;
        for (Integer contagem : adicioarPalavraMap.values()) {
            totalContagem += contagem;
        }
        return totalContagem;
    }

    public String encontrarPalavraMaisFrequente() {
        String palavraMaisFrequente = null;
        int maiorContagem = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : adicioarPalavraMap.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }

        return palavraMaisFrequente;
    }

    public void exibirPalavras() {
        for (Map.Entry<String, Integer> entry : adicioarPalavraMap.entrySet()) {
            String palavra = entry.getKey();
            Integer contagem = entry.getValue();
            System.out.println("Palavra: " + palavra + ", Contagem: " + contagem);
        }
    }

    public static void main(String[] args) {

        Map<String, Integer> mapaPalavras = new HashMap<>();

        ContagemPalavras contagemPalavras = new ContagemPalavras(mapaPalavras);

        System.out.println("Adicionando palavra: ");
        contagemPalavras.adicionarPalavra("caixa", 1);
        contagemPalavras.adicionarPalavra("flor", 3);
        contagemPalavras.adicionarPalavra("caixa", 4);
        contagemPalavras.adicionarPalavra("flor", 6);
        contagemPalavras.adicionarPalavra("abacaxi", 1);
        contagemPalavras.adicionarPalavra("estrela", 5);
        contagemPalavras.adicionarPalavra("caixa", 2);

        contagemPalavras.exibirPalavras();
        System.out.println("Contagem de palavras: " + contagemPalavras.exibirContagemPalavras());
        System.out.println();

        contagemPalavras.removerPalavra("estrela");
        System.out.println("Palavra 'estrela' removida.");
        contagemPalavras.exibirPalavras();

        System.out.println();
        String palavraMaisFrequente = contagemPalavras.encontrarPalavraMaisFrequente();
        System.out.println("Palavra mais frequente: " + palavraMaisFrequente);
    }

}
