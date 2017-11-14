package fiuba.algo3.tp2.algopoly.model;

public class Capital {

    private int cantidad;

    public Capital(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return this.cantidad;
    }
    
    public boolean equals(Capital dinero) {
        return this.cantidad == dinero.getCantidad();
    }

    public void sumar(Capital dinero) {
        this.cantidad += dinero.getCantidad();
    }

    public void restar(Capital dinero) {
        this.cantidad -= dinero.getCantidad();
    }

}
