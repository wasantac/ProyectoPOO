import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author NARVAEZ, RANGLES, SUAREZ
 * Clase Lista_Jugadores la cual crea la lista de jugadores
 */
public class ListaEmpleados {



	private static ArrayList<Empleado> lista_empleados= new ArrayList <Empleado>();

	public ListaEmpleados(){

	}

	public Empleado buscar(String vid){

		for(Empleado e: lista_empleados){

			if(e.getID() == vid){

				System.out.println("Empleado " + e.getID()+" "+e.getNombre()+" "+e.getApellido()+e.getPosicion());

			}

		}
		return null;
	}
	
	
	public boolean existeEmpleado(String vid){

		for(Empleado e: lista_empleados){

			if(e.getID() == vid){

				System.out.println("El empleado si existe");
				

			}else{

				System.out.println("El empleado no existe");
			}
				
		}

		return true;

	}
	

	public void imprimir(){

		Iterator<Empleado> i = lista_empleados.iterator();

		while(i.hasNext()){

			int c = 1;
			Empleado e = i.next();
			System.out.println(c+") "+"Empleado" + " " +e.getID()+" "+e.getNombre()+" "+" "+e.getApellido()+e.getPosicion());
			c++;
		}
	}

	public void ingresar(String vID, String vnombre, String vapellido,String vposicion){

		lista_empleados.add(new Empleado(vID, vnombre, vapellido, vposicion));
	}

	public void eliminar(String vid){

		for(Empleado e: lista_empleados){

			if(e.getID() == vid){

				lista_empleados.remove(e);

				break;
			}
		}
	}
}