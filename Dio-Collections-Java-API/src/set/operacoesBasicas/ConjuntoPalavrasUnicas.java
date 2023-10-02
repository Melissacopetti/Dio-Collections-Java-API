package set.operacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavras;

    public ConjuntoPalavrasUnicas(Set<String> palavras) {
        this.palavras = palavras;
    }

    public Set<String> getPalavras() {
        return palavras;
    }

    public void adicionarPalavra(String palavra) {
        palavras.add(palavra);
    }

    public void removerPalavra(String palavra) {
        palavras.remove(palavra);
    }

    public boolean verificarPalavra(String palavra) {
        return palavras.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavras);
    }

    public static void main(String[] args) {
        Set<String> conjuntoPalavras = new HashSet<>();
        ConjuntoPalavrasUnicas conjunto = new ConjuntoPalavrasUnicas(conjuntoPalavras);

        System.out.println("Adicionando palavras ao conjunto Set:");
        conjunto.adicionarPalavra("maçã");
        conjunto.adicionarPalavra("banana");
        conjunto.adicionarPalavra("cenoura");
        conjunto.adicionarPalavra("cenoura");
        conjunto.adicionarPalavra("uva");
        System.out.println();
        System.out.println("Palavras no conjunto:");
        conjunto.exibirPalavrasUnicas();
        System.out.println();
        boolean encontrada = conjunto.verificarPalavra("banana");
        System.out.println("A palavra 'banana' foi encontrada? " + encontrada);
        encontrada = conjunto.verificarPalavra("cenoura");
        System.out.println("A palavra 'cenoura' foi encontrada? " + encontrada);
        encontrada = conjunto.verificarPalavra("repolho");
        System.out.println("A palavra 'repolho' foi encontrada? " + encontrada);
        System.out.println();
        System.out.println("Removendo palavra 'maçã'");
        conjunto.removerPalavra("maçã");
        System.out.println();
        System.out.println("Palavras no conjunto após a remoção:");
        conjunto.exibirPalavrasUnicas();
    }

}


