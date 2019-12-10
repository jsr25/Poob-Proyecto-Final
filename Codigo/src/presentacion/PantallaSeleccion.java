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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.border.Border;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class PantallaSeleccion extends JDialog {
	private JLabel mario,luigi,items,characters;
	private JButton cereza,corazon,manzana;
	private JButton select1,select2,next,back;
	private Boolean c1,c2;
	private String monoN,marioN;
	private Timer timer1,timer2;
	private Boolean cerezaB,corazonB,manzanaB;
	private Color n,b;
	private int jugadores;
	/**
	 * constructor de la pantalla de selecion
	 */
	public PantallaSeleccion(int s) {
		super();
		jugadores=s;
		prepareElementos();
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
				abraPantallaPlay();
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
		manzana.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (manzanaB==true) {
							cambiarFondo(manzana,b);
							manzanaB=false;
						}
						else {
							cambiarFondo(manzana,n);
							manzanaB=true;
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
	/**
	 * cambia el fondo de un boton
	 * @param boton
	 * @param color
	 */
	public void  cambiarFondo(JButton boton,Color color) {
		boton.setBackground(color);
	}
	/**
	 * prepara elementos principales
	 */
	public void prepareElementos() {
		n=Color.black;
		b=Color.white;
		cerezaB=true;
		corazonB=true;
		manzanaB=true;
		this.setLayout(null);
		setSize(600,600);
		this .getContentPane().setBackground(new Color(0,0,0));
		setLocationRelativeTo(null);
		this.setResizable(false);
		
	}
	/**
	 * prepara los necesarios
	 */
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
		cereza.setLocation(150,200);
		corazon=new JButton();
		ImageIcon img2=new ImageIcon("data/corazon.png");
		corazon.setIcon(img2);
		corazon.setBounds(0, 0, 20, 20);
		corazon.setLocation(250,200);
		manzana=new JButton();
		ImageIcon img3=new ImageIcon("data/manzana.png");
		manzana.setIcon(img3);
		manzana.setBounds(0, 0, 20, 20);
		manzana.setLocation(350,200);
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
		manzana.setBackground(n);
		corazon.setBackground(n);
		select1.setBorder(null);
		select2.setBorder(null);
		cereza.setBorder(null);
		corazon.setBorder(null);
		manzana.setBorder(null);
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
		add(manzana);
		add(cereza);
		add(items);
		add(characters);
		generarTimer1();
		generarTimer2();
		
	}
	/**
	 * detiene el timer de mario
	 */
	public void detener1() {
		c1=true;
		mario.setIcon(new ImageIcon("data/marioDerecha.png"));
		marioN="data/marioDerecha.png";
		timer1.stop();
	}
	/**
	 * mueve el timer de mario
	 */
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
	/**
	 * detiene el timer de luigi
	 */
	public void detener2() {
		c2=true;
		luigi.setIcon(new ImageIcon("data/luigiderecha.png"));
		monoN="data/luigiderecha.png";
		timer2.stop();
	}
	/**
	 * mueve el timer de luigi
	 */
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
	/**
	 * abre la pantalla play
	 */
	public void abraPantallaPlay() {
		PantallaPlay p = new PantallaPlay();
		this.setVisible(false);
		p.setVisible(true);
		}
	/**
	 * abre el tablero
	 */
	public void abraMonkeyPoobGUI() {
		ArrayList<String>hs=sorpresa();
		if (jugadores==1) {
			String n;		
			if (c1==false) {n="mario";}
			else {n="luigi";}
				MonkeyPoobGUI p = new MonkeyPoobGUI(1,n,hs,null);
				this.setVisible(false);
				p.setVisible(true);
			}
		
		else {
			String n;
			String n2;
			if (c1==false) {n="mario"; n2="luigi";}
			else {n="luigi"; n2="mario";}
			MonkeyPoobGUI p = new MonkeyPoobGUI(2,n,n2,hs,null);
			this.setVisible(false);
			p.setVisible(true);
			}
		}
	

	/**
	 * genera el timer de mario
	 */
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
	/**
	 * genera el timer de luigi
	 */
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
	private ArrayList<String>  sorpresa()
	{
		ArrayList<String> n=new ArrayList<String>();
		if(!manzanaB) {
			n.add("Manzana");
			}
		if (!cerezaB) {
			n.add("Cereza");
			}
		if (!corazonB) {
			n.add("Corazon");
		}
		
		return n;
	}
	
	
}
