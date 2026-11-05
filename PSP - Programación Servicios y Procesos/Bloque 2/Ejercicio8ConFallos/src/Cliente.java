public class Cliente extends Thread {
    int num = 1;
    private String nombreCliente = "";
    Almacen a;


    public Cliente(String nombreCliente, Almacen al){
        this.nombreCliente = nombreCliente;
        this.a = al;
    }


    public void run(){
        while (true) {
            productoID = "Producto " + num + " de " + nombreCliente;
            this.a.insertarProducto(productoID);
            num++;
        }
    }
}
