package graficos;
import javax.swing.*;
public class CreandoMarco {

	public static void main(String[] args) {
		miMarco marco1 = new miMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTable tblDatos = new JTable();
		tblDatos.setModel(new javax.swing.table.DefaultTableModel(
									new String[][] {
										{
											"Periodo",
											"Cuota",
											"Interes",
											"Amortizacion",
											"Saldo",
										}
									}, args));
	}

}

class miMarco extends JFrame{
	public miMarco() {
		setSize(500,300);
		/*setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
}