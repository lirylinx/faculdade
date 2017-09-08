
package teste;

import java.io.Serializable;

/**
 *
 * @author root
 */
public abstract class SimCard implements Serializable{
    public int numero;
    public String operadora;
    double saldo;
    
    public SimCard() {

    }
    public SimCard(int numero, double saldo, String operadora){

      this.saldo = saldo;
      if (saldo > 0)
        this.saldo = saldo;
      else
        this.saldo = 0.0;
      this.numero = numero;
      this.operadora = operadora;
    }

    public SimCard(int numero){

    this.saldo = numero;
    if (saldo > 0)
      this.saldo = saldo;
    else
      this.saldo = 0.0;
    this.numero = numero;
    this.operadora = operadora;
  }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo > 0)
            if (this.saldo > 0)
                this.saldo += saldo;
            else
                this.saldo = saldo;
    }
    
    
  
  @Override
  public String toString() {
    return "operadora: " + this.operadora + "\nNumero: " + this.numero + "\nSaldo: " + this.saldo;
  }

  public int transferir(double valor, SimCard destino) {
    if (valor <= 0)
      return -1;
    if (this.saldo <= valor)
      return -2;
    if (this.operadora != destino.operadora)
      return -3;

    this.saldo -= valor;
    destino.setSaldo(valor);
    return 0;
  }
  abstract int recarregar(double saldo);


    
}

class CartaoVodacom extends SimCard implements Serializable{

  public String pais;
  public CartaoVodacom(int numero, String pais) {
    super(numero, 20, "Vodacom");
    this.pais = pais;
  }

  public String getPais(){
    return this.pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }


  @Override
  public int recarregar(double valor) {
    if (valor <= 0)
      return -1;
    double bonus = valor * 0.5;
    this.setSaldo(valor + bonus);
    return 0;
  }

    @Override
    public String toString() {
        return super.toString() +"\npais: " + pais;
    }



  
  public int recarregar(double valor, double bonusPercent) {
    if (valor <= 0)
      return -1;
    bonusPercent = bonusPercent / 100;
    double bonus = valor * bonusPercent;
    this.setSaldo(valor + bonus);
    return 0;
  }


}


class CartaoMcel extends SimCard implements Serializable{
  public String endereco;
  
  public CartaoMcel(int numero, String endereco) {
    super(numero, 20, "Mcel");
    this.endereco = endereco;

  }

  public String getEndereco(){
    return this.endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }


  @Override
  public int recarregar(double valor) {
    if (valor <= 0)
      return -1;
    double bonus = valor * 0.5;
    this.setSaldo(valor + bonus);
    return 0;
  }

  public int recarregar(double valor, double bonusPercent) {
    if (valor <= 0)
      return -1;
    bonusPercent = bonusPercent / 100;
    double bonus = valor * bonusPercent;
    this.setSaldo(valor + bonus);
    return 0; 
  }

  @Override
  public String toString() {
    return super.toString(); //+ "\nEndereco: " + this.endereco;
  }

}