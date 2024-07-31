

public class Notificacion
{
    protected String mensaje;
    protected Usuario remitente;
    protected Usuario destinatario;
    protected String fecha;
    public Notificacion(String mensaje,Usuario remitente,Usuario destinatario,String fecha){
        this.mensaje=mensaje;
        this.remitente=remitente;
        this.destinatario=destinatario;
        this.fecha=fecha;
    }
    public String getMensaje(){
        return mensaje;
    }
    public String getRemitente(){
        return remitente.getNombre();
    }
    public String getDestinatario(){
        return destinatario.getNombre();
    }public String getFecha(){
        return fecha;
    }
    
}
