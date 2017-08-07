import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author NARVAEZ, RANGLES, SUAREZ
 * Clase ListaEmpleados la cual crea la lista de empleados
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

	public void GenerarInformeEmpleados(String archivo) {
		 FileWriter fichero2 = null;
		 PrintWriter pw = null;
			
		try{
			fichero2 = new FileWriter(archivo, true);
			pw = new PrintWriter (fichero2);
			for(Empleado em: lista_empleados) {
				pw.println("***********************");
				pw.println("Apellido: " + em.getApellido());
				pw.println("Nombre: " + em.getNombre());
				pw.println("Cedula: " + em.getID());
				pw.println("Posicion: " + em.getPosicion());
				pw.println("Sueldo Base: " + em.getSueldoBase());
				pw.println("Horas Extras: " + em.getHorasExtras());
			}

			}
		catch(Exception e ){
			e.printStackTrace();
		}finally{
			try{
				if(null != fichero2);
				fichero2.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
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