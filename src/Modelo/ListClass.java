package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ListClass
{
    public List<Cliente> listaC = new ArrayList<>();
    public List<Prestamo> listaPres = new ArrayList<>();
    public List<Pago> listaPag = new ArrayList<>();



    public ListClass()
    {
        listaC = new ArrayList<>();
        listaPres = new ArrayList<>();
        listaPag = new ArrayList<>();
    }


    public List<Cliente> getListaC() {
        return listaC;
    }

    public void setListaC(List<Cliente> listaC) {
        this.listaC = listaC;
    }

    public List<Prestamo> getListaPres() {
        return listaPres;
    }

    public void setListaPres(List<Prestamo> listaPres) {
        this.listaPres = listaPres;
    }

    public List<Pago> getListaPag() {
        return listaPag;
    }

    public void setListaPag(List<Pago> listaPag) {
        this.listaPag = listaPag;
    }
}
