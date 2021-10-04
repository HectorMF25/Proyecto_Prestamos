package vista;

import java.util.Scanner;

public class VistaPago {
    //Pago
    private String textoMontoPagar;
   private String textoIdCliente;
   private String textoIndice;

    public String getTextoMontoPagar() {
        return textoMontoPagar;
    }

    public void setTextoMontoPagar(String textoMontoPagar) {
        this.textoMontoPagar = textoMontoPagar;
    }

    public String getTextoIdCliente() {
        return textoIdCliente;
    }

    public void setTextoIdCliente(String textoIdCliente) {
        this.textoIdCliente = textoIdCliente;
    }

    public String getTextoIndice() {
        return textoIndice;
    }

    public void setTextoIndice(String textoIndice) {
        this.textoIndice = textoIndice;
    }

    public void capturaIDCli()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Pagos:");
        System.out.println("Ingrese los datos del pago:");
        System.out.println("Ingrese el id del cliente para cancelar el prestamo:");
        setTextoIdCliente(scanner.nextLine());
    }

    public void capturaIndice()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Pagos:");
        System.out.println("Ingrese el numero de prestamo en la lista:");
        setTextoIndice(scanner.nextLine());
    }

    public void capturaPago()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Pagos:");
        System.out.println("Ingrese la cuota a pagar:");
        setTextoMontoPagar(scanner.nextLine());
    }





    public  void mostrarDatos(String datos)
    {
        System.out.println(datos);
    }

    public  void mostrarErrores(String errores)
    {
        System.out.println("ERROR: "+errores);
    }
}
