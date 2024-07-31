import java.util.*;

public class Pedido {
    private static int idContador = 1;
    private int idPedido;
    private ArrayList<Producto> productos;
    private ArrayList<Integer> cantidades;
    private double total;
    private String estado;
    private Date fecha;

    public Pedido() {
        this.idPedido = idContador++;
        this.productos = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.total = 0.0;
        this.estado = "Pendiente";
        this.fecha = new Date();
    }

    public void registrarPedido(Carrito carrito) {
        this.productos.clear();
        this.cantidades.clear();
        for(Map.Entry<Producto, Integer> entry : carrito.getProductosCarrito().entrySet()) {
            this.productos.add(entry.getKey());
            this.cantidades.add(entry.getValue());
        }
        this.total = carrito.getTotal();
        carrito.vaciarCarrito();
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void mostrarPedido() {
        System.out.println("--------PEDIDO #" + idPedido + "--------");
        System.out.println("Fecha: " + fecha);
        for(int i = 0; i < productos.size(); i++){
            Producto producto = productos.get(i);
            int cantidad = cantidades.get(i);
            System.out.println("Producto: " + producto.getNombreProducto());
            System.out.println("Cantidad: " + cantidad);
            System.out.println("Precio Unitario: " + producto.getPrecio() + " Bs");
            System.out.println("Subtotal: " + (producto.getPrecio() * cantidad) + " Bs");
            System.out.println();
        }
        System.out.println("Total: " + total + " Bs");
        System.out.println("Estado: " + estado);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Integer> getCantidades() {
        return cantidades;
    }

    public double getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }
    
    public int getIdPedido() {
        return idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return null;
    }
}