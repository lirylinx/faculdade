package ficha4;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import pesquisa.Pesquisas;
import recursividade.Recursividade;
/**
 * classe Matematica contendo colecoes de funcoes matematicas aplicada 
 * em diversas areas
 * @author root
 */

/**
 * classe MatematicaEx1 contendo colecoes de funcoes matematicas aplicada 
 em diversas areas
 * @author root
 */
public class MatematicaEx1 {

    
    public static void printLista(int[] lista) {
            for (int elem: lista)
                System.out.print("|" + elem +"");
            System.out.println("|");
    }
    
    /**
     * Classe estatica Estatisca 
     * metodos para resolucoes de alguns problemas na area de estatistica
     */

    static class Estatistica {
        
//        int[] lista = new int[]{10, 5, 9, 5, 6, 4, 5, 14};
        static Pesquisas pesquisa ;

        public Estatistica() {
        }
        
        
        /**
         * Verificar moda ou item com maior ocorrencia
         * @param vetor - lista de valores inteiros
         * @var Pesquisa pesquisa - Emprestado dos trabalho de EDA (reutilizacao de codigo)
         * @return moda - moda da lista de inteiros
         */

        public static int moda(int[] vetor) {
            pesquisa = new Pesquisas(vetor);
            
            int tamanho = vetor.length;
            int moda = 0;
            int count = 0;
            
            for(int i = 0; i < tamanho-2; i++) {                
                if (count < pesquisa.encontrarMaiorOcorrencia(vetor[i])) {
                    count =  pesquisa.encontrarMaiorOcorrencia(vetor[i]);
                    // System.out.printf("[DBG] Pos: %d -- cout: %d \n", i, count);
                    moda = vetor[i]; // valor de maior ocorrencia na lista
                }
            }
            return moda;
        }
        
        /**
         * Calcular a media da soma de todos os valores inteiros da lista
         * @param vetor - lista de valores inteiros
         * @return media - media da soma dos valores
         */
        public static int media(int[] vetor) {
            int media = 0;
            int size = vetor.length;
            Recursividade recursividade = new Recursividade();
            media = recursividade.somarVetor(vetor)/size;
            return media;
        }
        
        public static ArrayList arrayAsList(int[] vetor) {
            int size = vetor.length;
            ArrayList lista = new ArrayList(size);
            for (int elem: vetor)
                lista.add(elem);

            return lista;
        }
        
        public static int mediana(int[] vetor) {
            int mediana = 0;
            int pos = -1;
            int size = vetor.length;
            if (size % 2 == 0) {
//                 pos = ((size/2) + (size/2 - 1))/ 2;
                mediana = vetor[size/2] + vetor[size/2 - 1] / 2;
            } else {
                mediana = vetor[mediana];
//                System.out.println("ImPar");
            }
            return mediana;
        }
        
        

        
        
        
    }
}
