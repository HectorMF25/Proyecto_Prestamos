package controlador;

import Modelo.Cliente;
import Modelo.JTable_Prestamos;
import Modelo.PagoModelo;
import Modelo.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
btnBuscar--->("1");
btnGuardar--->("2");
btnPrestamo--->("3");
btnRealzarPrestamo--->("4")
btnRealizarPago--->("5")
btnRegresoPrincipal--->("6");
*/
public class ControladorSupremo {

    ControladorClientes controlClientes;
    ControladorPrestamos controlPrestamos;

    public ControladorSupremo(){
        controlClientes = new ControladorClientes();
        controlClientes.vistaCliente.addListeners(new ListenersAction());
        controlPrestamos =new ControladorPrestamos();
        controlPrestamos.vistaPres.addListeners(new ListenersAction());
       // controlPrestamos.tablaXML();
       // controlPrestamos.agregarDatosDefault();
        agregarDatosDefaultS();
    }
    public void agregarDatosDefaultS(){
        PagoModelo list1 = new PagoModelo();
        Cliente cli1 = new Cliente("123", "Hector1", "Alajuela", "Alajuela", "Carrizal");
        Prestamo prestamo1 = new Prestamo("1234", 1500, 0.05, 4, cli1, list1);

        //agregandole pagos por default
        prestamo1.agregarPago(423);
        prestamo1.agregarPago(423);
        prestamo1.agregarPago(423);


        PagoModelo list2 = new PagoModelo();
        Cliente cli2 = new Cliente("3210", "Hector2", "Limon", "Pococí", "Guapiles");
        Prestamo prestamo2 = new Prestamo("321", 6000, 0.10, 6, cli2, list2);

        //agregando prestamos
        controlPrestamos.listaPres.addPrestamo(prestamo2);
        controlPrestamos.listaPres.addPrestamo(prestamo1);

        //agregando a los clientes
        controlClientes.listaCliente.addCliente(cli1);
        controlClientes.listaCliente.addCliente(cli2);

       // JTable tabla = new JTable();
       // tabla.setModel(new JTable_Prestamos( controlPrestamos.listaPres.getListaPres()));
      //  controlPrestamos.agregarListenerTabla(tabla);
      //  controlPrestamos.vistaPres.setjTableprestamos(tabla); //se agrego

      //  JScrollPane pn1 = new JScrollPane(tabla);
      //  controlPrestamos.vistaPres.agregarTablaPrestamos(pn1);
    }

