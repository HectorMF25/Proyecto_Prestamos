package Principal;
import Modelo.Fecha;
import controlador.ControladorClientes;
import controlador.ControladorPrestamos;
import controlador.ControladorSupremo;
import vista.VistaClientes;

//
public class Principal
{
    public static void main(String [] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
           //     ControladorSupremo control = new ControladorSupremo();
                ControladorPrestamos control = new ControladorPrestamos();
            }

        });
    }
}
