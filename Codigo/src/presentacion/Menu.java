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
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import presentacion.PantallaOptions;
import presentacion.PantallaPlay;
import presentacion.PantallaScore;

import javax.swing.JOptionPane;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
	public class Menu extends JDialog {
		JPanel principal,menu;
		JLabel botones,mario,mono;
		JButton options,exit,play;
		String monoN,marioN;
		public static void main (String [] args){
			Menu princi= new Menu();
			princi.setVisible(true);

		}
	/**
	 * contructor de menu
	 */
	public  Menu(){
			super();
			prepareElementos();
			prepareElementosMenu();
			prepararElementosEncabezado();
			prepareAcciones();
			this.add(mario);

		}
	/**
	 * prepara los oyentes necesarios
	 */
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
		
		
	/**
	 * prepara los elementos principales
	 */
	public void prepareElementos() {
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(600,600);
		setLocationRelativeTo(null);   
		this .getContentPane().setBackground(new Color(0,0,0));
		this.setLayout(null);
		this.setResizable(false);
		
	}
	/**
	 * prepara los elementos necesarios
	 */
	public void prepareElementosMenu() {
		botones=new JLabel();
		play=new JButton("PLAY");
		options=new JButton("OPTIONS");
		exit=new JButton("EXIT");
		play.setFont(new Font("Gill Sans Ultra Bold",1,25));
		play.setForeground(Color.red);
		play.setBounds(0, 0, 300, 50);
		play.setLocation(175, 300);
		options.setFont(new Font("Gill Sans Ultra Bold",1,25));
		options.setForeground(Color.red);
		options.setBounds(0, 0, 350, 50);
		options.setLocation(150, 350);
		exit.setFont(new Font("Gill Sans Ultra Bold",1,25));
		exit.setForeground(Color.red);
		exit.setBounds(0, 0, 300, 50);
		exit.setLocation(175, 400);
		play.setBackground(Color.black);
		options.setBackground(Color.black);
		exit.setBackground(Color.black);
		play.setBorder(null);	 
		options.setBorder(null);
		exit.setBorder(null);
		this.add(play);
		this.add(options);
		this.add(exit);
		
	}
	/**
	 * prepara los elementos del encabezado
	 */
	public void prepararElementosEncabezado() {
		mario=new JLabel();	
		mario.setSize(400,400);
		mario.setIcon(new ImageIcon("data/logo1.png"));
		marioN="data/logo1.png";
		mario.setBounds(100, 100, 700, 220);;
		mario.setLocation(0, 0);
		Timer timer=new Timer();
		TimerTask tarea=new TimerTask(){
			@Override
			public void run() {	
				if (marioN=="data/logo1.png") {
					mario.setIcon(new ImageIcon("data/logo2.png"));
					marioN="data/logo2.png";
				}

				else {
					mario.setIcon(new ImageIcon("data/logo1.png"));
					marioN="data/logo1.png";
				}
			}
		};
		timer.schedule(tarea, 0, 500);
		
	}
	/**
	 * cerrar el programa
	 */
	public void salga() {
		System.exit(0);
	}
	/**
	 * abrir pantalla Play
	 */
	private void abraPantallaPlay() {
		PantallaPlay p = new PantallaPlay();
		this.setVisible(false);
		p.setVisible(true);
		
	}
	/**
	 * abrir pantalla score
	 */
	private void abraPantallaScore() {
		PantallaScore p = new PantallaScore();
		this.setVisible(false);
		p.setVisible(true);
		
	}
	/**
	 * abrir pantalla opciones
	 */
	private void abraPantallaOptions() {
		PantallaOptions p = new PantallaOptions();
		this.setVisible(false);
		p.setVisible(true);
		
	}
}

	




