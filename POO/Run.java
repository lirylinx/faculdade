/**
 * Teste de Resolucao de todos exercicios da ficha 4
 * 
 * @author root --- Dercio Geraldo Comiche Guirruta
 */
package ficha4;

import java.util.Scanner;
import java.util.Vector;

/**
 *  Executando todos trabalhos da ficha
 * @author root
 */
public class Run {
    

    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        run_all();
    }

    /**
     * Interface com o usuario 
     * 
     */
   public static void run_all() {
        int opt = -1;
        do {            
            menu();
            System.out.print("input\\> ");
            opt = input.nextInt();
            
            switch(opt) {
                case 1:
                    teste_estatistica();
                    break;
                case 2:
                    teste_jogoGalo();
                    break;
                case 3:
                    teste_realJogoGalo();
                    break;
                case 4:
                    teste_turma();
                    break;
                case 5:
                    testeCompararBool();
                case 6:
                    teste_ordenar();
                    break;                    

                default:
                    opt = -1;
            }
        } while (opt != -1);
    }
    public static void menu() 
    {
        System.out.println("\t\t*** Testes de Exercicos Ficha 4 ***\n\n");
        System.out.println("1 - Estatistica --- Moda - Mediana - Media");
        System.out.println("2 - Jogo do Galo --- Advinhar um numero sorteado");
        System.out.println("3 - Jogo do Galo  --- Jogo da Velha");
        System.out.println("4 - Media e Numero estudante --- Exibir estudantes e as respectivas medias e o(s) melhor(es) aluno(s)");
        System.out.println("5 - Comparar dois vetores --- Se possuem mesmo tamanho e mesmos elementos");
        System.out.println("6 - Ordenar vetor --- Loop  Removendo o maior valor de uma lista e colocar em uma nova lista");
        System.out.println("7 - Sair\n\n");

    }
    
    /**
     * Teste para exercicio 1
     */
    public static void teste_estatistica()
    {    

        int[] lista = new int[]{1,  1, 5, 6, 10, 5, 3, 9, 5, 6, 4, 51,1, 14, 3, 1, 23, 6, 7, 6, 21, 6, 4, 4};
//        int[] lista = new int[] {20, 20, 20};
        int moda = MatematicaEx1.Estatistica.moda(lista);
        
        int media = MatematicaEx1.Estatistica.media(lista);
        int mediana = MatematicaEx1.Estatistica.mediana(lista);
        System.out.println("Moda: " + moda);
        System.out.println("Media: " + media);
        System.out.println("Mediana: " + mediana);
    }
    
    /**
     * Teste para exercicio 2
     * Jogo do Galo
     */
    public static void teste_jogoGalo()
    {
        JogoGalo jogo = new JogoGalo();
        jogo.exec();
        
    }
    
    public static void teste_realJogoGalo()
    {
        realJogoGalo galo = new realJogoGalo();
        galo.play();
        
    }
    
    /**
     * Teste para exercicio 2
     * Comparar dois vetores em termos de tamanho e se possuem os mesmos elementos
     * em cada posicao
     */
    public static void testeCompararBool() {
        int max = 11;
        Vector<Integer> lista1 = new Vector<Integer>(max);
        Vector<Integer> lista2 = new Vector<Integer>(max);
        for (int i = 0; i < max; i++) {
            lista1.add(gerador_numero());
            lista2.add(gerador_numero());
        }

//        for (int i = 0; i < max-1; i++) {
//            lista1.add(gerador_numero());
//            lista2.add(gerador_numero());
//        }
        
        CompararVetores compVetor = new CompararVetores();
        System.out.print("Lista 1: ");
        printLista(lista1);
        System.out.print("Lista 2: ");
        printLista(lista2);

        int rv= compVetor.compare(lista1, lista2);
        if (rv == 0) 
            System.out.println("\nIguais");
        else
            System.out.print("\nDiferentes ");
            if (rv == -1) 
                System.out.println("no tamanho");
            else
                 System.out.println("nos elementos");
        
    }
    /**
     * Teste para exercicio 3
     * Contagem e calculo de media de estudantes 
     */
    public static  void teste_turma()
    {
        UemDmiEx3 uem = new UemDmiEx3();
        uem.registar();
        uem.Turmas.get(0).printEstudantes();
        uem.Turmas.get(0).showEstudanteMelhorMedia();        
    }


    /**
     *  Teste para exercicio 5
     *  Ordenar valores inteiros um vetor para outro
     *  vetor na ordem decrescente
     */
    public static void teste_ordenar()
    {
       int max = 11;
        Vector<Integer> desordenado = new Vector<Integer>(max);
        for (int i = 0; i < max; i++) {
            desordenado.add(gerador_numero());
        }
        OrdenarEx5 ordenar = new OrdenarEx5();
        ordenar.sort(desordenado);        
    }

    
    public static int gerador_numero() {
            return (int)  (1 + Math.random() * 9);
    }

    public static void printLista(int[] lista) {
        for (int elem: lista)
            System.out.print("|" + elem +"");
        System.out.println("|");
    }

    private static void printLista(Vector<Integer> lista) {
        for (int elem: lista)
            System.out.print("|" + elem +"");
        System.out.println("|");
    }

}
