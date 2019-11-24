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

import aplicacion.MonkeyPoob;

public class MonkeyPoobGUI extends JFrame {
	private JLabel mario,mono,barril,plataforma,sorpresa,escalera;
	public String monoN,barrilN;
	private String nombre;
	private MonkeyPoob app;
	private int i;
	public MonkeyPoobGUI() {
		super("Monkey");		
		setFocusable(true);
		prepararElementos();
		prepararPersonajes();
		prepareAcciones();
		
		//añadirPlataforma( 0,300,100);
		//añadirPlataforma( 0,300,200);
		//añadirPlataforma( 0,300,300);
		//a�adirPlataforma( 0,300,350);
		//agregrarplata(0,300,300);
		add(mario);
		add(plataforma);
		add(mono);
		add(barril);
		add(escalera);

		
		
		
	}
	public static void main(String[] args) {
		MonkeyPoobGUI intf=new MonkeyPoobGUI();
		intf.setVisible(true);
	}

	public void prepararElementos() {
		i=-1;
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(800,500);
		setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		app= new MonkeyPoob();
	}
	public void prepararPersonajes() {

		mario=new JLabel();		
		mario.setSize(10, 10);
		app.agregarJugadores(0, 350, "mario");
		app.generarEscaleras(40, 350, 320);
		
		sorpresa=new JLabel();
		sorpresa.setIcon(new ImageIcon(app.generarSorpresa(100,350)));
		sorpresa.setBounds(0, 0, 80, 110);
		sorpresa.setLocation(100, 350);
		sorpresa.setSize(100, 100);	
		add(sorpresa);
		app.crearPlataforma(0, 0, 100, 40);
		
		
		escalera=new JLabel();
		
		escalera.setIcon(new ImageIcon(app.getEscaleraIm()));
		escalera.setBounds(0, 0, 80, 110);
		escalera.setLocation(40, (350+320)/2);
		escalera.setSize(100, 100);		
		
		
		mario.setIcon(new ImageIcon(app.getForma(1)));
		mario.setBounds(0, 0, 80, 110);
		mario.setLocation(0,350);
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
		plataforma=new JLabel();		
		plataforma.setSize(50, 50);		
		plataforma.setIcon(new ImageIcon("data/plataforma.png"));
		plataforma.setBounds(0, 320, 300, 200);
		plataforma.setLocation(0,320);
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
	public void agregrarplata(int x1,int x2,int y1) {
		JLabel plataforma=new JLabel() {
			protected void paintComponent(Graphics grafico) {
                Graphics2D graficoNuevo = (Graphics2D) grafico;
                graficoNuevo.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                AffineTransform at = graficoNuevo.getTransform();
                Shape figura = graficoNuevo.getClip();

                double X = getWidth() / 2.0;
                double Y = getHeight() / 2.0;

                at.rotate(Math.toRadians(2*i), X, Y);
                i=i*-1;

                graficoNuevo.setTransform(at);
                graficoNuevo.setClip(figura);

                super.paintComponent(grafico);
            }

        };
        
        ImageIcon imageIcon = new ImageIcon("data/plataforma.png"); 
        Image image = imageIcon.getImage(); 
        Image newimg = image.getScaledInstance(Math.abs(x1-x2), 15,  java.awt.Image.SCALE_SMOOTH);   
        imageIcon = new ImageIcon(newimg);
        plataforma.setIcon(imageIcon);
        plataforma.setSize(500, 20);		
		plataforma.setBounds(100, 350, 500, 20);
		plataforma.setLocation((x1+x2)/2,y1);
        plataforma.setVisible(true);
        add(plataforma);
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
					app.subirEscalera(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));	
					System.out.println(app.getJugadorPosX(1)+"  "+app.getJugadorPosY(1));
					
										
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					if (mario.getX()>0) {
					app.moverIzquieda(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));	
					System.out.println(app.getJugadorPosX(1)+"  "+app.getJugadorPosY(1));
					
					}		
						
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					if(mario.getX()<770) {
					app.moverDerecha(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));
					if (app.cambioPuntos()) {
						app.removerSorpresa(1);
						remove(sorpresa);
					}
					System.out.println(app.getJugadorPosX(1)+"  "+app.getJugadorPosY(1));
					}
						
				}
				if(e.getKeyChar()=='s' || e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					app.bajarEscalera(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					mario.setLocation(app.getJugadorPosX(1),app.getJugadorPosY(1));
				}
				
				
			}
			public void keyReleased(KeyEvent e) {
				if(e.getKeyChar()=='w' || e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					if(!app.getEnEscalera(1)) {
					app.FormaEstaticaIz(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					}
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					if(!app.getEnEscalera(1)) {
					app.FormaEstaticaDer(1);
					mario.setIcon(new ImageIcon(app.getForma(1)));
					}
				}
				if(e.getKeyChar()=='s' || e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					
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
