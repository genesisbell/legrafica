package legrafica.Modelos;

/**
 *
 * @author genesisbell
 */
public class Proyectos {
    private int IdProyectos;
    private String nombreProyectos;
    
    public int getId(){
        return IdProyectos;
    }
    
    public void setId(int newId){
        this.IdProyectos = newId;
    }
    
    public String getNombre(){
        return nombreProyectos;
    }
    
    public void setNombre(String newNombre){
        this.nombreProyectos = newNombre;
    }
}
