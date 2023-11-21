// Trabalho 2 - Divisão e Conquista
// Problema da Maior Subsequência Crescente Contígua
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 20/11/2023

public class tp2 {
    public static void main(String[] args) {
        Bruteforce bf = new Bruteforce();
        DivisaoEConquista dv = new DivisaoEConquista();
        int[] entrada = { 13, 24, 15, 6, 9, 5, 12, 3, 14, 16, 0, 8, 7, 2, 1, 11, 10, 17, 19, 4, 18, 20, 21, 23, 25};

        System.out.println("Força Bruta:");
        long startingBF = System.nanoTime();
        bf.call(entrada);
        long endingBF = System.nanoTime();
        System.out.println("Tempo decorrido: " + (endingBF - startingBF) / 1000000.0 + "ms");
        
        System.out.println();
        System.out.println("Divisão e Conquista:");
        long startingDV = System.nanoTime();
        dv.call(entrada);
        long endingDV = System.nanoTime();
        System.out.println("Tempo decorrido: " + (endingDV - startingDV) / 1000000.0 + "ms");
    }
}
