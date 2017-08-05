import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;

public class Factura {

	private Cliente cliente;
	private Empleado vendedor;
	private LocalDateTime fecha; 
	private double precioTotal;
	private ArrayList <LineaFactura> lineaFactura;
	
	public Factura() {
		this.cliente = new Cliente();
		this.vendedor = new Empleado();
		this.fecha = LocalDateTime.now(); 
		this.precioTotal = 0.0;
		this.lineaFactura = new ArrayList <LineaFactura>();
	}
	
	public Factura(Cliente Cliente, Empleado vendedor, LocalDateTime fecha, double precioTotal, ArrayList <LineaFactura> lineaFactura) {
		this.cliente = Cliente;
		this.fecha = fecha; 
		this.precioTotal = precioTotal;
		this.lineaFactura = lineaFactura;
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

	public ArrayList<LineaFactura> getLineaFactura() {
		return lineaFactura;
	}

	public void setLineasFactura(ArrayList<LineaFactura> lineaFactura) {
		this.lineaFactura = lineaFactura;
	}	
	
}
