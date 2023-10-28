package poo;
import javax.swing.*;
import javax.swing.Timer;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.*;
public class pruebaTemporizador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionListener oyente = new DameHora();//constructor por defecto
		Timer miTemporizador = new Timer(5000,oyente);
		miTemporizador.start();
		JOptionPane.showMessageDialog(null, "presione aceptar para detener");
		System.exit(0);
	}

}

class DameHora implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		Date ahora = new Date();
		System.out.println("la hora actual es: "+ahora);
		Toolkit.getDefaultToolkit().beep();
	}
}