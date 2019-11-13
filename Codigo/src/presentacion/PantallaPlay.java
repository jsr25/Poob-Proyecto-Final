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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class PantallaPlay extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel dificultades,opciones;
	JButton start,easy,medium,hard,back;
	
	public PantallaPlay() {
		super();
		prepararElementos();
		prepareElementosMenu();
		prepareAcciones();
	}
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				salga();
			}
		});
	start.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abra();
					}

					

				});
	}
	public void prepararElementos(){
		this.setLayout(new BorderLayout());
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(ancho/2,alto/2);
		setLocationRelativeTo(null);  
	}
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		dificultades=new JPanel();
		opciones=new JPanel();
		opciones.setLayout(new GridLayout(1,2));
		dificultades.setLayout(new GridLayout(3,1));
		easy= new JButton("easy");
		medium= new JButton("medium");
		hard= new JButton("hard");
		start= new JButton("start");
		back= new JButton("back");
		easy.setBackground(Color.black);
		medium.setBackground(Color.black);
		hard.setBackground(Color.black);
		back.setBackground(Color.black);
		start.setBackground(Color.black);
		easy.setForeground(Color.yellow);
		medium.setForeground(Color.yellow);
		hard.setForeground(Color.yellow);
		start.setForeground(Color.yellow);
		back.setForeground(Color.yellow);
		easy.setBorder(blueLine);
		medium.setBorder(blueLine);
		hard.setBorder(blueLine);
		start.setBorder(blueLine);
		back.setBorder(blueLine);
		dificultades.add(easy);
		dificultades.add(medium);
		dificultades.add(hard);
		opciones.add(back);
		opciones.add(start);
		this.add(dificultades,BorderLayout.CENTER);
		this.add(opciones,BorderLayout.SOUTH);
	}
public void salga() {
		if (JOptionPane.showConfirmDialog(this,"Esta seguro de cerrar")== JOptionPane.OK_OPTION)
		{
			System.exit(0);
		}
	}
private void abra() {
	Tablero p = new Tablero();
	p.setVisible(true);
	
}
}
