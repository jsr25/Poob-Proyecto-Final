package aplicacion;

import java.util.ArrayList;
/**
 * 
 * @author ramos
 *
 */
public class MonkeyPoob {
	ArrayList<Plataforma> plataformas;
	ArrayList<Jugador> jugadores;
	ArrayList<Escalera> escaleras;
	ArrayList<Sorpresa> sorpresas;
	ArrayList<Barril> barriles;
	/**
	 * 
	 */
	public MonkeyPoob() {
		plataformas=new ArrayList<Plataforma>();
		barriles= new ArrayList<Barril>();
		jugadores = new ArrayList<Jugador>();
		sorpresas = new ArrayList<Sorpresa>();
		escaleras = new ArrayList<Escalera>();
	}
	
	public void crearPlataforma(int x1, int y1 , int x2 ,int y2) {
		plataformas.add(new Plataforma(x1,y1,x2,y2));
	}
	
	public void generarBarriles() {
		barriles.add(new Barril());
	}
	
	public void generarSorpresa(int posX, int posY) {
		sorpresas.add(new Sorpresa(posX,posY));
	}
	
	public void generarEscaleras(int x, int yIni , int yFin) {
		escaleras.add(new Escalera(x,yIni,yFin));
	}
	
	public void agregarJugadores(int posX, int posY) {
		jugadores.add(new Jugador(posX,posY));
	}
	
	public void moverDerecha(int personaje) {
		jugadores.get(personaje).moverDerecha();;
	}
	
	public void moverIzquieda(int personaje) {
		jugadores.get(personaje).moverIzquierda();
	}
	
	public void  saltar(int personaje) {
		jugadores.get(personaje).saltar();
	}
	
	public void beneficio(int personaje) {
		
		for(int i=0;i<sorpresas.size();i++) {
			if ((sorpresas.get(i).getPosX()==jugadores.get(personaje).getPosX())&&(sorpresas.get(i).getPosY()==jugadores.get(personaje).getPosY())) 
			{
				
			}
		}
		
	}
	
}

