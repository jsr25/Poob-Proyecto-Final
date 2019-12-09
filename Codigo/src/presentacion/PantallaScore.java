package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class PantallaScore extends JDialog {
	private static final long serialVersionUID = 1L;
	JPanel opciones;
	JButton back;
	/**
	 * constructor score
	 */
	public PantallaScore() {
		super();
		prepararElementos();
		prepareElementosMenu();
		prepareAcciones();
	}
	/**
	 * prepara los oyentes necesarios
	 */
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				abrirPantallaMenu();
			}
		});
	back.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirPantallaMenu();
				}
			});
	}
	/**
	 * prepara los elemtos principales
	 */
	public void prepararElementos(){
		this.setLayout(new BorderLayout());
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(ancho/2,alto/2);
		setLocationRelativeTo(null);  
	}
	/**
	 * prepara los elementos necesarios 
	 */
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		opciones=new JPanel();
		opciones.setLayout(new GridLayout(1,2));
		back= new JButton("back");
		back.setBackground(Color.black);
		back.setForeground(Color.yellow);
		back.setBorder(blueLine);
		opciones.add(back);
		this.add(opciones,BorderLayout.SOUTH);
	}
	/**
	 * abre el menu
	 */
	public void abrirPantallaMenu() {
		Menu p = new Menu();
		this.setVisible(false);
		p.setVisible(true);
		}
}