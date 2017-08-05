import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// COntrola la salas existentes
		ArrayList<Sala> salas = new ArrayList<Sala>();
		//

		Sala sala = new Sala();
		sala.setNumSala(1);

		ListaAsientos asientosSala1 = new ListaAsientos();
		asientosSala1.setColumnas(15);
		asientosSala1.setFilas(8);

		System.out.println(asientosSala1.getDisponibles());

		if (!asientosSala1.AsignarAsiento('h', 3)) {
			System.out.println("ya existe el asiento");
		}
		
		//asientosSala1.RemoverAsiento('h', 3);
		sala.setAsientos(asientosSala1);
		FormatoSala formato = new FormatoSala();
		
		// peliculas
		ListaPeliculas peliculas = new ListaPeliculas();
		
		Pelicula pelicula = new Pelicula();
		pelicula.setNombre("Lo que el viento se llevo");
				
		ListadoHorarioSala horarios = new ListadoHorarioSala();
		LocalDateTime inicio = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
		LocalDateTime fin = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 00, 0);
		horarios.AgregarHorario(inicio, fin, pelicula, sala);
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 5); 
		// Lo que el viento se llevo
		// 2017 08 05
		// sala 1, 9h10 a 11h00
		
	}
}