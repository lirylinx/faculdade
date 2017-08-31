package hieraquia_ex2;

/**
 *
 * @author root
 */
public class ContaCorrente extends ContaBancaria{
    /* Toda informacao sobre conta bancaria */
    int quantidade_transacoes = 0;

    public ContaCorrente( int senha) {
        super(senha);
    }

    public ContaCorrente() {
    }


    @Override
    int saca(double valor) {        
        if (this.saldo > valor) {
            this.saldo -= valor;
            this.quantidade_transacoes += 1;
            return 0;
        }        
        System.out.println("Saldo indisponivel!");
        return -1;
    }

    @Override
    int deposita(double valor) {
        if (valor > 0) {
            this.saldo = valor;
            return 0;
        }
        
        return -1;
    }

    @Override
    void tiraExtrato() {
        System.out.println("\t\tEXTRACTO");
        System.out.println("\t\tConta Corrente\n");
        System.out.printf("CONTA NR: %d\n"
                + "SALDO: %f\n"
                + "Qtd Transacao: %d\n\n\n", this.numero, this.saldo, this.get_transacao());

    }
    
    
    public int get_transacao(){
        return this.quantidade_transacoes;
    }
    

}
