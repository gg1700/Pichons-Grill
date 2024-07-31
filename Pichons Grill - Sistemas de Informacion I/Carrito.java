import java.util.*;

public class Carrito{
    private HashMap<Producto, Integer> productosCarrito;
    private double total;
    private final int cantidadProductosLimite;
    private Pedido pedido;

    public Carrito(){
        productosCarrito = new HashMap<>();
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

    public void finalizarPedido(){
        pedido.registrarPedido(this);
        vaciarCarrito();
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