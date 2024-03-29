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
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class PantallaPlay extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel dificultades,opciones;
	private JButton start,pvp,pve,p,eve,back;
	
	/**
	 * constructor play
	 */
	public PantallaPlay() {
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
	start.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abra();
					}
				});
	pvp.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select(pvp);
				}
			});
	pve.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select(pve);
				}
			});
	eve.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select(eve);
				}
			});
	p.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select(p);
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
	 * prepara los elementos principales 
	 */
	public void prepararElementos(){
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(600,600);
		setLocationRelativeTo(null);  
		this.setResizable(false);
	}
	/**
	 * prepara los elementos necesarios
	 */
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		dificultades=new JPanel();
		opciones=new JPanel();
		opciones.setLayout(new GridLayout(1,2));
		dificultades.setLayout(new GridLayout(4,1));
		pvp= new JButton("PVP");
		pve= new JButton("PVE");
		eve= new JButton("EVE");
		p= new JButton("SINGLE");
		start= new JButton("next");
		back= new JButton("back");
		pvp.setBackground(Color.black);
		pve.setBackground(Color.black);
		eve.setBackground(Color.black);
		p.setBackground(Color.black);
		back.setBackground(Color.black);
		start.setBackground(Color.black);
		pvp.setForeground(Color.yellow);
		pve.setForeground(Color.yellow);
		eve.setForeground(Color.yellow);
		p.setForeground(Color.yellow);
		start.setForeground(Color.yellow);
		back.setForeground(Color.yellow);
		pvp.setBorder(blueLine);
		pve.setBorder(blueLine);
		eve.setBorder(blueLine);
		p.setBorder(blueLine);
		start.setBorder(blueLine);
		back.setBorder(blueLine);
		dificultades.add(p);
		dificultades.add(pvp);
		dificultades.add(pve);
		dificultades.add(eve);
		opciones.add(back);
		opciones.add(start);
		this.add(dificultades,BorderLayout.CENTER);
		this.add(opciones,BorderLayout.SOUTH);
	}
	private JButton opcion() {
		JButton b=null;
		if (pvp.getBackground().equals(Color.RED)) {
			b=pvp;
		}
		else if (pve.getBackground().equals(Color.RED)){
			b=pve;
		}
		else if (eve.getBackground().equals(Color.RED)){
			b=eve;
		}
		else if (p.getBackground().equals(Color.RED)){
			b=p;
		}
		else {
			JOptionPane.showMessageDialog(this, "No tiene una opcion seleccionada");
		}
		return b;
		
	}
	/**
	 * abre la pantalla de seleccion
	 */
	private void abra() {
		JButton b=opcion();
		if (b!=null) {
			if (p.getBackground().equals(Color.RED)) {
			PantallaSeleccion p = new PantallaSeleccion(1);
			this.setVisible(false);
			p.setVisible(true);}
			else {
				PantallaSeleccion p = new PantallaSeleccion(2);
				this.setVisible(false);
				p.setVisible(true);
			}
		}
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
	 * se evita que se selecciones dos botones
	 * @param b boton
	 */
	public void select(JButton b) {
		if (pvp.getBackground().equals(Color.RED) || pve.getBackground().equals(Color.RED) || eve.getBackground().equals(Color.RED) || p.getBackground().equals(Color.RED)) {
			if (b.getBackground().equals(Color.RED)) {
				b.setBackground(Color.black);
			}
			else {
				JOptionPane.showMessageDialog(this, "Ya tiene una opcion seleccionada");
			}
		}
		else {
			b.setBackground(Color.RED);
		}
	}
}
