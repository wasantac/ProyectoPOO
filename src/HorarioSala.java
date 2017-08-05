import java.time.LocalDateTime;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Pelicula la cual crea objetos del tipo Pelicula.
 */
public class HorarioSala {

	private LocalDateTime inicio;
	private LocalDateTime fin;

	/**
	 * Constructor por defecto. 
	 */
	public HorarioSala(){

		this.inicio = null;
		this.fin = null;
	}

	/**
	 * @param inicio locadatetime inicio de la sala
	 * @param fin localdatetime fin de la sala
	 */
	public HorarioSala(LocalDateTime inicio,LocalDateTime fin){

		this.inicio = inicio;
		this.fin = fin;
	}

	/**
	 * Getters and Setters
	 */
	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Funcion sobreescrita del tipo toString
	 */
	@Override
	public String toString(){
		return "Inicio de la sala: "+this.inicio+" "+"Fin de la sala:  "+this.fin;
	} 
}