import java.util.ArrayList;

public class Producto{
    protected int idProducto;
    protected String nombreProducto;
    protected double precio;
    protected String descripcion;
    protected String imagen;
    
    private final int limiteSuperior;
    private Menu menu; 
    private ArrayList<Integer> listaIds;
    
    public Producto(int idProducto, String nombreProducto, double precio, String descripcion, String imagen){
        limiteSuperior = 999;
        menu = new Menu();
        listaIds = obtenerIdsMenu();
        this.idProducto = asignarIdProducto(idProducto);
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
        idProducto = asignarIdProducto(nuevoId);
    }
    
    private int asignarIdProducto(int nuevoId){
        int res;
        if(!listaIds.isEmpty()){
            if(nuevoId <= limiteSuperior && nuevoId >= 0 && 
                !listaIds.contains(idProducto)){
                res = nuevoId;
            }else{
                int ultimoId = listaIds.get(listaIds.size()-1);
                if(ultimoId != limiteSuperior){
                    res = ultimoId + 1;
                }else{
                    res = -1;
                }
            }
        }else{
            if(nuevoId <= limiteSuperior && nuevoId >= 0){
                res = nuevoId;
            }else{
                res = 0;
            }
        }
        return res;
    }
    
    private ArrayList<Integer> obtenerIdsMenu(){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < menu.getProductos().size(); i++){
            Producto actual = menu.getProductos().get(i);
            res.add(actual.getIdProducto());
        }
        return res;
    }
    
    private boolean idValido(){
        boolean res;
        res = (idProducto <= 999 && idProducto >= 0);
        return res;
    }
}