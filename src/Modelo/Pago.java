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


}
