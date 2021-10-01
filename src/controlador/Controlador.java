package controlador;
import Modelo.ClienteModelo;
import Modelo.PrestamoModelo;
import vista.VistaPago;
import vista.VistaCliente;
import vista.VistaPrestamo;

import java.util.Scanner;

public class Controlador
{
    //private Creadora creadora;

    private ClienteModelo clienteModelo;
    private PrestamoModelo prestamoModelo;
    private VistaCliente vistaCliente;
    private VistaPrestamo vistaPrestamo;
    private VistaPago vista;

    public Controlador()
    {
        clienteModelo = new ClienteModelo();
        prestamoModelo = new PrestamoModelo();
        vistaCliente = new VistaCliente();
        vistaPrestamo = new VistaPrestamo();
      //  creadora = new Creadora();
        vista = new VistaPago();
    }



    public void controladorDeInteracciones()
    {
        while(true){
        int opcion, r;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite una opcion");
        opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        interaccionesCliente();
                        break;
                    case 2:
                        interaccionesPrestamo();
                        break;
                    default:
                        System.out.println("Opcion invalida, saliendo...");
                }
            }
    }

    public void interaccionesPrestamo()
    {
        Scanner scanner = new Scanner(System.in);
        String r = "1";
        while(true)
        {
            try
            {
                //vista.capturaDatosPrestamo();
                vistaPrestamo.capturaDatosPrestamo();
                double m = Double.parseDouble(vistaPrestamo.getTextoMonto());
                double inte = Double.parseDouble(vistaPrestamo.getTextoInteres());
                int p = Integer.parseInt(vistaPrestamo.getTextoPlazo());
                System.out.println("Estos son los datos de los clientes:");
                //creadora.listarClientes();
                clienteModelo.listarClientes();
                System.out.println("Ahora escoja un cliente por id para asignarlo al prestamo:");
                String id = scanner.nextLine();
                //creadora.asignarDatosPrestamo(m, inte, p, creadora.buscarClienteID(id));
                prestamoModelo.asignarDatosPrestamo(m, inte, p, clienteModelo.buscarClienteID(id));
                System.out.println("Desea seguir ingresando prestamos?");
                r = scanner.nextLine();
                if (r.equals("1"))
                {
                    System.out.println("Ok seguimos");
                }
                else
                {
                    //creadora.listarPrestamos();
                    prestamoModelo.listarPrestamos();
                    break;
                }
            }
            catch (NumberFormatException e) {
                vista.mostrarErrores("Solo de aceptan numeros!");
            }
        }
    }

    public void interaccionesCliente()
    {
        Scanner scanner = new Scanner(System.in);
        String r = "1";
        while(true)
        {
            try
            {

                vistaCliente.capturaDatosClienete();

                int id = Integer.parseInt(vistaCliente.getTextoId());
                String n = vistaCliente.getTextoNombre();
                String p = vistaCliente.getTextoProvincia();
                String c = vistaCliente.getTextoCanton();
                String d = vistaCliente.getTextoDistrito();
                    if(n.isBlank())
                    {
                        throw new Exception("El apellido no puede estar vacio");
                    }
                    else
                        {

                        //creadora.asignaDatosCliente(id, n, p, c, d);
                            clienteModelo.asignaDatosCliente(id, n, p, c, d);
                            System.out.println("Desea seguir ingresando clientes?");
                        r = scanner.next();
                        if (r.equals("1"))
                        {
                            System.out.println("Ok seguimos");
                        }
                        else
                            {

                            //creadora.listarClientes();
                            clienteModelo.listarClientes();
                                break;
                            }
                        }
            }
            catch (NumberFormatException exception) {
                vista.mostrarErrores("El id solo acepta numeros!");
            }
            catch (Exception e)
            {
                vista.mostrarErrores(e.getMessage());
            }

        }
    }
}

