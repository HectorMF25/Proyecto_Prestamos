package Modelo;

public class Prestamo {

    private String idPrestamo;

    private double monto;

    private double interes;

    private int plazo;

    private Cliente cliente;

    PagoModelo listaPagos;


    public Prestamo(double monto, double interes, int plazo, Cliente cliente, PagoModelo listaP, String id) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.cliente = cliente;
        this.listaPagos = listaP;
        this.idPrestamo = id;
    }

    public Prestamo() {
        this.monto = 0;
        this.interes = 0;
        this.plazo = 0;
        this.cliente = null;
        this.listaPagos = null;
        this.idPrestamo = "";
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public PagoModelo getListaPagos() {
        return listaPagos;
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

    @Override
    public String toString() {
        return "Prestamo{" +
                "monto=" + monto +
                ", interes=" + interes +
                ", plazo=" + plazo +
                ", Cliente: "+ cliente.toString()+
                '}';
    }
}
