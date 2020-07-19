package Objetos;

import java.util.ArrayList;

import Listas.ListaPeliculas;

public class Cine {
	private static ArrayList<Empleado> lista_empleados;
	private static ListaPeliculas peliculas;
	private static ArrayList<Cliente> lista_clientes;
	private static ArrayList<Sala> salas;
	
	public Cine() {
		lista_clientes= new ArrayList <Cliente>();
		lista_empleados = new ArrayList <Empleado>();
		peliculas = new ListaPeliculas();
		salas = new ArrayList<Sala>();
		
	}

	public static ArrayList<Empleado> getLista_empleados() {
		return lista_empleados;
	}

	public static void setLista_empleados(ArrayList<Empleado> lista_empleados) {
		Cine.lista_empleados = lista_empleados;
	}

	public static ListaPeliculas getPeliculas() {
		return peliculas;
	}

	public static void setPeliculas(ListaPeliculas peliculas) {
		Cine.peliculas = peliculas;
	}

	public static ArrayList<Sala> getSalas() {
		return salas;
	}

	public static void setSalas(ArrayList<Sala> salas) {
		Cine.salas = salas;
	}
	
	public static ArrayList<Cliente> getLista_clientes() {
		return lista_clientes;
	}

	public static void setLista_clientes(ArrayList<Cliente> lista_clientes) {
		Cine.lista_clientes = lista_clientes;
	}

	public void Cartelera(){
		
		int i=1;
		
		for(Pelicula vpelicula:peliculas.getListaPeliculas()){
			System.out.println(Integer.toString(i) + ") "+ vpelicula+"\n");
			i++;
			
		}
	}
}
