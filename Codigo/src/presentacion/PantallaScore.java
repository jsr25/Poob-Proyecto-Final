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

public class PantallaScore extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel dificultades,opciones;
	JButton pvp,pve,eve,p,back,next;
	public PantallaScore() {
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
	next.addActionListener(
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
		dificultades.setLayout(new GridLayout(4,1));
		pvp= new JButton("PVP");
		pve= new JButton("PVE");
		eve= new JButton("EVE");
		p= new JButton("SINGLE");
		next= new JButton("next");
		back= new JButton("back");
		pvp.setBackground(Color.black);
		pve.setBackground(Color.black);
		eve.setBackground(Color.black);
		p.setBackground(Color.black);
		back.setBackground(Color.black);
		next.setBackground(Color.black);
		pvp.setForeground(Color.yellow);
		pve.setForeground(Color.yellow);
		eve.setForeground(Color.yellow);
		p.setForeground(Color.yellow);
		next.setForeground(Color.yellow);
		back.setForeground(Color.yellow);
		pvp.setBorder(blueLine);
		pve.setBorder(blueLine);
		eve.setBorder(blueLine);
		p.setBorder(blueLine);
		next.setBorder(blueLine);
		back.setBorder(blueLine);
		dificultades.add(p);
		dificultades.add(pvp);
		dificultades.add(pve);
		dificultades.add(eve);
		opciones.add(back);
		opciones.add(next);
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
	PantallaScoreEasy p = new PantallaScoreEasy();
	p.setVisible(true);
	}
	
public void select(JButton b) {
	if (pvp.getBackground().equals(Color.RED) || pve.getBackground().equals(Color.RED) || eve.getBackground().equals(Color.RED) || p.getBackground().equals(Color.RED)) {
		JOptionPane.showMessageDialog(this, "Ya tiene una opcion seleccionada");
	}
	else {
		b.setBackground(Color.RED);
	}
}
public void abrirPantallaMenu() {
	Menu p = new Menu();
	this.setVisible(false);
	p.setVisible(true);
	}
}