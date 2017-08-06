import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase HorarioSala la cual crea objetos del tipo HorarioSala.
 */
public class ListadoHorarioSala implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public boolean AgregarHorario(HorarioSala horarioSala) {
		return AgregarHorario(horarioSala.getInicio(), horarioSala.getFin(), horarioSala.getPelicula(), horarioSala.getSala());
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


	public void ImprimirHorarioPelicula(Pelicula pelicula, int anio, int mes, int dia){

		System.out.println(pelicula.getNombre());

		System.out.println(String.valueOf(anio)+" / "+mes+" / "+String.valueOf(dia));

		int i= 0;

		for(HorarioSala hs: listaHorarios){

			if(hs.getInicio().getDayOfMonth() == dia){

				System.out.println(Integer.toString(i + 1) + ") Sala " + hs.getSala().getNumSala() + ", Formato " + hs.getSala().getFormato().getFormato() + ": de" + String.valueOf(hs.getInicio().getHour() +":"+hs.getInicio().getMinute()+" a "+hs.getFin().getHour()+":"+hs.getFin().getMinute()));
				i++;

			}
		}	

		if(i==0){

			System.out.println("No se encontraron resultados");
		
		}
	}

}
