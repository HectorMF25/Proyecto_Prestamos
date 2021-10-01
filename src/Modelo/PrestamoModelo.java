package Modelo;

import java.util.ArrayList;
import java.util.List;

public class PrestamoModelo
{
    private ListClass listClass;

    public PrestamoModelo() {
        listClass = new ListClass();
    }

    public void asignarDatosPrestamo(double m, double in, int p, Cliente c)
    {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(m);
        prestamo.setInteres(in);
        prestamo.setPlazo(p);
        prestamo.setCliente(c);
        listClass.getListaPres().add(prestamo);
    }

    public void listarPrestamos()
    {
        for(Prestamo prestamo : listClass.getListaPres())
        {
            System.out.println(prestamo.toString());

        }
    }

    public void listarPrestamosPorCliente(String id)
    {
        List<Prestamo> l = new ArrayList<>();
        int flag = 0;
        int ID = Integer.parseInt(id);
        for (Prestamo prestamo : listClass.getListaPres())
        {
            if(prestamo.getCliente().getCedula()==ID)
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
