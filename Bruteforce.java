// Trabalho 2 - Divisão e Conquista
// Problema da Maior Subsequência Crescente Contígua
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 18/11/2023

import java.util.ArrayList;

public class Bruteforce {

    // método principal de chamada
    public void call(int[] entrada) {
        ArrayList<Integer> saida = new ArrayList<Integer>();
        encontraMaiorSubsequencia(entrada, saida);
        System.out.println("Subsequencia(BF): " + saida);
        System.out.println("Tamanho da maior subsequencia(BF): "  + saida.size());
    }

    // método força bruta
    public static void encontraMaiorSubsequencia(int[] entrada, ArrayList<Integer> saida) {
        // array que salva a maior subsequência atual
        ArrayList<Integer> maiorAtual = new ArrayList<Integer>();
        int temp = 0;
        
        // itera sobre o vetor de entrada
        for (int i = 0; i < entrada.length; i++) {
            // itera sobre o vetor de entrada a partir do elemento atual
            for (int j = i; j < entrada.length - 1; j++) {
                temp = entrada[j + 1];
                // se o elemento atual for menor que o próximo, adiciona ao array
                if (entrada[j] < temp) {
                    maiorAtual.add(entrada[j]);
                } 
                // se não, adiciona o elemento atual e quebra o loop
                else {
                    temp = entrada[j];
                    break; 
                }
            }
            // adiciona o último elemento do array
            maiorAtual.add(temp);
            // se o array atual for maior que o array de saída, substitui
            if (maiorAtual.size() > saida.size()) {
                saida.clear();
                saida.addAll(maiorAtual);
            }
            maiorAtual.clear();
        }
    }
}