import java.util.ArrayList;

public class Pelicula {

	private String nombre;
	private ArrayList<Sala> salas;
	private final int hora;
	private final int minutos;
	private String idioma;
	private String censura;
	private String formato;

	public Pelicula(String vnombre,ArrayList<Horario>  vhorario,ArrayList<Sala> vsala,int vhoras,int vminutos,String vidioma,String vcensura,String vformato){
		
		this.nombre=vnombre;
		this.salas=vsala;
		this.hora=vhoras;
		this.minutos=vminutos;
		this.idioma=vidioma;
		this.censura=vcensura;
		this.formato=vformato;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String vnombre) {
		this.nombre = vnombre;
	}

	public ArrayList<Horario> getHorarios() {
		return new ArrayList<Horario>();
	}

	public void setHorarios(ArrayList<Horario> horarios) {
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void setSalas(ArrayList<Sala> vsalas) {
		this.salas = vsalas;
	}
	public int getHora() {
		return hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String vidioma) {
		this.idioma = vidioma;
	}

	public String getCensura() {
		return censura;
	}

	public void setCensura(String vcensura) {
		this.censura = vcensura;
	}


	public String getFormato() {
		return formato;
	}

	public void setFormato(String vformato) {
		this.formato = vformato;
	}

	//Informaci�n para el vendedor luego de escoger una pel�cula
	/*public void listar(){
		int indice=0;
		System.out.println("Salas disponibles");
		for (Horario vhorario:horarios){
			//System.out.println(vhorario+" "+salas.get(indice).toString());
			System.out.print(salas.get(indice).toString()+" ");
			indice++;
		}
	}*/

	public void salas(){
		int indice=0;
		System.out.println("Salas disponibles");
		for (Sala vsala:salas){
			//System.out.println(vhorario+" "+salas.get(indice).toString());
			System.out.print(vsala.getNumSala()+" ");
			indice++;
		}
		System.out.println(" ");
	}


	@Override
	public String toString(){
		return "Titulo: "+this.nombre+
				" \nIdioma: "+this.idioma+
				" \nCensura: "+this.censura+
				" \nFormato: "+this.formato+
				" \nDuracion: "+this.hora+":"+this.minutos;
	} 
}