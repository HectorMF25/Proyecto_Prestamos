package Modelo;

public class Prestamo {

    private double monto;

    private double interes;

    private int plazo;

    private Cliente cliente;

    //Pago---> lo que pagara el cliente (lista o atributo)?


    public Prestamo(double monto, double interes, int plazo, Cliente cliente) {
        this.monto = monto;
        this.interes = interes;
        this.plazo = plazo;
        this.cliente = cliente;
    }

    public Prestamo() {

    }

    /*public Prestamo() {
        this.monto = 0;
        this.interes = 0;
        this.plazo = 0;
    }*/

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
