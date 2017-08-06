/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase CLiente la cual crea objetos del tipo Cliente.
 */
public class Cliente {

	private String nombre;
	private int id;
	private String direcccion;
	private int tarjeta;

	/**
	 * Constructor por defecto 
	 */
	public Cliente (){
		this.direcccion= null;
		this.id= 0;
		this.nombre = null;
		this.tarjeta= 0;
	}
	
	/**
	 * @param _nom string
	 * @param _id int 
	 * @param _dir string 
	 * @param _tarjeta int
	 */
	public Cliente(String nombre, int id, String dir, int tarjeta){
		this.direcccion = dir;
		this.id = id;
		this.nombre = nombre;
		this.tarjeta= tarjeta;
	}

	/**
	 * Getters and Setters
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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