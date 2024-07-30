import java.util.Date;

public class QR extends Pago{
    private Date fechaEmision;
    private Date fechaExpiracion;
    private double monto;
    private String imagenQR;
    private String bancoEmisor;
    
    public QR(){
        
    }
    
    public Date getFechaEmision(){
        return fechaEmision;
    }
    
    public Date getFechaExpiracion(){
        return fechaExpiracion;
    }
    
    public double getMonto(){
        return monto;
    }
    
    public String getImagenQR(){
        return imagenQR;
    }
    
    public String getBancoEmisor(){
        return bancoEmisor;
    }
}