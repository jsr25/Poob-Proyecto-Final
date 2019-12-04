package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import aplicacion.MonkeyPoob;

public class single extends JPanel{
	private JLabel mario,mono,barril,plataforma,sorpresa,escalera,puntos,vidas,pauline,logo,score,lifes;
	public String monoN,barrilN;
	private ArrayList<int[]> esca;
	private String nombre,paulineN,logoN;
	private int k;
	Timer timer1,timer2,timer3;
	ArrayList<ArrayList<JLabel>> plataformas=new ArrayList<ArrayList<JLabel>>();
	public  single(){
		setFocusable(true);
		esca=new ArrayList<int[]>();
		k=1;
		this.setSize(600,600);
		this.setBackground(Color.black);
		puntajeYVidas();
		prepararPersonajes();
		
		
	}
	public void puntajeYVidas() {
		puntos =new JLabel("--");
		puntos.setSize(25,10);
		puntos.setBounds(0, 0, 20, 10);
		puntos.setLocation(15,15);
		puntos.setForeground(Color.white);
		puntos.setBackground(Color.white);
		vidas=new JLabel();
		vidas.setSize(50, 10);
		vidas.setBounds(0, 0, 10, 10);
		vidas.setLocation(110,15);
		vidas.setForeground(Color.white);
		vidas.setBackground(Color.white);
		lifes=new JLabel("Lifes");
		lifes.setForeground(Color.white);
		lifes.setSize(20, 20);
		lifes.setBounds(0, 0, 80, 10);
		lifes.setLocation(100,0);
		score=new JLabel("Scores");
		score.setForeground(Color.white);
		score.setSize(20, 20);
		score.setBounds(0, 0, 80, 10);
		score.setLocation(0,0);
		add(score);
		add(lifes);
		add(puntos);
		add(vidas);
	}
	public void prepararPersonajes() {
		logo=new JLabel();		
		logo.setSize(20, 20);
		logo.setIcon(new ImageIcon("data/logoS1.png"));
		logoN="data/logoS1.png";
		logo.setBounds(0, 0,150, 150);
		logo.setLocation(300,-28);
		add(logo);
		mono=new JLabel();		
		mono.setSize(20, 20);
		mono.setIcon(new ImageIcon("data/monoBaile1.png"));
		monoN="data/monoBaile1.png";
		mono.setBounds(0, 0, 80, 110);
		mono.setLocation(0,40);
		add(mono);
		pauline=new JLabel();		
		pauline.setSize(20, 20);
		pauline.setIcon(new ImageIcon("data/paulineDerecha1.png"));
		paulineN="data/paulineDerecha1.png";
		pauline.setBounds(0, 0, 80, 110);
		pauline.setLocation(60,-15);
		add(pauline);
		preparaMono();
		preparaPrincesa();
		preparaLogo();
	}
	public void  preparaMono() {
		timer2=new Timer(500,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						if (monoN=="data/monoBaile1.png") {
							mono.setIcon(new ImageIcon("data/monoBaila4.png"));
							monoN="data/monoBaila4.png";
						}
						/*else if (monoN=="data/monoBaile2.png") {
							mono.setIcon(new ImageIcon("data/monoBaila3.png"));
							monoN="data/monoBaila3.png";
						}*/
						else {
							mono.setIcon(new ImageIcon("data/monoBaile1.png"));
							monoN="data/monoBaile1.png";
							}
					}
			
		});
		timer2.start();
}
	public void  preparaPrincesa() {
		timer2=new Timer(1000,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						if (paulineN=="data/paulineDerecha1.png") {
							pauline.setIcon(new ImageIcon("data/paulineDerecha2.png"));
							pauline.setLocation(75,-15);
							paulineN="data/paulineDerecha2.png";
						}
						else {
							pauline.setIcon(new ImageIcon("data/paulineDerecha1.png"));
							pauline.setLocation(60,-15);
							paulineN="data/paulineDerecha1.png";
							}
					}
			
		});
		timer2.start();
}
	public void  preparaLogo() {
		timer3=new Timer(500,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (logoN=="data/logoS1.png") {
							logo.setIcon(new ImageIcon("data/logoS2.png"));
							logoN="data/logoS2.png";
						}
						else {
							logo.setIcon(new ImageIcon("data/logoS1.png"));
							logoN="data/logoS1.png";
							}
					}
			
		});
		timer3.start();
}
	public void setVidas(String v) {
		vidas.setText(v);
	}
	public void setPuntos(String v) {
		puntos.setText(v);
	}
	public void addPersonaje(int x, int y, String img) {
		mario=new JLabel();
		mario.setSize(10, 10);
		mario.setIcon(new ImageIcon(img));
		mario.setBounds(0, 0, 80, 110);
		mario.setLocation(x,y);
		add(mario);
		
	}
	public void moverPersonaje(int x,int y,String img) {
		mario.setLocation(x,y);
		mario.setIcon(new ImageIcon(img));
	}
	public void addPlataformaAbajo(int x,int y, String img) {
		ArrayList<JLabel> pAb=new ArrayList<JLabel>();
		
		int pos=x;
		int pos2=y;
		int j=1;
		for (int i=0;i<20;i++) {
			
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(img));
			plataforma.setBounds(0, 0, 80, 110);
			if (i<10) {
			plataforma.setLocation(pos+(i*16),pos2);
			}
			else {
			plataforma.setLocation(pos+(i*16),pos2+(-j));
			j=j+1;
			}
			add(plataforma);
			pAb.add(plataforma);
		}
		plataformas.add(pAb);
	}
	public void addPlataformaArriba(int x,int y, String img) {
		ArrayList<JLabel> pAr=new ArrayList<JLabel>();
		int pos=x;
		int pos2=y;
		int j=1;
		for (int i=0;i<15;i++) {
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(img));
			plataforma.setBounds(0, 0, 80, 110);
			//pos=pos+(i*15);
			if (i<7) {
			plataforma.setLocation(pos+(i*16),pos2);
			}
			else {
			plataforma.setLocation(pos+(i*16),pos2+(j));
			j=j+1;
			}
			add(plataforma);
			pAr.add(plataforma);
		}
		plataformas.add(pAr);
	}
	public void addPlataformaCentral(int y, String img) {
		ArrayList<JLabel> pC=new ArrayList<JLabel>();
		int pos;
		if (k==1) {
			pos=0;
		}
		else {
			pos=32;
		}
		int pos2=y;
		for (int i=0;i<15;i++) {
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(img));
			plataforma.setBounds(0, 0, 80, 110);
			plataforma.setLocation(pos+(i*16),pos2+(i*k));
			add(plataforma);
			pC.add(plataforma);
			
		}
		k=k*-1;
		plataformas.add(pC);
	}
	public int [] getEscalera(int i) {
		int[] esc= esca.get(i-1);
		return esc;
		
	}
	public void addPlataforma(int x, int y, int x2, String string) {
		ArrayList<JLabel> pC=new ArrayList<JLabel>();
		for(int i=0;i<x2/16;i++) {
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(string));
			plataforma.setBounds(0, 0, 80, 110);
			plataforma.setLocation(x+(i*16),y);
			add(plataforma);
			pC.add(plataforma);
		}
		plataformas.add(pC);
	}
	public void crearEscalera(int x, int y1, int y2) {
		for (int i=0; i<((y1-y2)/7);i++) {
			escalera=new JLabel();
			escalera.setIcon(new ImageIcon("data/escalera.png"));
			escalera.setSize(8, 7);		
			escalera.setBounds(0, 0, 80, 110);
			escalera.setLocation(x,(y1-8)+(-i*7));
			add(escalera);
		
		}
	}
	
	public void crearBarril(int x , int y) {
		barril=new JLabel();
		barril.setIcon(new ImageIcon("data/barrilGirando1.png"));
		barrilN="data/barrilGirando1.png";
		barril.setSize(20,20);
		barril.setBounds(0, 0, 80, 110);
		barril.setLocation(x,y);
		add(barril);
	}
	public void actualizarbar(int j, int getbarx, int getbary) {
		barril.setLocation(getbarx, getbary);
		
		if(barrilN.equals("data/barrilGirando1.png")) {
			barril.setIcon(new ImageIcon("data/barrilgirando2.png"));
			barrilN="data/barrilgirando2.png";
		}
		else {
			barril.setIcon(new ImageIcon("data/barrilGirando1.png"));
			barrilN="data/barrilGirando1.png";
		}
		repaint();
		
	}
	public void removebar(int j) {
		remove(barril);
	}
}
