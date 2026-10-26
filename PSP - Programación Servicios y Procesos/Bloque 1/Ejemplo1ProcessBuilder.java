public class Ejemplo1ProcessBuilder {
    public static void main(String[] args) {
        try {

            



            // Los programas nativos de windows no necesitan ruta completa

            // Ejecutar la Calculadora de Windows
            ProcessBuilder calculadora = new ProcessBuilder("calc");
          //   calculadora.start();
            Process calc = calculadora.start();
            // Esperar un momento para asegurarnos de que la calculadora se abra completamente
            Thread.sleep(2000);

            // Ejecutar el bloc de notas de Windows
            ProcessBuilder bloc_notas = new ProcessBuilder("notepad");
         //    bloc_notas.start();
            Process bloc = bloc_notas.start();
            // Esperar un momentos para asegurarnos de que el  Bloc de notas se abra completamente
            Thread.sleep(2000);

            // Ejecutar Paint de Windows
            ProcessBuilder paint = new ProcessBuilder("mspaint");
          //  paint.start();
            Process paintclose = paint.start();
            // Esperar paint de windows que se abra completamente
            Thread.sleep(2000);

            // Ejecutar netbeans en Windows
            ProcessBuilder netbeans = new ProcessBuilder("C:\\Program Files\\NetBeans-23\\netbeans\\bin\\netbeans64.exe");
         //   netbeans.start();
            Process Netbeans = netbeans.start();
            Thread.sleep(5000);

            calc.destroyForcibly();

             Thread.sleep(2000);

            bloc.destroyForcibly();

            Thread.sleep(2000);

            paintclose.destroyForcibly();

            Thread.sleep(2000);

            Netbeans.destroy();
            
        } catch (Exception e) {
            
        }
    }
}
