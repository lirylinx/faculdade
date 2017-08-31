package hieraquia_ex2;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Teste {
    Object[] lista_conta;
    Scanner input = new Scanner(System.in);
    public void criar_conta() {
        System.out.println("Quantas contas vai criar ?");
        int num_conta =  input.nextInt();
        if (num_conta < 1) 
            num_conta = 1;
        Object [] contas =  new Object[num_conta];
        for (int i = 0; i < num_conta; i++) {
            System.out.println("Selecione a opcao\n1-Conta Corrente\n"
                    + "2-Conta Poupanca ?");
            int opcao = input.nextInt();
            if (opcao < 1 || opcao > 2) 
                opcao = 1;
            System.out.println("Informe a senha\n");
            int senha = input.nextInt();
            ContaBancaria conta = null;     
            if (opcao == 1) {
                conta = new ContaCorrente(senha);
            } else if (opcao == 2) {
                conta = new ContaPoupanca(senha);
            }
            contas[i] = conta;
        }
        
        this.lista_conta = contas;
    }

    /* procurar por um numero de conta na lista de contas criadas */
    private ContaBancaria findConta(int numero){
        for (int i = 0; i < this.lista_conta.length; i++) {
            if (this.convertAndCompare(lista_conta[i], numero)) {
                ContaBancaria conta  = (ContaBancaria) lista_conta[i];
                return conta;
            }            
        }        
        
        return null;
    }
    
    private boolean convertAndCompare(Object obj, int numero) {
        if (obj instanceof ContaBancaria) {
            ContaBancaria conta  = (ContaBancaria) obj;
            if (conta.numero == numero)
                return true;
        }
        return false;
    }
    private void login() {
        System.out.println("\t\tBANCO POO");
        System.out.print("\tConta Num: ");
        int num = input.nextInt();        
        ContaBancaria conta;
        if ((conta = findConta(num)) != null) {
            System.out.println("\tSenha");
            int senha = input.nextInt();
            if (conta.senha == senha) {
                showDeposito(conta);
            }
            
        } 
        
    }
    private void showlevantamento(ContaBancaria conta) {
        System.out.println("\t\tBANCO POO");
        System.out.println("\t1 - 200.00");
        System.out.println("\t2 - 500.00");
        System.out.println("\t3 - 1.000.00");
        System.out.println("\t4 - 5.000.00");        
        System.out.println("\t5 - Outros Montantes");
        int opt = input.nextInt();
        switch(opt) {
            case 1: this.testeLevantamento(conta, 200.0);
            case 2: this.testeLevantamento(conta, 500.0);
            case 3: this.testeLevantamento(conta, 1000.0);
            case 4: this.testeLevantamento(conta, 5000.0);
            case 5: 
                System.out.print("Valor\\> ");
                Double valor = input.nextDouble();                
                conta.saca(valor);
            default: break;

        }
    }

        private void showDeposito(ContaBancaria conta) {
        System.out.println("\t\tDEPOSITO\n");
        System.out.print("\tDEPOSITANDO\\> ");
        Double valor = input.nextDouble();
        this.showmenu();
    }

    
    
    private void showmenu() {
        System.out.println("\t\tBANCO POO");
        System.out.println("\t\t1 - LEVANTAMENTO");
        System.out.println("\t\t2 - DEPOSITO");
        System.out.println("\t\t3 - EXTRATO");
        System.out.println("\t\t4 - ALTERAR SENHA");        
    }
    public void menu(){
        this.login();
    }
    
    public void listar(){
        // flag para o fim da lista
        for (int i = 0; i < this.lista_conta.length; i++) {
            testeExtrato((ContaBancaria)this.lista_conta[i]);
        }
    }
    public void testeDeposita(ContaBancaria conta, Double valor) {
        conta.deposita(valor);
    }

    public void testeLevantamento(ContaBancaria conta, Double valor) {
        conta.saca(valor);
    }
    public void testeExtrato(ContaBancaria conta) {
        conta.tiraExtrato();
    }
    
}
