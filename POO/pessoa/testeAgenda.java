package pessoa;

import java.util.Scanner;

/**
 *  Classe testeAgenda Testar o objecto Agenda. Informar quantidade
 * de objectos a gravar em uma lista, preencher os atributos de todos objectos
 * juntamente com atributos exclusivos a certas classe derivada da classe Pessoa
 * 
 *  * @author root
 */
public class testeAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int qtd;
        System.out.println("Quantos contactos a gravar ?");
         qtd = input.nextInt();
        Agenda agenda = new Agenda(qtd);
        System.out.println("Amigos: " + agenda.getQtd_amigo());
        System.out.println("Conhecidos: " + agenda.getQtd_conhecido());
        
        agenda.addInformacoes();
   
//         Se tiver pelo menos um amigo na agenda imprimi seu aniversario
        if (agenda.getQtd_amigo() > 0){
            agenda.imprimiAniversarios();
        } 
//        Se tiver pelo menos um conhecido entao imprimi o seu email
        if (agenda.getQtd_conhecido() > 0){
            agenda.imprimiEmail();
        }
    
        agenda.imprimi();        

    }
    
}
