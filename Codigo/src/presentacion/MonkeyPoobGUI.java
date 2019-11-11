package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class MonkeyPoobGUI extends JFrame {
	JButton play,options,scores,exit;
	JPanel principal,menu;
	public static void main (String [] args){
		MonkeyPoobGUI princi= new MonkeyPoobGUI();
		princi.setVisible(true);
	}
public  MonkeyPoobGUI(){
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
}
	
	

public void prepareElementos() {
	Toolkit t = Toolkit.getDefaultToolkit();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	setSize(ancho/2,alto/2);
	setLocationRelativeTo(null);    
}

public void prepareElementosMenu() {
	menu=new JPanel();
	menu.setLayout(new GridLayout(4,1));
	play=new JButton("");
	play.setIcon(new ImageIcon("data/Play.png"));
	scores=new JButton("scores");
	options=new JButton("options");
	exit=new JButton("exit");
	menu.add(play);
	menu.add(scores);
	menu.add(options);
	menu.add(exit);
	this.add(menu);
	
}
public void salga() {
	if (JOptionPane.showConfirmDialog(this,"Esta seguro de cerrar")== JOptionPane.OK_OPTION)
	{
		System.exit(0);
	}
}
}