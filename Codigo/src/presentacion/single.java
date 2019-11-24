package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aplicacion.MonkeyPoob;

public class single extends JPanel{
	private JLabel mario,mono,barril,plataforma,sorpresa,escalera;
	public String monoN,barrilN;
	private String nombre;
	private int k;
	ArrayList plataformas=new ArrayList<ArrayList>();
	public  single(){
		setFocusable(true);
		k=-1;
		this.setSize(800,500);
		
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
		for (int i=0;i<25;i++) {
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(img));
			plataforma.setBounds(0, 0, 80, 110);
			if (i<12) {
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
			pos=50;
		}
		int pos2=y;
		for (int i=0;i<15;i++) {
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(img));
			plataforma.setBounds(0, 0, 80, 110);
			//pos=pos+(i*15);
			plataforma.setLocation(pos+(i*16),pos2+(i*k));
			add(plataforma);
			pC.add(plataforma);
		}
		k=k*-1;
		plataformas.add(pC);
	}
	public void addEscalera(int y1, int y2, int x) {
		for (int i=0; i<4;i++) {
			escalera=new JLabel();
			escalera.setIcon(new ImageIcon("data/escalera.png"));
			escalera.setSize(9, 19);		
			escalera.setBounds(0, 0, 80, 110);
			escalera.setLocation(x,y1+(-i*19));
			add(escalera);
	}
	}
	
}