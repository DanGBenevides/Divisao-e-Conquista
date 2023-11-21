// Trabalho 2 - Divisão e Conquista
// Problema da Maior Subsequência Crescente Contígua
// Alunos: Arthur Santiago Loschi Ruiz e Daniel Gomes Benevides
// Professor: Daniel Capanema
// Disciplina: Projeto e Análise de Algoritmos
// Última modificação: 20/11/2023

import java.util.ArrayList;

public class DivisaoEConquista {

    // arrays auxiliares
    static ArrayList<Integer> Se = new ArrayList<Integer>();
    static ArrayList<Integer> Sd = new ArrayList<Integer>();

    // método principal de chamada
    public void call(int[] entrada) {
        ArrayList<Integer> saida = new ArrayList<Integer>();
        encontraMaiorSubsequencia(entrada, saida);

        System.out.println("Subsequencia(DC): " + saida);
        System.out.println("Tamanho da maior subsequencia(DC): " + saida.size());
    }

    // método de chamada recursiva
    public static void encontraMaiorSubsequencia(int[] entrada, ArrayList<Integer> saida) {
        encontraMaiorSubsequenciaDAC(entrada, 0, entrada.length - 1, saida);
    }

    // método recursivo de divisão e conquista
    public static ArrayList<Integer> encontraMaiorSubsequenciaDAC(int[] entrada, int inicio, int fim,
            ArrayList<Integer> saida) {

        // caso base (vetor de tamanho 1)
        if (inicio == fim) {
            saida.clear();
            saida.add(entrada[inicio]);
            return saida;
        }

        int meio = (inicio + fim) / 2;

        // chamada recursiva para a esquerda e direita
        ArrayList<Integer> saidaEsquerda = new ArrayList<Integer>();
        ArrayList<Integer> saidaDireita = new ArrayList<Integer>();
        saidaEsquerda = encontraMaiorSubsequenciaDAC(entrada, inicio, meio, saidaEsquerda);
        saidaDireita = encontraMaiorSubsequenciaDAC(entrada, meio + 1, fim, saidaDireita);

        // junção das saídas
        if (saidaEsquerda.size() > 0 && saidaDireita.size() > 0) {
            int ultEsq = saidaEsquerda.get(saidaEsquerda.size() - 1);
            int primDir = saidaDireita.get(0);

            if (ultEsq < primDir) {
                saida.clear();
                saida.addAll(saidaEsquerda);
                saida.addAll(saidaDireita);
            } else {
                if (Sd.size() > 0) {
                    int SdUlt = Sd.get(Sd.size() - 1);
                    if (SdUlt < primDir) {
                        Sd.clear();
                        Sd.add(SdUlt);
                        Sd.addAll(saidaDireita);
                        saidaDireita.clear();
                        saidaDireita.addAll(Sd);
                    }
                }
                Sd.clear();

                if (Se.size() > 0) {
                    int SePrim = Se.get(0);
                    if (SePrim > ultEsq) {
                        saidaEsquerda.add(SePrim);
                    }
                }
                Se.clear();

                if (saidaEsquerda.size() > saidaDireita.size()) {
                    Sd.addAll(saidaDireita);
                    Se.addAll(saidaEsquerda);
                    saida.clear();
                    saida.addAll(saidaEsquerda);
                } else {
                    saida.clear();
                    saida.addAll(saidaDireita);
                }
            }
        }
        return saida;
    }
}