package Modelo;

//Si el cliente hiciera un pago por un monto superior a la cuota eso disminuye de mayor manera el saldo del
//préstamo. En dicho caso deberá recalcularse la cuota, considerando el saldo remanente y el plazo restante. Así
//la nueva cuota mensual será menor que antes.

public class Pago { //clase de pago

    private double montoPagar;

    private double interes;

    private double amortizacion;

    private int numeroCuota;

    private Fecha fechaPago;

    public Pago(double montoPagar, double interes, double amortizacion, int numeroCuota, Fecha fechaPago) {
        this.montoPagar = montoPagar;
        this.interes = interes;
        this.amortizacion = amortizacion;
        this.numeroCuota = numeroCuota;
        this.fechaPago = fechaPago;
    }

    public Pago() {
        this.montoPagar = 0;
        this.interes = 0;
        this.amortizacion = 0;
        this.numeroCuota = 0;
        this.fechaPago = null;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public double getInteres() {
        return interes;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public int getNumeroCuota() {
        return numeroCuota;
    }

    public Fecha getFechaPago() {
        return fechaPago;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public void setNumeroCuota(int numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public void setFechaPago(Fecha fechaPago) {
        this.fechaPago = fechaPago;
    }
}
