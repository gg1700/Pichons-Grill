import java.util.Date;


public class Notificacion
{
    protected String mensaje;
    protected String remitente;
    protected Usuario destinatario;
    protected Date fecha;
    protected Pedido pedido;
    public Notificacion(String mensaje,String remitente,Usuario destinatario,Date fecha){
        this.mensaje=mensaje;
        this.remitente=remitente;
        this.destinatario=destinatario;
        this.fecha=fecha;
    }
    public String getMensaje(){
        return mensaje;
    }
    public String getRemitente(){
        return remitente;
    }
    public String getDestinatario(){
        return destinatario.getNombre();
    }public Date getFecha(){
        return fecha;
    }
    
}
