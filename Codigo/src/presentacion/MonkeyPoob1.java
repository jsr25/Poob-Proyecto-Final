package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MonkeyPoob1 extends JFrame {
	private JLabel mario;
	public MonkeyPoob1() {
		super("Monkey");		
		setFocusable(true);
		prepararElementos();
		prepararPersonajes();
		prepareAcciones();
		add(mario);
	}
	public static void main(String[] args) {
		MonkeyPoob1 intf=new MonkeyPoob1();
		intf.setVisible(true);
	}
	public void prepararElementos() {
		//Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(800,500);
		setLayout(null);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.black);
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
					mario.setLocation(mario.getX(),mario.getY()-5);
					mario.setIcon(new ImageIcon("data/marioDerecha.png"));
				}
				if(e.getKeyChar()=='a' || e.getExtendedKeyCode()== KeyEvent.VK_LEFT) {
					mario.setLocation(mario.getX()-5,mario.getY());
					mario.setIcon(new ImageIcon("data/marioIzquierda.png"));
				}
				if(e.getKeyChar()=='d' || e.getExtendedKeyCode()== KeyEvent.VK_RIGHT) {
					mario.setLocation(mario.getX()+5,mario.getY());
					mario.setIcon(new ImageIcon("data/marioDerecha.png"));
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
