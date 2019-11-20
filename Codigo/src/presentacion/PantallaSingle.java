package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.util.Timer;
//import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;

public class PantallaSingle extends JDialog {
	JLabel mario,luigi;
	JButton select1,select2,next,back;
	Boolean c1,c2;
	String monoN,marioN;
	Timer timer1,timer2;
	public PantallaSingle() {
		super();
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
		add(mario);
		add(luigi);
	}	
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				salga();
			}
		});
		select1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(c1==true) {
							mover1();
						}
						else {
							detener1();
						}
					}
				});
		select2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(c2==true) {
							mover2();
						}
						else {
							detener2();
						}
					}
				});
		back.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abraPantallaPlay();
					}
				});
		next.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						abraMonkeyPoobGUI();
					}
				});
		
		
	}
	public void prepareElementos() {
		this.setLayout(null);
		setSize(200,250);
		this .getContentPane().setBackground(new Color(0,0,0));
		setLocationRelativeTo(null);
		
	}
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		c1=true;
		c2=true;
		select1=new JButton("SELECT");
		select2=new JButton("SELECT");
		next=new JButton("next");
		back=new JButton("back");
		mario= new JLabel();
		mario.setIcon(new ImageIcon("data/marioDerecha.png"));
		mario.setBounds(0, 0, 80, 110);
		mario.setLocation(0,0);
		luigi=new JLabel();
		luigi.setIcon(new ImageIcon("data/luigi.png"));
		monoN="data/luigi.png";
		luigi.setBounds(0, 0, 80, 110);
		luigi.setLocation(100,0);
		next.setBounds(0, 0, 80, 15);
		next.setLocation(100,150);
		back.setBounds(0, 0, 80, 15);
		back.setLocation(0,150);
		select1.setBounds(0, 0, 80, 15);
		select1.setLocation(0,100);
		select2.setBounds(0, 0, 80, 15);
		select2.setLocation(100,100);
		select1.setBackground(Color.BLACK);
		select2.setBackground(Color.black);
		select1.setBorder(null);
		select2.setBorder(null);
		select1.setForeground(Color.white);
		select2.setForeground(Color.white);
		next.setBackground(Color.BLACK);
		back.setBackground(Color.black);
		next.setBorder(blueLine);
		back.setBorder(blueLine);
		next.setForeground(Color.yellow);
		back.setForeground(Color.yellow);
		add(select1);
		add(select2);
		add(next);
		add(back);
		generarTimer1();
		generarTimer2();
		
	}
	public void salga() {
		System.exit(0);
	}
	public void detener1() {
		c1=true;
		mario.setIcon(new ImageIcon("data/marioDerecha.png"));
		marioN="data/marioDerecha.png";
		timer1.stop();
	}
	public void mover1() {
		c1=false;
		if (c1==false && c2==false) {
			JOptionPane.showMessageDialog(this, "Ya tiene una opcion seleccionada");
			c1=true;
		}
		else {
		timer1.start();
		}
	}
	public void detener2() {
		c2=true;
		luigi.setIcon(new ImageIcon("data/luigi.png"));
		monoN="data/monoBaile1.png";
		timer2.stop();
	}
	public void mover2() {
		c2=false;
		if (c1==false && c2==false) {
			JOptionPane.showMessageDialog(this, "Ya tiene una opcion seleccionada");
			c1=false;
		}
		else {
		timer2.start();
		}
	}
	public void abraPantallaPlay() {
		PantallaPlay p = new PantallaPlay();
		this.setVisible(false);
		p.setVisible(true);
		}
	public void abraMonkeyPoobGUI() {
		MonkeyPoobGUI p = new MonkeyPoobGUI();
		this.setVisible(false);
		p.setVisible(true);
		}
	
	//public void detener2( ) {
		//c2=true;
		//timer2.cancel();
//	}
	//public void  mover2() {
	//	c2=false;
	//	timer1=new Timer();
//		TimerTask tarea=new TimerTask(){
	//		@Override
//			public void run() {
			//	if (monoN=="data/monoBaile1.png") {
		//			luigi.setIcon(new ImageIcon("data/monoBaile2.png"));
	//				monoN="data/monoBaile2.png";
//				} 
				//else if (monoN=="data/monoBaile2.png") {
			//		luigi.setIcon(new ImageIcon("data/monoBaila3.png"));
		//			monoN="data/monoBaila3.png";
	//			}
//				else {
					//luigi.setIcon(new ImageIcon("data/monoBaile1.png"));
				//	monoN="data/monoBaile1.png";
			//	}
		//	}
	//	};
//		timer1.schedule(tarea, 0, 500);
		


	public void  generarTimer1() {
		timer1=new Timer(300,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
				if (marioN=="data/marioDerecha.png") {
					mario.setIcon(new ImageIcon("data/marioPasoDerecha.png"));
					marioN="data/barrilCayendo2.png";
				}

				else {
					mario.setIcon(new ImageIcon("data/marioDerecha.png"));
					marioN="data/marioDerecha.png";
				}
					}
			
		});
	}
		public void  generarTimer2() {
			timer2=new Timer(300,new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								
							if (monoN=="data/luigi.png") {
								luigi.setIcon(new ImageIcon("data/luigi2.png"));
								monoN="data/luigi2.png";
							} 
							else if (monoN=="data/luigi2.png") {
								luigi.setIcon(new ImageIcon("data/luigi3.png"));
								monoN="data/monoBaila3.png";
							}
							else {
								luigi.setIcon(new ImageIcon("data/luigi.png"));
								monoN="data/luigi.png";
								}
						}
				
			});
		
		



}
}
