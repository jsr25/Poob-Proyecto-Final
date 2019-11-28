package presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import aplicacion.MonkeyPoob;

public class MonkeyPoobGUI extends JFrame {
	private JLabel mario,mono,barril,plataforma,sorpresa,escalera;
	public String monoN,barrilN;
	private single principal;
	private String nombre;
	private MonkeyPoob app;
	private int i;
	public MonkeyPoobGUI(int j) {
		super("Monkey");		
		if (j==1) {
			principal=new single();
			this.setContentPane(principal);
			principal.setVisible(true);
		}
		setFocusable(true);
		prepararElementos();
		prepararPersonajes();
		prepareAcciones();
		/*add(mario);
		add(plataforma);
		add(mono);
		add(barril);
		add(escalera);*/

		
		
		
	}
	public static void main(String[] args) {
		MonkeyPoobGUI intf=new MonkeyPoobGUI(1);
		intf.setVisible(true);
	}

	public void prepararElementos() {
		i=-1;
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(800,550);
		setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		app= new MonkeyPoob();
	}
	public void crearPlataformaBaja() {		
		int[] pl=app.getPlataformas(1);		
		principal.addPlataformaAbajo(pl[0], pl[1], "data/plataforma.png");		
	}
	
	public void crearPataformaCentral(int i) {
		int[] pl=app.getPlataformas(i);		
		principal.addPlataformaCentral( pl[1], "data/plataforma.png");
	}
	public void prepararPersonajes() {
		app.agregarJugadores(32, 288, "mario");
		principal.addPersonaje(32,288,"data/marioDerecha.png");
		app.crearPlataformaBaja(0, 412);
		crearPlataformaBaja();
		app.crearPlataformaCentral(340);
		crearPataformaCentral(2);
		app.crearPlataformaCentral(300);
		crearPataformaCentral(3);
		app.crearPlataformaCentral(240);
		crearPataformaCentral(4);
		
		/*principal.addPlataformaAbajo(0, 412, "data/plataforma.png");
		principal.addPlataformaCentral(340, "data/plataforma.png");
		principal.addPlataformaCentral(300, "data/plataforma.png");
		principal.addPlataformaCentral(240, "data/plataforma.png");
		principal.addPlataformaCentral(210, "data/plataforma.png");
		principal.addPlataformaCentral(140, "data/plataforma.png");
		principal.addPlataformaCentral(100, "data/plataforma.png");
		principal.addPlataformaArriba(0, 40, "data/plataforma.png");*/
		/*principal.addEscalera(1, 2, 40);
		principal.addEscalera(2, 3, 120);
		principal.addEscalera(3, 4, 50);
		principal.addEscalera(4, 5, 120);
		principal.addEscalera(5, 6, 60);
		principal.addEscalera(6, 7, 120);
		principal.addEscalera(7, 8, 50);
		repaint();
		app.generarEscaleras(40, 400, 350);*/
		
		sorpresa=new JLabel();
		sorpresa.setIcon(new ImageIcon(app.generarSorpresa(48,400)));
		sorpresa.setBounds(0, 0, 80, 110);
		sorpresa.setLocation(48, 400);
		sorpresa.setSize(100, 100);	
		add(sorpresa);
		//app.crearPlataforma(0, 0, 100, 40);
		
		
		/*escalera=new JLabel();
		
		escalera.setIcon(new ImageIcon(app.getEscaleraIm()));
		escalera.setBounds(0, 0, 80, 110);
		escalera.setLocation(40, (350+320)/2);
		escalera.setSize(100, 100);	*/	
		

		mono=new JLabel();		
		mono.setSize(20, 20);
		
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
		//plataforma.
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
	public void agregrarplata(int x,int y) {
		//app.crearPlataforma(x, y, x+16, y);
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
				if(e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					app.subirEscalera(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					//System.out.println(app.getJugadorPosX(1)+"  "+app.getJugadorPosY(1));
					
										
				}
				if( e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					if (app.getJugadorPosX(1)>0) {
					app.moverIzquieda(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					
					}		
						
				}
				if( e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					if(app.getJugadorPosX(1)<770) {
					app.moverDerecha(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					if (app.cambioPuntos()) {
						app.removerSorpresa(1);
						remove(sorpresa);
					}
					//System.out.println(app.getJugadorPosX(1)+"  "+app.getJugadorPosY(1));
					}
				}
						
				
				if(e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					app.bajarEscalera(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_SPACE) {
					app.saltar(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					app.saltar(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					app.saltar(1);
					(principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				}
				
				
			}
			public void keyReleased(KeyEvent e) {
				if(e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					if(!app.getEnEscalera(1)) {
					app.FormaEstaticaIz(1);
					principal.moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					}
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					if(!app.getEnEscalera(1)) {
					app.FormaEstaticaDer(1);
					principal.moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					}
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_SPACE) {
					app.dejarsaltar(1);
					((single) principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
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
