import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Sala la cual crea objetos del tipo Sala.
 */
public class Sala {

	private int numSala;
	private ListaAsientos asientos;
	
	/**
	 * Constructor  
	 */
	public Sala(){

		this.numSala= 0;
		this.asientos = new ListaAsientos();
	}

	/**
	 * @param vnumSala int numero de sala 
	 * @param vasientos vector para seleccion de asiento
	 * @param listaHorarios horario de la sala 
	 */
	public Sala(int vnumSala,ListaAsientos vasientos) {

		this.numSala=vnumSala;
		this.asientos=vasientos;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Funcion sobreescrita tipo toString
	 */
	@Override
	public String toString(){
		return "Sala: "+this.numSala;
	}
	
	/**
	 * Getters and Setters
	 */
	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int vnumSala) {
		this.numSala = vnumSala;
	}
	public ListaAsientos getAsientos() {
		return asientos;
	}

	public void setAsientos(ListaAsientos vasientos) {
		this.asientos = vasientos;
	}

}