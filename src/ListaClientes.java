import java.util.ArrayList;
import java.util.Iterator;
/**
 * @author NARVAEZ, RANGLES, SUAREZ
 * Clase Lista_Jugadores la cual crea la lista de jugadores
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
				

			}else{

				System.out.println("El cliente no existe");
			}
				
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
}