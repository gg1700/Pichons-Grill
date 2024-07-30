import java.util.ArrayList;

public class Producto{
    protected int idProducto;
    protected String nombreProducto;
    protected double precio;
    protected String descripcion;
    protected String imagen;
    
    private Menu menu;
    
    public Producto(String nombreProducto, double precio, String descripcion, String imagen){
        menu = new Menu();
        this.idProducto = 0;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getIdProducto(){
        return idProducto;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getImagen(){
        return imagen;
    }
    
    public void setIdProducto(int nuevoId){
       idProducto = nuevoId; 
    }
    //esta clase quizas se podria pasar directamente al menu para no tener que
    //tener una instancia de Menu en cada producto (eso o volver menu estatico)
    //-chamo
    public boolean idValido(){
        boolean res;
        res = (idProducto <= menu.getLimiteSuperior() && idProducto >= 0);
        return res;
    }
}