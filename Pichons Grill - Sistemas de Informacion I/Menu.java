import java.util.ArrayList;

public class Menu{
    private ArrayList<Producto> productos;
    private final int limiteSuperior;
    
    public Menu(){
        productos = new ArrayList<Producto>();
        limiteSuperior = 999;
    }
    
    public int getLimiteSuperior(){
        return limiteSuperior;
    }
    
    public ArrayList<Producto> getProductos(){
        return productos;
    }
    
    public String registrarProducto(Producto producto){
        String res;
        if(productos.isEmpty()){
            productos.add(producto);
            if(producto instanceof Plato){
                res = "El plato ha sido registrado al menu con exito.";
            }else if(producto instanceof Bebida){
                res = "La bebida ha sido registrada al menu con exito.";
            }else{
                res = "El producto ha sido registrado al menu con exito.";
            }
        }else{
            int ultimoId = productos.get(productos.size()-1).getIdProducto();
            producto.setIdProducto(ultimoId + 1);
            if(producto.idValido()){
                productos.add(producto);
                if(producto instanceof Plato){
                    res = "El plato ha sido registrado al menu con exito.";
                }else if(producto instanceof Bebida){
                    res = "La bebida ha sido registrada al menu con exito.";
                }else{
                    res = "El producto ha sido registrado al menu con exito.";
                }
            }else{
                if(producto instanceof Plato){
                    res = "El plato no ha podido ser registrado en el menu.";
                }else if(producto instanceof Bebida){
                    res = "La bebida no ha podido ser registrada en el menu.";
                }else{
                    res = "El producto no ha podido ser registrado en el menu.";
                }
            }
        }
        return res;
    }
    
    public void quitarProducto(){
        
    }
    
    public void modificarProducto(){
        
    }
}