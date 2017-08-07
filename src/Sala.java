import java.io.Serializable;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Sala la cual crea objetos del tipo Sala.
 */
public class Sala implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numSala;
	private ListaAsientos asientos;
	private FormatoSala formato;
	
	/**
	 * Constructor  
	 */
	public Sala(){

		this.numSala= 0;
		this.asientos = new ListaAsientos();
		this.formato = new  FormatoSala();
	}

	/**
	 * @param vnumSala int numero de sala 
	 * @param vasientos vector para seleccion de asiento
	 * @param listaHorarios horario de la sala 
	 */
	public Sala(int numSala, ListaAsientos asientos, FormatoSala formato) {

		this.numSala = numSala;
		this.asientos = asientos;
		this.formato = formato;
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

	public FormatoSala getFormato() {
		return formato;
	}

	public void setFormato(FormatoSala formato) {
		this.formato = formato;
	}

}