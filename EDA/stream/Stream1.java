package stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static sun.java2d.cmm.ColorTransform.Out;

/**
 *
 * @author root
 */
public class Stream1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
       Stream stream;
       String line = "texto";
        stream = new Stream("/home/lirylinx/teste.db");
        Object obj;
//        stream.fileObjWriter(line, "/home/lirylinx/teste.db");
        if ((obj = stream.fileObjReader()) instanceof String) {
            line = new String((String) obj);
        } 
           System.out.println(line);
//   
           
//            /* Carregar ficheiro nan memoria */
//            InputStream entrada  = new FileInputStream("/home/lirylinx/alone.xspf");
//
//            /* Converter de byte para caracteres */
//            InputStreamReader reader = new InputStreamReader(entrada);
//            
//            /* Criar um buffer para cada caracter do reader e retornar
//                depois que atingir tamanho total do buffer;
//            */
//            BufferedReader buffer = new BufferedReader(reader);
//            
//            String line = buffer.readLine();
//            
//            
//            OutputStream saida = new FileOutputStream("/home/lirylinx/saida.txt");
//            OutputStreamWriter writer = new OutputStreamWriter(saida);
//            BufferedWriter bufwt = new BufferedWriter(writer);
//            while(line != null) {
//                System.out.println(line);
//                bufwt.write(line);
//                bufwt.newLine();
//                line = buffer.readLine();
//            }
//            
//            
//            
//            /* Libertar os recursos alocados */
//            buffer.close();
//            bufwt.close();
    }
        
}
