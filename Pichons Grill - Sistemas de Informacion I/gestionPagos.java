import java.util.ArrayList;

public class gestionPagos{
    private ArrayList<Pago> pagosRegistrados;
    private int limiteSuperior = 999;
    public gestionPagos(){
        pagosRegistrados = new ArrayList<>();
    }
    
    public String registrarPago(Pago pago){
        String res = "";
        if(pagosRegistrados.isEmpty()){
            pago.setIdPago(1);
            pagosRegistrados.add(pago);
            res = "Pago registrado exitosamente!";
        }
        else{
            int ultimoId = pagosRegistrados.get(pagosRegistrados.size()-1).getIdPago();
            pago.setIdPago(ultimoId + 1);
            if(validarPago(pago)){
                res = "Pago registrado exitosamente!";
                pagosRegistrados.add(pago);
            }
            else{
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
}
