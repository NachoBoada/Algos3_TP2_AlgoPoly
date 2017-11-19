package fiuba.algo3.tp2.algopoly.model;

public class Dinero {

    private int cantidad;

    public Dinero(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {  //TODO private
        return this.cantidad;
    }

    public boolean equals(Dinero dinero) {
        return this.cantidad == dinero.getCantidad();
    }

    public void sumar(Dinero dinero) {
        this.cantidad += dinero.getCantidad();
    }

    public void restar(Dinero dinero) {
        if (this.cantidad < dinero.getCantidad()) {
            throw new ElDineroNoPuedeSerNegativo();
        }

        this.cantidad -= dinero.getCantidad();
    }

    public void restarEntero(int factor) {
        if (this.cantidad < factor) {
            throw new ElDineroNoPuedeSerNegativo();
        }

        this.cantidad -= factor;
    }

}
