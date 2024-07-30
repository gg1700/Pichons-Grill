public class Bebida extends Producto{
    private int mls;
    private String marca;
    private boolean natural;
    
    public Bebida(int idProducto, String nombreProducto, double precio, String descripcion, String imagen, 
        int mls, String marca){
        super(idProducto, nombreProducto, precio, descripcion, imagen);
        this.mls = mls;
        this.marca = marca;
    }
    
    public int getMls(){
        return mls;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public boolean esNatural(){
        return natural;
    }
}