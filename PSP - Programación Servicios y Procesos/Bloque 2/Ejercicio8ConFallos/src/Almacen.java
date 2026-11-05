public class Almacen {
    private String[] almacen;
    private int contador;



    public Almacen(){
        this.almacen = new String[10];
        this.contador = 0;
    }

        // esto es una sección critica es decir creemos que va a dar fallo
    public void insertarProducto(String productoID){
        if (this.contador <= 9) {
            this.almacen[this.contador] = productoID;
            this.contador++;
        }
    }

        // esto es una sección critica es decir creemos que va a dar fallo
        public void eliminarProducto(){
            if (this.contador > 0) {
                this.contador--;
                System.out.println("Se ha eliminado el " + this.almacen);
                this.almacen[this.contador] = null;
            }
        }
   
}
