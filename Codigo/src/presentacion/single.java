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


public class single extends  TableroJuego{
	private JLabel score,lifes,puntos,vidas,personaje;
	public  single(){
		puntajeYVidas();
	}

	@Override
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

	@Override
	public void setVidas(String v) {
		vidas.setText(v);
		
	}

	@Override
	public void setPuntos(String v) {
		puntos.setText(v);
	}

	@Override
	public void addPersonaje(int x, int y, String img) {
		personaje=new JLabel();
		personaje.setSize(10, 10);
		personaje.setIcon(new ImageIcon(img));
		personaje.setBounds(0, 0, 80, 110);
		personaje.setLocation(x,y);
		add(personaje);		
	}

	@Override
	public void moverPersonaje(int x, int y, String img, int i) {
		
		personaje.setLocation(x,y);
		personaje.setIcon(new ImageIcon(img));		
		
	}
	
	
	
	
		
		
}
