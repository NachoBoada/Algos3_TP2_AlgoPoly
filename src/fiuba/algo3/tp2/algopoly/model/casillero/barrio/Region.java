package fiuba.algo3.tp2.algopoly.model.casillero.barrio;

import fiuba.algo3.tp2.algopoly.model.CapitalInsuficienteException;
import fiuba.algo3.tp2.algopoly.model.Dinero;
import fiuba.algo3.tp2.algopoly.model.Jugador;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException;
import fiuba.algo3.tp2.algopoly.model.casillero.JugadorNoPuedeConstruirHotelSiNoSeConstruyeElMaximoNumeroDeCasasException;

public abstract class Region {

    protected BarrioDividido barrioSur;
    protected BarrioDividido barrioNorte;

    public BarrioDividido getBarrioNorte() {
        return barrioNorte;
    }

    public BarrioDividido getBarrioSur() {
        return barrioSur;
    }
    
    public void agregarCasa (BarrioDividido barrio, Jugador jugador, Dinero costoCasa) throws CapitalInsuficienteException {   
    	
    	if (jugador.esPropietarioDe(barrioSur) && jugador.esPropietarioDe(barrioNorte)) {
    		jugador.decrementarCapitalEn(costoCasa);
    		barrio.sumarCasa();
    	}else { throw new JugadorNoPuedeConstruirCasaSiNoAdquiereLosDosBarriosException(); }
    		
    }
    
    public void agregarHotel (BarrioDividido barrio, Jugador jugador, Dinero costoHotel) throws CapitalInsuficienteException {
    	if ((barrioSur.getCantidadCasas() == 2) && ( barrioNorte.getCantidadCasas() == 2 )) {
    		
    		jugador.decrementarCapitalEn(costoHotel);
    		barrio.sumarHotel();
    	}else {throw new JugadorNoPuedeConstruirHotelSiNoSeConstruyeElMaximoNumeroDeCasasException();}
    }

	public void demolerEdificaciones() {
		barrioSur.demolerEdificaciones();
		barrioNorte.demolerEdificaciones();
	}    
}