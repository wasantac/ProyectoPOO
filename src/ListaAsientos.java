import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase ListaAsientos la cual crea lista de asientos.
 */
public class ListaAsientos {

	private ArrayList<Asiento> listaAsientos;
	private int total;
	private int disponibles;
	private int ocupados;
	private int filas;
	private int columnas;

	/**
	 * Constructor 
	 */
	public ListaAsientos() {

		this.listaAsientos=new ArrayList<Asiento>();

	}

	/**
	 * @param listaAsientos array de asientos
	 * @param filas int 
	 * @param columnas int
	 */
	public ListaAsientos(ArrayList<Asiento> listaAsientos, int filas, int columnas) {
		this.listaAsientos = listaAsientos;
		this.total = filas*columnas;
		this.disponibles = total;
		this.ocupados = 0;
		this.filas = filas;
		this.columnas = columnas;
	}

	/**
	 * Getters and Setters
	 */
	public ArrayList<Asiento> getListaAsientos() {
		return listaAsientos;
	}

	public void setListaAsientos(ArrayList<Asiento> listaAsientos) {
		this.listaAsientos = listaAsientos;
	}

	public int getFilas() {
		return filas;
	}

	public void setFilas(int filas) {
		this.filas = filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	public int getTotal() {
		return total;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public int getOcupados() {
		return ocupados;
	}
}