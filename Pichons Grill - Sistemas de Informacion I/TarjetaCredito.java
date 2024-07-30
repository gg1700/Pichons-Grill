public class TarjetaCredito extends Pago{
    private int numero;
    private int CVV;
    private String titular;
    private String bancoEmisor;
    private String estadoTarjeta;
    private String direccionFacturacion;
    
    public TarjetaCredito(Pedido pedido){
        super(pedido);
    }
    
    public void registrarDatos(int numero, int CVV, String titular, String bancoEmisor, String estado, String direccion){
        this.numero = numero;
        this.CVV = CVV;
        this.titular = titular;
        this.bancoEmisor = bancoEmisor;
        this.estadoTarjeta = estado;
        this.direccionFacturacion = direccion;
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