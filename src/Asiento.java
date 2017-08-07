import java.io.Serializable;


/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Asiento la cual crea objetos del tipo Asiento.
 */
public class Asiento implements Serializable {

	private static final long serialVersionUID = 1L;	
	private char fila;
	private int numero;

	/**
	 * Constructor por defecto. 
	 */
	public Asiento(){

		this.fila = ' ';
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

	@Override
	public String toString() {
		return new StringBuffer(" Asiento, fila ")
				.append(this.fila).append(" numero : ")
				.append(this.numero).toString();
	}
}