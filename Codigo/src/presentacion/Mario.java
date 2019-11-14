package presentacion;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Mario {
	private String mario;
	private int dx,dy,x,y;
	private Image imagen;
	public Mario() {
		x=40;
		y=60;
		mario="marioDerecha.png";
		ImageIcon img=new ImageIcon(this.getClass().getResource(mario));
		imagen =img.getImage();
	}
	public void KeyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) {
			dx=-1;
			
		}
		if(key==KeyEvent.VK_RIGHT) {
			dx=1;
		}
		if(key==KeyEvent.VK_UP) {
			dy=-1;
		}
		if(key==KeyEvent.VK_DOWN) {
			dy=1;
		}
		mover();
	}
	public void KeyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_LEFT) {
			dx=0;
		}
		if(key==KeyEvent.VK_RIGHT) {
			dx=0;
		}
		if(key==KeyEvent.VK_UP) {
			dy=0;
		}
		if(key==KeyEvent.VK_DOWN) {
			dy=0;
		}
	}
	public void mover() {
		x+=dx;
		y+=dy;
	}
	public int tenerX() {
		return x;
	}
	public int tenerY() {
		return y;
	}
	public Image tenerImagen() {
		return imagen;
	}
}
