import java.util.Date;
import java.util.ArrayList;

public class Pedido{
    private String idPedido;
    private ArrayList<Producto> contenidos;
    private boolean pagado;
    private Pago tipoPago;
    private Repartidor repartidorEncargado;
    private Date fecha;
    private Cliente cliente;
    
    public Pedido(){
        
    }
    
    public ArrayList<Producto> getContenidos(){
        return contenidos;
    }
    
    public boolean estaPagado(){
        return pagado;
    }
    
    public Pago getTipoPago(){
        return tipoPago;
    }
    
    public Repartidor getRepartidorEncargado(){
        return repartidorEncargado;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public double getTotal(){
        return 0;
    }
}