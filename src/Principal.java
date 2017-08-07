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
			System.out.println("5.SALIR");

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
					
					If(vid == false){

					System.out.println("Ingrese los datos del cliente ");	

					System.out.println("Ingrese el nombre del cliente:  ");	

					nombre = sc.next();

					

					System.out.println("Ingrese la direccion del cliente:  ");
					direccion = sc.next();

					System.out.println("Ingrese el numero de tarjeta del cliente:  ");
					tarjeta= sc.nextInt();	
					
					}else{
						
						
						si existe el cliente
						
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

				System.exit(0); 

			}
		}
	}

	public void GenerarInformeFacturas(String archivo) {
		
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

	
/*while(true){

		menu_cliente();
		System.out.println();
		System.out.println();
	}
 */


private static void CrearFicheroInicial(String sFichero) {
	// Lectura del archivo

	// Creacion de las 4 salas
	Sala sala = new Sala();
	sala.setNumSala(1);

	ListaAsientos asientosSala1 = new ListaAsientos();
	asientosSala1.setColumnas(9);
	asientosSala1.setFilas(12);

	ListaFormatosSala formatos = new ListaFormatosSala(); 

	Asiento asiento1 = new Asiento('h',3);

	if (!asientosSala1.AsignarAsiento(asiento1)) {
		System.out.println("ya existe el asiento");
	}

	//asientosSala1.RemoverAsiento('h', 3);
	sala.setAsientos(asientosSala1);
	FormatoSala formato = new FormatoSala();
	sala.setFormato(formato);
	formatos.AgregarFormato(formato);

	Pelicula pelicula = new Pelicula();
	pelicula.setNombre("TRANSFORMERS");

	peliculas.ingresarpelicula(pelicula);	

	LocalDateTime inicio = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
	LocalDateTime fin = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 00, 0);
	HorarioSala horario1 = new HorarioSala(inicio, fin, pelicula, sala);
	horarios.AgregarHorario(horario1);

	LocalDateTime inicio1 = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
	LocalDateTime fin1 = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 10, 0);
	LocalDateTime inicio2 = LocalDateTime.of(2017, Month.AUGUST, 6, 12, 10, 0);
	LocalDateTime fin2 = LocalDateTime.of(2017, Month.AUGUST, 6, 13, 30, 0);
	LocalDateTime inicio3 = LocalDateTime.of(2017, Month.AUGUST, 7, 20, 10, 0);
	LocalDateTime fin3 = LocalDateTime.of(2017, Month.AUGUST, 7, 11, 22, 10);


	horarios.AgregarHorario(inicio1, fin1, pelicula, sala);
	horarios.AgregarHorario(inicio2, fin2, pelicula, sala);
	horarios.AgregarHorario(inicio3, fin3, pelicula, sala);


	horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 5); 
	horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 6);
	horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 7);
	horarios.ImprimirHorarioPelicula(pelicula, 2017, 8, 8);


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
	lineafactura.setPrecioUnitario(sala.getFormato().getPrecio(), cliente1.getTarjeta());
	lineafactura.setAsientos(asientosFactura);
	lineafactura.setHorarioSala(horario1);

	factura.AgregarLineaFactura(lineafactura);

	///////////////////////////////////////////////////////////////////////////////
	//pruebas clientes
	peliculas.Cartelera();
	formatos.ObtenerPrecio(cliente1.getTarjeta(), "2D");
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


































