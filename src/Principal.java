import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Controla la salas existentes
		ArrayList<Sala> salas = new ArrayList<Sala>();
		//
		
		Sala sala = new Sala();
		sala.setNumSala(1);
		
		ListaAsientos asientosSala1 = new ListaAsientos();
		asientosSala1.setColumnas(15);
		asientosSala1.setFilas(8);
		
		if (!asientosSala1.AsignarAsiento('h', 3)) {
			System.out.println("ya existe el asiento");
		}
		
		//asientosSala1.RemoverAsiento('h', 3);
		sala.setAsientos(asientosSala1);

		// peliculas
		ListaPeliculas peliculas = new ListaPeliculas();
		
		Pelicula pelicula = new Pelicula();
		pelicula.setNombre("Lo que el viento se llevo");
		
		sala.set
		
		salas.add(new Sala());
		
		
		
	}

}
