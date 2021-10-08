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

    public PagoModelo() {
        pagoList = new ArrayList<>();
    }

    public void asignarDatosPago(Pago obj)
    {
        pagoList.add(obj);
    }

    public int numeroPagos(){
       return pagoList.size();
    }

    public void imprimir(){
        if(pagoList.size()==0){
            System.out.println("No hay pagos aun\n");
        }else {
            for (Pago pago : pagoList) {
                System.out.println("Pago=");
                pago.toStringPago(); System.out.println();
            }
        }
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }
}