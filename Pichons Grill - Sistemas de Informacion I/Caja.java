import java.util.ArrayList;
public class Caja{
    protected ArrayList<Pedido> listaDePedidos;
    protected String fecha;
    protected ArrayList<Pago> listaDePagos;
    protected ArrayList<String> contactos;
    protected Cajero cajeroDesignado;
    public Caja(){
        listaDePedidos = new ArrayList<Pedido>();
        listaDePagos = new ArrayList<Pago>();
        contactos = new ArrayList<String>();
    }
    public void pasarPedidoACocina (){
        
    }
    public void pasarPedidoARepartidor(){
        
    }
    public String verNombreCajero() {
        return cajeroDesignado.getNombreCajero();
    }
    public void designarNuevoCajero(){
        
    }
}
