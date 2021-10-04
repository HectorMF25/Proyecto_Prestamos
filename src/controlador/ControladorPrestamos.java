package controlador;

import Modelo.Cliente;
import Modelo.JTable_Prestamos;
import Modelo.Prestamo;
import Modelo.PrestamoModelo;
import vista.VistaPrestamos;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.util.List;

public class ControladorPrestamos {
    VistaPrestamos vistaPres;
    PrestamoModelo listaPres;

   public ControladorPrestamos(){
        vistaPres = new VistaPrestamos();
        listaPres = new PrestamoModelo();
       vistaPres.establecerFormatoTablaPrestamos(listaPres);

       //prueba para agregar un elemento
       listaPres.getListaPres().add(new Prestamo(0,0,1,new Cliente(),null,"123"));
      //  actualizarDatosPrestamo();
       actualizarTabla(listaPres.getListaPres());

    }

    public void actualizarDatosPrestamo(){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(listaPres.getListaPres()));
        //tabla.addMouseListener(new ListenerTable(tabla));
        vistaPres.setjTableprestamos(tabla); //se agrego
    }

    public void actualizarTabla(List<Prestamo> list){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(list));
        //tabla.addMouseListener(new ListenerTable(tabla));
        vistaPres.setjTableprestamos(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaPrestamos(pn1);
    }
}
