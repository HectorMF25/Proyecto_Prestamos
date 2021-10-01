package Principal;
import vista.VistaClientes;

//
public class Principal
{
    public static void main(String [] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                VistaClientes vista = new VistaClientes();
            }

        });
    }
}
