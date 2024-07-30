public class Bebida extends Producto{
    private int ml;
    private String marca;
    
    public Bebida(){
        ml = 0;
        marca = "";
    }
    
    public int getMls(){
        return ml;
    }
    
    public String getMarca(){
        return marca;
    }
}