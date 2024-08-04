import PaquetePedidos.*;
import PaquetePagos.*;
import PaqueteUsuarios.*;
import PaqueteProductos.*;
import PaqueteExepciones.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AplicacionTest{
    Aplicacion aplicacion;
    Cliente cliente;
    Menu menu;
    Carrito carrito;
    Caja caja;
    Cajero cajero;
    Repartidor repartidor;
    String mensajeEsperado;
    String mensajeDevuelto;
    
    @BeforeEach
    public void setUp(){
        aplicacion = new Aplicacion();
        aplicacion.crearActores();
        cliente = aplicacion.getCliente();
        menu = aplicacion.getMenu();
        carrito = aplicacion.getCarrito();
        caja = aplicacion.getCaja();
        cajero = aplicacion.getCajero();
        repartidor = aplicacion.getRepartidor();
    }
    
    //Escenario de Prueba: Pagar Pedidos.
    @Test
    public void testPagoMontoInsuficiente(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        cliente.agregarProductoCarrito(0, 50);
        double montoPago = cliente.getSaldo();
        mensajeDevuelto = cliente.pagarPedido(1, montoPago);
        mensajeEsperado = "No se puede pagar el pedido, monto insuficiente.";
        //Assert
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    @Test
    public void testPagoMontoCorrecto(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        aplicacion.vincularCajaCajeroRepartidor(caja, cajero, repartidor);
        cliente.agregarProductoCarrito(0, 2);
        double montoPago = 120.0;
        mensajeDevuelto = cliente.pagarPedido(1, montoPago);
        mensajeEsperado = "El pedido ha sido pagado con exito.";
        //Assert
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    @Test
    public void testPagoCarritoVacio(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        double montoPago = 70.0;
        mensajeDevuelto = cliente.pagarPedido(1, montoPago);
        mensajeEsperado = "No es posible pagar un pedido que no contenga productos en el carrito.";
        //Assert
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    //Escenario de Prueba: Quitar Productos del Carrito.
    @Test
    public void testQuitarProductosDeCarritoLleno(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        cliente.agregarProductoCarrito(0, 2);
        mensajeDevuelto = cliente.quitarProductoCarrito(0);
        mensajeEsperado = "El plato que ha seleccionado, ha sido retirado del carrito.";
        //Arrange
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    @Test
    public void testQuitarProductosDeCarritoVacio(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        mensajeDevuelto = cliente.quitarProductoCarrito(0);
        mensajeEsperado = "No es posible quitar productos, el carrito esta vacio, agregue productos.";
        //Arrange
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    @Test
    public void testQuitarProductosNoExistentesEnElCarrito(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        cliente.agregarProductoCarrito(0, 2);
        mensajeDevuelto = cliente.quitarProductoCarrito(15);
        mensajeEsperado = "No es posible quitar el producto solicitado, no existe en el carrito.";
        //Arrange
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    //Escenario de Prueba: Estados de un Pedido.
    @Test
    public void testEstadoDePedidoPagado(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        aplicacion.vincularCajaCajeroRepartidor(caja, cajero, repartidor);
        cliente.agregarProductoCarrito(0, 2);
        cliente.pagarPedido(1, 120.0);
        mensajeDevuelto = carrito.getPedido().getEstado();
        mensajeEsperado = "Pagado.";
        //Arrange
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    @Test
    public void testEstadoDePedidoEntregado(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        aplicacion.vincularCajaCajeroRepartidor(caja, cajero, repartidor);
        cliente.agregarProductoCarrito(0, 2);
        cliente.pagarPedido(1, 120.0);
        cajero.agregarRepartidor(repartidor);
        cajero.asignarPedidoRepartidor();
        mensajeDevuelto = repartidor.getPedidosPendientes().get(0).getEstado();
        mensajeEsperado = "Entregado.";
        //Arrange
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
    
    @Test
    public void testEstadoDePedidoEnProgreso(){
        //Act
        aplicacion.vincularClienteCarritoCaja(cliente, carrito, menu);
        aplicacion.vincularCajaCajeroRepartidor(caja, cajero, repartidor);
        cliente.agregarProductoCarrito(0, 2);
        cliente.pagarPedido(1, 120.0);
        cajero.agregarRepartidor(repartidor);
        cajero.asignarPedidoRepartidor();
        repartidor.marcarPedidoProgreso();
        mensajeDevuelto = repartidor.getPedidoEnProgresoActual().getEstado();
        mensajeEsperado = "En Progreso.";
        //Arrange
        assertEquals(mensajeEsperado, mensajeDevuelto);
    }
}