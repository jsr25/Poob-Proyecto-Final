package presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MonkeyPoob extends JFrame {
	public MonkeyPoob() {
		prepareElementos();
	}
	public void prepareElementos() {
		this.add(new Dibujar());
		this.setTitle("DonkeyKong)");
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(ancho/2,alto/2);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
}
