package presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import aplicacion.MonkeyPoob;

public class MonkeyPoobGUI extends JFrame {
	private JLabel mario,mono,barril,plataforma;
	public String monoN,barrilN;
	private String nombre;
	private MonkeyPoob app;
	int i;
	public MonkeyPoobGUI() {
		super("Monkey");		
		setFocusable(true);
		prepararElementos();
		prepararPersonajes();
		prepareAcciones();
		add(mario);
		add(mono);
		add(barril);
		add(plataforma);
		
	}
	public static void main(String[] args) {
		MonkeyPoobGUI intf=new MonkeyPoobGUI();
		intf.setVisible(true);
	}

	public void prepararElementos() {
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(800,500);
		setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		app= new MonkeyPoob();
	}
	public void prepararPersonajes() {

		mario=new JLabel();		
		mario.setSize(50, 50);
		app.agregarJugadores(0, 350, "mario");		
		mario.setIcon(new ImageIcon(app.getForma(1)));
		mario.setBounds(20, 20, 80, 110);
		mario.setLocation(0,350);
		mono=new JLabel();		
		mono.setSize(50, 50);		
		mono.setIcon(new ImageIcon("data/monoBaile1.png"));
		monoN="data/monoBaile1.png";
		mono.setBounds(20, 20, 80, 110);
		mono.setLocation(0,0);
		barril=new JLabel();		
		barril.setSize(50, 50);	
		barril.setIcon(new ImageIcon("data/barrilCayendo1.png"));
		barrilN="data/barrilCayendo1.png";
		barril.setBounds(20, 20, 80, 110);
		barril.setLocation(12,15);
		plataforma=new JLabel();		
		plataforma.setSize(50, 50);		
		plataforma.setIcon(new ImageIcon("data/plataforma.png"));
		plataforma.setBounds(20, 20, 80, 110);
		plataforma.setLocation(0,20);
		Timer timer=new Timer();
		TimerTask tarea=new TimerTask(){
			@Override
			public void run() {
				if (monoN=="data/monoBaile1.png") {
					mono.setIcon(new ImageIcon("data/monoBaile2.png"));
					monoN="data/monoBaile2.png";
				}
				else if (monoN=="data/monoBaile2.png") {
					mono.setIcon(new ImageIcon("data/monoBaila3.png"));
					monoN="data/monoBaila3.png";
				}
				else {
					mono.setIcon(new ImageIcon("data/monoBaile1.png"));
					monoN="data/monoBaile1.png";
				}
			}
		};
		timer.schedule(tarea, 0, 500);
		Timer timer2=new Timer();
		TimerTask tarea2=new TimerTask(){
			@Override
			public void run() {	
				if  (barril.getY()==400) {
					barril.setLocation(12, 15);
				}
				if (barrilN=="data/barrilCayendo1.png") {
					barril.setIcon(new ImageIcon("data/barrilCayendo2.png"));
					barril.setLocation(barril.getX(),barril.getY()+5);
					barrilN="data/barrilCayendo2.png";
				}

				else {
					barril.setIcon(new ImageIcon("data/barrilCayendo1.png"));
					barril.setLocation(barril.getX(),barril.getY()+5);
					barrilN="data/barrilCayendo1.png";
				}
			}
		};
		timer2.schedule(tarea2, 0, 50);
	}
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				abrirPantallaMenu();
			}
		});
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()=='w' || e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					mario.setIcon(new ImageIcon("data/marioSalto.png"));					
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					if (mario.getX()>0) {
					app.moverIzquieda(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));	
					}		
						
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					if(mario.getX()<770) {
					app.moverDerecha(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));			
					}
						
				}
				if(e.getKeyChar()=='s' || e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					mario.setLocation(mario.getX(),mario.getY()+5);
					mario.setIcon(new ImageIcon("data/marioDerecha.png"));
				}
				
				
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()=='w' || e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					//mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					app.FormaEstaticaIz(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					app.FormaEstaticaDer(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
				}
				if(e.getKeyChar()=='s' || e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					//mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));
				}
				
			}
				
			
		});
	}
	public void abrirPantallaMenu() {
		Menu p = new Menu();
		this.setVisible(false);
		p.setVisible(true);
		}

}
