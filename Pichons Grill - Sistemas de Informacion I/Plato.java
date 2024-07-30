public class Plato extends Producto{
    private String categoria;
    
    public Plato(String nombreProducto, double precio, String descripcion, String imagen, 
        String categoria){
        super(nombreProducto, precio, descripcion, imagen);
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setCategoria(String nuevaCategoria){
        categoria = nuevaCategoria;
    }
}