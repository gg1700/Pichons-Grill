public class Producto{
    protected String idProducto;
    protected String nombreProducto;
    protected double precio;
    
    public Producto(){
        idProducto = "";
        nombreProducto = "";
        precio = 0.0;
    }
    
    public String getIdProducto(){
        return idProducto;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public double getPrecio(){
        return precio;
    }
}