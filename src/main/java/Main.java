import modelo.Alcancia;
import vista.VistaAlcancia;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Alcancia alcancia = Alcancia.getInstance();
        VistaAlcancia vistaAlcancia = new VistaAlcancia();
        vistaAlcancia.run();
    }
}
