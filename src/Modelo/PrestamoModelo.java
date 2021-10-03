package Modelo;

import java.util.ArrayList;
import java.util.List;

public class PrestamoModelo
{
    private List<Prestamo> listaPres;

    public PrestamoModelo() {
        listaPres = new ArrayList<>();
    }

    public void asignarDatosPrestamo(double m, double in, int p, Cliente c) //agregar a la lista
    {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(m);
        prestamo.setInteres(in);
        prestamo.setPlazo(p);
        prestamo.setCliente(c);
        listaPres.add(prestamo);
    }

    public void listarPrestamos()//imprimir lista
    {
        for(Prestamo prestamo : listaPres )
        {
            System.out.println(prestamo.toString());

        }
    }

    public void listarPrestamosPorCliente(String id)
    {
        List<Prestamo> l = new ArrayList<>();
        int flag = 0;
        for (Prestamo prestamo : listaPres )
        {
            if(prestamo.getCliente().getCedula()==id)
            {
                flag = 1;
                l.add(prestamo);
            }
        }
        if(flag ==1) {
            System.out.println("Estos son los prestamos que tiene el cliente");
            for (Prestamo pres : l) {

                System.out.println(pres.toString());
            }
        }
        else
            System.out.println("El usuario ingresado no posee ningun prestamo activo");
    }
}
