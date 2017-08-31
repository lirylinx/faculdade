package hieraquia_ex2;

import java.util.Scanner;

/**
 *
 * @author root
 */
public abstract class ContaBancaria {
    int senha;
    int numero;
    double saldo;
    public ContaBancaria(int senha, double saldo) {
        this.senha = senha;
        this.saldo = saldo;
        init_conta();
    }

    public ContaBancaria(int senha) {
        this.senha = senha;
        init_conta();
    }

    
    public ContaBancaria() {
        init_conta();
    }
 
    private void init_conta() {
        for(int i = 0; i < 4; i++) {
            this.numero *= 10; 
            this.numero += Math.random() * 9;
        }
        this.saldo = 0.0;
    }

    /*  @Metodo saca e deposita
    *   @return 0: Sucesso
    *         -1: Algum erro
    */
    abstract int saca(double valor);
    abstract int deposita(double valor);
    abstract void tiraExtrato();
    
    private void alteraSenha(int nova_senha){
        Scanner input = new Scanner(System.in);
        System.out.print("Informe a senha actual");
        int old = input.nextInt();
        if (this.senha == old) {
            /* Enquanto nao confirmar a nova senha continuar a perguntar
                apos 3 tentativas terminar o loop
            */
            int confirm;
            do {
                System.out.print("Confirmar nova senha\n\\> ");
                confirm = input.nextInt();
                if (nova_senha == confirm) {
                    this.senha = nova_senha;
                    System.out.println("Senha Alterado com sucesso");
                    break;
                }
            } while(nova_senha != confirm);
        } else {
            System.out.println("Senha errado!!!");
        }
    }
}
