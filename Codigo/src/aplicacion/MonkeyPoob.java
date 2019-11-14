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
		barriles.add(new Barril(this));
	}
	
	public void generarSorpresa(int posX, int posY) {
		sorpresas.add(new Cereza(posX,posY));
	}
	
	public void generarEscaleras(int x, int yIni , int yFin) {
		escaleras.add(new Escalera(x,yIni,yFin));
	}
	
	public void agregarJugadores(int posX, int posY) {
		jugadores.add(new Real(posX,posY));
	}
	
	public void moverDerecha(int personaje) {
		(jugadores.get(personaje-1)).avanzar();
		beneficio(personaje);	
		
	}
	public Jugador getJugador(int personaje) {
		return jugadores.get(personaje-1);
	}
	
	public ArrayList<Barril> getBarriles(){
		return barriles;
	}
	
	public void moverIzquieda(int personaje) {
		(jugadores.get(personaje-1)).retroceder();
		beneficio(personaje);
	}
	
	public void  saltar(int personaje) {
		(jugadores.get(personaje-1)).saltar();
	}
	
	public void beneficio(int personaje) {
		
		for(Sorpresa s:sorpresas) {
			if ((s.getPosX()==jugadores.get(personaje-1).getPosX())&&(s.getPosY()==jugadores.get(personaje-1).getPosY())) 
			{
				if (s.getTipo().equals("puntos")) {
					jugadores.get(personaje-1).setPuntos(s.beneficio());
				
				}
			}
		}
		
	}
	
	public void estadoPersonaje() {
		
	}
	
	public ArrayList<Plataforma> getPlataformas() {
		return plataformas;
	}
}

