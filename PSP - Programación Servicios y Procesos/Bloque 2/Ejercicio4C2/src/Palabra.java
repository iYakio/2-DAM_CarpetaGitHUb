public class Palabra extends Thread {
    private String palabra;

    public Palabra(String palabra){
        this.palabra = palabra;
    }


    public String getPalabra(){
        return palabra;
    }

    public void setPalabra(String palabra){
        this.palabra = palabra;
    }

    public void run(){
        System.out.println(palabra);
    }

}
