import java.io.Serializable;
import java.util.ArrayList;

public class ListaFormatosSala implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<FormatoSala> listaFormatosSala;
	
	public ListaFormatosSala() {
		
		this.listaFormatosSala = new ArrayList<FormatoSala>(); 
		
	}
	
	public ListaFormatosSala(ArrayList<FormatoSala> listaFormatosSala) {
		
		this.listaFormatosSala = listaFormatosSala; 
		
	}

	
	public void AgregarFormato(FormatoSala formato) {
		this.listaFormatosSala.add(formato);
	}
	
	public void EliminarFormato(FormatoSala formato) {
		this.listaFormatosSala.remove(formato);
	}
	
	public double ObtenerPrecio(int tarjeta, String formato) {
		
		for(FormatoSala f: listaFormatosSala) {
			if(f.getFormato() == formato) {
				if (tarjeta == 1) {
					return f.getPrecio() - (f.getPrecio() * 20 / 100);
				}
				else {
					return f.getPrecio();
				}
			}
		}
		
		return 0;
	}
}
