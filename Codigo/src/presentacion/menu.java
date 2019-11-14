package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.JOptionPane;

public class menu extends JDialog {
	JButton play,options,scores,exit;
	JPanel principal,menu;
	public static void main (String [] args){
		menu princi= new menu();
		princi.setVisible(true);

	}
public  menu(){
		super();
		prepareElementos();
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
	
	play.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abraPantallaPlay();
				}	
			});
	scores.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abraPantallaScore();
				}	
			});
	options.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abraPantallaOptions();
				}	
			});
	exit.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					salga();
				}	
			});
}
	
	

public void prepareElementos() {
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	setSize(ancho/2,alto/2);
	setLocationRelativeTo(null);    
	this.setLayout(new BorderLayout());
	prepararElementosEncabezado();
}

public void prepareElementosMenu() {
	//Bodoni MT Black
	Border blackline = BorderFactory.createLineBorder(Color.BLUE);
    Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    Border raisedbevel  = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    Border loweredbevel = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    Border empty = BorderFactory.createEmptyBorder();
	
	Font fuente= new Font("Gill Sans Ultra Bold",3,20);
	menu=new JPanel();
	menu.setLayout(new GridLayout(4,1));
	play=new JButton("Play");
	play.setBackground(Color.black);
	play.setForeground(Color.yellow);
	//play.setIcon(new ImageIcon("data/Play.png"));
	play.setBorder(blackline);
	play.setFont(fuente);
	scores=new JButton("scores");
	scores.setFont(fuente);
	scores.setBackground(Color.black);
	scores.setForeground(Color.yellow);
	scores.setBorder(blackline);
	options=new JButton("options");
	options.setFont(fuente);
	options.setBackground(Color.black);
	options.setForeground(Color.yellow);
	options.setBorder(blackline);
	exit=new JButton("exit");
	exit.setFont(fuente);
	exit.setForeground(Color.yellow);
	exit.setBackground(Color.black);
	exit.setBorder(blackline);
	menu.add(play);
	menu.add(scores);
	menu.add(options);	
	menu.add(exit);	
	this.add(menu,BorderLayout.CENTER);
	
	
	
}

public void prepararElementosEncabezado() {
	principal=new JPanel();
	JLabel ima=new JLabel();
	ImageIcon n= new ImageIcon("data/logo.png");
	Image s= n.getImage();
	s.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
	principal.setBackground(Color.black);
	ima.setIcon(new ImageIcon(s.getScaledInstance(200, 150, Image.SCALE_SMOOTH)));
	principal.add(ima);
	this.add(principal,BorderLayout.NORTH);
}
public void salga() {
	if (JOptionPane.showConfirmDialog(this,"Esta seguro de cerrar")== JOptionPane.OK_OPTION)
	{
		System.exit(0);
	}
}

private void abraPantallaPlay() {
	PantallaPlay p = new PantallaPlay();
	p.setVisible(true);
	
}
private void abraPantallaScore() {
	PantallaScore p = new PantallaScore();
	p.setVisible(true);
	
}
private void abraPantallaOptions() {
	PantallaOptions p = new PantallaOptions();
	p.setVisible(true);
	
}
}