package poo;
import java.util.*;

public class uso_Empleado {


    public static void main(String[] args) {
        // TODO code application logic here
    	//forma 1 arreglo
    	Jefe jefe = new Jefe("jefe",100000,1923,10, 18);
    	jefe.incentivoJefe(5000);
     	Empleado[] misEmpleados = new Empleado[5];
        misEmpleados[0] = new Empleado("uno");
        misEmpleados[1] = new Empleado("dos",95000,1990,8, 18);
        misEmpleados[2] = new Empleado("uno",100000,1023,10, 18);
        misEmpleados[3] = jefe; //polimorfismo en accion. principio sustitución
        misEmpleados[4] = new Jefe("jefe1",101000,1900,12, 20);
        
        /*ACA ESTOY REALIZANDO UNA REFUNDICION Ó CASTING
        DE EMPLEADO A JEFE*/
        Jefe jefe_finanzas = (Jefe) misEmpleados[4];
        jefe_finanzas.incentivoJefe(50000);
        
        /*INTERFACES video 50 EJEMPLO:
         LUEGO USO LA INTERFACE Jefes Y EL metodo(tomar_decisiones)
        */
        System.out.println("la decisión del jefe es: "
        +jefe_finanzas.tomar_decision("una hora de oscio para empleados"));
	    
        System.out.println("el jefe: "+jefe_finanzas.dameNombre()+" recibe un bono de: "
        		+jefe_finanzas.establece_bonus(500));
	    System.out.println("el trabajador: "+misEmpleados[0].dameNombre()+ " recibe un bonus de: "
        		+misEmpleados[0].establece_bonus(500));
	    /*USO DE INSTANCEOF
	    Empleado director_comercial = new Jefe("Cristian",20000,2024,8,02);
	    Comparable ejemplo = new Empleado("N",500,2024,06,9);
	    //podemos utilizar instance of con:
	    //instanceof con clases
	    if(director_comercial instanceof Empleado) {
	    	System.out.println("director comercial es de tipo jefatura"
	    			+ "porque esta hereda de Empleado");
	    }
	    //instanteof con interfaces
	    if(ejemplo instanceof Comparable) {
	    	System.out.println("ejemplo implementa la interfaz comparable");
	    }
        */
        

	    
	    

        //LE AGREGO EL AUMENTO DEL 5% A CADA EMPLEADO
        for (Empleado miEmpleado : misEmpleados) {
            miEmpleado.definirAumento(5);
        }
        
        Arrays.sort(misEmpleados);
        
        //ACA IMPRIMO CADA UNO DE LOS EMPLEADOS DE LA LISTA
        for (Empleado e: misEmpleados) {
            System.out.println("nombnre: " + e.dameNombre()+
                    " sueldo: "+e.dameSueldo()+ " fecha: "+e.dameFecha());
        }
        
        
       /*FORMA 2 DE MANERA MANUAL
        Empleado e1= new Empleado("uno",80000,2023,13, 18);
        Empleado e2= new Empleado("dos",90000,2025,14, 19);
        Empleado e3= new Empleado("tres",100000,2020,15, 20);
        
        System.out.println("nombre e1: "+e1.dameNombre() +
        					"salario "+ e1.dameSueldo() +
        					e1.dameFecha());
        */
    }
}

//Comparable <T> debe ser parametrizada(Hace Referencia a las clases parametrizadas)
class Empleado implements Comparable,Trabajador {
	//atributos ó campos de clase
	private int id;
	private static int idSiguiente;
	private final String nombre;
    private double sueldo;
    private Date altaContrato;
    
    	public Empleado(String nom) {
    		this(nom, 20000,2023,12,1);
    	}
    	
	    public Empleado(String nom, double sue, int agno, int mes, int dia){
	        ++idSiguiente;
	        id=idSiguiente;
	        nombre = nom;
	        sueldo = sue;
	        GregorianCalendar calendario = new GregorianCalendar(agno,mes,dia);
	        altaContrato = calendario.getTime();
	    }
	    
	    @Override
	    public double establece_bonus(double gratificacion) {
	    	return Trabajador.bonus+gratificacion;
	    }
	    
	    
	    //IMPLEMENTO EL METODO DE LA INTERFACE Comparable
		@Override
		public int compareTo(Object miObjeto) {
			/*hago una refundicion porque estoy recibiendo
			 un parametro de tipo OBJETO(miObjeto) y tengo
			 que transformar ese parametro en un objeto tipo EMPLEADO
			 ¡PARA PODER COMPARAR EL SUELDO DE LOS EMPLEADOS!
			 */
			Empleado miEmpleado = (Empleado) miObjeto;
			
			if(this.id < miEmpleado.id) {
				return -1;
			}
			if(this.id > miEmpleado.id) {
				return 1;
			}
			return 0;
		}	
	    
	    //AUMENTO A TODOS LOS EMPLEADOS
	    public void definirAumento(double porcentaje){
	        double aumento = sueldo*(porcentaje/100);
	        sueldo += aumento;
	    }
	    
	    //METODO PARA AUMENTAR EL id 
	    public static String idSiguiente() {
	    	return "el id siguiente es: " + idSiguiente;
	    }
	    
	    //getters y setters

	    public String dameNombre(){
	        return nombre + " id: "+ id;
	    }
	    public double dameSueldo(){
	        return sueldo;
	    }
	    public Date dameFecha(){
	        return altaContrato;
	    }

	}

class Jefe extends Empleado implements Jefes{
	private double incentivo;
	
	public Jefe(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
	public double incentivoJefe(double inc) {
		return incentivo = inc;
	}
	
	@Override
	public String tomar_decision(String decision) {
		return decision;
	}
	
	@Override
	public double establece_bonus(double gratificacion) {
		double prima=2000;
		return Trabajador.bonus+gratificacion+prima;
	}
	
	//sobre escribo el metodo dame sueldo pero para el JEFE en concreto
	public double dameSueldo() {
		double sueldoJefe = super.dameSueldo()+incentivo;
		return sueldoJefe;
	}


}
	

class Director extends Jefe{
	public Director(String nom, double sue, int agno, int mes, int dia) {
		super(nom, sue, agno, mes, dia);
	}
}
	

