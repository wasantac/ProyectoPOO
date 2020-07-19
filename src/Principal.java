import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import Listas.ListaAsientos;
import Listas.ListaClientes;
import Listas.ListaEmpleados;
import Listas.ListaFormatosSala;
import Listas.ListaPeliculas;
import Listas.ListadoHorarioSala;
import Listas.ListadoLineasFactura;
import Objetos.Asiento;
import Objetos.Cine;
import Objetos.Cliente;
import Objetos.Empleado;
import Objetos.Factura;
import Objetos.FormatoSala;
import Objetos.HorarioSala;
import Objetos.LineaFactura;
import Objetos.Pelicula;
import Objetos.Sala;
/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Principal del sistema.
 */
public class Principal  {
	/**
	 * Interface: implementa serializable a todas las clases y no lo utiliza
Open close: Reptie muchos datos los cuales pueden estar en una clase padre
Single responsibility: Exisiten clases que tienen métodos para cambiar otros datos
Single responsibility: Se asignan a las listas que hagan funciones que haria el cine
Interface: Se puede implementar una interfaz impersion ya que exiten metodos iguales en alguna de las listas
	 */
	static Cine c;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Factura> facturas = new ArrayList<Factura>();
	static ListadoHorarioSala horarios = new ListadoHorarioSala();
	static ListaFormatosSala formatos = new ListaFormatosSala();
	static ListaClientes clientes = new ListaClientes();
	static ListaEmpleados empleados = new ListaEmpleados();

