import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// COntrola la salas existentes
		ArrayList<Sala> salas = new ArrayList<Sala>();
		//

		Sala sala = new Sala();
		sala.setNumSala(1);



		ListaAsientos asientosSala1 = new ListaAsientos();
		asientosSala1.setColumnas(15);
		asientosSala1.setFilas(8);

		System.out.println(asientosSala1.getDisponibles());

		if (!asientosSala1.AsignarAsiento('h', 3)) {
			System.out.println("ya existe el asiento");
		}


		asientosSala1.AsignarAsiento('d', 8);
		asientosSala1.AsignarAsiento('d', 9);

		asientosSala1.imprimir();

		asientosSala1.RemoverAsiento('d', 9);


		asientosSala1.imprimir();
	}
}