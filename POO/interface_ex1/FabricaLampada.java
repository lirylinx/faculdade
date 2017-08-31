
package interface_ex1;

/**
 *
 * @author estudante
 */
public class FabricaLampada {

    public Object construir(String tipo_lampada) {
        if (tipo_lampada.equalsIgnoreCase("Incadescente"))
            return new Incadescente();

        return new Fluorescente();
    }
}

class Incadescente implements Lampada{

  
    @Override
    public void ligar() {
        System.out.println("Incadescente ligado");
    }

    @Override
    public void desligar() {
        System.out.println("Incadescente desligado");
    }
       
}




class Fluorescente implements Lampada{

  
    @Override
    public void ligar() {
        System.out.println("Fluorescente ligado");
    }

    @Override
    public void desligar() {
        System.out.println("Fluorescente desligado");
    }
       
}