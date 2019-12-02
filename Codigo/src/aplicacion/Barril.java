package aplicacion;

import java.util.ArrayList;

public class Barril {
	private int x;
	private int y;
	private MonkeyPoob monkey;
	
	public Barril(MonkeyPoob monkey) {
		this.x=0;
		this.y=50;
		this.monkey=MonkeyPoob.getMonkey();
	}
	
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
	
	
	/*public int movimiento(int x) {
		ArrayList<Plataforma> plataformas= monkey.getPlataformas();
		for (Plataforma p: plataformas) {
			if(p.estaEnRango(x)) {
				if(y==p.valorY(x)) {
					if(p.pendienteNegativa()) {
						x+=1;
					}
					else {
						x-=1;
					}
				}
			}
		}
		return x;
	}*/
	
	public int getY() {
		return y;
	}

	public boolean colision(int posX, int posY) {
		return x==posX && y==posY;
	}

	public int getX() {
		
		return x;
	}
}
