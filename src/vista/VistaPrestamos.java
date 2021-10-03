package vista;

import javax.swing.*;

public class VistaPrestamos extends JFrame{

    JTable jTableprestamos, jTableCuotas; //tablas que mostraran los prestamos y los pagos de cadaa prestamo
    JButton btnPago;
    JTextField jTextFMonto, numeroCuota;

    VistaPrestamos(){

        setVisible(true);

        setTitle("Prestamos clientes");

        setBounds(100, 25, 950, 730);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);

        this.instantiateComponents();
        this.addComponents();
    }

    public void instantiateComponents(){
        btnPago = new JButton("Agregar Pago");

        jTableprestamos = new JTable();
        jTableCuotas = new JTable();
    }

    public void addComponents(){

    }
}
