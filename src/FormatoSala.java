import java.io.Serializable;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase FormatoSala la cual crea objetos del tipo FormatoSala.
 */
public class FormatoSala  implements Serializable {

	private static final long serialVersionUID = 1L;
	private String formato;
	private double precio; 

	/**
	 *Constructor 
	 */
	public FormatoSala(){

		this.formato = "2D";
		this.precio = 5.50;
	}

	/**
	 * @param formato string
	 * @param precio double
	 */
	public FormatoSala(String formato, double precio) {

		this.formato = formato;
		this.precio = precio;
	}

	/**
	 * Getters and Setters
	 */
	public String getFormato() {
		return this.formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}