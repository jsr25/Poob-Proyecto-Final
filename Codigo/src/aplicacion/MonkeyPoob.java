package aplicacion;

import java.util.ArrayList;
/**
 * 
 * @author Juan Ramos 
 *
 */
public class MonkeyPoob {
	private ArrayList<ArrayList<Plataforma>> plataformas;
	private ArrayList<Jugador> jugadores;
	private	ArrayList<Escalera> escaleras;
	private ArrayList<Sorpresa> sorpresas;
	private ArrayList<Barril> barriles;
	private boolean cambioP;
	/**
	 * Constructor de la capa de 
	 * aplicacion para un solo jugador
	 */
	public MonkeyPoob() {
		plataformas=new ArrayList<ArrayList<Plataforma>>();
		barriles= new ArrayList<Barril>();
		jugadores = new ArrayList<Jugador>();
		sorpresas = new ArrayList<Sorpresa>();
		escaleras = new ArrayList<Escalera>();
		cambioP=false;
	}
	
	
	/**
	 * Genera las plataformas en la capa de aplicacion
	 *  a partir de los valores de los puntos de los 
	 *  extremos de la plataforma 
	 * @param x1 la x inicial 
	 * @param y1 la y inicial
	 * @param x2 la x final 
	 * @param y2 la y final 
	 */
	public void crearPlataformaBaja(int x1, int y1) {
		ArrayList<Plataforma> plat=new ArrayList<Plataforma>();
		//plat.add(new Plataforma(x2,y,x,0,-1));
		int x=16;
		int x2=x1;
		int y=y1;
		for (int i=0;i<20;i++ ) {
			if(i<10) {
				if (i==9) {
					plat.add(new Plataforma(x2,y,x,0,-1));
				}
				else {
				plat.add(new Plataforma(x2,y,x,0));
				}
				x2=x;
				x=x+16;
				
			}
			else {
				y=y-1;
				plat.add(new Plataforma(x2,y,x,-1));
				x2=x;
				x=x+16;
				
			}
		}
		plataformas.add(plat);
	}
/*	public void crearPlataformaCentral(int x1, int y1 , int x2) {
		plataformas.add(new Plataforma(x1,y1,x2));
	}
	
	public void crearPlataformaAlta(int x1, int y1 , int x2) {
		plataformas.add(new Plataforma(x1,y1,x2));
	}*/
	
	/**
	 * Genera un barril en la capa 
	 * de aplicacion 
	 */
	public void generarBarriles() {
		barriles.add(new Barril(this));
	}
	/**
	 * Genera un sorpresa en la capa 
	 * de aplicacion
	 * @param posX
	 * @param posY
	 */
	public String generarSorpresa(int posX, int posY) {
		Cereza cs = new Cereza(posX,posY);
		sorpresas.add(cs);
		return cs.getImagen();
	}
	/**
	 * Genra un escalera el la capa 
	 * de aplicacion
	 * @param x
	 * @param yIni
	 * @param yFin
	 */
	public void generarEscaleras(int x, int yIni , int yFin) {
		escaleras.add(new Escalera(x,yIni,yFin));
	}
	/**
	 * Genera un jugador Real para en 
	 * la capa de aplicacion
	 * @param posX
	 * @param posY
	 * @param name
	 */
	public void agregarJugadores(int posX, int posY, String name) {
		jugadores.add(new Real(posX,posY,name));
	}
	/**
	 * Dado el personaje lo mueve a la 
	 * derecha en la capa de aplicacion
	 * @param personaje
	 */
	public void moverDerecha(int personaje) {
		if (plataformas.get(jugadores.get(personaje-1).getPlat()).get(jugadores.get(personaje-1).getSubPlat()).estaSobre(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY())) {
			(jugadores.get(personaje-1)).avanzar();
		
		beneficio(personaje);	
		perderVida(personaje);
		//System.out.println(jugadores.get(personaje-1).getPuntos());
		}
		else {
			
			if (  (jugadores.get(personaje-1)).getSubPlat()+1<plataformas.get(jugadores.get(personaje-1).getPlat()).size()-1){
				(jugadores.get(personaje-1)).sumSub();
				jugadores.get(personaje-1).sumY(plataformas.get(jugadores.get(personaje-1).getPlat()).get(jugadores.get(personaje-1).getSubPlat()).getTipo());
				(jugadores.get(personaje-1)).avanzar();
			}
			else {
				
			}
			
		}
		System.out.println((jugadores.get(personaje-1)).getPosX());
	}
	
