/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase FormatoSala la cual crea objetos del tipo FormatoSala.
 */
public class FormatoSala {

	private String formato;
	private double precio; 

	/**
	 *Constructor 
	 */
	public FormatoSala(){

		this.formato = null;
		this.precio = 0;
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
		return formato;
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