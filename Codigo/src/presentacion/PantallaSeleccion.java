package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

public class PantallaSeleccion extends JDialog {
	JLabel mario,luigi,items,characters;
	JButton cereza,corazon,soga,hongo;
	JButton select1,select2,next,back;
	Boolean c1,c2;
	String monoN,marioN;
	Timer timer1,timer2;
	Boolean cerezaB,corazonB,sogaB,hongoB;
	Color n,b;
	public PantallaSeleccion() {
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
		cereza.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cerezaB==true) {
							cambiarFondo(cereza,b);
							cerezaB=false;
						}
						else {
							cambiarFondo(cereza,n);
							cerezaB=true;
						}
					}
				});
		hongo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (hongoB==true) {
							cambiarFondo(hongo,b);
							hongoB=false;
						}
						else {
							cambiarFondo(hongo,n);
							hongoB=true;
						}
					}
				});
		soga.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (sogaB==true) {
							cambiarFondo(soga,b);
							sogaB=false;
						}
						else {
							cambiarFondo(soga,n);
							sogaB=true;
						}
					}
				});
		corazon.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (corazonB==true) {
							cambiarFondo(corazon,b);
							corazonB=false;
						}
						else {
							cambiarFondo(corazon,n);
							corazonB=true;
						}
					}
				});
		
		
	}
	public void  cambiarFondo(JButton boton,Color color) {
		boton.setBackground(color);
	}
	public void prepareElementos() {
		n=Color.black;
		b=Color.white;
		cerezaB=true;
		corazonB=true;
		sogaB=true;
		hongoB=true;
		this.setLayout(null);
		setSize(600,600);
		this .getContentPane().setBackground(new Color(0,0,0));
		setLocationRelativeTo(null);
		this.setResizable(false);
		
	}
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		c1=true;
		c2=true;
		
		next=new JButton("next");
		back=new JButton("back");
		mario= new JLabel();
		mario.setIcon(new ImageIcon("data/marioDerecha.png"));
		mario.setBounds(0, 0, 30, 30);
		mario.setLocation(200,50);
		cereza=new JButton();
		ImageIcon img1=new ImageIcon("data/cereza.png");
		cereza.setIcon(img1);
		cereza.setBounds(0, 0, 20, 20);
		cereza.setLocation(75,200);
		corazon=new JButton();
		ImageIcon img2=new ImageIcon("data/corazon.png");
		corazon.setIcon(img2);
		corazon.setBounds(0, 0, 20, 20);
		corazon.setLocation(175,200);
		soga=new JButton();
		ImageIcon img3=new ImageIcon("data/soga.png");
		soga.setIcon(img3);
		soga.setBounds(0, 0, 20, 30);
		soga.setLocation(275,200);
		hongo=new JButton();
		ImageIcon img4=new ImageIcon("data/hongo.png");
		hongo.setIcon(img4);
		hongo.setBounds(0, 0, 20, 20);
		hongo.setLocation(375,200);
		luigi=new JLabel();
		luigi.setIcon(new ImageIcon("data/luigiderecha.png"));
		monoN="data/luigiderecha.png";
		luigi.setBounds(0, 0, 30, 30);
		luigi.setLocation(300,50);
		items=new JLabel("Items");
		items.setBounds(0, 0, 150, 20);
		items.setLocation(225,150);
		items.setFont(new Font("Gill Sans Ultra Bold",1,25));
		items.setForeground(Color.red);
		characters=new JLabel("Characters");
		characters.setBounds(0, 0, 200, 20);
		characters.setFont(new Font("Gill Sans Ultra Bold",1,25));
		characters.setLocation(185,0);
		characters.setForeground(Color.red);
		next.setBounds(0, 0, 80, 15);
		next.setLocation(300,250);
		back.setBounds(0, 0, 80, 15);
		back.setLocation(50,250);
		select1=new JButton();
		select2=new JButton();
		select1.setBounds(0, 0, 30, 30);
		select1.setLocation(200,50);
		select2.setBounds(0, 0, 30, 30);
		select2.setLocation(300,50);
		select1.setBackground(null);
		select2.setBackground(null);
		select1.setOpaque(false);
		select1.setContentAreaFilled(false);
		select1.setBorderPainted(false);
		select2.setOpaque(false);
		select2.setContentAreaFilled(false);
		select2.setBorderPainted(false);
		cereza.setBackground(n);
		soga.setBackground(n);
		corazon.setBackground(n);
		hongo.setBackground(n);
		select1.setBorder(null);
		select2.setBorder(null);
		cereza.setBorder(null);
		corazon.setBorder(null);
		soga.setBorder(null);
		hongo.setBorder(null);
		next.setBackground(n);
		back.setBackground(n);
		next.setBorder(blueLine);
		back.setBorder(blueLine);
		next.setForeground(Color.yellow);
		back.setForeground(Color.yellow);
		add(mario);
		add(luigi);
		add(select1);
		add(select2);
		add(next);
		add(back);
		add(corazon);
		add(soga);
		add(hongo);
		add(cereza);
		add(items);
		add(characters);
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
		luigi.setIcon(new ImageIcon("data/luigiderecha.png"));
		monoN="data/luigiderecha.png";
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
		MonkeyPoobGUI p = new MonkeyPoobGUI(1);
		this.setVisible(false);
		p.setVisible(true);
		}
	


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
								
							if (monoN=="data/luigiderecha.png") {
								luigi.setIcon(new ImageIcon("data/luigiPasoDerecha.png"));
								monoN="data/luigiPasoDerecha.png";
							} 
							else if (monoN=="data/luigiPasoDerecha.png") {
								luigi.setIcon(new ImageIcon("data/luigiPasoDerecha2.png"));
								monoN="data/luigiPasoDerecha2.png";
							}
							else {
								luigi.setIcon(new ImageIcon("data/luigiderecha.png"));
								monoN="data/luigiderecha.png";
								}
						}
				
			});
		
		



}
}
