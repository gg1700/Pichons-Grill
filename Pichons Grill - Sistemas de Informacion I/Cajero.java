import java.util.*;
public class Cajero
{
    protected String idCajero;
    protected String nombreCajero;
    protected Caja caja;
    public Cajero(String idCajero,String nombreCajero){
        this.idCajero=idCajero;
        this.nombreCajero=nombreCajero;
    }
    public void designarCaja(Caja caja){
        this.caja=caja;
    }
    protected String getNombreCajero(){
        return nombreCajero;
    }
    protected void setNombreCajero(String nombreCajero){
        this.nombreCajero=nombreCajero;
    }
    public String getIdCajero(){
        return idCajero;
    }
    public void setIdCajero(String nuevoId){
        idCajero=nuevoId;
    }
    public void verPagosDelDia(){
        caja.verPagosDelDia();
    }
    public void verContactosDelCliente(){
        caja.verContactosDelCliente();
    }
    public void notificarRepartidor(){
        String mensaje="Usted tiene un nuevo pedido";
        Usuario destinatario=caja.repartidores.get(0);
        Calendar calendario = Calendar.getInstance();
        calendario.set(2024, Calendar.JULY, 31, 18, 13, 31);
        Date fecha = calendario.getTime();
        Notificacion notificacion = new Notificacion(mensaje,getNombreCajero(),destinatario,fecha);
    }
    public ArrayList<Pedido> ordenarPedidosPorCompletadosPendientes(){
        return null;
    }
}