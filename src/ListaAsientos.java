import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase ListaAsientos la cual crea lista de asientos.
 */
public class ListaAsientos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public boolean FormatoAsientoCorrecto (String butaca) {
		
		String[] temp = butaca.toLowerCase().trim().split(" ");
		
		if(temp.length == 2) {
			if(temp[0].length() != 1 || !Character.isLetter(temp[0].charAt(0))) {
				return false;
			}
			for(int i=1; i<temp[1].length(); i++){
				if(!Character.isDigit(temp[1].charAt(i))) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private Asiento ConvertirAsiento (String butaca) {

		char fila = ' ';
		int columna = 0;
		
		String[] temp = butaca.toLowerCase().trim().split(" ");
		
		fila = temp[0].charAt(0);
		columna = Integer.parseInt(temp[1]);
		
		return new Asiento(fila, columna);
		
	}
	
	public boolean AsientoAsignado(Asiento asiento) {
		for (Asiento a: listaAsientos) {
			if(a.getFila() == asiento.getFila()&& a.getNumero() == asiento.getNumero()) {
				return true;
			}
		}
		return false;
	}

	public boolean AsientoAsignado(char fila, int numero) {
		Asiento a = new Asiento(fila, numero);
		return AsientoAsignado(a);
	}

	public boolean AsientoAsignado(String butaca) {
		Asiento a = ConvertirAsiento(butaca);
		return AsientoAsignado(a);
	}
	
	/**
	 * Funcion que asigna asientos
	 * @param fila char
	 * @param columna int
	 */
	public boolean AsignarAsiento(Asiento asiento){
		if (AsientoAsignado(asiento) || disponibles == 0) {
			return false;
		}
		listaAsientos.add(asiento);
		recalcularVariable();		
		return true;
	}

	public boolean AsignarAsiento(String butaca){
		Asiento a = ConvertirAsiento(butaca);
		return AsignarAsiento(a);
	}

	public void imprimir(){

		Iterator<Asiento> i = listaAsientos.iterator();

		while(i.hasNext()){

			Asiento a = i.next();
			System.out.println("Asiento:" + " " + Integer.toString(a.getFila())+" "+a.getNumero());

		}
	}

	public void RemoverAsiento(char fila, int numero){

		for(Asiento a: listaAsientos){

			if(a.getFila()== fila && a.getNumero()== numero){

				listaAsientos.remove(a);
				return;
			}
		}
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

	private char ConvertirNumeroLetra(int numero) {
		
		final char letra[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
	
		return letra[numero-1];
	}


	public void VisualizacionAsientos() {

		String linea = "  ";

		for (int j = 1; j <= columnas; j++) {
			linea+= " "+ Integer.toString(j);
		}
		System.out.println(linea);


		for(int i = 1; i <= filas; i++) {

			linea="";

			for (int j = 0; j <= columnas; j++) {

				if(j==0){

					linea+=" "+ConvertirNumeroLetra(i);

				}else{

					if(AsientoAsignado(ConvertirNumeroLetra(i), j)) {
						linea+=" X";
					}
					else {
						linea+=" L";
					}


				}


			}
			
			System.out.println(linea);

		}
	}
}