import java.util.HashMap;

public class Cliente extends Usuario{
    private String direccion;
    private String NIT;
    private Menu menu;
    private Carrito carrito;

    public Cliente(){
        
    }

    public String getDireccion(){
        return direccion;
    }

    public String getNIT(){
        return NIT;
    }

    public void setDireccion(){

    }

    public void setNIT(){

    }
    
    public void consultarFiltrosMenu(){
        
    }

    public Menu verMenu(int noOpcion){
        return menu; 
    }

    public Menu seleccionarFiltro(){
        return menu;
    }

    public Producto verDetallesProduto(){
        return null;
    }

    public String agregarProductoCarrito(int id, int cantidad){
        String res;
        if(menu.idValido(id)){
            Producto productoActual = menu.getProductoMenu(id);
            if(!productoActual.getNombreProducto().equals("") && productoActual.getIdProducto() != 0){
                carrito.agregarProducto(productoActual, cantidad);
                if(productoActual instanceof Plato){
                    res = "El plato ha sido registrado en el carrito exitosamente.";
                }else if(productoActual instanceof Bebida){
                    res = "La bebida ha sido registrada en el carrito exitosamente.";
                }else{
                    res = "El producto ha sido registrado en el carrito exitosamente.";
                }
            }else{
                res = "No se ha podido registrar producto en el carrito.";
            }
        }else{
            res = "No se ha podido registrar producto en el carrito, el producto que desea agregar no existe.";
        }
        return res;
    }

    public String quitarProductoCarrito(int id){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    if(!productoActual.getNombreProducto().equals("") && productoActual.getIdProducto() != 0){
                        carrito.quitarProducto(productoActual);
                        if(productoActual instanceof Plato){
                            res = "El plato que ha seleccionado, ha sido retirado del carrito.";
                        }else if(productoActual instanceof Bebida){
                            res = "La bebida que ha seleccionado, ha sido retirada del carrito.";
                        }else{
                            res = "El producto que ha seleccionado, ha sido retirado del carrito.";
                        }
                    }else{
                        res = "No se ha podido retirar del carrito el producto seleccionado.";
                    }
                }else{
                    res = "No es posible quitar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible quitar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido retirar el producto del carrito, el producto que desea retirar no existe.";
        }
        return res;
    }

    public String modificarProductoCarrito(int id, int cantidad){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    if(carrito.validarCantidad(cantidad)){
                        if(!productoActual.getNombreProducto().equals("") && productoActual.getIdProducto() != 0){
                            carrito.modificarCantidad(productoActual, cantidad);
                            if(productoActual instanceof Plato){
                                res = "El plato que ha seleccionado, ha sido modificado en cantidad.";
                            }else if(productoActual instanceof Bebida){
                                res = "La bebida que ha seleccionado, ha sido modificada en cantidad.";
                            }else{
                                res = "El producto que ha seleccionado, ha sido modificado en cantidad.";
                            }
                        }else{
                            res = "No se ha podido modificar el producto seleccionado del carrito .";
                        }
                    }else{
                        res = "La cantidad solicitada es invalida";
                    }
                }else{
                    res = "No es posible modificar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible modificar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido modificar el producto del carrito, el producto que desea modificar no existe.";
        }
        return res;
    }

    public String sumarCantidadProductoCarrito(int id){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    int cantidad = carrito.getProductosCarrito().get(productoActual);
                    if(carrito.validarCantidad(cantidad)){
                        if(!productoActual.getNombreProducto().equals("") && productoActual.getIdProducto() != 0){
                            carrito.sumarCantidadProducto(productoActual);
                            if(productoActual instanceof Plato){
                                res = "El plato que ha seleccionado, ha sido modificado en cantidad.";
                            }else if(productoActual instanceof Bebida){
                                res = "La bebida que ha seleccionado, ha sido modificada en cantidad.";
                            }else{
                                res = "El producto que ha seleccionado, ha sido modificado en cantidad.";
                            }
                        }else{
                            res = "No se ha podido modificar el producto seleccionado del carrito .";
                        }
                    }else{
                        res = "La cantidad solicitada supera al limite de 99 productos";
                    }
                }else{
                    res = "No es posible modificar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible modificar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido modificar el producto del carrito, el producto que desea modificar no existe.";
        }
        return res;
    }

    public String restarCantidadProductoCarrito(int id){
        String res;
        if(menu.idValido(id)){
            if(!carrito.esVacio()){
                Producto productoActual = menu.getProductoMenu(id);
                if(carrito.getProductosCarrito().containsKey(productoActual)){
                    int cantidad = carrito.getProductosCarrito().get(productoActual);
                    if(!productoActual.getNombreProducto().equals("") && productoActual.getIdProducto() != 0){
                        carrito.restarCantidadProducto(productoActual);
                        if(productoActual instanceof Plato){
                            res = "El plato que ha seleccionado, ha sido modificado en cantidad.";
                        }else if(productoActual instanceof Bebida){
                            res = "La bebida que ha seleccionado, ha sido modificada en cantidad.";
                        }else{
                            res = "El producto que ha seleccionado, ha sido modificado en cantidad.";
                        }
                    }else{
                        res = "No se ha podido modificar el producto seleccionado del carrito .";
                    }
                }else{
                    res = "No es posible modificar el producto solicitado, no existe en el carrito.";
                }
            }else{
                res = "No es posible modificar productos, si el carrito esta vacio, agregue productos.";
            }
        }else{
            res = "No se ha podido modificar el producto del carrito, el producto que desea modificar no existe.";
        }
        return res;
    }
    
    public void verContenidoCarrito(){
        carrito.mostrarCarrito();
    }
    
    public double verMontoTotal(){
        double res;
        res = carrito.getTotal();
        return res;
    }
    
    public String cancelarPedido(){
        String res;
        if(!carrito.esVacio()){
            carrito.vaciarCarrito();
            res = "El pedido ha sido cancelado, todos los productos en el carrito han sido eliminados.";
        }else{
            res = "El pedido ha sido cancelado, no se borro ningun producto, porque el carrito estaba vacio.";
        }
        return res;
    }
    
    public boolean confirmarPedido(){
        boolean res;
        carrito.finalizarPedido();
        res = true;
        return res;
    }
    
    public HashMap<Producto, Integer> verProductosCarrito(){
        HashMap<Producto, Integer> res;
        res = carrito.getProductosCarrito();
        return res;
    }
    
    
}