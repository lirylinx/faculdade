/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisa;

/**
 *
 * @author root
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] lista = new int[]{10, 5, 9, 5, 6, 4, 5, 14};
        Pesquisas pesquisa = new Pesquisas(lista);
        int key = 5;
        int found; 
//        found = pesquisa.sequencialRecursivo(key, 0);
//        found = pesquisa.sequencial(key);
//        int last = pesquisa.lista.length - 1;
//        found = pesquisa.binariaRecursivo(key, 0, last);
//        found = pesquisa.binaria(key);
//        found = pesquisa.sequencialSentinela(key);
        pesquisa.encontrarOcorrencia(key);
//        System.out.printf("chave %d encontrado aqui %d", key, found);
        
        
        
        
        /* Exercicio 3 - pesquisa binaria*/
//        int[] lista2 = new int[]{5, 8, 10, 11, 13, 20, 25, 28, 30, 40};
//        pesquisa.setLista(lista2);
//        pesquisa.printLista();
//        key = 30;
//        found = pesquisa.binaria(key);
//        System.out.printf("chave %d encontrado aqui %d --> Binario normal\n\n", key, found);
//        int last = pesquisa.lista.length - 1;
//        found = pesquisa.binariaRecursivo(key, 0, last);
//        System.out.printf("chave %d encontrado aqui %d --> Binario recursivo\n\n", key, found);
//
//        int[] lista3 = new int[]{3, 5, 8, 11, 15, 28, 30, 36};
//        pesquisa.setLista(lista3);
//        pesquisa.printLista();
//        key = 8;
//        found = pesquisa.binaria(key);
//        System.out.printf("chave %d encontrado aqui %d --> Binario normal\n\n", key, found);
//        last = pesquisa.lista.length - 1;
//        found = pesquisa.binariaRecursivo(key, 0, last);
//        System.out.printf("chave %d encontrado aqui %d --> Binario recursivo \n\n", key, found);
//
//        int[] lista4 = new int[]{4, 6, 15, 17, 19, 21, 25, 28, 35, 40};
//        pesquisa.setLista(lista4);
//        pesquisa.printLista();
//        key = 6;
//        found = pesquisa.binaria(key);
//        System.out.printf("chave %d encontrado aqui %d  --> Binario normal\n\n", key, found);
//        last = pesquisa.lista.length - 1;
//        found = pesquisa.binariaRecursivo(key, 0, last);
//        System.out.printf("chave %d encontrado aqui %d --> Binario recursivo\n\n", key, found);
//
//        int[] lista5 = new int[]{4, 5, 10, 17, 19, 20};
//        pesquisa.setLista(lista5);
//        pesquisa.printLista();
//        key = 19;
//        found = pesquisa.binaria(key);
//        System.out.printf("chave %d encontrado aqui %d --> Binario normal\n\n", key, found);
//        last = pesquisa.lista.length - 1;
//        found = pesquisa.binariaRecursivo(key, 0, last);
//        System.out.printf("chave %d encontrado aqui %d --> Binario recursivo\n\n", key, found);
//        
        
        
    }
    
}
