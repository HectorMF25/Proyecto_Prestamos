package Principal;
import controlador.ControladorClientes;
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
                ControladorSupremo control = new ControladorSupremo();
            }

        });
    }
}
