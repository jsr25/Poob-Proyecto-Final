package presentacion;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class Tablero extends JDialog {
	JButton punto;
	
	public Tablero() {
		super();
		prepararElementos();
	}
	
	public void prepararElementos(){
		this.setSize(500, 500);;
		punto= new JButton("Hola");
		this.add(punto);
		
	}
}
