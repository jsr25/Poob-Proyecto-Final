package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PantallaScore extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel dificultades,opciones;
	JButton easy,medium,hard,back;
	public PantallaScore() {
		super();
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
	}
	public void prepareAcciones() {
		easy.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abraPantallaScoreEasy();
					}
				});
		medium.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abraPantallaScoreMedium();
					}
				});
		hard.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abraPantallaScoreHard();
					}
				});
	
	}
	public void prepareElementos() {
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
		back= new JButton("back");
		easy.setBackground(Color.black);
		medium.setBackground(Color.black);
		hard.setBackground(Color.black);
		back.setBackground(Color.black);
		easy.setForeground(Color.yellow);
		medium.setForeground(Color.yellow);
		hard.setForeground(Color.yellow);
		back.setForeground(Color.yellow);
		easy.setBorder(blueLine);
		medium.setBorder(blueLine);
		hard.setBorder(blueLine);
		back.setBorder(blueLine);
		dificultades.add(easy);
		dificultades.add(medium);
		dificultades.add(hard);
		opciones.add(back);
		this.add(dificultades,BorderLayout.CENTER);
		this.add(opciones,BorderLayout.SOUTH);
	}
	private void abraPantallaScoreEasy() {
		PantallaScoreEasy p = new PantallaScoreEasy();
		p.setVisible(true);
		
	}
	private void abraPantallaScoreMedium() {
		PantallaScoreMedium p = new PantallaScoreMedium();
		p.setVisible(true);
		
	}
	private void abraPantallaScoreHard() {
		PantallaScoreHard p = new PantallaScoreHard();
		p.setVisible(true);
		
	}
}