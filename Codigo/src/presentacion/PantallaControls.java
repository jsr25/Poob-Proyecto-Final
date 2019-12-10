package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class PantallaControls extends JDialog {
	private static final long serialVersionUID = 1L;
	JButton back;
	JLabel w,a,s,d,p,space,up,left,right,down,tex1,tex2,tex3,tex4,text5,jugador1,jugador2;
	String upN,leftN,rightN,downN,saltoN,derN,izqN,spaceN,wN,aN,sN,dN,pN;
	/**
	 * constructor de la pantalla de los controles
	 */
	public PantallaControls() {
		super();
		prepareElementos();
		prepareControles();
		moverTeclas();
	}
	/**
	 * prepara los elementos principales
	 */
	public void prepareElementos() {
		this.setLayout(null);
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(600,600);
		setLocationRelativeTo(null);
		this .getContentPane().setBackground(new Color(0,0,0));
		this.setResizable(false);
		
	}
	/**
	 * prepara los elementos necesarios 
	 */
	public void prepareControles() {
		w=new JLabel();
		a=new JLabel();
		s=new JLabel();
		d=new JLabel();
		p=new JLabel();
		space=new JLabel();
		up=new JLabel();
		left=new JLabel();
		right=new JLabel();
		down=new JLabel();
		up.setIcon(new ImageIcon("data/teclaArriba1.png"));
		up.setBounds(0, 0, 200, 200);
		up.setLocation(0,0);
		upN="data/teclaArriba1.png";
		left.setIcon(new ImageIcon("data/teclaIzquierda1.png"));
		left.setBounds(0, 0, 200, 200);
		left.setLocation(100,0);
		leftN="data/teclaIzquierda1.png";
		right.setIcon(new ImageIcon("data/teclaDerecha1.png"));
		right.setBounds(0, 0, 200, 200);
		right.setLocation(200,0);
		rightN="data/teclaDerecha1.png";
		down.setIcon(new ImageIcon("data/teclaAbajo1.png"));
		down.setBounds(0, 0, 200, 200);
		down.setLocation(300,0);
		downN="data/teclaAbajo1.png";
		space.setIcon(new ImageIcon("data/space.png"));
		space.setBounds(0, 0, 200, 200);
		space.setLocation(400,0);
		spaceN="data/space.png";
		saltoN="data/salto1.png";
		derN="data/derecha1.png";
		izqN ="data/izquierda1.png";
		w.setIcon(new ImageIcon("data/teclaW1.png"));
		w.setBounds(0, 0, 400, 500);
		w.setLocation(0,50);
		wN ="data/teclaW1.png";
		p.setIcon(new ImageIcon("data/teclaP1.png"));
		p.setBounds(0, 0, 400, 500);
		p.setLocation(430,50);
		pN ="data/teclaP1.png";
		a.setIcon(new ImageIcon("data/teclaA1.png"));
		a.setBounds(0, 0, 400, 500);
		a.setLocation(100,50);
		aN ="data/teclaA1.png";
		s.setIcon(new ImageIcon("data/teclaS1.png"));
		s.setBounds(0, 0, 400, 500);
		s.setLocation(300,50);
		sN ="data/teclaS1.png";
		d.setIcon(new ImageIcon("data/teclaD1.png"));
		d.setBounds(0, 0, 400, 500);
		d.setLocation(200,50);
		dN ="data/teclaD1.png";
		add(up);
		add(left);
		add(right);
		add(down);
		add(space);
		add(w);
		add(a);
		add(s);
		add(d);
		add(p);	
	}
	/**
	 * genera los timer de las teclas
	 */
	public void moverTeclas() {
		Timer timer=new Timer();
		TimerTask tarea=new TimerTask(){
			@Override
			public void run() {	
				if (upN=="data/teclaArriba1.png") {
					up.setIcon(new ImageIcon("data/teclaArriba2.png"));
					upN="data/teclaArriba2.png";
				}

				else {
					up.setIcon(new ImageIcon("data/teclaArriba1.png"));
					upN="data/teclaArriba1.png";
				}
			}
		};
		timer.schedule(tarea, 0, 500);
		Timer timer2=new Timer();
		TimerTask tarea2=new TimerTask(){
			@Override
			public void run() {	
				if (leftN=="data/teclaIzquierda1.png") {
					left.setIcon(new ImageIcon("data/teclaIzquierda2.png"));
					leftN="data/teclaIzquierda2.png";
				}

				else {
					left.setIcon(new ImageIcon("data/teclaIzquierda1.png"));
					leftN="data/teclaIzquierda1.png";
				}
			}
		};
		timer2.schedule(tarea2, 0, 500);
		Timer timer3=new Timer();
		TimerTask tarea3=new TimerTask(){
			@Override
			public void run() {	
				if (rightN=="data/teclaDerecha1.png") {
					right.setIcon(new ImageIcon("data/teclaDerecha2.png"));
					rightN="data/teclaDerecha2.png";
				}

				else {
					right.setIcon(new ImageIcon("data/teclaDerecha1.png"));
					rightN="data/teclaDerecha1.png";
				}
			}
		};
		timer3.schedule(tarea3, 0, 500);
		Timer timer4=new Timer();
		TimerTask tarea4=new TimerTask(){
			@Override
			public void run() {	
				if (downN=="data/teclaAbajo1.png") {
					down.setIcon(new ImageIcon("data/teclaAbajo2.png"));
					downN="data/teclaAbajo2.png";
				}

				else {
					down.setIcon(new ImageIcon("data/teclaAbajo1.png"));
					downN="data/teclaAbajo1.png";
				}
			}
		};
		timer4.schedule(tarea4, 0, 500);
		Timer timer5=new Timer();
		TimerTask tarea5=new TimerTask(){
			@Override
			public void run() {	
				if (wN=="data/teclaW1.png") {
					w.setIcon(new ImageIcon("data/teclaW2.png"));
					wN="data/teclaW2.png";
				}

				else {
					w.setIcon(new ImageIcon("data/teclaW1.png"));
					wN="data/teclaW1.png";
				}
			}
		};
		timer5.schedule(tarea5, 0, 500);
		Timer timer6=new Timer();
		TimerTask tarea6=new TimerTask(){
			@Override
			public void run() {	
				if (aN=="data/teclaA1.png") {
					a.setIcon(new ImageIcon("data/teclaA2.png"));
					aN="data/teclaA2.png";
				}

				else {
					a.setIcon(new ImageIcon("data/teclaA1.png"));
					aN="data/teclaA1.png";
				}
			}
		};
		timer6.schedule(tarea6, 0, 500);
		Timer timer7=new Timer();
		TimerTask tarea7=new TimerTask(){
			@Override
			public void run() {	
				if (sN=="data/teclaS1.png") {
					s.setIcon(new ImageIcon("data/teclaS2.png"));
					sN="data/teclaS2.png";
				}

				else {
					s.setIcon(new ImageIcon("data/teclaS1.png"));
					sN="data/teclaS1.png";
				}
			}
		};
		timer7.schedule(tarea7, 0, 500);
		Timer timer8=new Timer();
		TimerTask tarea8=new TimerTask(){
			@Override
			public void run() {	
				if (dN=="data/teclaD1.png") {
					d.setIcon(new ImageIcon("data/teclaD2.png"));
					dN="data/teclaD2.png";
				}

				else {
					d.setIcon(new ImageIcon("data/teclaD1.png"));
					dN="data/teclaD1.png";
				}
			}
		};
		timer8.schedule(tarea8, 0, 500);
		Timer timer9=new Timer();
		TimerTask tarea9=new TimerTask(){
			@Override
			public void run() {	
				if (pN=="data/teclaP1.png") {
					p.setIcon(new ImageIcon("data/teclaP2.png"));
					pN="data/teclaW2.png";
				}

				else {
					p.setIcon(new ImageIcon("data/teclaP1.png"));
					pN="data/teclaP1.png";
				}
			}
		};
		timer9.schedule(tarea9, 0, 500);
		Timer timer10=new Timer();
		TimerTask tarea10=new TimerTask(){
			@Override
			public void run() {	
				if (spaceN=="data/space.png") {
					space.setIcon(new ImageIcon("data/space2.png"));
					spaceN="data/space2.png";
				}

				else {
					space.setIcon(new ImageIcon("data/space.png"));
					spaceN="data/space.png";
				}
			}
		};
		timer10.schedule(tarea10, 0, 500);
	}

}
