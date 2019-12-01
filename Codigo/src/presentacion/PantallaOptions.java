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

public class PantallaOptions extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton music,controls,credits,back,next;
	JPanel options,eleccion;
	public PantallaOptions() {
		super();
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
	}
	public void prepareElementos() {
		this.setLayout(new BorderLayout());
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(ancho/2,alto/2);
		setLocationRelativeTo(null);
		this.setResizable(false);
	}
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				salga();
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
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		options= new JPanel();
		options.setLayout(new GridLayout(3,1));
		eleccion=new JPanel();
		eleccion.setLayout(new GridLayout(1,2));
	    controls= new JButton("controls");
	    music= new JButton("music");
	    credits= new JButton("credits");
	    back= new JButton("back");
	    next=new JButton("next");
	    controls.setBackground(Color.black);
	    music.setBackground(Color.black);
	    credits.setBackground(Color.black);
	    back.setBackground(Color.black);
	    next.setBackground(Color.black);
	    controls.setForeground(Color.yellow);
	    credits.setForeground(Color.yellow);
	    music.setForeground(Color.yellow);
	    back.setForeground(Color.yellow);
	    next.setForeground(Color.yellow);
	    controls.setBorder(blueLine);
	    music.setBorder(blueLine);
	    credits.setBorder(blueLine);
	    back.setBorder(blueLine);
	    next.setBorder(blueLine);
	    eleccion.add(back);
	    eleccion.add(next);
	    options.add(controls);
	    options.add(music);
	    options.add(credits);

		this.add(options,BorderLayout.CENTER);
		this.add(eleccion,BorderLayout.SOUTH);
		
	}
	public void abrirPantallaMenu() {
		Menu p = new Menu();
		this.setVisible(false);
		p.setVisible(true);
		}
	public void abrirPantallaControls() {
		PantallaControls p = new PantallaControls();
		this.setVisible(false);
		p.setVisible(true);
		}
	public void salga() {
		System.exit(0);
	}
}