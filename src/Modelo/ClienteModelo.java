package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ClienteModelo
{

private List<Cliente> listaCli;
    public ClienteModelo() {

        listaCli = new ArrayList<>();
    }

    public void asignaDatosCliente(int id, String n, String p, String c, String d)
    {
        Cliente cli = new Cliente();
        cli.setCedula(id);
        cli.setNombre(n);
        cli.setProvincia(p);
        cli.setCanton(c);
        cli.setDistrito(d);
        listaCli.add(cli);
    }

    public void listarClientes()
    {

        for(Cliente cli : listaCli)
        {

            System.out.println(cli.toString());

        }
    }

    public boolean buscarClienteBool(String id)
    {
        int flag = 0;
        int ID = Integer.parseInt(id);
        for(Cliente cli : listaCli)
        {
            if (ID == cli.getCedula())
            {
                return true;
            }
        }
        if(flag==0)
            return false;
        return false;
    }

    public Cliente buscarClienteID(String id)
    {
        int flag = 0;
        int ID = Integer.parseInt(id);
        for(Cliente cli : listaCli)
        {
            if (ID == cli.getCedula())
            {
                flag = 1;
                return cli;
            }
        }
        if(flag==0)
            return null;

        return null;
    }
}
