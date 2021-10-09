package Principal;
import controlador.Controlador;

import java.io.IOException;

public class Principal
{
    public static void main(String [] args) throws IOException {
        Controlador controlador = new Controlador();
        controlador.controladorDeInteracciones();
    }
}
