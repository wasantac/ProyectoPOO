import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Sala la cual crea objetos del tipo Sala.
 */
public class Sala {

	private int numSala;
	private int [][]asientos;
	private ArrayList<HorarioSala> listaHorarios;

	/**
	 * Constructor  
	 */
	public Sala(){

		this.numSala= 0;
		this.asientos = null;
		this.listaHorarios = null;
	}

	/**
	 * @param vnumSala int numero de sala 
	 * @param vasientos vector para seleccion de asiento
	 * @param listaHorarios horario de la sala 
	 */
	public Sala(int vnumSala,int [][]vasientos, ArrayList<HorarioSala> listaHorarios) {

		this.numSala=vnumSala;
		this.asientos=vasientos;
		this.listaHorarios = listaHorarios;
	}

	/**
	 * Funcion que cuenta los asientos. 
	 */
	public void asientos(){

		int i,j;
		for (i=0;i<asientos.length;i++){
			for(j=0;j<asientos.length;j++){
				asientos[i][j]=0;
			}
		}
	}

	/**
	 * Funcion que asigna asientos
	 * @param fila char
	 * @param columna int
	 */
	public void AsignarAsiento(char fila,int columna){
		
		int i,j;
		i=(int)fila-65;
		j=columna-1;
		if(asientos[i][j]==0){
			asientos[i][j]=1;
			System.out.println("Fila: "+fila+" Columna: "+columna);
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Funcion sobreescrita tipo toString
	 */
	@Override
	public String toString(){
		return "Sala: "+this.numSala;
	}
	
	/**
	 * Getters and Setters
	 */
	public int getNumSala() {
		return numSala;
	}

	public void setNumSala(int vnumSala) {
		this.numSala = vnumSala;
	}
	public int[][] getAsientos() {
		return asientos;
	}

	public void setAsientos(int[][] vasientos) {
		this.asientos = vasientos;
	}

	public ArrayList<HorarioSala> getListaHorarios() {
		return listaHorarios;
	}

	public void setListaHorarios(ArrayList<HorarioSala> listaHorarios) {
		this.listaHorarios = listaHorarios;
	}
}