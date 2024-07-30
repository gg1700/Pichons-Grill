public abstract class Pago{
    protected String idPago;
    protected Pedido pedido;
    
    public String getIdPago(){
        return idPago;
    }
    
    public Pedido getPedido(){
        return pedido;
    }
    
    public Cliente getCliente(){
        return pedido.getCliente();
    }
}