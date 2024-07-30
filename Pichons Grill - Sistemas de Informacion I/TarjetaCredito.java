public class TarjetaCredito extends Pago{
    private int numero;
    private int CVV;
    private String titular;
    private String bancoEmisor;
    private String estadoTarjeta;
    private String direccionFacturacion;
    
    public TarjetaCredito(){
        
    }
    
    public void registrarDatos(){
        
    }
    
    public String getTitular(){
        return titular;
    }
    
    public String getBancoTitular(){
        return bancoEmisor;
    }
    
    public String estadoTarjeta(){
        return estadoTarjeta;
    }
    
    public String getDireccionFacturacion(){
        return direccionFacturacion;
    }
}