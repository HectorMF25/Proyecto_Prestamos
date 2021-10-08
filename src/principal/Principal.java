package Principal;
import Modelo.*;
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

                ControladorSupremo control = new ControladorSupremo();

               // ControladorPrestamos control = new ControladorPrestamos();


            /*    PagoModelo listaPagos = new PagoModelo();
                Cliente cli = new Cliente("123","Hctor","Alauela","Alajuelita","Bosque Encantado");
                Prestamo prestamo = new Prestamo("123",1500,0.10,4,cli,listaPagos);
               System.out.println(prestamo.toString());

               System.out.println("\nRealizando primer pago: ");
               prestamo.agregarPago(473);
                System.out.println(prestamo.toString());

                System.out.println("\nRealizando segundo pago: ");
                prestamo.agregarPago(1000);
                System.out.println(prestamo.toString());

                 System.out.println("\nRealizando tercer pago: ");
                  prestamo.agregarPago(170.0);
                 System.out.println(prestamo.toString());

                System.out.println("\nRealizando tercer pago: ");
                prestamo.agregarPago(170.0);
                System.out.println(prestamo.toString());

*/


            }

        });
    }
}
