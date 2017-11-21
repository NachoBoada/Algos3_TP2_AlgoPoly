package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficiente;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.ElJugadorNoTieneCapitalSuficienteParaEdificar;
import fiuba.algo3.tp2.algopoly.model.Jugador;

public abstract class Region {

    protected BarrioDividido barrioSur;
    protected BarrioDividido barrioNorte;

    public BarrioDividido getBarrioNorte() {
        return barrioNorte;
    }

    public BarrioDividido getBarrioSur() {
        return barrioSur;
    }
    
    public void agregarCasa (BarrioDividido barrio, Jugador jugador, Dinero costoCasa) {    
    	if (jugador.esPropietarioDe(barrioSur) && jugador.esPropietarioDe(barrioNorte)) {
    		try {
    			jugador.decrementarCapitalEn(costoCasa);
    		}catch (CapitalInsuficiente e) {throw new ElJugadorNoTieneCapitalSuficienteParaEdificar();}
    		
    		barrio.sumarCasa();
    	}
    		
    }
    
    public void agregarHotel (BarrioDividido barrio, Jugador jugador, Dinero costoHotel) {
    	if ((barrioSur.getCantidadCasas() == 2) && ( barrioNorte.getCantidadCasas() == 2 )) {
    		
    		try {
    			jugador.decrementarCapitalEn(costoHotel);
    		}catch (CapitalInsuficiente e) {throw new ElJugadorNoTieneCapitalSuficienteParaEdificar();}

    		barrio.sumarHotel();
    	}
    }
    
 

    
}