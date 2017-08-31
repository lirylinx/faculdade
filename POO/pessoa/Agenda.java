
package pessoa;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *  Classe Agenda contendo uma lista (array) de Objectos Pessoa 
 contendo Tres atributos para controlar a quantidade de qtd_amigo, conhecidos
 e quantidade total de items a armazenar
 * @author root
 */
public class Agenda {
    public int MAX_SIZE;
    public Pessoa[] agenda;
    public int qtd_amigo;
    public int qtd_conhecido;
    private Scanner input = new Scanner(System.in);

    private int opt;
        
    
    /**
     * Construtor Agenda Inicializando a quantidade limite 
 de itens na Agenda  e preencher com objectos pessoa
 Usando o metodo Math.random, criar objecto qtd_amigo e qtd_conhecido
 dependendo do valor de retorna do metodo random()
     * @param MAX_SIZE 
     */
    public Agenda(int MAX_SIZE) {
        qtd_conhecido = qtd_amigo = 0;
        this.MAX_SIZE = MAX_SIZE;
        this.agenda = new Pessoa[this.MAX_SIZE];
        for (int i = 0; i < this.MAX_SIZE; i++) {
            opt = 1 + (int) (Math.random() * 2);
            if (opt == 1) {
//                Conhecido obj = new Conhecido();
//                Amigo obj = ;
                this.agenda[i] = new Amigo();
                qtd_amigo += 1;
            } else {                
                this.agenda[i] = new Conhecido();
                qtd_conhecido += 1;
            }
        }        
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public void setMAX_SIZE(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    
    public Pessoa[] getAgenda() {
        return agenda;
    }

    public void setAgenda(Pessoa[] agenda) {
        this.agenda = agenda;
    }

    public int getQtd_amigo() {
        return qtd_amigo;
    }

    public void setQtd_amigo(int qtd_amigo) {
        this.qtd_amigo = qtd_amigo;
    }

    public int getQtd_conhecido() {
        return qtd_conhecido;
    }

    public void setQtd_conhecido(int qtd_conhecido) {
        this.qtd_conhecido = qtd_conhecido;
    }

    
    /**
     * Adicionar informacoes a todos objectos da lista pessoa via teclado.
     * dependendo do objecto actual (adicionar informacoes 
     * inerente a essa classe) no loop for
     */
    
    SimpleDateFormat sdl = new SimpleDateFormat();
    public void addInformacoes() {
        for (int i = 0; i < this.MAX_SIZE; i++) {            
            Pessoa obj = this.agenda[i];
            if (obj instanceof Amigo)
                System.out.println("\nAmigo\n");
            else
                System.out.println("\nConhecido\n");
                
            
            System.out.print("Nome: ");
            String nome = input.next();
            
            System.out.print("Idade: ");
            int idade = input.nextInt();

            obj.setNome(nome);
            obj.setIdade(idade);

            if (obj instanceof Amigo) {
                System.out.println("Data aniversario: DD/MM/AAAA");
                String datafrmt = input.next();                        
                Amigo amigo = (Amigo) obj;
//                amigo.setData_aniversario(datafrmt);
            } else if (obj instanceof Conhecido) {
                System.out.print("Email: ");
                String email = input.next();                        
                Conhecido conhec = (Conhecido) obj;
                conhec.setEmail(email);
            }
        }
    }
    
    /**
     * Imprimir informacoes da data de aniversario de todos objectos amigo
     * da lista pessoa
     */
    public void imprimiAniversarios() {
        for (int i = 0; i < this.MAX_SIZE; i++) {
            Pessoa obj = this.agenda[i];
            if (obj instanceof Amigo) {
                Amigo amigo = (Amigo) obj;                
                System.out.println("Nome: " + amigo.getNome());
                System.out.println("Data aniversario: " + amigo.getData_aniversario());
            }
        }
        
    }
    
    /**
     *  Imprimir emails de todos objectos Conhecido da lista Pessoa
     */
    public void imprimiEmail() {
        for (int i = 0; i < this.MAX_SIZE; i++) {
            Pessoa obj = this.agenda[i];
            if (obj instanceof Amigo) {
                Conhecido conhecido = (Conhecido) obj;                
                System.out.println("Nome: " + conhecido.getNome());
                System.out.println("Email: " + conhecido.getEmail());
            }
        }
        
    }
    
    public void imprimi() {
        for (int i = 0; i < this.MAX_SIZE; i++) {
            System.out.println("Nome: " + this.agenda[i].getNome());
            System.out.println("Idade: " + this.agenda[i].getIdade());
            System.out.println("-----------------------------------");
        }
        
    }


}
