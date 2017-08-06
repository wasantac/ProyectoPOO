import java.time.LocalDateTime;
import java.util.Date;
import java.util.ArrayList;

public class Factura{

	private Cliente cliente;
	private Empleado vendedor;
	private LocalDateTime fecha; 
	private double precioTotal;
	private ListadoLineasFactura listadolineasfactura;

	public Factura() {
		this.cliente = new Cliente();
		this.vendedor = new Empleado();
		this.fecha = LocalDateTime.now(); 
		this.precioTotal = 0.0;
		this.listadolineasfactura = new ListadoLineasFactura();
	}
	
	public Factura(Cliente Cliente, Empleado vendedor, LocalDateTime fecha, double precioTotal, ListadoLineasFactura listadolineasfactura) {
		this.cliente = Cliente;
		this.fecha = fecha; 
		this.precioTotal = precioTotal;
		this.listadolineasfactura = listadolineasfactura;
		this.vendedor = vendedor;
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
	
	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}
	
	public ListadoLineasFactura getListadolineasfactura() {
		return listadolineasfactura;
	}

	public void setListadolineasfactura(ListadoLineasFactura listadolineasfactura) {
		this.listadolineasfactura = listadolineasfactura;
	}
	
	public void AgregarLineaFactura(LineaFactura lineaFactura) {
		this.listadolineasfactura.AgregarLineaFactura(lineaFactura);
		this.precioTotal = listadolineasfactura.getTotal();
	}

	public void RemoverLineaFactura(LineaFactura lineaFactura) {
		this.listadolineasfactura.RemoverLineaFactura(lineaFactura);
		this.precioTotal = listadolineasfactura.getTotal();
	}
	
}
