package Listas;
import java.util.ArrayList;

import Objetos.FormatoSala;
/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase  ListaFormatosSala la cual crea objetos del tipo  ListaFormatosSala
 */
public class ListaFormatosSala  {

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
