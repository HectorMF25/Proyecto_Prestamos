package controlador;

import Modelo.*;
import vista.VistaPrestamos;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ControladorPrestamos {
    Prestamo prestamo;
    VistaPrestamos vistaPres;
    PrestamoModelo listaPres;

   public ControladorPrestamos(){
        vistaPres = new VistaPrestamos();
        listaPres = new PrestamoModelo();
        prestamo = null;
        vistaPres.actionCommands();
      // vistaPres.establecerFormatoTablaPrestamos(listaPres);
       // actualizarTablaPrestamos(listaPres.getListaPres());
        vistaPres.addMouseListeners(new ListenerTabla(vistaPres.getjTableprestamos()));
    }


    public void tablaXML() { //me agregara a la lista elementos por defecto
        PagoModelo list1 = new PagoModelo();
        Cliente cli1 = new Cliente("123", "Hector1", "Alajuela", "Alajuela", "Carrizal");
        Prestamo prestamo1 = new Prestamo("123", 1500, 0.05, 4, cli1, list1);

        PagoModelo list2 = new PagoModelo();
        Cliente cli2 = new Cliente("321", "Hector2", "Limon", "Pococí", "Guapiles");
        Prestamo prestamo2 = new Prestamo("321", 6000, 0.10, 6, cli2, list2);

        listaPres.addPrestamo(prestamo2);
        listaPres.addPrestamo(prestamo1);

        JAXBParser parser = new JAXBParser(); //creo la intancia de la clase que me realiza el marshal y unkmarshall
        parser.marshall(listaPres, "Prestamos.xml"); //Me agarra toda la lista y la metera adentro de un archivo
        PrestamoModelo lista2 = (PrestamoModelo) parser.unmarshall(new PrestamoModelo(), "Prestamos.xml");


        System.out.println("imprimiendo datos de la lista (null)");
        lista2.listarPrestamos();

        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(lista2.getListaPres()));
        // tabla.addMouseListener(new ListenerTable(tabla));
        vistaPres.setjTableprestamos(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaPrestamos(pn1);
    }

    public void agregarDatosDefault(){
        PagoModelo list1 = new PagoModelo();
        Cliente cli1 = new Cliente("123", "Hector1", "Alajuela", "Alajuela", "Carrizal");
        Prestamo prestamo1 = new Prestamo("123", 1500, 0.05, 4, cli1, list1);

        //agregandole pagos por default
        prestamo1.agregarPago(423);
        prestamo1.agregarPago(423);
        prestamo1.agregarPago(423);


        PagoModelo list2 = new PagoModelo();
        Cliente cli2 = new Cliente("3210", "Hector2", "Limon", "Pococí", "Guapiles");
        Prestamo prestamo2 = new Prestamo("3210", 6000, 0.10, 6, cli2, list2);

        listaPres.addPrestamo(prestamo2);
        listaPres.addPrestamo(prestamo1);

        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(listaPres.getListaPres()));
       agregarListenerTabla(tabla);
        vistaPres.setjTableprestamos(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaPrestamos(pn1);
    }
    public void agregarListenerTabla(JTable tabla){
       tabla.addMouseListener(new ListenerTabla(tabla));
    }

    public void actualizarDatosPrestamo(){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(listaPres.getListaPres()));
        //tabla.addMouseListener(new ListenerTable(tabla));
        vistaPres.setjTableprestamos(tabla); //se agrego
    }

    public void actualizarTablaPagos(List<Pago> list){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Pagos(list));
        //tabla.addMouseListener(new ListenerTable(tabla));
        vistaPres.setjTableCuotas(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaCuotas(pn1);
    }

    public void actualizarTablaPrestamos(List<Prestamo> list){
        JTable tabla = new JTable();
        tabla.setModel(new JTable_Prestamos(list));
        tabla.addMouseListener(new ListenerTabla(tabla));
        vistaPres.setjTableprestamos(tabla); //se agrego

        JScrollPane pn1 = new JScrollPane(tabla);
        vistaPres.agregarTablaPrestamos(pn1);
    }

    private class ListenerTabla extends MouseAdapter{
        JTable tabla;
        public ListenerTabla(JTable tabla){ //constructor
            this.tabla = tabla;
        }
        @Override
        public void mouseClicked(MouseEvent e) { //listener
            super.mouseClicked(e);
            int fila = tabla.getSelectedRow();
            String idprestamo = (String)tabla.getValueAt(fila,0);
            prestamo = listaPres.retornarPrestamo(idprestamo);
            actualizarTablaPagos(prestamo.getPagoList().getPagoList());
            vistaPres.getjLabelIDPrestamo().setText("-ID: "+prestamo.getId());
            vistaPres.getjLabelCuotaPrestamo().setText("-Cuota: "+prestamo.getCuota());
            vistaPres.getjLabelMontoPrestamo().setText("-Monto: "+prestamo.getMonto());
            vistaPres.getjLabelInteresPrestamo().setText("-Interes: "+prestamo.getInteres());
            vistaPres.getjLabelPlazoPrestamo().setText("-Plazo: "+prestamo.getPlazo()+" meses");
            vistaPres.getjLabelEstadoPrestamo().setText("-Estado: "+prestamo.getEstadoPago());
        }
    }

}
