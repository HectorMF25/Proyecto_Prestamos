package vista;

import Modelo.JTable_Prestamos;
import Modelo.PrestamoModelo;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class VistaPrestamos extends JFrame{

    JPanel panelSuperior = new JPanel();
    JPanel panelInferior = new JPanel();
    JTable jTableprestamos, jTableCuotas; //tablas que mostraran los prestamos y los pagos de cadaa prestamo
    JButton btnPago;
    JTextField jTextFMonto, numeroCuota;
    JLabel jLabelPrestamoCliente, jLabelCuotasPrestamo;

    public VistaPrestamos(){

        setVisible(true);

        setTitle("Prestamos clientes");

        setBounds(100, 25, 950, 730);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // setResizable(false);

        this.instantiateComponents();
        this.addComponents();
    }

    public void instantiateComponents(){
        btnPago = new JButton("Agregar Pago");

        jTableprestamos = new JTable();

        jTableCuotas = new JTable();

        String t = "              ";
        jLabelPrestamoCliente = new JLabel(t+t+t+t+t+t+t+"Prestamos del cliente");

        jLabelCuotasPrestamo = new JLabel("Cuotas del prestamo seleccionado");
    }

    public void addComponents(){
        this.getContentPane().setLayout(new GridLayout(2,0));
        JPanel norte = new JPanel();
        JPanel sur = new JPanel();
        norte.setLayout(new BorderLayout());

        //Agregamos en la parte superior
        norte.add(jLabelPrestamoCliente, BorderLayout.NORTH);
        norte.add(panelSuperior,BorderLayout.CENTER);

        //agregamos a la parte inferior
        sur.add(jLabelCuotasPrestamo,BorderLayout.NORTH);
        sur.add(panelInferior,BorderLayout.CENTER);
        //agregamos al panel principal
        this.getContentPane().add(norte);
        this.getContentPane().add(norte);
    }

    public void establecerFormatoTablaPrestamos(PrestamoModelo listD){
            jTableprestamos.setModel(new JTable_Prestamos(listD.getListaPres()));
    }

    public void agregarTablaPrestamos(JScrollPane sp){ //este metodo me quita la tabla actual y coloca la nueva en el scrollPanel
        if(panelSuperior.getComponentCount() > 0){
            panelSuperior.remove(0); //remuevo all lo que hay en el panel(en este caso la tabla)
        }
        panelSuperior.add(sp); //agrego el scrollPane al panelCentral
        panelSuperior.validate(); //le pido al JPanel que se vuelva a validar para que se repinte nuevamente
    }

    public void agregarTablaCuotas(JScrollPane sp){ //este metodo me quita la tabla actual y coloca la nueva en el scrollPanel
        if(panelInferior.getComponentCount() > 0){
            panelInferior.remove(0); //remuevo all lo que hay en el panel(en este caso la tabla)
        }
        panelInferior.add(sp); //agrego el scrollPane al panelCentral
        panelInferior.validate(); //le pido al JPanel que se vuelva a validar para que se repinte nuevamente
    }

    public void setjTableprestamos(JTable jTableprestamos) {
        this.jTableprestamos = jTableprestamos;
    }

    public void setjTableCuotas(JTable jTableCuotas) {
        this.jTableCuotas = jTableCuotas;
    }

    public void setBtnPago(JButton btnPago) {
        this.btnPago = btnPago;
    }

    public void setjTextFMonto(JTextField jTextFMonto) {
        this.jTextFMonto = jTextFMonto;
    }

    public void setNumeroCuota(JTextField numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public JTable getjTableprestamos() {
        return jTableprestamos;
    }

    public JTable getjTableCuotas() {
        return jTableCuotas;
    }

    public JButton getBtnPago() {
        return btnPago;
    }

    public JTextField getjTextFMonto() {
        return jTextFMonto;
    }

    public JTextField getNumeroCuota() {
        return numeroCuota;
    }
}
