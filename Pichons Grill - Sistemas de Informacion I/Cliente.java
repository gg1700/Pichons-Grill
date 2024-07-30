public class Cliente extends Usuario{
    private String direccion;
    private String NIT;
    private Menu menu;
    
    public Cliente(){
        
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public String getNIT(){
        return NIT;
    }
    
    public void setDireccion(){
        
    }
    
    public void setNIT(){
        
    }
    
    public Menu verMenu(){
        return menu; 
    }
    
    public Menu seleccionarFiltro(){
        return menu;
    }
    
    public Producto verDetallesProduto(){
        return null;
    }
    
    public void agregarProductoAlCarrito(){
        
    }
    
    public void aumentarCantidadProduto(){
        
    }
    
    public void eliminarProductoDelCarrito(){
        
    }
    
    public void disminuirCantidadProducto(){
        
    }
    
    public boolean confirmarPedido(){
        return true;
    }
}