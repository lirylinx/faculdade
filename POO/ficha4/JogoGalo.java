
package ficha4;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *  Jogo do Galo
 * @author root
 */
public class JogoGalo {

    
    
    Vector<Integer> vetor = new Vector<Integer>();
    private Scanner input = new Scanner(System.in);
    public JogoGalo() {
        gerador_numero(10);
    }
    

    private void gerador_numero(int size) {
        int val;
        for(int i = 0; i < 7; i++) {            
            val = (int) (Math.random() * 9);
            this.vetor.add(val);
        }
    }
    
    private int gerador(int size) {
        return (int) (Math.random() * size);
    }
    
    
    public void printLista() {
        for(int i = 0; i < this.vetor.size(); i++) {
            System.out.print("| "+ this.vetor.get(i) );
        }
        System.out.println("  |");
    }

    public void exec() {
        System.out.println("LISTA DE NUMERO");
        int target = gerador(this.vetor.size());
        printLista();
        while(true) {
            System.out.print("GUESS\\> ");
            int escolhido = input.nextInt();
            if (this.vetor.get(target) == escolhido) {
                 System.out.printf("Parabens %d valor escolhido\n", escolhido);
                break;
            } else {
                 System.out.printf("Erro %d nao eh o escolhido\n", escolhido);                
            }
        }

    }

}
