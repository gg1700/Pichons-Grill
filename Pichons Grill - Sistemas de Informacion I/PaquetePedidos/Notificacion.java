package PaquetePedidos;

import java.util.Date;
import java.time.*;

public class Notificacion{
    private String mensaje;
    private String remitente;
    private String destinatario;
    private LocalDateTime fecha;
    private Pedido pedido;
    
    public Notificacion(String mensaje, String remitente, String destinatario, LocalDateTime fecha, Pedido pedido){
        this.mensaje = mensaje;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fecha = fecha;
        this.pedido = pedido;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public String getRemitente(){
        return remitente;
    }
    
    public String getDestinatario(){
        return destinatario;
    }
    
    public LocalDateTime getFecha(){
        return fecha;
    }
}
