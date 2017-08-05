import java.time.LocalDateTime;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase HorarioSala la cual crea objetos del tipo HorarioSala.
 */
public class HorarioSala {

	private LocalDateTime inicio;
	private LocalDateTime fin;
	private Sala sala;
	private Pelicula pelicula;

	/**
	 * Constructor por defecto. 
	 */
	public HorarioSala(){

		this.inicio = null;
		this.fin = null;
		this.sala = null;
		this.pelicula = null;
	}

	/**
	 * @param inicio locadatetime inicio de la sala
	 * @param fin localdatetime fin de la sala
	 */
	public HorarioSala(LocalDateTime inicio, LocalDateTime fin, Pelicula pelicula, Sala sala){

		this.inicio = inicio;
		this.fin = fin;
		this.sala = null;
		this.pelicula = null;
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

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
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