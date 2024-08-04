import java.util.ArrayList;

public class Usuario{
    protected String nombre;
    protected String telefono;
    
    public String getNombre(){
        return nombre;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }
    
    public void setTelefono(String nuevoTelefono){
        telefono = nuevoTelefono;
    }
}