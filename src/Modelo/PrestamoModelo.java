package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class PrestamoModelo
{

private List<Prestamo> listPrestamo;


    public PrestamoModelo() {

    listPrestamo = new ArrayList<>();
    }

    public void asignarDatosPrestamo(double m, double in, double p, Cliente c)
    {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(m);
        prestamo.setInteres((in/100));
        prestamo.setPlazo(p);
        prestamo.setSaldo(m);
        prestamo.setCliente(c);
        double cuota = (prestamo.getSaldo() * prestamo.getInteres()) / (1 - (pow((1 + prestamo.getInteres()), -prestamo.getPlazo())));
        prestamo.setCuota(cuota);
        listPrestamo.add(prestamo);
    }

    public Prestamo devuelvePrestamo(String i)
    {
        int ind = Integer.parseInt(i);
        int flag = 0;
        for(Prestamo prestamo : listPrestamo)
        {
            if((ind-1) == listPrestamo.indexOf(prestamo))
            {
                flag =1;
                return prestamo;
            }
        }
        if(flag==0)
            return null;
        return null;
    }

    public void imprimePrestamo(String i)
    {
        int ind = Integer.parseInt(i);
        int flag = 0;
        for(Prestamo prestamo : listPrestamo)
        {
            if((ind-1) == listPrestamo.indexOf(prestamo))
            {
                flag =1;
                System.out.println("Numero en lista: "+(1+listPrestamo.indexOf(prestamo)));
                System.out.println(prestamo.toString());
            }
        }
        if(flag==0)
            System.out.println("Prestamo no encontrado");
    }

    public void listarPrestamos()
    {

        for(Prestamo prestamo : listPrestamo)
        {
            System.out.println(prestamo.toString());

        }
    }

    public List<Prestamo> devuelvePrestamos()
    {
        return listPrestamo;
    }

   public void listarPrestamosPorCliente(String id)
    {
        int flag = 0;
        int ID = Integer.parseInt(id);
        for (Prestamo prestamo : listPrestamo)
        {
            if(prestamo.getCliente().getCedula()==ID)
            {
                flag = 1;
                System.out.println("Numero en lista: "+(1+listPrestamo.indexOf(prestamo)));
                System.out.println(prestamo.toString());

            }
        }
        if(flag ==0)
            System.out.println("El usuario ingresado no posee ningun prestamo activo");
    }


    public void imprimeDatosPagoInteres(String index)
    {
        Iterator<Pago> p ;

        int i = Integer.parseInt(index);
        for(Prestamo prestamo : listPrestamo)
            if((i-1)==listPrestamo.indexOf(prestamo))
            {
                p = prestamo.getPagoList().iterator();
                while (p.hasNext())
                {

                        System.out.println("Este es el porcentanje del pago destinado a los intereses: "
                                + p.next().getMontoInteres());
                        break;

                }
            }

    }

    public void imprimeDatosPagoAmort(String index)
{
    Iterator<Pago> p ;

    int i = Integer.parseInt(index);
    for(Prestamo prestamo : listPrestamo)
        if((i-1)==listPrestamo.indexOf(prestamo))
        {
            p = prestamo.getPagoList().iterator();
            while (p.hasNext())
            {

                System.out.println("Este es el porcentaje destinado a la amortizacion: "
                                + Math.round(p.next().getAmortizacion()));
                break;
            }
        }

}



}
