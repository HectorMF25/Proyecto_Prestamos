package vista;

import java.util.Scanner;

public class Vista {
    //Cliente
    private String textoId;
    private String textoNombre;
    private String textoProvincia;
    private String textoCanton;
    private String textoDistrito;

    //Prestamo
    private String textoMonto;
    private String textoInteres;
    private String textoPlazo;

    //Pago
    private String textoMontoPagar;
    private String textoInteresPago;
    private String textoAmortizacion;
    private String textoNumeroCuota;

    public String getTextoMontoPagar() {
        return textoMontoPagar;
    }

    public void setTextoMontoPagar(String textoMontoPagar) {
        this.textoMontoPagar = textoMontoPagar;
    }

    public String getTextoInteresPago() {
        return textoInteresPago;
    }

    public void setTextoInteresPago(String textoInteresPago) {
        this.textoInteresPago = textoInteresPago;
    }

    public String getTextoAmortizacion() {
        return textoAmortizacion;
    }

    public void setTextoAmortizacion(String textoAmortizacion) {
        this.textoAmortizacion = textoAmortizacion;
    }

    public String getTextoNumeroCuota() {
        return textoNumeroCuota;
    }

    public void setTextoNumeroCuota(String textoNumeroCuota) {
        this.textoNumeroCuota = textoNumeroCuota;
    }

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

    public void capturaDatosPago()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Prestamos:");
        System.out.println("Ingrese los datos del pago:");
        System.out.println("Ingrese el monto a pagar:");
        setTextoMontoPagar(scanner.nextLine());

        System.out.println("Ingrese el interes del pago:");
        setTextoInteresPago(scanner.nextLine());

        System.out.println("Ingrese el monto la amortizacion del pago:");
        setTextoAmortizacion(scanner.nextLine());

        System.out.println("Ingrese el numero de cuota:");
        setTextoNumeroCuota(scanner.nextLine());
    }

    public void capturaDatosPrestamo()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido(a) al Sistema de Prestamos:");
        System.out.println("Ingrese los datos del prestamo:");
        System.out.println("Ingrese el monto:");
        setTextoMonto(scanner.nextLine());

        System.out.println("Ingrese el interes:");
        setTextoInteres(scanner.nextLine());

        System.out.println("Ingrese el plazo:");
        setTextoPlazo(scanner.nextLine());
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
