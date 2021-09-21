package Modelo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Creadora
{
    public List<Cliente> listaC = new ArrayList<>();
    public List<Prestamo> listaPres = new ArrayList<>();
    public List<Pago> listaPag = new ArrayList<>();
    public Creadora()
    {

    }

    public void asignaDatosCliente(int id, String n, String p, String c, String d)
    {
        Cliente cli = new Cliente();
        cli.setCedula(id);
        cli.setNombre(n);
        cli.setProvincia(p);
        cli.setCanton(c);
        cli.setDistrito(d);
        listaC.add(cli);


    }

    public void listarClientes()
    {
        for(Cliente cli : listaC)
        {
            System.out.println(cli.toString());

        }
    }

    public void asignarDatosPrestamo(double m, double in, int p)
    {
        Prestamo prestamo = new Prestamo();
        prestamo.setMonto(m);
        prestamo.setInteres(in);
        prestamo.setPlazo(p);
        listaPres.add(prestamo);
    }

    public void listarPrestamos()
    {
        for(Prestamo prestamo : listaPres)
        {
            System.out.println(prestamo.toString());

        }
    }



}
