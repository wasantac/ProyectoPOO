import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase ListadoLineasFactura la cual crea objetos del tipo ListadoLineasFactura
 */
public class ListadoLineasFactura implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private ArrayList <LineaFactura> lineasFactura;
	private double total;
	
	public ListadoLineasFactura() {
		this.lineasFactura = new ArrayList <LineaFactura>();
		this.total = 0.0;
	}
	
	public ListadoLineasFactura(ArrayList <LineaFactura> listadoLineasFactura, double total) {
		this.lineasFactura = listadoLineasFactura;
		this.total = total;
	}
	
	public double getTotal() {
		return total;
	}

	public ArrayList<LineaFactura> getLineasFactura() {
		return lineasFactura;
	}

	public void AgregarLineaFactura(LineaFactura lineaFactura) {
		this.lineasFactura.add(lineaFactura);
		this.total += lineaFactura.getTotal();
	}

	public void RemoverLineaFactura(LineaFactura lineaFactura) {
		if (this.lineasFactura.remove(lineaFactura)) {
			this.total -= lineaFactura.getTotal();
		}
	}
}