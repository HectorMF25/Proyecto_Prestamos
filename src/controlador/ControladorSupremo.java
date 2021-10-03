package controlador;

import Modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
btnBuscar--->("1");
btnGuardar--->("2");
btnPrestamo--->("3");
*/
public class ControladorSupremo {

    ControladorClientes controlClientes;

    public ControladorSupremo(){
        controlClientes = new ControladorClientes();
        controlClientes.vistaCliente.addListeners(new ListenersAction());
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
                        controlClientes.vistaCliente.getjTextFNombre().setText(cli.getNombre());
                        controlClientes.vistaCliente.getjTextFProvincia().setText(cli.getProvincia());
                        controlClientes.agregarComboBoxXML(cli.getProvincia()+".xml");
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
                    }catch (RuntimeException rt){
                        JOptionPane.showMessageDialog(null,rt.getMessage());
                    }
                    JOptionPane.showMessageDialog(null, "Se ingreso el cliente al sistema");
                    break;
                }//Boton de agregar cliente
                case 3:{

                }//Boton de abrir ventna de prestamos
            }
        }
    }
}
