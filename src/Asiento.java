/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Asiento la cual crea objetos del tipo Asiento.
 */
public class Asiento {

	private char fila;
	private int numero;

	/**
	 * Constructor por defecto. 
	 */
	public Asiento(){

		this.fila = null;
		this.numero = 0;
	}

	/**
	 * @param fila String fila
	 * @param numero int numero
	 */
	public Asiento(char fila, int numero) {

		this.fila = fila;
		this.numero = numero;
	}

	/**
	 * Getters and Setters
	 */
	public char getFila() {
		return fila;
	}
	public void setFila(char fila) {
		this.fila = fila;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}	
}