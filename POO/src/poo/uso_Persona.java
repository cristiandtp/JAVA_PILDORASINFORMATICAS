//VIDEO 46 CLASES ABSTRCTAS 2
package poo;

import java.util.Date;
import java.util.GregorianCalendar;

public class uso_Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	
		Persona1[] lista_personas = new Persona1[2];
		lista_personas[0] = new Empleado2("cero",3000, 2023, 12, 5);
		lista_personas[1] = new Alumno("Ana López","Biológicas");
		
		for(Persona1 persona: lista_personas) {
			System.out.println(persona.dameNombre()+" "+persona.dameDescripcion());
		}
		

	}

}

/*CLASE PRINCIPAL Abstracta
porque tiene en su interior 1 ó mas metodos abstractos
*/
abstract class Persona1{
	private String nombre;
	
	public Persona1(String nom) {
		nombre = nom;
	}
	
	//ESTE METODO SERA EL MISMO PARA LAS CLASES QUE HEREDAN
    public String dameNombre(){
        return nombre;
    }
    
    /*ESTE METODO SE HACE ABSTRACT PORQUE SERA DIFERENTE
    EN CADA CLASE QUE VA A HEREDAR empleado y alumno
    (recordar que al definir un metodo abstracto 
    debo poner la clase abstracta)
    */
    public abstract String dameDescripcion(); 
}

//CLASE EMPLEADO 2 QUE HEREDA DE PERSONA2
class Empleado2 extends Persona1 {
	private int id;
	private static int idSiguiente;
    private double sueldo;
    private Date altaContrato;
    

	    public Empleado2(String nom,double sue, int agno, int mes, int dia){
	        super(nom);
	    	++idSiguiente;
	        id=idSiguiente;
	        sueldo = sue;
	        GregorianCalendar calendario = new GregorianCalendar(agno,mes,dia);
	        altaContrato = calendario.getTime();
	    }
	    
	    //metodo obligatorios de la herencia
	    @Override
	    public String dameDescripcion() {
	    	return "empledo numero: " +id+ " tiene un sueldo: " + sueldo;
	    }
	    //metodos propios
	    public int dameId() {
	    	return id;
	    }
	    
	    public double dameSueldo(){
	        return sueldo;
	    }
	    public Date dameFecha(){
	        return altaContrato;
	    }
	    
	    public void definirAumento(double porcentaje){
	        double aumento = sueldo*(porcentaje/100);
	        sueldo += aumento;
	    }
	    
	    public static String idSiguiente() {
	    	return "el id siguiente es: " + idSiguiente;
	    }
	    
	}

//CLASE ALUMNO QUE HEREDA DE PERSONA2
class Alumno extends Persona1{
	private String carrera;
	
	public Alumno(String nom, String carrera) {
		super(nom);
		this.carrera = carrera;
	}

	//sobre escribo el metodo que debo realizar
	@Override
	public String dameDescripcion() {
		return "el Alumno esta estudiando " + carrera;
	}
}
