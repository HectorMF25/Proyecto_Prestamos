package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class PagoModelo
{
    List<Pago> pagoList;
    PrestamoModelo pres;
    public PagoModelo() {
        pagoList = new ArrayList<>();
    }

    public Pago asignarDatosPago(double cuota, double mInteres, double amort, int numC)
    {
        Object fecha = new Date();
        Pago pago = new Pago();
        pago.setFecha(fecha);
        pago.setMontoPagar(cuota);
        pago.setMontoInteres(mInteres);
        pago.setAmortizacion(amort);
        pago.setNumeroCuota(numC);
        return  pago;
    }

    public void pagar(Prestamo prestamo, double pago)
    {

        prestamo.setPagoList(pagoList);
        double cuota = 0;
        double pagoInteres = 0;
        double pagoAmortizacion = 0;
        int numCuota = 0;
        double saldo = 0;
        if(Math.round(prestamo.getSaldo())==0)
        {
            System.out.println("A esta lista ya se le han agregado los pagos correspondientes");
        }
        else
        {
            cuota = prestamo.getCuota();
            pagoInteres = prestamo.getSaldo() * prestamo.getInteres();
            pagoAmortizacion = pago - pagoInteres;
            if(prestamo.getPagoList().isEmpty())
                numCuota = 1;
            else
                numCuota = prestamo.getPagoList().size()+1;
            if(pago< prestamo.getCuota())
            {
                System.out.println("Imposible realizar el pago porque es una cantidad menor a la solicitada");
            }
            if(pago==cuota)
            {
                prestamo.getPagoList().add(asignarDatosPago(pago, pagoInteres, pagoAmortizacion, numCuota));
                /*if(prestamo.getPlazo()==numCuota)
                    prestamo.setSaldo(0);
                else*/
                {
                    saldo = prestamo.getSaldo() - pagoAmortizacion;
                    prestamo.setSaldo(saldo);
                }
            }
            if(pago>cuota)
            {
                prestamo.getPagoList().add(asignarDatosPago(pago, pagoInteres, pagoAmortizacion, numCuota));
                saldo = prestamo.getSaldo() - pagoAmortizacion;
                prestamo.setSaldo(saldo);
                cuota = (prestamo.getSaldo() * prestamo.getInteres()) / (1 - (pow((1 + prestamo.getInteres()), -(prestamo.getPlazo()-numCuota))));
                prestamo.setCuota(cuota);
            }
        }
    }

}
