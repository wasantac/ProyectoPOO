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

		//System.out.println(asientosSala1.getDisponibles());

		if (!asientosSala1.AsignarAsiento('h', 3)) {
			System.out.println("ya existe el asiento");
		}
		
		//asientosSala1.RemoverAsiento('h', 3);
		sala.setAsientos(asientosSala1);
		FormatoSala formato = new FormatoSala();
		
		// peliculas
		ListaPeliculas peliculas = new ListaPeliculas();
		
		Pelicula pelicula = new Pelicula();
		pelicula.setNombre("TRANSFORMERS");
				
		ListadoHorarioSala horarios = new ListadoHorarioSala();
		LocalDateTime inicio1 = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
		LocalDateTime fin1 = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 10, 0);
		LocalDateTime inicio2 = LocalDateTime.of(2017, Month.AUGUST, 6, 12, 10, 0);
		LocalDateTime fin2 = LocalDateTime.of(2017, Month.AUGUST, 6, 13, 30, 0);
		LocalDateTime inicio3 = LocalDateTime.of(2017, Month.AUGUST, 7, 20, 10, 0);
		LocalDateTime fin3 = LocalDateTime.of(2017, Month.AUGUST, 7, 11, 22, 10);
		
		
		horarios.AgregarHorario(inicio1, fin1, pelicula, sala);
		horarios.AgregarHorario(inicio2, fin2, pelicula, sala);
		horarios.AgregarHorario(inicio3, fin3, pelicula, sala);
	
		
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 5); 
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 6);
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 7);
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 8);
		
		
	}
}