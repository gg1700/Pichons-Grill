package PaqueteUsuarios;

import PaquetePedidos.*;
import PaquetePagos.*;
import PaqueteProductos.*;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDateTime;

public class Caja{
    private ArrayList<Pedido> listaDePendientes;
    private ArrayList<Pedido> listaDeCompletados;
    private ArrayList<Pago> listaDePagos;
    private ArrayList<Cliente> clientes;
    private Cajero cajeroDesignado;
    private ArrayList<Notificacion> notificaciones;
    private int limiteSuperior = 999;
    
    public Caja(){
        listaDeCompletados = new ArrayList<Pedido>();
        listaDePendientes = new ArrayList<Pedido>();
        listaDePagos = new ArrayList<Pago>();
        clientes = new ArrayList<Cliente>();
        notificaciones = new ArrayList<Notificacion>();
    }
    
    public String verNombreCajero() {
        return cajeroDesignado.getNombre();
    }
    
    public void designarNuevoCajero(Cajero cajeroDesignado){
        this.cajeroDesignado = cajeroDesignado;
    }
    
    public void verPagosDelDia(){
        if(listaDePagos.isEmpty()){
            System.out.println("No hubo pagos en el dia");
        }else{
            System.out.println("---------Pagos del dia----------");
            for(Pago pago: listaDePagos){
                String depositario= pago.getPedido().getCliente().getNombre();
                System.out.println("Depositario:" + depositario);
                double monto= pago.getPedido().getTotal();
                System.out.println("Monto Depositado: " + monto);
                LocalDateTime fechaPago = pago.getPedido().getFecha();
                String fecha = fechaPago.getDayOfMonth() + "/" + fechaPago.getMonthValue() + "/" + fechaPago.getYear();
                System.out.println("Fecha del Pago: " + fecha);
            }
        }
    }
    
    public void verContactosDelCliente(){
        if(clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
        }else{
            System.out.println("---------Contactos Registrados----------");
            for(Cliente cliente: clientes ){
                String nombre = cliente.getNombre();
                System.out.println("Nombre del cliente :" + nombre);
                String numero = cliente.getTelefono();
                System.out.println("Telefono :" + numero);
            }
        }
    }
    
    public String registrarPago(Pago pago){
        String res = "";
        if(listaDePagos.isEmpty()){
            pago.setIdPago(1);
            listaDePagos.add(pago);
            res = "¡Pago registrado exitosamente!";
        }else{
            int ultimoId = listaDePagos.get(listaDePagos.size()-1).getIdPago();
            pago.setIdPago(ultimoId + 1);
            if(validarPago(pago)){
                res = "¡Pago registrado exitosamente!";
                listaDePagos.add(pago);
            }else{
                res = "El Pago no pudo ser registrado.";
            }
        }
        return res;
    }
    
    private boolean validarPago(Pago pago){
        boolean res = true;
        if(pago.getIdPago() > limiteSuperior){
            res = false;
        }
        return res;
    }
    
    public ArrayList<Pedido> getPedidosPendientes(){
        return listaDePendientes;
    }
    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
    
    public void recibirNotificacionCliente(Notificacion notificacion){
        notificaciones.add(notificacion);
    }
    
    public void agregarPago(Pago pago){
        listaDePagos.add(pago);
    }
    
    public ArrayList<Pedido> getPedidosCompletados(){
        return listaDeCompletados;
    }
}