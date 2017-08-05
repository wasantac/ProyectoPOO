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
		this.total = 0;
		this.disponibles = 0;
		this.ocupados = 0;
		this.filas = 0;
		this.columnas =0;
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

	public boolean AsientoAsignado(char fila, int numero) {
		for (Asiento a: listaAsientos) {
			if(a.getFila() == fila && a.getNumero() == numero) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Funcion que asigna asientos
	 * @param fila char
	 * @param columna int
	 */
	public boolean AsignarAsiento(char fila, int numero){
		if (AsientoAsignado(fila, numero) || disponibles == 0) {
			return false;
		}
		listaAsientos.add(new Asiento(fila, numero));
		recalcularVariable();		
		return true;
	}
		
	private void recalcularVariable() {
		// en base a cualquier cambio de los valores recalcula los subtotales
		this.total = filas * columnas;
		this.ocupados = this.listaAsientos.size();
		this.disponibles = this.total - this.ocupados;
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
		recalcularVariable();		 
	}

	public int getColumnas() {
		return columnas;
	}

	public void setColumnas(int columnas) {
		this.columnas = columnas;
		recalcularVariable();		 
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