import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class Principal implements Serializable {

	private static final long serialVersionUID = 1L;
	static ArrayList<Sala> salas = new ArrayList<Sala>();
	static ArrayList<Factura> facturas = new ArrayList<Factura>();
	static ListaPeliculas peliculas = new ListaPeliculas();
	static ListadoHorarioSala horarios = new ListadoHorarioSala();
	
	public static void main(String[] args) {

	    File fichero = new File("data.txt");
	    
	    if (!fichero.exists()) {
	    	CrearFicheroInicial("data.txt");	
	    }
	    //else {
	    //	leerFicheroInicial(sFichero);
	    //}

	}
	    
	private static void CrearFicheroInicial(String sFichero) {
		// Lectura del archivo

		// Creacion de las 4 salas
		Sala sala = new Sala();
		sala.setNumSala(1);

		ListaAsientos asientosSala1 = new ListaAsientos();
		asientosSala1.setColumnas(9);
		asientosSala1.setFilas(12);

		ListaFormatosSala formatos = new ListaFormatosSala(); 

		Asiento asiento1 = new Asiento('h',3);

		if (!asientosSala1.AsignarAsiento(asiento1)) {
			System.out.println("ya existe el asiento");
		}

		//asientosSala1.RemoverAsiento('h', 3);
		sala.setAsientos(asientosSala1);
		FormatoSala formato = new FormatoSala();
		sala.setFormato(formato);
		formatos.AgregarFormato(formato);
		
		Pelicula pelicula = new Pelicula();
		pelicula.setNombre("TRANSFORMERS");
        pelicula.setIdioma("Ingles");
        pelicula.setCensura("Mayores de 12 años");
		peliculas.ingresarpelicula(pelicula);

		Scanner sc = new Scanner(System.in);
		FileWriter fichero1 = null;
		PrintWriter pw = null;
		try{
			fichero1 = new FileWriter("C:\\Users\\ANAHI\\Documents\\CrearDirectorio\\Peliculas.txt", true);
			pw = new PrintWriter (fichero1);
			pw.println(pelicula);		
			}
		catch(Exception e ){
			e.printStackTrace();
		}finally{
			try{
				if(null != fichero1);
				fichero1.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		
		LocalDateTime inicio = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
		LocalDateTime fin = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 00, 0);
		HorarioSala horario1 = new HorarioSala(inicio, fin, pelicula, sala);
		horarios.AgregarHorario(horario1);

		LocalDateTime inicio1 = LocalDateTime.of(2017, Month.AUGUST, 5, 9, 10, 0);
		LocalDateTime fin1 = LocalDateTime.of(2017, Month.AUGUST, 5, 11, 10, 0);
		LocalDateTime inicio2 = LocalDateTime.of(2017, Month.AUGUST, 6, 12, 10, 0);
		LocalDateTime fin2 = LocalDateTime.of(2017, Month.AUGUST, 6, 13, 30, 0);
		LocalDateTime inicio3 = LocalDateTime.of(2017, Month.AUGUST, 7, 20, 10, 0);
		LocalDateTime fin3 = LocalDateTime.of(2017, Month.AUGUST, 7, 11, 22, 10);


		horarios.AgregarHorario(inicio1, fin1, pelicula, sala);
		horarios.AgregarHorario(inicio2, fin2, pelicula, sala);
		horarios.AgregarHorario(inicio3, fin3, pelicula, sala);


		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 5); 
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 6);
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 7);
		horarios.ImprimirHorarioPelicula(pelicula, 2017, Month.AUGUST, 8);


		Empleado vendedor1 = new Empleado("Patricio","Rangles","1717104127");
		vendedor1.setPosicion("Vendedor");
		
		 FileWriter fichero2 = null;
		
		try{
			fichero2 = new FileWriter("C:\\Users\\ANAHI\\Documents\\CrearDirectorio\\Empleados.txt", true);
			pw = new PrintWriter (fichero2);
			pw.println("***********************");
			pw.println("Apellido: " + vendedor1.getApellido());
			pw.println("Nombre: " + vendedor1.getNombre());
			pw.println("Cedula: " + vendedor1.getID());
			pw.println("Posicion: " + vendedor1.getPosicion());
			pw.println("Sueldo Base: " + vendedor1.getSueldoBase());
			pw.println("Horas Extras: " + vendedor1.getHorasExtras());

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
		
		
		
		

		Cliente cliente1 = new Cliente("Luchito Cifuentes","1823632929");
		cliente1.setTarjeta(1);
		
		 FileWriter fichero3 = null;
		
		try{
			fichero3 = new FileWriter("C:\\Users\\ANAHI\\Documents\\CrearDirectorio\\Clientes.txt", true);
			pw = new PrintWriter (fichero3);
			
			pw.println("***********************");
			pw.println("Nombre: " + cliente1.getNombre());
			pw.println("Cedula: " + cliente1.getID());
			pw.println("Tarjeta: " + cliente1.getTarjeta());
			
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
		
		
		
		

		Factura factura = new Factura();
		factura.setCliente(cliente1);
		factura.setFecha(LocalDateTime.of(2017, Month.AUGUST, 5, 07, 33, 30));
		

		ArrayList<Asiento> asientosFactura = new ArrayList<Asiento>(); 
		asientosFactura.add(asiento1);

		LineaFactura lineafactura = new LineaFactura();
		lineafactura.setCantidad(3);
		lineafactura.setPrecioUnitario(sala.getFormato().getPrecio(), cliente1.getTarjeta());
		lineafactura.setAsientos(asientosFactura);
		lineafactura.setHorarioSala(horario1);

		factura.AgregarLineaFactura(lineafactura);
		
        FileWriter fichero4 = null;
		
		try{
			fichero4 = new FileWriter("C:\\Users\\ANAHI\\Documents\\CrearDirectorio\\Facturas.txt", true);
			pw = new PrintWriter (fichero4);
			
			pw.println("***********************");
			pw.println(factura.getClass());
			pw.println("Fecha: " + factura.getFecha());
			pw.println(factura.getCliente());
			pw.println("Horario de la pelicula: "+ lineafactura.getHorarioSala());
			pw.println("Pelicula: " + pelicula.toString());
			pw.println("Detalles de los Asientos: " + lineafactura.getAsientos());
			pw.println("Numero de boletos: " + lineafactura.getCantidad());
			pw.println("Precio unitario: " + lineafactura.getPrecioUnitario());
			pw.println("TOTAL: " + factura.getPrecioTotal()+ "dolares.");
			}
		catch(Exception e ){
			e.printStackTrace();
		}finally{
			try{
				if(null != fichero4);
				fichero4.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		///////////////////////////////////////////////////////////////////////////////
		//pruebas clientes
		peliculas.Cartelera();
		formatos.ObtenerPrecio(cliente1.getTarjeta(), "2D");
		// desde escoger pelicula hasta comprar boleto se hace con los objetos existentes con el ejemplo anterior
		asientosSala1.VisualizacionAsientos();

		
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
