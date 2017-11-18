package fiuba.algo3.tp2.algopoly.model;

import java.util.ArrayList;
import fiuba.algo3.tp2.algopoly.model.boleta.BoletaQuini6;
import fiuba.algo3.tp2.algopoly.model.casillero.Barrio;
import fiuba.algo3.tp2.algopoly.model.casillero.Carcel;
import fiuba.algo3.tp2.algopoly.model.casillero.Encasillable;
import fiuba.algo3.tp2.algopoly.model.casillero.Salida;
import fiuba.algo3.tp2.algopoly.model.estado.Estado;
import fiuba.algo3.tp2.algopoly.model.estado.Libre;

public class Jugador {

    private final Dinero capitalDelJugador;
    private final ArrayList<Barrio> propiedades;
    private final BoletaQuini6 boletaQuini6;
    private Encasillable casilleroActual;
    private int posicionActual;
    private Estado estado;

    private int ultimaSumaDados; //Temporal hasta tener clase Dados

    public Jugador(Dinero capitalInicial) {

        capitalDelJugador = capitalInicial;

        propiedades = new ArrayList<>();

        boletaQuini6 = new BoletaQuini6();

        casilleroActual = new Salida();
        posicionActual = 0;

        estado = new Libre();
    }

    public boolean mover(int cantidadCasilleros) {
        ultimaSumaDados = cantidadCasilleros;
        return (estado.mover(this, cantidadCasilleros));
    }

    public void caerEn(Encasillable casillero) {
        casillero.actuarSobre(this);
    }

    public Encasillable casilleroActual() {
        return casilleroActual;
    }

    public int posicionActual() {
        return posicionActual;
    }

    public int obtenerUltimaSumaDados() {
        return this.ultimaSumaDados;
    }

    public void actualizarCasillero(Encasillable encasillable, int posicion) {
        casilleroActual = encasillable;
        posicionActual = posicion;
    }

    public void sumarAPosicion(int cantidad) {
        this.posicionActual += cantidad;
    }

    public void incrementarCapitalEn(Dinero incrementoDeCapital) {
        capitalDelJugador.sumar(incrementoDeCapital);
    }

    public void derementarCapitalEn(Dinero decrementoDeCapital) throws ElDineroNoPuedeSerNegativo {
        capitalDelJugador.restar(decrementoDeCapital);
    }

    public Dinero getCapital() {
        return capitalDelJugador;
    }

    public BoletaQuini6 getBoletoQuini6() {
        return boletaQuini6;
    }

    public void comprarBarrio(Barrio barrioAComprar) {

        try {
            this.derementarCapitalEn(barrioAComprar.getPrecioDelBarrio());
        } catch (ElDineroNoPuedeSerNegativo e) {
            throw new ElJugadorNoTieneCapitalSuficienteParaComprarEsteBarrio();
        }

        propiedades.add(barrioAComprar);
    }

    public boolean esPropietarioDe(Barrio barrio) {
        return propiedades.contains(barrio);
    }

    public void cambiarEstado(Estado estado) {
        this.estado = estado;
    }

    public void irPreso(Carcel carcel) {
        estado.cambiarProximoEstadoPreso(this, carcel);
    }

    public boolean pagarFianza() {
        return (estado.pagarFianza(this));
    }

    public int getCantidadDePropiedades() {
        return this.propiedades.size();
    }

}
