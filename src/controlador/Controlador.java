package controlador;
import vista.Vista;
import Modelo.Creadora;

import java.util.Scanner;

public class Controlador
{
    private Creadora creadora;
    private Vista vista;

    public Controlador()
    {
        creadora = new Creadora();
        vista = new Vista();
    }



    public void controladorDeInteracciones()
    {
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

    public void interaccionesPrestamo()
    {
        Scanner scanner = new Scanner(System.in);
        String r = "1";
        while(true)
        {
            try
            {
                vista.capturaDatosPrestamo();

                double m = Double.parseDouble(vista.getTextoMonto());
                double inte = Double.parseDouble(vista.getTextoInteres());
                int p = Integer.parseInt(vista.getTextoPlazo());
                creadora.asignarDatosPrestamo(m, inte, p);
                System.out.println("Desea seguir ingresando prestamos?");
                r = scanner.next();
                if (r.equals("1"))
                {
                    System.out.println("Ok seguimos");
                }
                else
                {
                    creadora.listarPrestamos();
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

                vista.capturaDatosClienete();

                int id = Integer.parseInt(vista.getTextoId());
                String n = vista.getTextoNombre();
                String p = vista.getTextoProvincia();
                String c = vista.getTextoCanton();
                String d = vista.getTextoDistrito();
                    if(n.isBlank())
                    {
                        throw new Exception("El apellido no puede estar vacio");
                    }
                    else
                        {

                        creadora.asignaDatosCliente(id, n, p, c, d);
                        System.out.println("Desea seguir ingresando clientes?");
                        r = scanner.next();
                        if (r.equals("1"))
                        {
                            System.out.println("Ok seguimos");
                        }
                        else
                            {
                            creadora.listarClientes();
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

