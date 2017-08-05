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

	/**
	 * Funcion que cuenta los asientos. (No la creo necesaria) 
	 */
	public void asientos(){

		int i,j;
		for (i=0;i<asientos.length;i++){
			for(j=0;j<asientos.length;j++){
				asientos[i][j]=0;
			}
		}
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
	 * Funcion que asigna asientos (lo crea si aun no existe)
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
	
	/**
	 * Funcion que muestra los asientos a los clientes.
	 */
	public void mostrarAsientos(){
		int cont=0,i,j;
		System.out.println("Sala: "+this.getNumSala());
		for(i=0;i<asientos.length;i++){
			if(i==0){
				System.out.print("   "+(i+1));
			}else{
				System.out.print("  "+(i+1));
			}

		}
		System.out.println("");
		for (i=0;i<asientos.length;i++){
			System.out.print((char)(65+i)+"-");
			for(j=0;j<asientos.length;j++){
				if(asientos[i][j]==0){
					System.out.print("[ ]");
				}else{
					System.out.print("[X]");
				}
				if(asientos[i][j]==1){
					cont=cont+1;
				}
			}
			System.out.println();
			/*if (cont==asientos.length*asientos.length){
				System.out.println("ya no existen asientos disponibles");
				break;
			}*/
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
}