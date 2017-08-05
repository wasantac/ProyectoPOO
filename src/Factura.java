import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;

public class Factura {

	private Cliente cliente;
	private LocalDateTime fecha; 
	private double precioTotal;
	private ArrayList <LineasFactura> lineasFactura;
	
	public Factura() {
		this.cliente = new Cliente();
		this.fecha = LocalDateTime.now(); 
		this.precioTotal = 0.0;
		this.lineasFactura = new ArrayList <LineasFactura>();
	}
	
	public Factura(Cliente vCliente, LocalDateTime vfecha, double vprecioTotal, ArrayList <LineasFactura> vlineasFactura) {
		this.cliente = vCliente;
		this.fecha = vfecha; 
		this.precioTotal = vprecioTotal;
		this.lineasFactura = vlineasFactura;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public ArrayList<LineasFactura> getLineasFactura() {
		return lineasFactura;
	}

	public void setLineasFactura(ArrayList<LineasFactura> lineasFactura) {
		this.lineasFactura = lineasFactura;
	}	
	
}
