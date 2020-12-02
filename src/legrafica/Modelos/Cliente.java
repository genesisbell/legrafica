package legrafica.Modelos;

/**
 *
 * @author genesisbell
 */
public class Cliente {
    private int idCliente;
    private String nombreCliente;
    
    public int getId(){
        return idCliente;
    }
    
    public void setId(int newId){
        this.idCliente = newId;
    }
    
    public String getNombre(){
        return nombreCliente;
    }
    
    public void setNombre(String newNombre){
        this.nombreCliente = newNombre;
    }
    
}
