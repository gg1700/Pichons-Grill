import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;

public class Caja{
    protected ArrayList<Pedido> listaDePendientesAll;
    protected ArrayList<Pedido> listaDeCompletados;
    protected String fecha;
    protected ArrayList<Pago> listaDePagos;
    protected ArrayList<Cliente> clientes;
    protected ArrayList<Repartidor> repartidores;
    protected Cajero cajeroDesignado;
    protected ArrayList<Notificacion> notificaciones;
    
    public Caja(){
        listaDeCompletados = new ArrayList<Pedido>();
        listaDePendientesAll = new ArrayList<Pedido>();
        listaDePagos = new ArrayList<Pago>();
        clientes = new ArrayList<Cliente>();
        notificaciones = new ArrayList<Notificacion>();
    }
    
    public void pasarPedidoACocina(){
        
    }
    
    public void pasarPedidoARepartidor(){
        //repartidores.get(0).listaDePendientesAll.add();
    }
    
    public String verNombreCajero() {
        return cajeroDesignado.getNombreCajero();
    }
    
    public void designarNuevoCajero(Cajero cajeroDesignado){
        this.cajeroDesignado = cajeroDesignado;
    }
    
    public void verPagosDelDia(){
        if(listaDePagos.isEmpty()){
            System.out.println("No hubo pagos en el dia");
        }else{
            System.out.println("---------Pagos del dia----------");
            for(Pago pago: listaDePagos ){
                String depositario= pago.getCliente().getNombre();
                System.out.println("Depositario :"+depositario);
                double monto= pago.pedido.getTotal();
                System.out.println("Monto Depositado");
                LocalDateTime fechaPago = pago.pedido.getFecha();
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String fechaFormateada = formatoFecha.format(fechaPago);
                System.out.println("Fecha del Pago :"+fechaFormateada);
            }
        }
    }
    
    public void verContactosDelCliente(){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            System.out.println("---------Contactos Registrados----------");
            for(Cliente cliente: clientes ){
                String nombre= cliente.getNombre();
                System.out.println("Cliente :"+nombre);
                String numero= cliente.getTelefono();
                System.out.println("Cliente :"+nombre);
            }
        }
    }
    
    public ArrayList<Pedido> getPedidosPendientes(){
        return listaDePendientesAll;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    public void recibirNotificacionCliente(Notificacion notificacion){
        notificaciones.add(notificacion);
    }
}