package presentacion;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public class doble extends TableroJuego {
	private JLabel score1,lifes1,score2,lifes2,puntos1,puntos2,vidas1,vidas2,personaje1,personaje2;
	/**
	 * contructor del tablero doble
	 */
	public doble() {
		puntajeYVidas();
		prepararVidas2();
	}
	/**
	 * inicializa los puntajes y las vidas de mario
	 */
	@Override
	public void puntajeYVidas() {
		puntos1 =new JLabel();
		puntos1.setSize(25,10);
		puntos1.setBounds(0, 0, 20, 10);
		puntos1.setLocation(15,15);
		puntos1.setForeground(Color.white);
		puntos1.setBackground(Color.white);
		vidas1=new JLabel();
		vidas1.setSize(50, 10);
		vidas1.setBounds(0, 0, 10, 10);
		vidas1.setLocation(110,15);
		vidas1.setForeground(Color.white);
		vidas1.setBackground(Color.white);
		lifes1=new JLabel("Lifes");
		lifes1.setForeground(Color.white);
		lifes1.setSize(20, 20);
		lifes1.setBounds(0, 0, 80, 10);
		lifes1.setLocation(100,0);
		score1=new JLabel("Scores");
		score1.setForeground(Color.white);
		score1.setSize(20, 20);
		score1.setBounds(0, 0, 80, 10);
		score1.setLocation(0,0);
		add(score1);
		add(lifes1);
		add(puntos1);
		add(vidas1);		
	}
	/**
	 * incializa los puntajes y cidas de luigi
	 */
	public void prepararVidas2() {
		puntos2 =new JLabel("--");
		puntos2.setSize(25,10);
		puntos2.setBounds(0, 0, 20, 10);
		puntos2.setLocation(15,15);
		puntos2.setForeground(Color.white);
		puntos2.setBackground(Color.white);
		vidas2=new JLabel();
		vidas2.setSize(50, 10);
		vidas2.setBounds(0, 0, 10, 10);
		vidas2.setLocation(110,15);
		vidas2.setForeground(Color.white);
		vidas2.setBackground(Color.white);
		lifes2=new JLabel("Lifes");
		lifes2.setForeground(Color.white);
		lifes2.setSize(20, 20);
		lifes2.setBounds(0, 0, 80, 10);
		lifes2.setLocation(100,0);
		score2=new JLabel("Scores");
		score2.setForeground(Color.white);
		score2.setSize(20, 20);
		score2.setBounds(0, 0, 80, 10);
		score2.setLocation(0,0);
		add(score2);
		add(lifes2);
		add(puntos2);
		add(vidas2);
	}
	/**
	 * modifica las vidas
	 */
	@Override
	public void setVidas(String v,String s) {
		vidas1.setText(v);
		vidas2.setText(s);
		
	}
	/**
	 * modifica los puntos
	 */
	@Override
	public void setPuntos(String v,String s) {
		puntos1.setText(v);
		puntos2.setText(s);		
	}
	/**
	 * añade los personajes
	 */
	@Override
	public void addPersonaje(int x, int y, String img) {
		if(personaje1==null) {
			personaje1=new JLabel();
			personaje1.setSize(10, 10);
			personaje1.setIcon(new ImageIcon(img));
			personaje1.setBounds(0, 0, 80, 110);
			personaje1.setLocation(x,y);
			add(personaje1);	
		}
		
		else {
			personaje2=new JLabel();
			personaje2.setSize(10, 10);
			personaje2.setIcon(new ImageIcon(img));
			personaje2.setBounds(0, 0, 80, 110);
			personaje2.setLocation(x,y);
			add(personaje2);
		}
		
	}
	/**
	 * permite mover los personajes
	 */
	@Override
	public void moverPersonaje(int x, int y, String img, int i) {
		if(i==1) {
			personaje1.setLocation(x,y);
			personaje1.setIcon(new ImageIcon(img));	
		}
		else {
			personaje2.setLocation(x,y);
			personaje2.setIcon(new ImageIcon(img));
		}
		
	}

}
