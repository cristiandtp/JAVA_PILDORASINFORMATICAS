package poo;

public class Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Empleados t1 = new Empleados("d");
    	Empleados t2 = new Empleados("paca");
    	Empleados t3 = new Empleados("pala");
    	System.out.println(t1.devolverTrabajador());
    	System.out.println(t2.devolverTrabajador());
	}

}
class Empleados {
	private String nombre;
	private String seccion;
	private int id;
	private static int idSiguiente=1;
	
	public Empleados(String nom) {
		this.nombre = nom;
		seccion ="admin";
		id= idSiguiente;
		idSiguiente++;
	}
	
	public String devolverTrabajador() {
		return "nombre: "+nombre + " seccion: "+seccion + " id: " +id;
	}
	
	public void cambiarSeccion(String sec) {
		seccion = sec;
	}
	
	public String devolverSeccion() {
		return seccion;
	}
}