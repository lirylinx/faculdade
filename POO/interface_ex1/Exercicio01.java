package interface_ex1;

import java.util.Scanner;

/**
 *
 * @author estudante
 */
public class Exercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lampada: 1 - Fluorescente");
        System.out.println("Lampada: 2 - Incadescente");
        System.out.print("\\> ");
        int value = input.nextInt();
        if (value == 1) {
            FabricaLampada f = new FabricaLampada();
            Fluorescente flu = (Fluorescente) f.construir("fluorescente");
            flu.ligar();
            flu.desligar();
        } else if (value == 2) {
            FabricaLampada f = new FabricaLampada();
            Incadescente flu = (Incadescente) f.construir("incadescente");
            flu.ligar();
            flu.desligar();
        }

    }
    
}
