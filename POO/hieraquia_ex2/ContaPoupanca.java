
package hieraquia_ex2;

/**
 *
 * @author root
 */
public class ContaPoupanca extends ContaBancaria{
    /* Toda informacao sobre a conta poupanca */
    Double taxa_rendimento;

    public ContaPoupanca(Double taxa_rendimento, int senha, double saldo) {
        super(senha, saldo);
        this.taxa_rendimento = taxa_rendimento;
    }

    public ContaPoupanca(Double taxa_rendimento, int senha) {
        super(senha);
        this.taxa_rendimento = taxa_rendimento;
    }

    public ContaPoupanca(int senha) {
        super(senha);
        this.taxa_rendimento = 0.0;
    }


    public ContaPoupanca() {
    }

    
    @Override
    int saca(double valor) {        
        if (this.saldo > valor) {
            this.saldo -= valor;
            return 0;
        }        
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
        System.out.println("\t\t\tEXTRACTO\n\n");
        System.out.println("\t\t\tConta Corrente");
        System.out.printf("\tCONTA NR: %d\n"
                + "SALDO: %f\n"
                + "TAXA RENDIMENTO: %f\n", this.numero, this.saldo, this.getTaxa_rendimento());

    }

    public Double getTaxa_rendimento() {
        return taxa_rendimento;
    }
    

    
}
