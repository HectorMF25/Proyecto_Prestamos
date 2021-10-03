package vista;

import javax.swing.*;

public class VistaPrestamos extends JFrame{

    JTable jTableprestamos, jTableCuotas;
    JButton btnPago;

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
