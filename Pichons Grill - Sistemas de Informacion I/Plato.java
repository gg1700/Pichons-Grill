public class Plato extends Producto{
    private String descripcion;
    private String imagen;
    private String categoria;
    
    public Plato(){
        descripcion = "";
        imagen = "";
        categoria = "";
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public String getImagen(){
        return imagen;
    }
    
    public String getCategoria(){
        return categoria;
    }
}