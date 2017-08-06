/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase CLiente la cual crea objetos del tipo Cliente.
 */
public class Cliente {

	private final String nombre;
	private final String ID;
	private String direcccion;
	private int tarjeta;

	/**
	 * Constructor por defecto 
	 */
	public Cliente (String nombre, String ID){
		this.direcccion= null;
		this.ID= ID;
		this.nombre = nombre;
		this.tarjeta= 0;
	}
	
	/**
	 * @param _nom string
	 * @param _id int 
	 * @param _dir string 
	 * @param _tarjeta int
	 */
	public Cliente(String nombre, String ID, String dir, int tarjeta){
		this.direcccion = dir;
		this.ID = ID;
		this.nombre = nombre;
		this.tarjeta= tarjeta;
	}

	/**
	 * Getters and Setters
	 */
	public String getNombre() {
		return nombre;
	}
	public String getID() {
		return ID;
	}

	public String getDirecccion() {
		return direcccion;
	}
	
	public void setDirecccion(String direcccion) {
		this.direcccion = direcccion;
	}
	public int getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}
}