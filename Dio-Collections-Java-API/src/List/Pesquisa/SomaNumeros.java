package list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {

    private List<Integer> numeros = new ArrayList<>();

    public SomaNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }
    public void adicionarNumero(int numero){
        numeros.add(numero);
    }
    public int calcularSoma(List<Integer> numeros){
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }
    public int  encontrarMaiorNumero(List<Integer> numeros){
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia.");
        }

        int maior = numeros.get(0); // Assumimos que o primeiro número é o maior inicialmente

        for (int numero : numeros) {
            if (numero > maior) {
                maior = numero;
            }
        }

        return maior;
    }
    public int  encontrarMenorNumero(List<Integer> numeros){
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista está vazia.");
        }

        int menor = numeros.get(0);

        for (int numero : numeros) {
            if (numero < menor) {
                menor = numero;
            }
        }

        return menor;
    }

    public  void exibirTodosNumeros(List<Integer> numeros) {
        if (numeros.isEmpty()) {
            System.out.println("A lista está vazia.");
            return; // Não há números para exibir, então apenas saia da função
        }

        System.out.println("Números na lista: ");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        SomaNumeros numerosLista = new SomaNumeros(numeros);

        System.out.println("Adicionando números à lista: ");
        numerosLista.adicionarNumero(2);
        numerosLista.adicionarNumero(24);
        numerosLista.adicionarNumero(14);
        numerosLista.adicionarNumero(43);
        numerosLista.adicionarNumero(6);
        numerosLista.adicionarNumero(1);
        numerosLista.adicionarNumero(234);
        numerosLista.adicionarNumero(8);

        System.out.println(numeros);

        System.out.println();
        System.out.println("Somando os números da lista: ");

        int resultado = numerosLista.calcularSoma(numeros);
        System.out.println("A soma dos números na lista é: " + resultado);

        System.out.println();
        System.out.println("Buscando o maior número: ");

        int maiorNumero = numerosLista.encontrarMaiorNumero(numeros);
        System.out.println("O maior número na lista é: " + maiorNumero);

        System.out.println();
        System.out.println("Buscando o menor número: ");

        int menorNumero = numerosLista.encontrarMenorNumero(numeros);
        System.out.println("O menor número na lista é: " + menorNumero);

        System.out.println();
        System.out.println("Exibindo lista de números: ");

       numerosLista.exibirTodosNumeros(numeros);
    }

}
