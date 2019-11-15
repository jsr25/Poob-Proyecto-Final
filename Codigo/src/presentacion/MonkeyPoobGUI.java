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

public class MonkeyPoobGUI extends JFrame {
	private JLabel mario;
	private String nombre;
	//private MonkeyPoob app;
	int i;
	public MonkeyPoobGUI() {
		super("Monkey");		
		setFocusable(true);
		prepararElementos();
		prepararPersonajes();
		prepareAcciones();
		add(mario);
		mario.setLocation(0,0);
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
	}
	public void prepararPersonajes() {
		mario=new JLabel();
		mario.setSize(200, 200);
		
		mario.setIcon(new ImageIcon("data/marioDerecha.png"));
		mario.setBounds(20, 20, 80, 110);
	}
	public void prepareAcciones() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='w' || e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					mario.setLocation(mario.getX(),mario.getY()-5);
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					mario.setLocation(mario.getX()-5,mario.getY());
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					mario.setLocation(mario.getX()+5,mario.getY());
				}
				if(e.getKeyChar()=='s' || e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					mario.setLocation(mario.getX(),mario.getY()+5);
				}
				
			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()=='w' || e.getExtendedKeyCode()== KeyEvent.VK_UP) {
					mario.setIcon(new ImageIcon("data/marioSalto.png"));					
					//for (int i=0;i<6;i++) {
					//	mario.setLocation(mario.getX(),mario.getY()-5);
					//}
					//mario.setIcon(new ImageIcon("data/marioDerecha.png"));
					//for (int i=0;i<6;i++) {
					//	mario.setLocation(mario.getX(),mario.getY()+5);
					//}
					
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					//System.out.println(nombre);
					if (nombre=="data/marioIzquierda.png") {
						mario.setIcon(new ImageIcon("data/marioPasoIzquierda.png"));
						nombre="data/marioPasoIzquierda.png";
					}
					else if(nombre=="data/marioPasoIzquierda.png") {
						mario.setIcon(new ImageIcon("data/marioPasoIzquierda2.png"));
						nombre="data/marioPasoIzquierda2.png";
					}
					else {
						mario.setIcon(new ImageIcon("data/marioIzquierda.png"));
						nombre="data/marioIzquierda.png";
					}
					mario.setLocation(mario.getX()-5,mario.getY());					
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					//System.out.println(nombre);
					if (nombre=="data/marioDerecha.png") {
						mario.setIcon(new ImageIcon("data/marioPasoDerecha.png"));
						nombre="data/marioPasoDerecha.png";
					}
					else if(nombre=="data/marioPasoDerecha.png") {
						mario.setIcon(new ImageIcon("data/marioPasoDerecha2.png"));
						nombre="data/marioPasoDerecha2.png";
					}
					else {
						mario.setIcon(new ImageIcon("data/marioDerecha.png"));
						nombre="data/marioDerecha.png";
					}
					mario.setLocation(mario.getX()+5,mario.getY());
						
				}
				if(e.getKeyChar()=='s' || e.getExtendedKeyCode()== KeyEvent.VK_DOWN) {
					mario.setLocation(mario.getX(),mario.getY()+5);
					mario.setIcon(new ImageIcon("data/marioDerecha.png"));
				}
				
				
			}
			public void keyReleased(KeyEvent e) {
				
			}
				
			
		});
	}

}
