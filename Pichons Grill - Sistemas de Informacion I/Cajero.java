import java.util.*;
public class Cajero
{
    protected String idCajero;
    protected String nombreCajero;
    protected Caja caja;
     
    public Cajero(String idCajero,Caja caja){
        this.idCajero=idCajero;
        this.caja=caja;
    }

    public String getNombreCajero(){
        return nombreCajero;
    }
    
    public String getIdCajero(){
        return idCajero;
    }
    
    public void setIdCajero(String nuevoId){
        idCajero=nuevoId;
    }
    
    public void verPagosDelDia(){
        if(caja.listaDePagos.isEmpty()){
            System.out.println("No hubo pagos en el dia");
        }
    }
    
    public void verContactosDelCliente(){
       if(caja.contactos.isEmpty()){
            System.out.println("No hay contactos registrados");
        } 
    }
    
    public ArrayList<Pedido> ordenarPedidosPorCompletadosPendientes(){
        return null;
    }
}
