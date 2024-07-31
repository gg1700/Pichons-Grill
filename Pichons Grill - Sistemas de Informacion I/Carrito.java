import java.util.*;

public class Carrito {
    // Mapa para almacenar los productos y sus cantidades en el carrito
    private HashMap<Producto, Integer> productosCarrito;
    // Total del carrito, calculado con base en los productos y sus cantidades
    private double total;

    // Constructor del carrito
    public Carrito() {
        productosCarrito = new HashMap<>();
        total = 0.0;
    }

    // Método para agregar un producto al carrito con una cantidad específica
    public void agregarProducto(Producto producto, int cantidad) {
        // Verifica si el producto ya está en el carrito
        if (productosCarrito.containsKey(producto)) {
            // Si el producto ya está, se actualiza la cantidad
            int cantidadActual = productosCarrito.get(producto);
            productosCarrito.put(producto, cantidadActual + cantidad);
        } else {
            // Si el producto no está en el carrito, se agrega con la cantidad especificada
            productosCarrito.put(producto, cantidad);
        }
        // Actualiza el total del carrito
        actualizarTotal();
    }

    // Método para quitar un producto del carrito
    public void quitarProducto(Producto producto) {
        // Verifica si el producto está en el carrito
        if (productosCarrito.containsKey(producto)) {
            // Si está, se elimina del carrito
            productosCarrito.remove(producto);
            // Actualiza el total del carrito
            actualizarTotal();
        }
    }

    // Método para modificar la cantidad de un producto en el carrito
    public void modificarCantidad(Producto producto, int nuevaCantidad) {
        // Verifica si el producto está en el carrito
        if (productosCarrito.containsKey(producto)) {
            if (nuevaCantidad > 0) {
                // Si la nueva cantidad es positiva, se actualiza
                productosCarrito.put(producto, nuevaCantidad);
            } else {
                // Si la nueva cantidad es cero o negativa, se quita el producto del carrito
                quitarProducto(producto);
            }
            // Actualiza el total del carrito
            actualizarTotal();
        }
    }

    // Método para finalizar el pedido y limpiar el carrito
    public void finalizarPedido(Pedido pedido) {
        // Registra el carrito en el pedido
        pedido.registrarPedido(this);
        // Limpia el carrito y resetea el total
        productosCarrito.clear();
        total = 0.0;
    }

    // Método privado para actualizar el total del carrito basado en los productos y cantidades
    private void actualizarTotal() {
        total = 0.0;
        // Recorre todos los productos en el carrito
        for (Map.Entry<Producto, Integer> entry : productosCarrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            // Calcula el subtotal para el producto y lo suma al total
            total += producto.getPrecio() * cantidad;
        }
    }

    // Método para mostrar los detalles del carrito
    public void mostrarCarrito() {
        System.out.println("--------CARRITO--------");
        // Recorre todos los productos en el carrito
        for (Map.Entry<Producto, Integer> entry : productosCarrito.entrySet()) {
            Producto producto = entry.getKey();
            int cantidad = entry.getValue();
            // Imprime los detalles del producto y su subtotal
            System.out.println("Producto: " + producto.getNombreProducto());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Unitario: " + producto.getPrecio() + " Bs");
            System.out.println("Subtotal: " + (producto.getPrecio() * cantidad) + " Bs");
            System.out.println();
        }
        // Imprime el total del carrito
        System.out.println("Total: " + total + " Bs");
    }

    // Métodos getters
    public HashMap<Producto, Integer> getProductosCarrito() {
        return productosCarrito;
    }

    public double getTotal() {
        return total;
    }
    
    public void clearCarrito() {
        // Elimina todos los productos del carrito
        productosCarrito.clear();
    }
    
}