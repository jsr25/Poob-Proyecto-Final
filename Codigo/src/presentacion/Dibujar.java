package presentacion;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Dibujar extends JPanel implements ActionListener{
	Mario mario=new Mario();
	Timer timer=new Timer(5,this);
	public Dibujar() {
		this.setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new teclado());
		timer.start();
	}
	public void paint(Graphics grafica) {
		super.paint(grafica);
		Graphics2D g2=(Graphics2D) grafica;
		g2.drawImage(mario.tenerImagen(), mario.tenerX(), mario.tenerY(),null);
		
	}
	public void actionPerformed(ActionEvent e) {
		mario.mover();
		repaint();
	}
	private class teclado extends KeyAdapter{
		public void KeyPressed(KeyEvent e) {
			mario.KeyPressed(e);
		}
		public void KeyReleased(KeyEvent e) {
			mario.KeyReleased(e);
		}
	}
}
