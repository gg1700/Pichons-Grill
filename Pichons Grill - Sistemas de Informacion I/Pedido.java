import java.util.*;

public class Pedido {
    // Contador estático para generar IDs únicos para cada pedido
    private static int idContador = 1;
    // ID del pedido
    private int idPedido;
    // Lista para almacenar los productos y sus cantidades en el pedido
    private List<Producto> productos;
    private List<Integer> cantidades;
    // Total del pedido
    private double total;
    // Estado del pedido
    private String estado;
    // Fecha en la que se realiza el pedido
    private Date fecha;

    // Constructor del pedido
    public Pedido() {
        this.idPedido = idContador++;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
        this.estado = "Pendiente";
        this.fecha = new Date(); // Establece la fecha actual al momento de la creación del pedido
    }

    // Método para registrar los productos del carrito en el pedido
    public void registrarPedido(Carrito carrito) {
        this.productos.clear();
        this.cantidades.clear();
        // Recorre los productos en el carrito y los agrega al pedido
        for (Map.Entry<Producto, Integer> entry : carrito.getProductosCarrito().entrySet()) {
            this.productos.add(entry.getKey());
            this.cantidades.add(entry.getValue());
        }
        // Actualiza el total del pedido basado en el carrito
        this.total = carrito.getTotal();
        // Limpia el carrito después de registrar el pedido
        carrito.clearCarrito();
    }

    // Método para cambiar el estado del pedido
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Método para mostrar los detalles del pedido
    public void mostrarPedido() {
        System.out.println("--------PEDIDO #" + idPedido + "--------");
        System.out.println("Fecha: " + fecha);
        // Recorre todos los productos en el pedido
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            // Imprime los detalles del producto y su subtotal
            System.out.println("Producto: " + producto.getNombreProducto());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Unitario: " + producto.getPrecio() + " Bs");
            System.out.println("Subtotal: " + (producto.getPrecio() * cantidad) + " Bs");
            System.out.println();
        }
        // Imprime el total del pedido y el estado
        System.out.println("Total: " + total + " Bs");
        System.out.println("Estado: " + estado);
    }

    // Métodos getters
    public List<Producto> getProductos() {
        return productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFecha() {
        return fecha;
    }
}
