package fiuba.algo3.tp2.algopoly.model;

public class Dinero {

    private int cantidad;

    public Dinero(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }
    
    public boolean equals(Dinero dinero) {
        return this.cantidad == dinero.getCantidad();
    }

    public void sumar(Dinero dinero) {
        this.cantidad += dinero.getCantidad();
    }

    public void restar(Dinero dinero) {
        this.cantidad -= dinero.getCantidad();
    }

}
