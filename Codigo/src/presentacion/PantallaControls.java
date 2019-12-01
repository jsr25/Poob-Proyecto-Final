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

public class PantallaControls extends JDialog {
	private static final long serialVersionUID = 1L;
	JButton back;
	JLabel w,a,s,d,p,space,up,left,right,down,salto,der,izq;
	String upN,leftN,rightN,downN,saltoN,derN,izqN,spaceN ;
	public PantallaControls() {
		super();
		prepareElementos();
		prepareControles();
		moverTeclas();
	}
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
		salto=new JLabel();
		der=new JLabel();
		izq=new JLabel();;
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
		salto.setIcon(new ImageIcon("data/salto1.png"));
		salto.setBounds(0, 0, 400, 400);
		salto.setLocation(0,200);
		saltoN="data/salto1.png";
		der.setIcon(new ImageIcon("data/derecha1.png"));
		der.setBounds(0, 0, 400, 400);
		der.setLocation(200,100);
		derN="data/derecha1.png";
		izq.setIcon(new ImageIcon("data/izquierda1.png"));
		izq.setBounds(0, 0, 400, 400);
		izq.setLocation(500,100);
		izqN ="data/izquierda1.png";
		add(up);
		add(left);
		add(right);
		add(down);
		add(space);
		/*
		add(salto);
		add(der);
		add(izq);*/
		
	}
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
				if (saltoN=="data/salto1.png") {
					salto.setIcon(new ImageIcon("data/salto2.png"));
					saltoN="data/salto2.png";
				}
				else if (saltoN=="data/salto2.png") {
					salto.setIcon(new ImageIcon("data/salto3.png"));
					saltoN="data/salto3.png";
				}

				else {
					salto.setIcon(new ImageIcon("data/salto1.png"));
					saltoN="data/salto1.png";
				}
			}
		};
		timer5.schedule(tarea5, 0, 500);
		Timer timer6=new Timer();
		TimerTask tarea6=new TimerTask(){
			@Override
			public void run() {	
				if (derN=="data/derecha1.png") {
					der.setIcon(new ImageIcon("data/derecha2.png"));
					derN="data/derecha2.png";
				}
				else if (derN=="data/derecha2.png") {
					der.setIcon(new ImageIcon("data/derecha3.png"));
					derN="data/derecha3.png";
				}
				else if (derN=="data/derecha3.png") {
					der.setIcon(new ImageIcon("data/derecha4.png"));
					derN="data/derecha4.png";
				}

				else {
					der.setIcon(new ImageIcon("data/derecha1.png"));
					derN="data/derecha1.png";
				}
			}
		};
		timer6.schedule(tarea6, 0, 500);
		Timer timer7=new Timer();
		TimerTask tarea7=new TimerTask(){
			@Override
			public void run() {	
				if (izqN=="data/izquierda1.png") {
					izq.setIcon(new ImageIcon("data/izquierda2.png"));
					izqN="data/izquierda2.png";
				}
				else if (izqN=="data/izquierda2.png") {
					izq.setIcon(new ImageIcon("data/izquierda3.png"));
					izqN="data/izquierda3.png";
				}
				else if (izqN=="data/izquierda3.png") {
					izq.setIcon(new ImageIcon("data/izquierda4.png"));
					izqN="data/izquierda4.png";
				}

				else {
					izq.setIcon(new ImageIcon("data/izquierda1.png"));
					izqN="data/izquierda1.png";
				}
			}
		};
		timer7.schedule(tarea7, 0, 500);
		Timer timer8=new Timer();
		TimerTask tarea8=new TimerTask(){
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
		timer8.schedule(tarea8, 0, 500);
	}

}
