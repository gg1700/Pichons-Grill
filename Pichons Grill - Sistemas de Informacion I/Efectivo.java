public class Efectivo extends Pago{
    public Efectivo(Pedido pedido){
        super(pedido);
    }
    
    public double getTotal(){
        return pedido.getTotal();
    }
}