    private class ListenersAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int valor =Integer.parseInt(e.getActionCommand());
            switch (valor){
                case 1:{
                    String id =(String) controlClientes.vistaCliente.getjTextFId().getText();
                    try{
                        Cliente cli;
                        if(id.isEmpty()){
                            throw new RuntimeException("ERROR, no se puede buscar una persona\n si el espacio de id esta vacio");
                        }
                        if(controlClientes.listaCliente.buscarClienteBool(id) == false){
                            throw new RuntimeException("RROR, el cliente que se quiere buscar\n NO existe en el registro bancario");
                        }
                        cli =controlClientes.listaCliente.buscarClienteID(id);
                        controlClientes.agregarComboBoxXML(cli.getProvincia()+".xml");
                        controlClientes.vistaCliente.getjTextFNombre().setText(cli.getNombre());
                        controlClientes.vistaCliente.getjTextFProvincia().setText(cli.getProvincia());
                        controlClientes.vistaCliente.colocarCantonComboBox(cli.getCanton());
                        controlClientes.vistaCliente.colocarDistritoComboBox(cli.getDistrito());
                    }catch (RuntimeException re){
                        JOptionPane.showMessageDialog(null,re.getMessage());
                    }
                    break;
                }//Boton de buscar cliente
                case 2:{
                    Cliente cliente = null;
                    String nombre = controlClientes.vistaCliente.getjTextFNombre().getText();
                    String id = controlClientes.vistaCliente.getjTextFId().getText();
                    String provincia = controlClientes.vistaCliente.getjTextFProvincia().getText();
                    String canton = (String)controlClientes.vistaCliente.getjComboCanton().getSelectedItem();
                    String distrito= (String)controlClientes.vistaCliente.getjComboDistrito().getSelectedItem();
                    try{
                        if(nombre.isBlank() || id.isEmpty() || provincia.isEmpty() || provincia.isEmpty()){ //verifica que ningun espacio este en blanco
                            throw new RuntimeException("ERROR, no se puede agregar \nsi hay un campo de texto vacio");
                        }
                        if(controlClientes.listaCliente.buscarClienteBool(id) == true){
                            throw new RuntimeException("ERROR, Ya existe un cliente\n en el registro con el id ingresado");
                        }
                        cliente = new Cliente(id,nombre,provincia,canton,distrito);
                        controlClientes.listaCliente.addCliente(cliente); //agrega un nuevo cliente

                        controlClientes.listaCliente.listarClientes();
                        JOptionPane.showMessageDialog(null, "Se ingreso el cliente al sistema");
                    }catch (RuntimeException rt) {
                        JOptionPane.showMessageDialog(null, rt.getMessage());
                    }
                    break;
                }//Boton de agregar cliente
                case 3:{
                    List<Prestamo> list = new ArrayList<>();
                    String id = controlClientes.vistaCliente.getjTextFId().getText();
                    try {
                        if(controlClientes.listaCliente.buscarClienteBool(id) == false){
                            throw new RuntimeException("Debe de ingresar el id de un cliente que se enceuntre\n en el registro para ver y realizarle prestamos");
                        }
                        if(id.isEmpty()){
                            throw new RuntimeException("Debe de ingresar el id de un cliente que se enceuntre\n en el registro para ver y realizarle prestamos");
                        }
                        controlClientes.cli = controlClientes.listaCliente.buscarClienteID(id);
                        controlPrestamos.listaPres.prestamosCliente(controlClientes.cli,list); //obtengo la lista de prestamos de ese cliente
                        controlPrestamos.actualizarTablaPrestamos(list); //agregamos los clientes a la tabla
                        controlClientes.vistaCliente.setVisible(false);
                        controlPrestamos.vistaPres.setVisible(true);
                        //agregamos los datos del usuario a los labels para que se muestre
                        controlPrestamos.vistaPres.getjLabelNombrePersona().setText("-Nombre: " +controlClientes.cli.getNombre());
                        controlPrestamos.vistaPres.getjLabelIDPersona().setText("-ID:" + controlClientes.cli.getCedula());
                        controlPrestamos.vistaPres.getjLabelProvinciaPersona().setText( "-Provincia: " +controlClientes.cli.getProvincia());
                        controlPrestamos.vistaPres.getjLabelCantonPersona().setText("-Canton: " + controlClientes.cli.getCanton());
                        controlPrestamos.vistaPres.getjLabelDistritoPersona().setText("-Distrito: " + controlClientes.cli.getDistrito());
                    }catch (RuntimeException tr){
                        JOptionPane.showMessageDialog(null,tr.getMessage());
                    }
                    break;
                }//Boton de abrir ventna de prestamos
                case 4: {
                    Prestamo prest = null;
                    PagoModelo listaPago = new PagoModelo();
                    String idPrestamo =(String) controlPrestamos.vistaPres.getjTextFIdPre().getText();
                    String montoPrestamo =(String) controlPrestamos.vistaPres.getjTextFMonto().getText();
                    String interes = (String)controlPrestamos.vistaPres.getjTextFInteres().getText();
                    String plazo =(String) controlPrestamos.vistaPres.getjTextFPlazo().getText();

                    Cliente cli = controlClientes.cli;
                    try{
                        if(idPrestamo.isBlank() || montoPrestamo.isBlank() || interes.isBlank() || plazo.isBlank()){ //verifica que ningun espacio este en blanco
                            throw new RuntimeException("ERROR, no se puede agregar un prestamo al cliente \nsi hay un campo de texto vacio");
                        }
                        double montoPres = Double.parseDouble(montoPrestamo);
                        double interesPres = Double.parseDouble(interes);
                        int plazoPres = Integer.parseInt(plazo);
                        if(controlPrestamos.listaPres.buscarPrestamo(idPrestamo)){
                            throw new RuntimeException("ERROR, el id ingresado ya es existente en otro prestamo\nporfavor digite uno distinto");
                        }
                        if(montoPres == 0 || montoPres<0){
                            throw new RuntimeException("ERROR, el monto ingresado no es valido\n prueba con valores mayores a 500");
                        }
                        if(montoPres < 500){
                            throw new RuntimeException("ERROR, el monto minimo de un prestamo es de 500");
                        }
                        if(interesPres > 0.9 || interesPres <0){
                            throw new RuntimeException("ERROR, interes debe de ser menor a 1 y mayor igual a 0\n ejm: 0.9, 0.0, 0.05");
                        }
                        if(plazoPres<0){
                            throw new RuntimeException("ERROR, el plazo debe de ser mayor o igual a 1");
                        }
                        //creo el prestamo y lo agrego a la lista
                        prest = new Prestamo(idPrestamo,montoPres,interesPres,plazoPres,cli,listaPago);
                        controlPrestamos.listaPres.addPrestamo(prest);
                        JOptionPane.showMessageDialog(null, "Se realizo un nuevo prestamo con exito");
                        controlPrestamos.actualizarTablaPrestamos(controlPrestamos.listaPres.getListaPres());
                        //creo la lista de prestamos del cliente nuevamente para cargarla al jTable
                        List<Prestamo> list = new ArrayList<>();
                        controlPrestamos.listaPres.prestamosCliente(cli,list); //obtengo la lista de prestamos de ese cliente
                        controlPrestamos.actualizarTablaPrestamos(list);
                    }catch (RuntimeException rt) {
                        JOptionPane.showMessageDialog(null, rt.getMessage());
                    }
                    break;}//boton para agregar un nuevo prestamo
                case 5: {
                    List<Prestamo> list = new ArrayList<>();
                    String pag = (String)controlPrestamos.vistaPres.getjTextFPago().getText();
                    try {
                        if(pag.isEmpty()){
                            throw new RuntimeException("Debe de colocar un monto a pagar en la casilla");
                        }
                        double pago = Double.parseDouble(pag);
                        controlPrestamos.prestamo.agregarPago(pago);
                       controlPrestamos.actualizarTablaPagos(controlPrestamos.prestamo.getPagoList().getPagoList());
                       controlPrestamos.listaPres.prestamosCliente(controlClientes.cli,list);
                       controlPrestamos.actualizarTablaPrestamos(list);

                    }catch (RuntimeException rt){
                        JOptionPane.showMessageDialog(null,rt.getMessage());
                    }
                    break;
                }//Boton de realizar pago a prestamo
                case 6: {
                    System.out.println("entro al boton regresar");
                    controlPrestamos.vistaPres.setVisible(false);
                    controlClientes.vistaCliente.setVisible(true);
                    break;
                }//boton para regrear a la ventana principal
            }
        }
    }
}
