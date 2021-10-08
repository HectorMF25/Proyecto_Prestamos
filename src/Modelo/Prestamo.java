package Modelo;

import javax.swing.*;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.round;


public class Prestamo {

    private String id;

    private double monto;

    private double interes;

    private int plazo;

    private double saldo;

    private double cuota;

    private PagoModelo pagoList;

    private Cliente cliente;

    private boolean estado; //0 sin cancelar 1 cancelado


    public Prestamo(String id, double monto, double interes, int plazo, Cliente cliente,
                    PagoModelo pagoList) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.saldo = monto;
        this.cliente = cliente;
        this.pagoList = pagoList;
        this.cuota = calculoDeCuota();
        this.id = id;
        this.estado = false;
    }

    public Prestamo() {

    }

    public String getId() {
        return id;
    }

    public boolean getEstado() {
        if((int)saldo == 0){
            estado = true;
        }else{
            estado = false;
        }
        return estado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public double getInteres() {
        return interes;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public PagoModelo getPagoList() {
        return pagoList;
    }

    public void setPagoList(PagoModelo pagoList) {
        this.pagoList = pagoList;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double calculoDeCuota(){
        double numerador = getSaldo()*getInteres();
        double denominador = (1 - (pow((1 + getInteres()), -(getPlazo()- getPagoList().numeroPagos()))));
        return round(numerador/denominador);
    }

    public void agregarPago(double pagoCuota) {
        int verificar = 0;
        Pago pago = new Pago();
        if ((verificarPago(pagoCuota))) { //si el pago es menor a la cuota
           // System.out.println("No es posible realizar el pago ya que es menor la cuota o mayor al saldo");
            JOptionPane.showMessageDialog(null,"No es posible realizar el pago ya que es\n menor la cuota o mayor al saldo");
            return;
        }
        if (confirmacionCancelacion()) {
           // System.out.println("Ya se cancelo este prestamo");
            JOptionPane.showMessageDialog(null,"Ya se cancelo este prestamo");
            setEstado(true);
            return;
        }
       // System.out.println("pagoCuota: "+pagoCuota+"  -getCuota: "+getCuota()+"  -getPagoList: "+getPagoList().numeroPagos()+"    plazo: "+plazo);
        if( pagoCuota>round(getCuota()) && getPagoList().numeroPagos()+1 == plazo){
            JOptionPane.showMessageDialog(null,"Es el ultimo plazo, debe de pagar su totalidad");
            // System.out.println("Es el ultimo plazo, debe de pagar su totalidad");
              return;
         }
         if(verficarExcedeCuota(pagoCuota)){
           //  System.out.println("Entra 0");
             pago.setMontoPagar(pagoCuota);
             setCuota(pagoCuota);
             verificar = 1;
         }else{
            // System.out.println("Entra 1");
            pago.setMontoPagar(getCuota());
        }
        pago.setMontoInteres(getInteres()); //interes del pago
        pago.setAmortizacion(amortizacionPago()); //
        pago.setNumeroCuota(getPagoList().numeroPagos());
        pago.setFecha(new Fecha());
        pagoList.asignarDatosPago(pago);
        setSaldo(getSaldo() - pago.getAmortizacion());
       // System.out.println("Plazo: "+plazo+" -listaPago: "+getPagoList().numeroPagos());
        if(verificar == 1 ){
            setCuota(calculoDeCuota());
            verificar =0;
        }
       // System.out.println("Imprime lista de pagos");
       // pagoList.imprimir();
    }

    public boolean confirmacionCancelacion(){
        if(getPagoList().numeroPagos() > plazo){
            return true;
        }
        return false;
    }

    public double amortizacionPago(){
        double total = getCuota()-(getInteres()*saldo);
        return total;
    }

    public boolean verificarPago(double pago){
       //System.out.println("pago: "+pago+" -monto: "+getMonto()+" -saldo: "+round(getSaldo())+" -Amortiacion: "+ amortizacionPago()+" -cuota: "+getCuota());
        if(pago<getCuota() || ((int)amortizacionPago())>((int)(getSaldo()))){
            return true;
        }
        return false;
    }

    public boolean verificarExcedeSaldo(double pago){
        if(pago>saldo){
            return true;
        }
        return false;
    }

    public boolean verficarExcedeCuota(double pago){
        if(pago > getCuota()){
            return true;
        }
        return false;
    }

    public void toStringPres() {
        System.out.println("-Monto: "+monto +"\n-interes=" + interes + "\n-plazo=" + plazo +"\n-saldo=" + Math.round(saldo) +"\n-cliente=" + cliente +"\n-couta a pagar=" + cuota +"\n-interes="+interes);
        pagoList.imprimir();
    }

    public String getEstadoPago(){
        if(getEstado()==true){
            return "cancelado";
        }
        return "pendiente";
    }
}