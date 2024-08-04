package PaqueteUsuarios;

import PaquetePedidos.*;

import java.util.*;
import java.time.LocalDateTime;

public class Cajero extends Usuario{
    private String idCajero;
    private Caja caja; //Registrar a Parte
    private ArrayList<Repartidor> listaRepartidores;
    private ArrayList<Pedido> pedidosPendientes;

    public Cajero(String nombre, String telefono, String idCajero, Caja caja){
        this.idCajero = idCajero;
        this.nombre = nombre;
        this.telefono = telefono;
        this.listaRepartidores = new ArrayList<Repartidor>();
        this.caja = caja;
        this.pedidosPendientes = caja.getPedidosPendientes();
    }

    public void designarCaja(Caja caja){
        this.caja = caja;
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

    public void agregarRepartidor(Repartidor repartidor){
        listaRepartidores.add(repartidor);
    }

    public void asignarPedidoRepartidor(){
        for(Repartidor repartidorActual: listaRepartidores){
            if(repartidorActual.getEstado().equals("Disponible.") && !pedidosPendientes.isEmpty()){
                Pedido pedidoReciente = pedidosPendientes.get(0);
                String mensaje = "Usted tiene un nuevo pedido";
                String destinatario = listaRepartidores.get(0).getNombre();
                LocalDateTime fecha = LocalDateTime.now();
                Pedido pedido = caja.getPedidosPendientes().get(0);
                Notificacion notificacion = new Notificacion(mensaje, getNombre(),destinatario, fecha, pedido);
                repartidorActual.recibirPedido(pedidoReciente, notificacion);
                pedidoReciente.cambiarEstado("Entregado.");
                caja.getPedidosCompletados().add(pedidoReciente);
                pedidosPendientes.remove(0);
                repartidorActual.setEstado("Ocupado.");
            }
        }
    }

    public ArrayList<Pedido> ordenarPedidosPorCompletadosPendientes(){
        return null;
    }
}