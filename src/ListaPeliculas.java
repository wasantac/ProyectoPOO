import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase ListaPelicula la cual crea lista de peliculas.
 */
public class ListaPeliculas {

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

	/**
	 * Muestra la cartelera de peliculas
	 */
	public void cartelera(){
		
		for(Pelicula vpelicula:listaPeliculas){
			System.out.println(vpelicula+"\n");
		}
	}

	/**
	 * Muestra la informacion de la sala
	 */
	public void informacionSala(){

		for(Pelicula vpelicula:listaPeliculas){
			
			System.out.println(vpelicula.getNombre());
			vpelicula.salas();
		}
	}
}