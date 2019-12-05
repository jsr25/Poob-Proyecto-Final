package aplicacion;

import java.util.ArrayList;

public abstract class Barril {
	protected int x;
	protected int y;
	private MonkeyPoob monkey;
	
	/**
	 * 
	 */
	public Barril() {
		this.x=0;
		this.y=50;
		this.monkey=MonkeyPoob.getMonkey();
	}
	
	/**
	 * 
	 */
	public void move() {		
			ArrayList<Plataforma> pT= monkey.getplata();
			boolean posible=false;
			int tipo=0;
			for (int i=0;i<pT.size() && posible==false;i++) {
				 
				if (pT.get(i).estaSobre(x, y) && pT.get(i).getTipo()==1) {
					posible=true;
					tipo=1;
				}
				else if (pT.get(i).estaSobre2(x, y) && pT.get(i).getTipo()==-1) {
					posible=true;
					tipo=-1;
				}
			}
			if (posible) {
				x+=(10*tipo);
			}
			else {
				y+=10;
			}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 * @return
	 */
	public boolean colision(int posX, int posY) {
		return x==posX && y==posY;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getX() {
		
		return x;
	}
	
	/**
	 * 
	 */
	public void reiniciar() {
		x=0;
		y=50;		
	}
}
