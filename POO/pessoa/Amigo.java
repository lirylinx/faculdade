
package pessoa;

import java.util.Date;

/**
 * Classe Amigo herdando atributos da super classe pessoa e possuindo
 * @var data_aniversario como atributo proprio
 * 
 * @author root
 */
public class Amigo extends Pessoa{
    public Date data_aniversario;

/*    Construtor amigo: inicializando o objecto amigo
        usando a data actual como valor padrao
*/         
    public Amigo() {
        this.data_aniversario = new Date();
    }

   
/**  
 * Obter a data de aniversario do objecto amigo
 * 
 * @return data_aniversario - objecto Date
 */
    public Date getData_aniversario() {
        return data_aniversario;
    }

    
/**
 * definir uma data de aniversario para objecto amido
 *  @param data_aniversario - objecto date com a data de aniversario do
 *          objecto amigo
 */
    
    public void setData_aniversario(Date data_aniversario) {
        this.data_aniversario = data_aniversario;
    }


    
}
