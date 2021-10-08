package vista;

import Modelo.*;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class VistaPrestamos extends JFrame{

    JPanel panelSuperior = new JPanel();
    JPanel panelInferior = new JPanel();
    JTable jTableprestamos, jTableCuotas; //tablas que mostraran los prestamos y los pagos de cadaa prestamo
    JButton btnPago, btnPrestamo, btnRegreso;
    JTextField jTextFMonto, numeroCuota, jTextFIdPre, jTextFPlazo, jTextFInteres, jTextFPago;
    JLabel jLabelPrestamoCliente, jLabelCuotasPrestamo, jLabelMonto,jLabelInteres,jLabelidPre, jLabelPlazo, jLabelMontoPago;



    public VistaPrestamos(){

        setVisible(false);

        setTitle("Prestamos clientes");

        setBounds(100, 25, 950, 730);

        setDefaultCloseOperation(0);

       // setResizable(false);

        this.instantiateComponents();
        this.addComponents();
        this.actionCommands();
    }

    public void instantiateComponents(){
        String t = "      ";
        btnPago = new JButton("Agregar Pago");
        jTableprestamos = new JTable();
        jTableCuotas = new JTable();

        jLabelPrestamoCliente = new JLabel("Prestamos del cliente");
        jLabelCuotasPrestamo = new JLabel("Cuotas del prestamo seleccionado");
        jLabelidPre = new JLabel(t+"ID");
        jLabelInteres =new JLabel(t+"Interes");
        jLabelMonto = new JLabel("Monto");
        jLabelPlazo = new JLabel(t+"Plazo");
        jLabelMontoPago = new JLabel("Monto de cuota");

        jTextFMonto = new JTextField(8);
        numeroCuota= new JTextField(8);
        jTextFIdPre= new JTextField(8);
        jTextFPlazo= new JTextField(8);
        jTextFInteres = new JTextField(8);
        jTextFPago = new JTextField(8);

        btnPrestamo = new JButton("add nuevo prestamo");
        btnPago =new JButton("add nuevo pago");
        btnRegreso = new JButton("Regresar");

    }

    public void addComponents(){
        this.getContentPane().setLayout(new GridLayout(2,0));
        JPanel norte = new JPanel();
        JPanel sur = new JPanel();
        sur.setLayout(new BorderLayout());
        norte.setLayout(new BorderLayout());
        //Agregamos en la parte superior
        JPanel subNorte = new JPanel(new BorderLayout());
        JPanel subsubNorte= new JPanel();
        JPanel tituloSuperior = new JPanel();
        tituloSuperior.setBackground(new Color(38, 236, 18, 176));

        tituloSuperior.add(new JLabel("Prestamos del cliente"));

        subsubNorte.add(jLabelMonto,BorderLayout.CENTER);
        subsubNorte.add(jTextFMonto,BorderLayout.CENTER);

        subsubNorte.add(jLabelInteres,BorderLayout.CENTER);
        subsubNorte.add(jTextFInteres,BorderLayout.CENTER);

        subsubNorte.add(jLabelPlazo,BorderLayout.CENTER);
        subsubNorte.add(jTextFPlazo,BorderLayout.CENTER);

        subsubNorte.add(jLabelidPre,BorderLayout.CENTER);
        subsubNorte.add(jTextFIdPre,BorderLayout.CENTER);

       // subsubNorte.add(btnPrestamo,BorderLayout.WEST);
        subNorte.add(btnPrestamo, BorderLayout.EAST);
        subNorte.add(tituloSuperior, BorderLayout.NORTH);
        subNorte.add(subsubNorte,BorderLayout.CENTER);
        subNorte.add(btnRegreso,BorderLayout.WEST);

        norte.add(subNorte, BorderLayout.NORTH);
        norte.add(panelSuperior,BorderLayout.CENTER);

        //agregamos a la parte inferior
        JPanel tituloInferior = new JPanel();
        tituloInferior.setBackground(new Color(38, 236, 18, 176));
        JPanel subsubSur= new JPanel();
        tituloInferior.add(new JLabel("Cuotas del prestamo selecciona"));
        JPanel subSur = new JPanel();
        subSur.setLayout(new BorderLayout());

        subSur.setLayout(new BorderLayout());
        subsubSur.add(jLabelMontoPago);
        subsubSur.add(jTextFPago);
       // subsubSur.add(btnPago);
        subSur.add(btnPago, BorderLayout.EAST);
        subSur.add(subsubSur, BorderLayout.CENTER);
        subSur.add(tituloInferior, BorderLayout.NORTH);
      //  subSur

        sur.add(subSur, BorderLayout.NORTH);
        sur.add(panelInferior,BorderLayout.CENTER);

        //agregamos al panel principal
        this.getContentPane().add(norte);
        this.getContentPane().add(sur);
    }

    public void establecerFormatoTablaPrestamos(PrestamoModelo listD){
            jTableprestamos.setModel(new JTable_Prestamos(listD.getListaPres()));
    }

    public void establecerFormatoTablaPagos(List<Pago> list){
        jTableCuotas.setModel(new JTable_Pagos(list));
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

    public void actionCommands(){
        btnPrestamo.setActionCommand("4");
        btnPago.setActionCommand("5");
        btnRegreso.setActionCommand("6");
    }

    public void addListeners(ActionListener ac){
        btnRegreso.addActionListener(ac);
        btnPago.addActionListener(ac);
        btnPrestamo.addActionListener(ac);
    }
    public void addMouseListeners(MouseListener ml){
        jTableprestamos.addMouseListener(ml);
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

    public JButton getBtnPrestamo() {
        return btnPrestamo;
    }

    public JTextField getjTextFIdPre() {
        return jTextFIdPre;
    }

    public JTextField getjTextFPlazo() {
        return jTextFPlazo;
    }

    public JTextField getjTextFInteres() {
        return jTextFInteres;
    }

    public JTextField getjTextFPago() {
        return jTextFPago;
    }
}
