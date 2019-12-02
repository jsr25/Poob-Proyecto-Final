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
	private JLabel mario,mono,barril,plataforma,sorpresa,escalera,puntos;
	public String monoN,barrilN;
	private single principal;
	private String nombre;
	private JMenuBar barra;
	private JMenu menu;
	private JMenuItem salvar,abrir;
	
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
		//add(mario);
		//add(plataforma);
		//add(mono);
		//add(barril);
		//add(escalera);

		
		
		
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
	
	public void crearPataformaCentral(int i) {
		int[] pl=app.getPlataformas(i);		
		principal.addPlataformaCentral(pl[1], "data/plataforma.png");
	}
	public void crearPlataformaAlta(int i) {
		int[] pl=app.getPlataformas(i);		
		principal.addPlataformaArriba(pl[0], pl[1], "data/plataforma.png");
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
							tim.stop();
						}
						else if(app.jugadoresMuertos()) {
							(principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
							//tim.stop();
							//principal.removebar(j);
						}
						app.moverBarril(j);
						principal.actualizarbar(j,app.getbarx(j),app.getbary(j));
					}	
				});		
		tim.start();
		
		
	}
	public void prepararPersonajes() {
		app.agregarJugadores(0, 400, "mario");
		//puntos= new JLabel();
		//puntos.setText(app.getPuntos(1)+"");
		//puntos.setForeground(Color.white);
		//puntos.setLocation(0,0);
		//puntos.setVisible(true);
		//principal.add(puntos);
		//principal.repaint();
		
		principal.addPersonaje(0,400,"data/marioDerecha.png");
		app.crearPlataforma(0, 412,480,-1);
		crearPlataforma(1);
		app.crearPlataforma(0, 362, 400, 1);
		crearPlataforma(2);
		app.crearPlataforma(80, 312, 400, -1);
		crearPlataforma(3);
		app.crearPlataforma(0, 262, 400, 1);
		crearPlataforma(4);
		app.crearPlataforma(80, 212, 400, -1);
		crearPlataforma(5);
		app.crearPlataforma(0, 162, 400, 1);
		crearPlataforma(6);
		app.crearPlataforma(80,112 , 400, -1);
		crearPlataforma(7);
		app.crearPlataforma(0, 62, 400, 1);
		crearPlataforma(8);
		app.crearPlataforma(90, 0, 160, 1);
		crearPlataforma(9);
		
		app.generarEscaleras(40, 1, 2);
		crearEscalera(1);
		app.generarEscaleras(80, 2, 3);
		crearEscalera(2);
		app.generarEscaleras(100, 3, 4);
		crearEscalera(3);
		app.generarEscaleras(120, 4, 5);
		crearEscalera(3);
		app.generarEscaleras(300, 5, 6);
		crearEscalera(4);
		app.generarEscaleras(200, 6, 7);
		crearEscalera(5);
		app.generarEscaleras(380, 7, 8);
		crearEscalera(6);
		app.generarEscaleras(120, 8, 9);
		crearEscalera(7);
		app.generarEscaleras(140, 8, 9);
		crearEscalera(8);
		app.generarEscaleras(200, 8, 9);
		crearEscalera(9);
		
		app.generarBarriles();
		crearBarril(1);
		moverBarril(1);
		
		
		
		/*app.crearPlataformaCentral(340);
		crearPataformaCentral(2);
		app.crearPlataformaCentral(300);
		crearPataformaCentral(3);
		app.crearPlataformaCentral(240);
		crearPataformaCentral(4);
		app.crearPlataformaCentral(100);
		crearPlataformaAlta(5);
		app.crearPlataformaAlta(0,40);
		crearPlataformaAlta(6);*/
		
		/*principal.addPlataformaAbajo(0, 412, "data/plataforma.png");
		principal.addPlataformaCentral(340, "data/plataforma.png");
		principal.addPlataformaCentral(300, "data/plataforma.png");
		principal.addPlataformaCentral(240, "data/plataforma.png");
		principal.addPlataformaCentral(210, "data/plataforma.png");
		principal.addPlataformaCentral(140, "data/plataforma.png");
		principal.addPlataformaCentral(100, "data/plataforma.png");
		principal.addPlataformaArriba(0, 40, "data/plataforma.png");*/
		//principal.addEscalera(1, 2, 40);
		/*principal.addEscalera(2, 3, 72);
		principal.addEscalera(3, 4, 56);
		principal.addEscalera(4, 5, 88);
		principal.addEscalera(5, 6, 104);*/
		//principal.addEscalera(6, 7, 120);
		//principal.addEscalera(7, 8, 50);
		
	/*	crearEscalera(1);
		crearEscalera(2);
		crearEscalera(3);
		crearEscalera(4);
		crearEscalera(5);*/
		
		sorpresa=new JLabel();
		sorpresa.setIcon(new ImageIcon(app.generarSorpresa(48,400)));
		sorpresa.setBounds(0, 0, 80, 110);
		sorpresa.setLocation(50, 400);
		sorpresa.setSize(100, 100);	
		add(sorpresa);
		app.generarSorpresa(50, 400);
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
		//Timer timer=new Timer();
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
		//timer.schedule(tarea, 0, 500);
		//Timer timer2=new Timer();
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
		//timer2.schedule(tarea2, 0, 50);
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
					app.dejarsaltar(1);
					((single) principal).moverPersonaje(app.getJugadorPosX(1), app.getJugadorPosY(1), app.getForma(1));
				}
				repaint();	
			}
				
			
		});
		
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
