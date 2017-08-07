import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author NARVAEZ, RANGLES, SUAREZ
 * Clase Lista_CLientes la cual crea la lista de clientes
 */
public class ListaClientes {

	private static ArrayList<Cliente> lista_clientes= new ArrayList <Cliente>();

	public ListaClientes(){

	}

	public Cliente buscar(String vid){

		for(Cliente c: lista_clientes){

			if(c.getID() == vid){

				System.out.println("Cliente " + c.getID()+" "+c.getNombre()+" "+c.getDirecccion()+Integer.toString(c.getTarjeta()));

			}

		}
		return null;
	}



	public boolean existeCLiente(String vid){

		for(Cliente c: lista_clientes){

			if(c.getID() == vid){

				System.out.println("El cliente si existe");
				return true;

			}				
		}

		System.out.println("El cliente no existe");
		return false;
	}
	
	
	public boolean idCorrecto(String vid){
		
						
		vid = vid.trim();
		
		for(int i=0; i<vid.length(); i++){
			
			Character.isLetterOrDigit(i);
				
		}
		return true;
		
	}


	public void imprimir(){

		Iterator<Cliente> i = lista_clientes.iterator();

		while(i.hasNext()){

			int j=1;
			Cliente c = i.next();
			System.out.println(j+") "+"Cliente" + " " +c.getID()+" "+c.getNombre()+" "+c.getDirecccion()+" "+Integer.toString(c.getTarjeta()));
			j++;
		}
	}

	public void ingresar(String vnombre, String vID, String vdir, int vtarjeta){

		lista_clientes.add(new Cliente(vnombre, vID, vdir, vtarjeta));
	}

	public void eliminar(String vid){

		for(Cliente c: lista_clientes){

			if(c.getID() == vid){

				lista_clientes.remove(c);

				break;
			}
		}
	}

	public void GenerarInformeClientes(String archivo) {
		PrintWriter pw = null;
		FileWriter fichero3 = null;
		
	try{
		fichero3 = new FileWriter(archivo, true);
		pw = new PrintWriter (fichero3);
		for(Cliente c: lista_clientes) {
			pw.println("***********************");
			pw.println("Nombre: " + c.getNombre());
			pw.println("Cedula: " + c.getID());
			pw.println("Tarjeta: " + c.getTarjeta());
		}
	}catch(Exception e ){
		e.printStackTrace();
	}finally{
		try{
			if(null != fichero3);
			fichero3.close();
		}catch(Exception e2){
			e2.printStackTrace();
		}
	}
	
	}
}