package Objetos;

public class Persona {
	
	private String nombre;
	private String apellido;
	private String ID;
	private String direcccion;
	
	public Persona(String nombre,String apellido,String ID,String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.ID = ID;
		this.direcccion = direccion;
		
	}

	public Persona() {
		this.nombre ="Consumidor";
		this.apellido = "Final";
		this.ID = "0";
		this.direcccion = "Cine";
		
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDirecccion() {
		return direcccion;
	}

	public void setDirecccion(String direcccion) {
		this.direcccion = direcccion;
	}
	
	
}
