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

	public class Menu2 extends JDialog {
		JPanel principal,menu;
		JLabel botones,mario,mono;
		JButton options,scores,exit,play;
		String monoN,marioN;
		public static void main (String [] args){
			Menu2 princi= new Menu2();
			princi.setVisible(true);

		}
	public  Menu2(){
			super();
			prepareElementos();
			prepareElementosMenu();
			prepararElementosEncabezado();
			prepareAcciones();
			this.add(mario);

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
		setSize(1010,alto-40);
		setLocationRelativeTo(null);   
		this .getContentPane().setBackground(new Color(0,0,0));
		this.setLayout(null);
		
	}

	public void prepareElementosMenu() {
		botones=new JLabel();
		play=new JButton("PLAY");
		options=new JButton("OPTIONS");
		scores=new JButton("SCORES");
		exit=new JButton("EXIT");
		play.setFont(new Font("Gill Sans Ultra Bold",1,35));
		play.setForeground(Color.red);
		play.setBounds(0, 0, 300, 90);
		play.setLocation(400, 400);
		options.setFont(new Font("Gill Sans Ultra Bold",1,35));
		options.setForeground(Color.red);
		options.setBounds(0, 0, 400, 90);
		options.setLocation(350, 475);
		scores.setFont(new Font("Gill Sans Ultra Bold",1,35));
		scores.setForeground(Color.red);
		scores.setBounds(0, 0, 300, 90);
		scores.setLocation(400, 550);
		exit.setFont(new Font("Gill Sans Ultra Bold",1,35));
		exit.setForeground(Color.red);
		exit.setBounds(0, 0, 300, 90);
		exit.setLocation(400, 625);
		play.setBackground(Color.black);
		options.setBackground(Color.black);
		scores.setBackground(Color.black);
		exit.setBackground(Color.black);
		play.setBorder(null);	 
		options.setBorder(null);
		scores.setBorder(null);
		exit.setBorder(null);
		this.add(play);
		this.add(scores);
		this.add(options);
		this.add(exit);
		
	}

	public void prepararElementosEncabezado() {
		mario=new JLabel();	
		mario.setSize(400,400);
		mario.setIcon(new ImageIcon("data/logo1.png"));
		marioN="data/logo1.png";
		mario.setBounds(100, 100, 1000, 400);;
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
	public void salga() {
		System.exit(0);
	}

	private void abraPantallaPlay() {
		PantallaPlay p = new PantallaPlay();
		this.setVisible(false);
		p.setVisible(true);
		
	}
	private void abraPantallaScore() {
		PantallaScore p = new PantallaScore();
		this.setVisible(false);
		p.setVisible(true);
		
	}
	private void abraPantallaOptions() {
		PantallaOptions p = new PantallaOptions();
		this.setVisible(false);
		p.setVisible(true);
		
	}
}

	




