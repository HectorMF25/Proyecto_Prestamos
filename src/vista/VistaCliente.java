package vista;

import java.util.Scanner;

public class VistaCliente
{
    //Cliente
    private String textoId;
    private String textoNombre;
    private String textoProvincia;
    private String textoCanton;
    private String textoDistrito;

    public String getTextoId() {
        return textoId;
    }

    public void setTextoId(String textoId) {
        this.textoId = textoId;
    }

    public String getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(String textoNombre) {
        this.textoNombre = textoNombre;
    }

    public String getTextoProvincia() {
        return textoProvincia;
    }

    public void setTextoProvincia(String textoProvincia) {
        this.textoProvincia = textoProvincia;
    }

    public String getTextoCanton() {
        return textoCanton;
    }

    public void setTextoCanton(String textoCanton) {
        this.textoCanton = textoCanton;
    }

    public String getTextoDistrito() {
        return textoDistrito;
    }

    public void setTextoDistrito(String textoDistrito) {
        this.textoDistrito = textoDistrito;
    }

    public  void capturaDatosClienete()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Prestamos:");
        System.out.println("Ingrese los datos del(a) cliente");
        System.out.println("Introduzca el ID (Se aceptan solo numeros)");
        setTextoId(scanner.nextLine());

        System.out.println("Introduzca el Nombre");
        setTextoNombre(scanner.nextLine());

        System.out.println("Introduzca la provincia a la que pertenece");
        setTextoProvincia(scanner.nextLine());

        System.out.println("Introduzca el canton al que pertenece");
        setTextoCanton(scanner.nextLine());

        System.out.println("Introduzca introduzca el distrito al que pertenece");
        setTextoDistrito(scanner.nextLine());

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
