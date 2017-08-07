import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase ListaPelicula la cual crea lista de peliculas.
 */
public class ListaPeliculas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pelicula> listaPeliculas;

	/**
	 * Constructor 
	 */
	public ListaPeliculas() {

		this.listaPeliculas=new ArrayList<Pelicula>();
	}

	/**
	 * @param vpelicula lista de peliculas
	 */
	public void ingresarpelicula(Pelicula vpelicula){

		listaPeliculas.add(vpelicula);
	}
	
	public Pelicula obtenerPelicula(int numeroPelicula){
		
	return	listaPeliculas.get(numeroPelicula-1);
			
	}
	
	
	
	
	/**
	 * Muestra la cartelera de peliculas
	 */
	public void Cartelera(){
		
		int i=1;
		
		for(Pelicula vpelicula:listaPeliculas){
			System.out.println(Integer.toString(i) + ") "+ vpelicula+"\n");
			i++;
			
		}
	}

	public void GenerarInformePeliculas(String archivo) {

		FileWriter fichero1 = null;
		PrintWriter pw = null;
		try{
			fichero1 = new FileWriter(archivo, true);
			pw = new PrintWriter (fichero1);
			for(Pelicula pelicula: this.listaPeliculas)
			{
				pw.println(pelicula);
			}
		}
		catch(Exception e ){
			e.printStackTrace();
		}finally{
			try{
				if(null != fichero1);
				fichero1.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
	}

}