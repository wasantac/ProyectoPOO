/**
 * @author ANAHI NARVAEZ, RICARDO RANGLES, RODRIGO SUAREZ
 * Clase Empleado la cual crea objetos del tipo Empleado.
 */
public class Empleado {
   
    private static double pagoPorHoraExtra; 
    private String ID;
    private String nombre;
    private String apellido;
    private String posicion;
    private double sueldoBase; 
    private int horasExtras;
     
    /**
     * Constructor por defecto.
     */
    public Empleado() {
    	
    }

    /**
     * Getters and Setters
     */
    public Empleado(String ID) {
        this.ID = ID;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public static double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public static void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        Empleado.pagoPorHoraExtra = pagoPorHoraExtra;
    }
   
    /**
     * Funcion que calcula el importe de las horas extras
     */
    public double calcularImporteHorasExtras(){
    	
        return horasExtras * pagoPorHoraExtra;
    }
   
     /**
     * Funcion que calcula el sueldo bruto o total
     */
    public double calcularSueldoBruto(){
    	
        return sueldoBase + calcularImporteHorasExtras();
    }
   
    //calcular el importe liquido a cobrar
    
    /**
     * Funcion que calcula el importe liquido a cobrar
     */
    public double calcularSueldo(){
    	
        return calcularSueldoBruto();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * Funcion que sobreescribe los datos de un trabajador
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nID: ");
        sb.append(ID);
        sb.append("\nPosicion: ");
        sb.append(posicion);
        sb.append("\nSueldo Base: ");
        sb.append(sueldoBase);
        sb.append("\nHoras Extras: ");
        sb.append(horasExtras);
        return  sb.toString();
    }
}