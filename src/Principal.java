import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	while(true){

		menu_cliente();
		System.out.println();
		System.out.println();
	}
}

	

	public static void menu_cliente(){

		System.out.println("*****BIENVENIDO******");
		System.out.println("1.VER CARTELERA");
		System.out.println("2.COMPRAR BOLETO");
		System.out.println("3.SALIR");

		int id;
		char opcion = sc.next().charAt(0);

		switch(opcion){

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
				
				;
				horarios.ImprimirHorarioPelicula(peliculas.obtenerPelicula(pelicula), LocalDateTime.now().getYear(), LocalDateTime.now().getMonth().getValue(), LocalDateTime.now().getDayOfMonth());	
				
				horario = sc.nextInt();

				System.out.println("Seleccione la butaca: ");
				//mostrar la matriz
				butaca = sc.next();

			}catch(Exception e){

				e.getStackTrace();

			}

			break;

		case '3':

			System.exit(0); 

		}
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

