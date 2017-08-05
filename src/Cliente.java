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
	public Cliente (String _nom, int _id, String _dir, int _tarjeta){
		this.direcccion= _dir;
		this.id= _id;
		this.nombre = _nom;
		this.tarjeta= _tarjeta;
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
	public int getTlf() {
		return tarjeta;
	}
	public void setTlf(int tlf) {
		this.tarjeta = tlf;
	}
}