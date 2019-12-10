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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class PantallaOptions extends JDialog {
	private static final long serialVersionUID = 1L;
	JButton controls,credits,back,next;
	JPanel options,eleccion;
	/**
	 * constructor de las opciones
	 */
	public PantallaOptions() {
		super();
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
	}
	/**
	 * prepara los elementos principales
	 */
	public void prepareElementos() {
		this.setLayout(new BorderLayout());
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(600,600);
		setLocationRelativeTo(null);
		this.setResizable(false);
	}
	/**
	 * prepara los  oyentes necesarios
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
		controls.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abrirPantallaControls();
					}
				});
	}
	/**
	 * prepara los elementos necesarios
	 */
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		options= new JPanel();
		options.setLayout(new GridLayout(2,1));
		eleccion=new JPanel();
		eleccion.setLayout(new GridLayout(1,2));
	    controls= new JButton("controls");
	    credits= new JButton("credits");
	    back= new JButton("back");
	    next=new JButton("next");
	    controls.setBackground(Color.black);
	    credits.setBackground(Color.black);
	    back.setBackground(Color.black);
	    next.setBackground(Color.black);
	    controls.setForeground(Color.yellow);
	    credits.setForeground(Color.yellow);
	    back.setForeground(Color.yellow);
	    next.setForeground(Color.yellow);
	    controls.setBorder(blueLine);
	    credits.setBorder(blueLine);
	    back.setBorder(blueLine);
	    next.setBorder(blueLine);
	    eleccion.add(back);
	    eleccion.add(next);
	    options.add(controls);
	    options.add(credits);

		this.add(options,BorderLayout.CENTER);
		this.add(eleccion,BorderLayout.SOUTH);
		
	}
	/**
	 * abrir pantalla menu
	 */
	public void abrirPantallaMenu() {
		Menu p = new Menu();
		this.setVisible(false);
		p.setVisible(true);
		}
	/**
	 * abrir pantalla controles
	 */
	public void abrirPantallaControls() {
		PantallaControls p = new PantallaControls();
		this.setVisible(false);
		p.setVisible(true);
		}
}