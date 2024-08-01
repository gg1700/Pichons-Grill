import java.util.Date;
import java.time.*;

public class Notificacion{
    protected String mensaje;
    protected String remitente;
    protected String destinatario;
    protected LocalDateTime fecha;
    protected Pedido pedido;
    
    public Notificacion(String mensaje, String remitente, String destinatario, LocalDateTime fecha){
        this.mensaje=mensaje;
        this.remitente=remitente;
        this.destinatario=destinatario;
        this.fecha = fecha;
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
