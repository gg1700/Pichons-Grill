public class Efectivo extends Pago{
    private Repartidor repartidor;
    
    public Efectivo(){
        
    }
    
    public void asignarRepartidor(){
        
    }
    
    public Repartidor getRepartidor(){
        return repartidor;
    }
    
    public double getTotal(){
        return pedido.getTotal();
    }
}