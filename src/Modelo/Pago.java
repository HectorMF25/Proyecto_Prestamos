package Modelo;

//Si el cliente hiciera un pago por un monto superior a la cuota eso disminuye de mayor manera el saldo del
//préstamo. En dicho caso deberá recalcularse la cuota, considerando el saldo remanente y el plazo restante. Así
//la nueva cuota mensual será menor que antes.

import java.util.Date;

import java.util.Date;

public class Pago { //clase de pago

    private double montoPagar;

    private double montoInteres;

    private double amortizacion;

    private int numeroCuota;

    private Fecha fecha;

    public Pago()
    {
    }


    public Pago(double montoPagar, double montoInteres, double amortizacion, int numeroCuota, Fecha fec) {
        this.montoPagar = montoPagar;
        this.montoInteres = montoInteres;
        this.amortizacion = amortizacion;
        this.numeroCuota = numeroCuota;
        fecha = fec;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public double getMontoInteres() {
        return montoInteres;
    }

    public void setMontoInteres(double montoInteres) {
        this.montoInteres = montoInteres;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public void setFecha(Fecha obj){
        fecha = obj;
    }
    public String getFechaPago() {
        return fecha.getFechaString();
    }

    public String getHoraPago(){return fecha.getHoraString();}

    public void toStringPago() {
            System.out.println("Pago{" +
                "fecha= " + getFechaPago() +
                ", montoPagar=" + montoPagar +
                ", interes=" + montoInteres +
                ", amortizacion=" + amortizacion +
                ", numeroCuota=" + numeroCuota +
                '}');
    }
}