	/**
	 * Dado un  jugador retorna el personaje
	 * @param personaje
	 * @return
	 */
	public Jugador getJugador(int personaje) {
		return jugadores.get(personaje-1);
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Barril> getBarriles(){
		return barriles;
	}
	/**
	 * 
	 * @param personaje
	 */
	public void moverIzquieda(int personaje) {
		System.out.println(jugadores.get(personaje-1).getPosY());
		System.out.println(jugadores.get(personaje-1).getPosX());
		System.out.println(plataformas.get(jugadores.get(personaje-1).getPlat()).get(jugadores.get(personaje-1).getSubPlat()).estaSobre2(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY()));
		
		if (plataformas.get(jugadores.get(personaje-1).getPlat()).get(jugadores.get(personaje-1).getSubPlat()).estaSobre2(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY())) {
			(jugadores.get(personaje-1)).retroceder();		
		beneficio(personaje);	
		perderVida(personaje);
		//System.out.println(jugadores.get(personaje-1).getPuntos());
		}
		else {		
			if ((jugadores.get(personaje-1)).getSubPlat()-1>-1){
				System.out.println("*************************");
				(jugadores.get(personaje-1)).resSub();	
				System.out.println(jugadores.get(personaje-1).getSubPlat());
				jugadores.get(personaje-1).resY(plataformas.get(jugadores.get(personaje-1).getPlat()).get(jugadores.get(personaje-1).getSubPlat()).getTipo(),plataformas.get(jugadores.get(personaje-1).getPlat()).get(jugadores.get(personaje-1).getSubPlat()).getTipo2());
				
				(jugadores.get(personaje-1)).retroceder();
			}
			else {
				
			}
		}
		//System.out.println((jugadores.get(personaje-1)).getPosX());
	}
	/**
	 * 
	 * @param personaje
	 */
	public void  saltar(int personaje) {
		(jugadores.get(personaje-1)).saltar();
		beneficio(personaje);	
		perderVida(personaje);
	}
	/**
	
	*/
	public void  dejarsaltar(int personaje) {
		(jugadores.get(personaje-1)).dejarSaltar();
		beneficio(personaje);	
		perderVida(personaje);
	}
	/**
	 * 
	 * @param personaje
	 */
	public void beneficio(int personaje) {
		
		for(Sorpresa s:sorpresas) {
			if ((s.getPosX()==jugadores.get(personaje-1).getPosX())&&(s.getPosY()==jugadores.get(personaje-1).getPosY())) 
			{
				if (s.getTipo().equals("puntos")) {
					jugadores.get(personaje-1).setPuntos(s.beneficio());
					cambioP=true;
				
				}
			}
		}
		
		
	}
	/**
	 * 
	 * @param personaje
	 * @return
	 */
	public boolean estadoPersonaje(int personaje) {				
		return jugadores.get(personaje-1).getEstado();
		
	}
	/**
	 * 
	 * @return
	 */
	public int[] getPlataformas(int cont) {
		int[] vals=new int[2];
		vals[0]=((Plataforma) plataformas.get(cont-1).get(0)).getX();
		vals[1]=((Plataforma) plataformas.get(cont-1).get(0)).getY();
		return vals;
	}
	/**
	 * 
	 * @param personaje
	 */
	private void perderVida(int personaje) {
		for(Barril b :barriles) {
			b.colision(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY());
		}
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Jugador> getJugadores(){
		
		return jugadores;
	}
	/**
	 * 
	 * @param personaje
	 * @return
	 */
	public String getForma(int personaje) {		
		return jugadores.get(personaje-1).getForma();
	}
	/**
	 * 
	 * @param pesonaje
	 * @return
	 */
	public int getJugadorPosX(int pesonaje) {
		return jugadores.get(pesonaje-1).getPosX();
	}
	/**
	 * 
	 * @param pesonaje
	 * @return
	 */
	public int getJugadorPosY(int pesonaje) {
		return jugadores.get(pesonaje-1).getPosY();
	}
	/**
	 * 
	 * @param personaje
	 */
	public void FormaEstaticaIz(int personaje) {
		jugadores.get(personaje-1).cambiarforma(4);
	}
	/**
	 * 
	 * @param personaje
	 */
	public void FormaEstaticaDer(int personaje) {
		jugadores.get(personaje-1).cambiarforma(1);
	}
	
	public void subirEscalera(int personaje) {
		boolean posible=false;
		int y=0;
		for (Escalera es: escaleras) {
			posible=es.posibleSubir(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY());
			if(posible) {y=(es.getY2()-es.getY1())/3;}
		}
		jugadores.get(personaje-1).subir(posible, y);
		//System.out.println("hola"+ posible);
		
	}
	
	public void bajarEscalera(int personaje) {
		boolean posible=false;
		int y=0;
		for (Escalera es: escaleras) {
			posible=es.posibleBajar(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY());
			if(posible) {y=(es.getY2()-es.getY1())/3;	
				}
		}
		jugadores.get(personaje-1).bajar(posible, y);
	}
	
	public boolean getEnEscalera(int personaje) {
		return jugadores.get(personaje-1).getInEscalera();
	}
	
	public boolean cambioPuntos() {
		return cambioP;
	}
	
	public void removerSorpresa(int personaje) 
	{
		int index=0;
		for(Sorpresa s:sorpresas) {
			if ((s.getPosX()==jugadores.get(personaje-1).getPosX())&&(s.getPosY()==jugadores.get(personaje-1).getPosY())) 
			{
				index=sorpresas.indexOf(s);
			}
		}
		sorpresas.remove(index);
		cambioP=false;
	}
	
	public String getEscaleraIm() {
		return escaleras.get(0).getImagen();
	}
	
}

