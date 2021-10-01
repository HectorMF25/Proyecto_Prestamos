package vista;

import java.util.Scanner;

public class VistaPago {
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





    public  void mostrarDatos(String datos)
    {
        System.out.println(datos);
    }

    public  void mostrarErrores(String errores)
    {
        System.out.println("ERROR: "+errores);
    }
}