	public static void main(String[] args) throws Exception {

		File fichero = new File("data.txt");

		if (!fichero.exists()) {
			c = CrearFicheroInicial("data.txt");	
		}
		//else {
		//	leerFicheroInicial(sFichero);
		//}
		clientes.ingresar(c.getLista_clientes());
		empleados.ingresar(c.getLista_empleados());
		System.out.println("*****BIENVENIDO******");
		System.out.println("1.CLIENTE");
		System.out.println("2.VENDEDOR");
		System.out.println("3.ADMINISTRADOR");

		int id;
		char opcion = sc.next().charAt(0);

		switch(opcion){

		case '1':

			System.out.println("*****BIENVENIDO******");
			System.out.println("1.VER CARTELERA");
			System.out.println("2.COMPRAR BOLETO");
			System.out.println("3.SALIR");

			char opcion1 = sc.next().charAt(0);

			switch(opcion1){

			case '1':

				c.Cartelera();
				break;

			case '2':

				try{

					int pelicula;
					int horario;
					String butaca;

					c.Cartelera();
					System.out.println("Escoger pelicula: ");			
					pelicula = sc.nextInt();

					c.getPeliculas().obtenerPelicula(pelicula);

					System.out.println("Seleccione el horario: ");


					horarios.ImprimirHorarioPelicula(c.getPeliculas().obtenerPelicula(pelicula), LocalDateTime.now().getYear(), LocalDateTime.now().getMonth().getValue(), LocalDateTime.now().getDayOfMonth());	

					horario = sc.nextInt();

					HorarioSala h = horarios.obtenerHorario(horario);

					h.getSala().getAsientos().VisualizacionAsientos();

					System.out.println("Ingrese la butaca en este formato: fila,numero \n ejemplo: h,3 ");

					System.out.println("Seleccione la butaca: ");

					butaca = sc.next();

					if(!h.getSala().getAsientos().FormatoAsientoCorrecto(butaca)) {

						System.out.println("El formato correcto es\n letra,numero\n ejemplo: h,3");

					}else {

						if(h.getSala().getAsientos().AsientoAsignado(butaca)== true){

							System.out.println("ASIENTO OCUPADO");

						}else if(h.getSala().getAsientos().AsignarAsiento(butaca)== true){

							System.out.println("Asiento Asignado "+ butaca);

						}
					}


				}catch(Exception e){

					e.getStackTrace();
				}

				break;

			case '3':

				System.exit(0); 
			}

		case '2':

			System.out.println("*****BIENVENIDO******");
			System.out.println("1.LOGUEAR");
			System.out.println("2.VENDER BOLETO");
			System.out.println("3.GENERAR FACTURA"); 
			System.out.println("4.SALIR");

			char opcion2 = sc.next().charAt(0);

			switch(opcion2){

			case '1':

				String username;
				String password;

				System.out.println("Username: ");	
				username = sc.next();
				System.out.println("Password: ");	
				password = sc.next();		
				break;

			case '2':

				try{

					String ID;
					String nombre;
					String apellido;
					String direccion;
					int tarjeta;

					System.out.println("Ingrese el ID del cliente: ");
					ID= sc.next();

					if(clientes.existeCLiente(ID) == false){

						System.out.println("Ingrese los datos del cliente ");	

						System.out.println("Ingrese el nombre del cliente:  ");	

						nombre = sc.next();
						System.out.println("Ingrese el nombre del cliente:  ");	

						apellido = sc.next();
						
						System.out.println("Ingrese la direccion del cliente:  ");
						direccion = sc.next();

						System.out.println("Ingrese el numero de tarjeta del cliente:  ");
						tarjeta= sc.nextInt();	
						Cliente c = new Cliente(nombre,apellido,ID, direccion, tarjeta);
						clientes.ingresar(c);
					}else{

						System.out.println("El cliente ya existe!!");
					}

				}catch(Exception e){

					e.getStackTrace();
				}

				break;

			

			case '3':

				GenerarInformeFacturas("informe-facturas.txt");
				
				break;


			case '4':

				System.exit(0); 

			}

		case '3':

			System.out.println("*****BIENVENIDO******");
			System.out.println("1.GENERAR REPORTE CLIENTES");
			System.out.println("2.GENERAR REPORTE EMPLEADOS");
			System.out.println("3.GENERAR REPORTE PELICULAS");
			System.out.println("4.SALIR");

			char opcion3 = sc.next().charAt(0);

			switch(opcion3){
			
			case '1':
				clientes.GenerarInformeClientes("reporte-clientes.txt");
				break;

			case '2':
				empleados.GenerarInformeEmpleados("reporte-empleados.txt");
				break;

			case '3':
				c.getPeliculas().GenerarInformePeliculas("reporte-peliculas.txt");
				break;
			case '4':	

				System.exit(0); 

			}
		}
	}

