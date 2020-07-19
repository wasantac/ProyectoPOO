package Objetos;
/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase CLiente la cual crea objetos del tipo Cliente.
 */
public class Cliente extends Persona{

	private int tarjeta;

	/**
	 * Constructor por defecto 
	 */
	public Cliente (){
		super();
		this.tarjeta= 0;
	}
	public Cliente (String nombre,String apellido,String ID,String direccion){
		super(nombre,apellido,ID,direccion);
		this.tarjeta= 0;
	}
	
	/**
	 * @param _nom string
	 * @param _id int 
	 * @param _dir string 
	 * @param _tarjeta int
	 */
	public Cliente(String nombre,String apellido,String ID,String direccion, int tarjeta){
		super(nombre,apellido,ID,direccion);
		this.tarjeta= tarjeta;
	}

	/**
	 * Getters and Setters
	 */
	public int getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}
}