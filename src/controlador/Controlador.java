package controlador;
import Modelo.*;
import vista.VistaPago;
import vista.VistaCliente;
import vista.VistaPrestamo;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.round;

public class Controlador
{
    //private Creadora creadora;

    private ClienteModelo clienteModelo;
    private PrestamoModelo prestamoModelo;
    private PagoModelo pagoModelo;
    private VistaCliente vistaCliente;
    private VistaPrestamo vistaPrestamo;
    private VistaPago vistaPago;

    public Controlador()
    {
        clienteModelo = new ClienteModelo();
        prestamoModelo = new PrestamoModelo();
        pagoModelo = new PagoModelo();
        vistaCliente = new VistaCliente();
        vistaPrestamo = new VistaPrestamo();
        vistaPago = new VistaPago();
    }



    public void controladorDeInteracciones() throws IOException {
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
                    case 3:
                        pago();
                        break;
                    case 4:
                        generarReporteClientes();
                        break;
                    case 5:
                        generarReportePagos();
                        break;
                    default:
                        System.out.println("Opcion invalida, saliendo...");
                }
            }
    }

    public void pago()
    {
        Scanner scanner = new Scanner(System.in);
        String r = "1";
        while (true)
        {
            try
            {
                vistaPago.capturaIDCli();
                String id = vistaPago.getTextoIdCliente();

                System.out.println("Estos son los prestamos del cliente:");
                prestamoModelo.listarPrestamosPorCliente(id);

                vistaPago.capturaIndice();
                String indice = vistaPago.getTextoIndice();

                prestamoModelo.imprimePrestamo(indice);
                Prestamo p = prestamoModelo.devuelvePrestamo(indice);
                System.out.println("Esta es la cuota del prestamo por mes:"+ Math.round(p.getCuota()));
                System.out.println("Desea ingresar automaticamente el pago sugerido o prefiere ingresarlo por su cuenta?");
                String d = scanner.nextLine();
                if(d.equals("1"))
                {
                    pagoModelo.pagar(p, p.getCuota());
                    prestamoModelo.imprimeDatosPagoInteres(indice);
                    prestamoModelo.imprimeDatosPagoAmort(indice);
                }
                else
                {
                    vistaPago.capturaPago();
                    double pago = Double.parseDouble(vistaPago.getTextoMontoPagar());
                    pagoModelo.pagar(p, pago);
                    prestamoModelo.imprimeDatosPagoInteres(indice);
                    prestamoModelo.imprimeDatosPagoAmort(indice);
                }
                System.out.println("Desea seguir haciendo pagos?");
                r = scanner.nextLine();
                if (r.equals("1"))
                {
                    System.out.println("Ok seguimos");

                }
                else
                {
                    prestamoModelo.listaPagosdePrestamo();
                    break;
                }


            } catch (Exception e) {
                vistaPago.mostrarErrores(e.getMessage());
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
                String ID = vistaPrestamo.getTextoID();
                double m = Double.parseDouble(vistaPrestamo.getTextoMonto());
                double inte = Double.parseDouble(vistaPrestamo.getTextoInteres());
                int p = Integer.parseInt(vistaPrestamo.getTextoPlazo());
                System.out.println("Estos son los datos de los clientes:");
                //creadora.listarClientes();
                clienteModelo.listarClientes();
                System.out.println("Ahora escoja un cliente por id para asignarlo al prestamo:");
                String id = scanner.nextLine();
                //creadora.asignarDatosPrestamo(m, inte, p, creadora.buscarClienteID(id));
                prestamoModelo.asignarDatosPrestamo(ID, m, inte, p, clienteModelo.buscarClienteID(id));
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
                vistaPrestamo.mostrarErrores("Solo de aceptan numeros!");
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
                vistaCliente.mostrarErrores("El id solo acepta numeros!");
            }
            catch (Exception e)
            {
                vistaCliente.mostrarErrores(e.getMessage());
            }

        }
    }

    public void generarReporteClientes() throws IOException {
        clienteModelo.generarregistroClientes();
    }

    public void generarReportePagos() throws IOException {
        prestamoModelo.generarRegistrodePagosXPrest();
    }
}

