package vista;

import java.util.Scanner;

public class VistaPrestamo
{
    private  String textoID;
    private String textoMonto;
    private String textoInteres;
    private String textoPlazo;

    public String getTextoMonto() {
        return textoMonto;
    }

    public void setTextoMonto(String textoMonto) {
        this.textoMonto = textoMonto;
    }

    public String getTextoInteres() {
        return textoInteres;
    }

    public void setTextoInteres(String textoInteres) {
        this.textoInteres = textoInteres;
    }

    public String getTextoPlazo() {
        return textoPlazo;
    }

    public void setTextoPlazo(String textoPlazo) {
        this.textoPlazo = textoPlazo;
    }

    public String getTextoID() {
        return textoID;
    }

    public void setTextoID(String textoID) {
        this.textoID = textoID;
    }

    public void capturaDatosPrestamo()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Prestamos:");
        System.out.println("Ingrese los datos del prestamo:");
        System.out.println("Ingrese el id del prestamo:");
        setTextoID(scanner.nextLine());
        System.out.println("Ingrese el monto:");
        setTextoMonto(scanner.nextLine());

        System.out.println("Ingrese el interes:");
        setTextoInteres(scanner.nextLine());

        System.out.println("Ingrese el plazo:");
        setTextoPlazo(scanner.nextLine());
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
