package presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import aplicacion.MonkeyPoob;

public class MonkeyPoobGUI extends JFrame {
	private JLabel mario;
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
	}
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

}
