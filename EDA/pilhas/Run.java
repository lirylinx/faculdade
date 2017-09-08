package pilhas;


import java.util.Scanner;
/**
 *
 * @author root
 */
public class Run {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("CONVERTER\\> ");
        int val = input.nextInt();

        ToBinario bin = new ToBinario();
        
        bin.dec_to_bin(val);
//        System.out.println("Convertendo " + val);
        bin.binario.imprimi();
    }
    
    
    
    public static void test_pilha()
    {
//        VetorPilha pilha = new VetorPilha(10);
//        ArrayPilha pilha = new ArrayPilha(10);
        ArrayListPilha pilha = new ArrayListPilha(10);
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        pilha.push(4);
        pilha.push(5);
        pilha.push(6);
        pilha.push(7);
        pilha.push(8);
        pilha.push(9);
        pilha.push(10);
        pilha.push(11);
        pilha.push(12);
        pilha.push(13);
        pilha.push(14);
        pilha.push(15);
        pilha.push(16);
        pilha.push(17);
        pilha.push(18);

        pilha.imprimi();
        
        System.out.println(pilha.peek());
        System.out.println(pilha.search(11));
        System.out.println(pilha.pop());
        pilha.imprimi();
        
    }
    
    
}
