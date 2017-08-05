import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase HorarioSala la cual crea objetos del tipo HorarioSala.
 */
public class ListadoHorarioSala {

	private ArrayList<HorarioSala> listaHorarios;
	
	/**
	 * Constructor por defecto. 
	 */
	public ListadoHorarioSala(){
		listaHorarios = new ArrayList<HorarioSala>();
	}

	public ArrayList<HorarioSala> getListaHorarios() {
		return listaHorarios;
	}

	public void setListaHorarios(ArrayList<HorarioSala> listaHorarios) {
		this.listaHorarios = listaHorarios;
	}
	
	public boolean AgregarHorario(LocalDateTime inicio, LocalDateTime fin, Pelicula pelicula, Sala sala) {
		for (HorarioSala h: listaHorarios) {
			if(h.getInicio() == inicio && h.getFin() == fin && h.getPelicula() == pelicula && h.getSala() == sala) {
				return false;
			}
		}
		listaHorarios.add(new HorarioSala(inicio, fin, pelicula, sala));
		return true;
	}

	public boolean RemoverHorario(LocalDateTime inicio, LocalDateTime fin, Pelicula pelicula, Sala sala) {
		for (HorarioSala h: listaHorarios) {
			if(h.getInicio() == inicio && h.getFin() == fin && h.getPelicula() == pelicula && h.getSala() == sala) {
				listaHorarios.remove(h);
				return true;
			}
		}
		return false;
	}
	
}