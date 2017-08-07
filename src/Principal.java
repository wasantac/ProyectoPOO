import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal implements Serializable  {

	static Scanner sc = new Scanner(System.in);
	private static final long serialVersionUID = 1L;
	static ArrayList<Sala> salas = new ArrayList<Sala>();
	static ArrayList<Factura> facturas = new ArrayList<Factura>();
	static ListaPeliculas peliculas = new ListaPeliculas();
	static ListadoHorarioSala horarios = new ListadoHorarioSala();
	static ListaFormatosSala formatos = new ListaFormatosSala();
	static ListaClientes clientes = new ListaClientes();	
	static ListaEmpleados empleados = new ListaEmpleados();	

	public static void main(String[] args) throws Exception {

		File fichero = new File("data.txt");

		if (!fichero.exists()) {
			CrearFicheroInicial("data.txt");	
		}
		//else {
		//	leerFicheroInicial(sFichero);
		//}

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

				peliculas.Cartelera();
				break;

			case '2':

				try{

					int pelicula;
					int horario;
					String butaca;

					peliculas.Cartelera();
					System.out.println("Escoger pelicula: ");			
					pelicula = sc.nextInt();

					peliculas.obtenerPelicula(pelicula);

					System.out.println("Seleccione el horario: ");


					horarios.ImprimirHorarioPelicula(peliculas.obtenerPelicula(pelicula), LocalDateTime.now().getYear(), LocalDateTime.now().getMonth().getValue(), LocalDateTime.now().getDayOfMonth());	

					horario = sc.nextInt();

					HorarioSala h = horarios.obtenerHorario(horario);

					h.getSala().getAsientos().VisualizacionAsientos();

					System.out.println("Ingrese la butaca en este formato: fila (espacio) numero, ejemplo h 3 ");

					System.out.println("Seleccione la butaca: ");

					butaca = sc.next();

					if(!h.getSala().getAsientos().FormatoAsientoCorrecto(butaca)) {

						System.out.println("El formato correcto es\n letra (espacio) numero, ejemplo: h 3");

					}else {

						if(h.getSala().getAsientos().AsientoAsignado(butaca)== true){

							System.out.println("ASIENTO OCUPADO");

						}else if(h.getSala().getAsientos().AsignarAsiento(butaca)== true){

							System.out.println("Asiento Asignado"+ butaca);

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
			System.out.println("3.IMPRIMIR BOLETO");
			System.out.println("4.EMITIR FACTURA");
			System.out.println("5.GENERAR FACTURA"); 
			System.out.println("6.SALIR");

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
					String direccion;
					int tarjeta;

					System.out.println("Ingrese el ID del cliente: ");
					ID= sc.next();

					if(clientes.existeCLiente(ID) == false){

						System.out.println("Ingrese los datos del cliente ");	

						System.out.println("Ingrese el nombre del cliente:  ");	

						nombre = sc.next();

						System.out.println("Ingrese la direccion del cliente:  ");
						direccion = sc.next();

						System.out.println("Ingrese el numero de tarjeta del cliente:  ");
						tarjeta= sc.nextInt();	

						clientes.ingresar(nombre, ID, direccion, tarjeta);
					}else{

						System.out.println("El cliente ya existe!!");
					}

				}catch(Exception e){

					e.getStackTrace();
				}

				break;

			case '3':

				System.out.println("BOLETO: //todos los atributos del boleto");

			case '4':

				System.out.println("FACTURA: //todos los atributos de la factura");

			case '5':

				GenerarInformeFacturas("informe-facturas.txt");


			case '6':

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
				peliculas.GenerarInformePeliculas("reporte-peliculas.txt");
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


private static void CrearFicheroInicial(String sFichero) {
	// Lectura del archivo

	// Creacion de las 4 salas
	Sala sala1 = new Sala();
	sala1.setNumSala(1);
	Sala sala2 = new Sala();
	sala2.setNumSala(2);
	Sala sala3 = new Sala();
	sala3.setNumSala(3);
	Sala sala4 = new Sala();
	sala4.setNumSala(4);

	ListaAsientos asientosSala1 = new ListaAsientos();
	asientosSala1.setColumnas(9);
	asientosSala1.setFilas(12);

	ListaAsientos asientosSala2 = new ListaAsientos();
	asientosSala2.setColumnas(8);
	asientosSala2.setFilas(10);

	ListaAsientos asientosSala3 = new ListaAsientos();
	asientosSala3.setColumnas(5);
	asientosSala3.setFilas(7);


	Asiento asiento1 = new Asiento('h',3);
    Asiento asiento2 = new Asiento('b',5);
	Asiento asiento3 = new Asiento('d',1);
	Asiento asiento4 = new Asiento('f',7);

	
	FormatoSala formato = new FormatoSala();
	formatos.AgregarFormato(formato);
	FormatoSala formato1 = new FormatoSala("3D", 7.50);
	formatos.AgregarFormato(formato1);
	FormatoSala formato2 = new FormatoSala("IMAX", 9.25);
	formatos.AgregarFormato(formato2);
	
	sala1.setAsientos(asientosSala1);
	sala1.setFormato(formato);

	
	
	Pelicula pelicula = new Pelicula();
	pelicula.setNombre("TRANSFORMERS");

	peliculas.ingresarpelicula(pelicula);	

	LocalDateTime inicio = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
	LocalDateTime fin = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 00, 0);
	HorarioSala horario1 = new HorarioSala(inicio, fin, pelicula, sala1);
	horarios.AgregarHorario(horario1);

	LocalDateTime inicio1 = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
	LocalDateTime fin1 = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 10, 0);
	LocalDateTime inicio2 = LocalDateTime.of(2017, Month.AUGUST, 6, 12, 10, 0);
	LocalDateTime fin2 = LocalDateTime.of(2017, Month.AUGUST, 6, 13, 30, 0);
	LocalDateTime inicio3 = LocalDateTime.of(2017, Month.AUGUST, 7, 20, 10, 0);
	LocalDateTime fin3 = LocalDateTime.of(2017, Month.AUGUST, 7, 11, 22, 10);


	horarios.AgregarHorario(inicio1, fin1, pelicula, sala1);
	horarios.AgregarHorario(inicio2, fin2, pelicula, sala2);
	horarios.AgregarHorario(inicio3, fin3, pelicula, sala2);


	//horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 5); 
	//horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 6);
	//horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 7);
	//horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 8);


	Empleado vendedor1 = new Empleado("Patricio","Rangles","1717104127");
	vendedor1.setPosicion("Vendedor");

	Cliente cliente1 = new Cliente("Luchito Cifuentes","1823632929");
	cliente1.setTarjeta(1);

	Factura factura = new Factura();
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

	///////////////////////////////////////////////////////////////////////////////
	//pruebas clientes
	//peliculas.Cartelera();
	//formatos.ObtenerPrecio(cliente1.getTarjeta(), "2D");
	// desde escoger pelicula hasta comprar boleto se hace con los objetos existentes con el ejemplo anterior



	//// Escritura del archivo
	//FileManager.WriteObject obj = new WriteObject();

	//Address address = new Address();
	//address.setStreet("wall street");
	//address.setCountry("united state");

	//obj.serializeAddress(address);

}

	//	public void serializeAddress(Address address) {
	//
	//		FileOutputStream fout = null;
	//		ObjectOutputStream oos = null;
	//
	//		try {
	//
	//			fout = new FileOutputStream("c:\\temp\\address.ser");
	//			oos = new ObjectOutputStream(fout);
	//			oos.writeObject(address);
	//
	//			System.out.println("Done");
	//
	//		} catch (Exception ex) {
	//
	//			ex.printStackTrace();
	//
	//		} finally {
	//
	//			if (fout != null) {
	//				try {
	//					fout.close();
	//				} catch (IOException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//
	//			if (oos != null) {
	//				try {
	//					oos.close();
	//				} catch (IOException e) {
	//					e.printStackTrace();
	//				}
	//			}
	//
	//		}
	//	}
	//
	//	public void serializeAddressJDK7(Address address) {
	//
	//		try (ObjectOutputStream oos =
	//				new ObjectOutputStream(new FileOutputStream("c:\\temp\\address2.ser"))) {
	//
	//			oos.writeObject(address);
	//			System.out.println("Done");
	//
	//		} catch (Exception ex) {
	//			ex.printStackTrace();
	//		}
	//
	//	}	
}
