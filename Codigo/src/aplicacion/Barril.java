package aplicacion;

import java.util.ArrayList;

public class Barril {
	private int x;
	private int y;
	private MonkeyPoob monkey;
	
	public Barril(MonkeyPoob monkey) {
		this.x=15;
		this.y=50;
		this.monkey=monkey;
		move();
	}
	
	public void move() {
		
		while(y!=0) {
			y-=1;
			//x=movimiento(x);
			ArrayList<Jugador> jp = monkey.getJugadores();
			for (Jugador j:jp) {
				if(j.colision(x,y)) {
					j.perdervida();
				}
			}
			
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
}
