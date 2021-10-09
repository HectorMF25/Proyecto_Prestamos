package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prestamo {

    private String id;

    private double monto;

    private double interes;

    private double plazo;

    private double saldo;

    private double cuota;

    private List<Pago> pagoList = new ArrayList<>();

    private Cliente cliente;



    public Prestamo(String id, double monto, double interes, int plazo, double saldo, Cliente cliente,
                     double cuota) {
        this.id = id;
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.saldo = saldo;
        this.cliente = cliente;
        this.cuota = cuota;

    }

    public Prestamo() {

    }


    public double getMonto() {
        return monto;
    }

    public double getInteres() {
        return interes;
    }

    public double getPlazo() {
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

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void agregarPago(Pago p)
    {
        pagoList.add(p);
    }


    @Override
    public String toString() {
        if(pagoList==null)
        {
            return "Prestamo{" +
                    "Prestamo id="+ id +
                    "monto=" + monto +
                    ", interes=" + interes +
                    ", plazo=" + plazo +
                    ", saldo=" + Math.round(saldo) +
                    ", cliente=" + cliente +
                    ", cuota=" + cuota +
                    '}';
        }
        return "Prestamo{" +
                "Prestamo id="+ id +
                "monto=" + monto +
                ", interes=" + interes +
                ", plazo=" + plazo +
                ", saldo=" + Math.round(saldo) +
                ", cliente=" + cliente +
                ", couta a pagar=" + cuota +
               ", Lista de pagos=" + pagoList.toString() +
                '}';
    }
}
