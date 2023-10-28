package poo;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;
import java.awt.Toolkit;
import java.awt.event.*;


public class pruebaTemporizador2 {
	public static void main(String[] args) {
		Reloj miReloj = new Reloj(4000,true);
		miReloj.enMarcha();
		JOptionPane.showMessageDialog(null, "presione aceptar para terminar");
		System.exit(0);
	}
}

class Reloj{
	private int intervalo;
	private boolean sonido;
	public Reloj(int intervalo,boolean sonido) {
		this.intervalo=intervalo;
		this.sonido=sonido;
	}
	
	public void enMarcha() {
		ActionListener oyente = new DameLaHora2();
		Timer miTemporizador = new Timer(intervalo,oyente);
		miTemporizador.start();
	}
	
	private class DameLaHora2 implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			Date ahora = new Date();
			System.out.println("la hora cada "+(intervalo/1000)+" seg es : "+ahora);
			if(sonido) {
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}


