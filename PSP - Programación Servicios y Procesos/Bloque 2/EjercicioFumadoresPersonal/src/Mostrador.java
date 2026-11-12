public class Mostrador {
    // Ingredientes 0 = cerillas, 1 = tabaco, 2 = papel
    private static final String[] Suministros = {"cerillas", "tabaco", "papel"};
    // Cada lugar en el array es un número por lo cual cerillas es 0, tabaco es 1 y papel es 2

    // Valor	Qué hay en el mostrador	Quién puede servirse
    // -1	nada (vacío)	nadie
    // 0	tabaco y papel	fumador 1 (tiene cerillas)
    // 1	cerillas y papel	fumador 2 (tiene tabaco)
    // 2	cerillas y tabaco	fumador 3 (tiene papel)
    
    private int ingredienteQueFalta = -1;

    // El estanquero coloca 2 ingredientes al azar (equivale a elegir el cuál NO colocar )
    public synchronized void colocarIngredientes(){
        // Espera a que el mostrador esté libre
        try {
            wait();
        } catch (Exception e) {
            // TODO: handle exception
        }

        
    }
}
