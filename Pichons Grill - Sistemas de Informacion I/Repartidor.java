public class Repartidor extends Usuario{
    private String idRepartidor;
    private Pedido pedidoActual;
    
    public Repartidor(){
        
    }
    
    public String getIdRepartidor(){
        return idRepartidor;
    }
    
    public Pedido getPedidoActual(){
        return pedidoActual;
    }
    
    public void setIdRepartidor(){
        //Lolsito
    }
    
    public void setPedidoActual(){
        
    }
    
    public String marcarEstadoPedido(){
        return "";
    }
    
    public String verDetallesPedido(){
        return "";
    }
    
    public boolean verificarEstadoPago(){
        return true;
    }
    
    public String visualizarMetodoPago(){
        return "";
    }
    
    public void notificarCliente(){
        
    }
    
    public void notificarCajero(){
        
    }
}