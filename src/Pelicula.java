import java.io.Serializable;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Pelicula la cual crea objetos del tipo Pelicula.
 */
public class Pelicula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private final int minutos;
	private String idioma;
	private String censura;

	/**
	 * Constructor por defecto 
	 */
	public Pelicula(){

		this.nombre= null;
		this.minutos= 0;
		this.idioma= null;
		this.censura= null;
	}

	/**
	 * Constructor
	 * @param vnombre String nombre de la pelicula
	 * @param vhorario Array lista de horarios
	 * @param vsala Array lista de salas
	 * @param vminutos int duracion de la pelicula
	 * @param vidioma String idioma pelicula
	 * @param vcensura String censura pelicula 
	 * @param vformato String formato de pelicula
	 */
	public Pelicula(String vnombre,int vminutos,String vidioma,String vcensura){

		this.nombre=vnombre;
		this.minutos=vminutos;
		this.idioma=vidioma;
		this.censura=vcensura;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Funcion sobreescrita tipo toString
	 */
	@Override
	public String toString(){
		return "Titulo: "+this.nombre+
				" \nIdioma: "+this.idioma+
				" \nCensura: "+this.censura;
	}

	/**
	 * Getters and Setters
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String vnombre) {
		this.nombre = vnombre;
	}

	public int getMinutos() {
		return minutos;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String vidioma) {
		this.idioma = vidioma;
	}

	public String getCensura() {
		return censura;
	}

	public void setCensura(String vcensura) {
		this.censura = vcensura;
	}
}