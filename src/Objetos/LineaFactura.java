package Objetos;
import java.util.ArrayList;

/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase LineaFactura la cual crea objetos del tipo LineaFactura.
 */

public class LineaFactura {


	private double cantidad;
	//private Pelicula pelicula;
	private ArrayList<Asiento> asientos;
	//private Sala sala;
	private HorarioSala horarioSala;
	private double precioUnitario;
	private double total;

	/**
	 * Constructor por defecto
	 */
	public LineaFactura() {
		this.cantidad = 0;
		//this.pelicula = new Pelicula();
		this.asientos = new ArrayList<Asiento>();
		//this.sala = new Sala();
		this.horarioSala = new HorarioSala();
		this.precioUnitario = 0;
		this.total = 0;
	}

	public LineaFactura(double cantidad, ArrayList<Asiento> asientos, HorarioSala horarioSala, double precioUnitario) {
		this.cantidad = cantidad;
		//this.pelicula = pelicula;
		this.asientos = asientos;
		//this.sala = sala;
		this.horarioSala = horarioSala;
		this.precioUnitario = precioUnitario;
		this.total = cantidad * precioUnitario;
	}

	public void CalcularTotal() {
		this.total = this.cantidad * this.precioUnitario;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
		CalcularTotal();
	}

	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}
	public HorarioSala getHorarioSala() {
		return horarioSala;
	}

	public void setHorarioSala(HorarioSala horarioSala) {
		this.horarioSala = horarioSala;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
		CalcularTotal();
	}

	public void setPrecioUnitario(double precioUnitario, int tarjeta) {
		if (tarjeta == 1) {
			this.precioUnitario = precioUnitario - (precioUnitario * 20 / 100);
		}
		else {
			this.precioUnitario = precioUnitario;
		}
		CalcularTotal();
	}

	public double getTotal() {
		return total;
	}	
}