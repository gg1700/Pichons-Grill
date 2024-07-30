public class Plato extends Producto{
    private String categoria;
    
    public Plato(int idProducto, String nombreProducto, double precio, String descripcion, String imagen, 
        String categoria){
        super(idProducto, nombreProducto, precio, descripcion, imagen);
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return categoria;
    }
}