	public static void GenerarInformeFacturas(String archivo) {

		PrintWriter pw = null;
		FileWriter fichero2 = null;

		try{
			fichero2 = new FileWriter(archivo, true);
			pw = new PrintWriter (fichero2);

			for (Factura f : facturas) {
				pw.println("***********************");
				pw.println(f.getClass());
				pw.println("Fecha: " + f.getFecha());
				pw.println(f.getCliente());
				ListadoLineasFactura llf = f.getListadolineasfactura();
				for(LineaFactura lf: llf.getLineasFactura()) {
					pw.println("Horario de la pelicula: "+ lf.getHorarioSala());
					pw.println("Pelicula: " + lf.getHorarioSala().getPelicula().toString());
					pw.println("Detalles de los Asientos: " + lf.getAsientos());
					pw.println("Numero de boletos: " + lf.getCantidad());
					pw.println("Precio unitario: " + lf.getPrecioUnitario());
				}
				pw.println("TOTAL: " + f.getPrecioTotal()+ "dolares.");
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


	private static Cine CrearFicheroInicial(String sFichero) {
		// Lectura del archivo

		// Creacion de las 4 salas
		Cine cine = new Cine();
		Sala sala1 = new Sala();
		sala1.setNumSala(1);
		Sala sala2 = new Sala();
		sala2.setNumSala(2);
		Sala sala3 = new Sala();
		sala3.setNumSala(3);
		Sala sala4 = new Sala();
		sala4.setNumSala(4);
		FormatoSala formato = new FormatoSala();
		formatos.AgregarFormato(formato);
		FormatoSala formato1 = new FormatoSala("3D", 7.50);
		formatos.AgregarFormato(formato1);
		FormatoSala formato2 = new FormatoSala("IMAX", 9.25);
		formatos.AgregarFormato(formato2);
		sala1.setFormato(formato);


		sala1.getAsientos().setColumnas(9);
		sala1.getAsientos().setFilas(12);

		sala2.getAsientos().setColumnas(8);
		sala2.getAsientos().setFilas(10);

		sala3.getAsientos().setColumnas(5);
		sala3.getAsientos().setFilas(7);

		Asiento asiento1 = new Asiento('h',3);
	    Asiento asiento2 = new Asiento('b',5);
		Asiento asiento3 = new Asiento('d',1);
		Asiento asiento4 = new Asiento('f',7);


		Pelicula pelicula1 = new Pelicula("TRANSFORMERS", 120, "Ingles", "12");
		Pelicula pelicula2 = new Pelicula("AVENGERS", 180, "Espanol", "Todo Publico");
		Pelicula pelicula3 = new Pelicula("IRON MAN 3", 190, "Ingles", "Todo Publico");
		Pelicula pelicula4 = new Pelicula("MI NOVIA POLY", 160, "Ingles", "12");

		cine.getSalas().add(sala1);
		cine.getSalas().add(sala2);
		cine.getSalas().add(sala3);
		cine.getSalas().add(sala4);
		cine.getPeliculas().ingresarpelicula(pelicula1);
		cine.getPeliculas().ingresarpelicula(pelicula2);
		cine.getPeliculas().ingresarpelicula(pelicula3);
		cine.getPeliculas().ingresarpelicula(pelicula4);
		
		
		LocalDateTime inicio = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
		LocalDateTime fin = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 00, 0);
		HorarioSala horario1 = new HorarioSala(inicio, fin, pelicula1, sala1);

		LocalDateTime inicio1 = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
		LocalDateTime fin1 = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 10, 0);
		LocalDateTime inicio2 = LocalDateTime.of(2017, Month.AUGUST, 6, 12, 10, 0);
		LocalDateTime fin2 = LocalDateTime.of(2017, Month.AUGUST, 6, 13, 30, 0);
		LocalDateTime inicio3 = LocalDateTime.of(2017, Month.AUGUST, 7, 20, 10, 0);
		LocalDateTime fin3 = LocalDateTime.of(2017, Month.AUGUST, 7, 11, 22, 10);

		horarios.AgregarHorario(horario1);
		horarios.AgregarHorario(inicio1, fin1, pelicula1, sala2);
		horarios.AgregarHorario(inicio2, fin2, pelicula1, sala3);
		horarios.AgregarHorario(inicio3, fin3, pelicula2, sala1);



		Empleado vendedor1 = new Empleado("Patricio","Rangles","1717104127","xxxx");
		vendedor1.setPosicion("Vendedor");

		Cliente cliente1 = new Cliente("Luchito"," Cifuentes","1823632929","xxxx",1);

		Factura factura = new Factura(vendedor1);
		factura.setCliente(cliente1);
		factura.setFecha(LocalDateTime.of(2017, Month.AUGUST, 5, 07, 33, 30));

		ArrayList<Asiento> asientosFactura = new ArrayList<Asiento>(); 
		asientosFactura.add(asiento1);

		LineaFactura lineafactura = new LineaFactura();
		lineafactura.setCantidad(3);
		lineafactura.setPrecioUnitario(sala1.getFormato().getPrecio(), cliente1.getTarjeta());
		lineafactura.setAsientos(asientosFactura);
		lineafactura.setHorarioSala(horario1);

		factura.AgregarLineaFactura(lineafactura);
		return cine;
		
	}

}
