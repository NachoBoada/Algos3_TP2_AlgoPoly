package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.Dinero;
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
    		barrio.sumarCasa();
    		jugador.decrementarCapitalEn(costoCasa);
    	}
    		
    }
    
    public void agregarHotel (BarrioDividido barrio, Jugador jugador, Dinero costoCasa) {
    	if ((barrioSur.getCantidadCasas() == 2) && ( barrioNorte.getCantidadCasas() == 2 )) {
    		
    		barrio.sumarHotel();
    		jugador.decrementarCapitalEn(costoCasa);
    	}
    }
    
 

    
}