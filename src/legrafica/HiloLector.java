
package legrafica;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class HiloLector extends Thread {
    private final InputStream is;
    
    public HiloLector (InputStream is) {
        this.is = is;
    }
    @Override
    public void run(){
        try{
            byte[]buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0){
                String texto = new String(buffer, 0, leido);
                System.out.print(texto);
                leido = is.read(buffer);
                
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
