public class Mensaje extends Thread {
    String[] mensajesAnimo = {
        "¡Tú puedes con todo lo que te propongas!",
        "Cada pequeño paso te acerca más a tu meta.",
        "No te rindas ahora, el esfuerzo de hoy será tu éxito de mañana.",
        "Eres más capaz de lo que imaginas.",
        "¡A por todas! Hoy es un gran día para aprender algo nuevo.",
        "Los errores son solo pruebas de que lo estás intentando.",
        "Confía en ti y sigue programando hacia adelante."

        
    };
    
    public Mensaje(String[] mensajesAnimo){
        this.mensajesAnimo = mensajesAnimo;
    }
    int Aleatorio = (int) (Math.random() * mensajesAnimo.length);


    @Override 
    public void run(){
        System.out.println(mensajesAnimo);
    }
}
