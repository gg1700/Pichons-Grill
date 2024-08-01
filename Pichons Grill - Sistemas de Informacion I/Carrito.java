import java.util.*;
import java.time.LocalDateTime;

public class Carrito{
    private HashMap<Producto, Integer> productosCarrito;
    private double total;
    private final int cantidadProductosLimite;
    private Pedido pedido;
    private Caja caja;

    public Carrito(){
        productosCarrito = new HashMap<Producto, Integer>();
        total = 0.0;
        cantidadProductosLimite = 99;
        pedido = new Pedido();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if(productosCarrito.containsKey(producto) && validarCantidad(cantidad)){
            int cantidadActual = productosCarrito.get(producto);
            productosCarrito.put(producto, cantidadActual + cantidad);
        }else{
            productosCarrito.put(producto, cantidad);
        }
        actualizarTotal();
    }

    public void quitarProducto(Producto producto){
        if(productosCarrito.containsKey(producto)){
            productosCarrito.remove(producto);
            //int cantidad=productosCarrito.get(producto);
            //total=-producto.getPrecio()*cantidad;
            actualizarTotal();
        }
    }

    public void modificarCantidad(Producto producto, int nuevaCantidad){
        if(productosCarrito.containsKey(producto)) {
            if(validarCantidad(nuevaCantidad)) {
                productosCarrito.put(producto, nuevaCantidad);
            }
            actualizarTotal();
        }
    }
    
    public void sumarCantidadProducto(Producto producto){
        if(productosCarrito.containsKey(producto)){
            int cantidadActual = productosCarrito.get(producto);
            if(validarCantidad(cantidadActual)){
                productosCarrito.put(producto, cantidadActual + 1);
            }
            actualizarTotal();
        }
    }
    
    public void restarCantidadProducto(Producto producto){
        if(productosCarrito.containsKey(producto)){
            int cantidadActual = productosCarrito.get(producto);
            if(validarCantidad(cantidadActual)){
                if(cantidadActual == 0){
                    quitarProducto(producto);
                }else{
                    productosCarrito.put(producto, cantidadActual - 1);
                }
            }
            actualizarTotal();
        }
    }
    
    public void vaciarCarrito(){
        if(!esVacio()){
            productosCarrito.clear();
            total = 0.0;
        }
    }

    public void finalizarPedido(Cliente cliente){
        pedido.asociarCliente(cliente);
        pedido.registrarPedido(this);
        vaciarCarrito();
        caja.getPedidosPendientes().add(pedido);
        caja.getClientes().add(cliente);
        String clienteActual = cliente.getNombre();
        String mensaje = "Un nuevo pedido ha sido solicitado por el cliente: " + clienteActual + ".";
        LocalDateTime fechaEmision = LocalDateTime.now(); 
        Notificacion notificacionCaja = new Notificacion(mensaje, clienteActual, caja.verNombreCajero(), fechaEmision);
        caja.recibirNotificacionCliente(notificacionCaja);
    }

    private void actualizarTotal(){
        total = 0.0;
        for(Map.Entry<Producto, Integer> entry : productosCarrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            total += producto.getPrecio() * cantidad;
        }
    }

    public void mostrarCarrito(){
        System.out.println("--------CARRITO--------");
        for(Map.Entry<Producto, Integer> entry : productosCarrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println("Producto: " + producto.getNombreProducto());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Unitario: " + producto.getPrecio() + " Bs");
            System.out.println("Subtotal: " + (producto.getPrecio() * cantidad) + " Bs");
            System.out.println();
        }
        System.out.println("Total: " + total + " Bs");
    }
    
    private void vincularConCaja(Caja cajaRelacionada){
        caja = cajaRelacionada;
    }

    public HashMap<Producto, Integer> getProductosCarrito(){
        return productosCarrito;
    }

    public double getTotal(){
        return total;
    } 
    
    public boolean esVacio(){
        boolean res;
        res = (total == 0.0);
        return res;
    }
    
    public boolean validarCantidad(int cantidad){
        boolean res;
        res = (cantidad <= cantidadProductosLimite && cantidad >= 0);
        return res;
    }
    
    public int getCantidadProductoLimite(){
        return cantidadProductosLimite;
    }
}