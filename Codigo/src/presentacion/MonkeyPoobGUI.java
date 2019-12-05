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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.io.File;
import javax.swing.Timer;

import org.junit.rules.Timeout;

import java.util.Random;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import aplicacion.MonkeyException;
import aplicacion.MonkeyPoob;

public class MonkeyPoobGUI extends JFrame {
	private JLabel mario,mono,barril,plataforma,sorpresa,escalera,puntos,pauline;
	public String monoN,barrilN;
	private single principal;
	private String nombre;
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem salvar,abrir;
	private Timer timer1,timer2,timer3;
	
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
		prepararMenu();
		prepararAccionesMenu();
		this.setResizable(false);
		this .getContentPane().setBackground(new Color(0,0,0));
		prepararEstructura();
		generarEstructura();
		

		
		
		
	}
	
	private void prepararMenu() {
		barra=new JMenuBar();
		menu = new JMenu("Menu");
		salvar=new JMenuItem("salvar");
		abrir=new JMenuItem("abrir");
		
		menu.add(salvar);
		menu.add(abrir);
		
		barra.add(menu);
		
		this.setJMenuBar(barra);
		
		
	}
	public static void main(String[] args) {
		MonkeyPoobGUI intf=new MonkeyPoobGUI(1);
		intf.setVisible(true);
	}

	public void prepararElementos() {
		i=-1;
		Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(500,550);
		setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		app= MonkeyPoob.getMonkey();
		
	}
	public void crearPlataforma(int i) {		
		int[] pl=app.getPlataformas(i);		
		principal.addPlataforma(pl[0], pl[1],pl[2], "data/plataforma.png");		
	}
	
	
	public void crearEscalera(int i){
		int[]esc=app.getEscalera(i);
		principal.crearEscalera(esc[0], esc[1], esc[2]);
	}
	private void crearBarril(int j) {
		int [] barr=app.getBarril(j);
		principal.crearBarril(barr[0],barr[1]);
	}
	private void moverBarril(int j) {	
		Timer tim=new Timer(100, null);		
		tim.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {				
						if (app.getbary(j)==400 && app.getbarx(j)==10) {
							principal.removebar(j);
							crearBarril2(j+1);
							tim.stop();
						}
						else if(app.jugadorMuerto(1)) {
							(principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
							reiniciar();
							//tim.stop();
							//principal.removebar(j);
							
							//app.resetJugador(1);
						}
						
						app.moverBarril(j);
						principal.setVidas(app.getVidas(1));
						principal.actualizarbar(j,app.getbarx(j),app.getbary(j));
					}	
				});		
		tim.start();
	}
	public void reiniciar() {
		app.resetJugador(1);
		principal.moverPersonaje(10, 400, app.getForma(1));

		
	}
	public void crearBarril2(int j) {		
			app.generarBarriles();
			crearBarril(j);
			moverBarril(j);
	}
	public void prepararPersonajes() {
		app.agregarJugadores(0, 400, "mario");
		principal.addPersonaje(0,400,"data/marioDerecha.png");		
		principal.setVidas(app.getVidas(1));
		principal.setPuntos(app.getPuntos(1));
		
	}
	public void prepararEstructura() {
		app.crearPlataforma(0, 412,480,-1);	
		
		Random r = new Random();
		int valor =r.nextInt(3)+2;
		if(valor%2!=0) {valor+=1;}
		int k=1;
		int o=0;
		int h=412-60;
		for (int i =1 ; i<=valor;i++) {
			app.crearPlataforma(o,h,400,k);
			if(o==0) {o=80;}
			else {o=0;}
			k=k*-1;
			h=h-60;
		}
		app.crearPlataforma(0, 62, 400, 1);	
		app.crearPlataforma(60, 0, 160, 1);
	
		System.out.println(app.getPlatSize());
		app.generarEscaleras(120, app.getPlatSize()-1,app.getPlatSize());	
		app.generarEscaleras(140, app.getPlatSize()-1, app.getPlatSize());
		int lo=100;
		for (int i=1;i<valor+2;i++) {
			app.generarEscaleras(lo,i,i+1);
			if(lo==100) {lo=100+40;}
			else {lo=100;}
			
		}
		
		
	
		app.generarBarriles();		
		app.generarSorpresa(50, 400);
	
		
		sorpresa=new JLabel();
		sorpresa.setIcon(new ImageIcon(app.generarSorpresa(48,400)));
		sorpresa.setBounds(0, 0, 80, 110);
		sorpresa.setLocation(50, 400);
		sorpresa.setSize(100, 100);	
		add(sorpresa);
		
		
		
		
	}
	
	public void generarEstructura() {
		for(int i=0;i<app.getPlatSize();i++) {
			crearPlataforma(i+1);
		}
		
		for (int i=0;i<app.getEscSize();i++) {
			crearEscalera(i+1);
		}	
		crearBarril(1);
		moverBarril(1);
			
			
		
					
		
		
		
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
				
										
				}
				if( e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					if (app.getJugadorPosX(1)>0) {
					app.moverIzquieda(1);
					principal.setPuntos(app.getPuntos(1));
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
					
					}		
						
				}
				if( e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
						app.moverDerecha(1);
						principal.setPuntos(app.getPuntos(1));
						( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
						if (app.cambioPuntos()) {
							app.removerSorpresa(1);
							remove(sorpresa);
						}
					}
						
				
				if(e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					app.bajarEscalera(1);
					( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_SPACE) {
					saltar(app.getJugadorPosY(1));
				}
				
				repaint();	
			}
			
			public void keyReleased(KeyEvent e) {
				if(e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					
					app.FormaEstaticaIz(1);
					principal.moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					
					app.FormaEstaticaDer(1);
					principal.moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					
				}
				if(e.getExtendedKeyCode()== KeyEvent.VK_SPACE) {
					//app.dejarsaltar(1);
					((single) principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				}
				repaint();	
			}
				
			
		});
		
	}
	public void saltar(int y) {
					timer1=new Timer(300,new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							app.saltar(1);
							( principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
							if (app.getJugadorPosY(1)==y) {
								timer1.stop();
							}
						}
						});
					timer1.start();
				
		       }	
	public void abrirPantallaMenu() {
		Menu p = new Menu();
		this.setVisible(false);
		p.setVisible(true);
		}
	
	private void prepararAccionesMenu() {
		salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcioSalvar();
			}	
		} );
	}
	
	private void opcioSalvar() {
		JFileChooser fc = new JFileChooser();
		int res=fc.showSaveDialog(this);
		if (fc.APPROVE_OPTION==res) {
		File f = new File(fc.getSelectedFile()+".dat");
		try {
			app.salvar(f);
		} catch (MonkeyException e) {
			//jpanel diciendo ErrorIO
		}
		}
	}
}
