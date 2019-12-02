package aplicacion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.lang.Math;
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
	private int k;
	//singleton
	public static MonkeyPoob monkey;
	public static MonkeyPoob getMonkey() {
		if(monkey==null) {
			monkey= new MonkeyPoob();
		}
		return monkey;
	}
	
	/**
	 * Constructor de la capa de 
	 * aplicacion para un solo jugador
	 */
	private MonkeyPoob() {
		plataformas=new ArrayList<ArrayList<Plataforma>>();
		barriles= new ArrayList<Barril>();
		jugadores = new ArrayList<Jugador>();
		sorpresas = new ArrayList<Sorpresa>();
		escaleras = new ArrayList<Escalera>();
		cambioP=false;
		k=1;
	}
	
	/**
	 * Metodo que permite salvar el proceso
	 * que se lleva en el juego
	 * @param f
	 * @throws MonkeyException
	 */
	public void salvar(File f)throws MonkeyException {
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(monkey);
			out.close();
		} catch (IOException e) {
			throw new MonkeyException(MonkeyException.ERROR_IO);
		}
		
	}
	
	
	/**
	 * Se genera la plataforma en donde
	 * inicia el jugador
	 * @param x1
	 * @param y1
	 */
	public void crearPlataformaBaja(int x1, int y1) {
		ArrayList<Plataforma> plat=new ArrayList<Plataforma>();
		int x=16;
		int x2=x1;
		int y=y1;
		for (int i=0;i<20;i++ ) {
			if(i<10) {
				plat.add(new Plataforma(x2,y,x,0));
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
	/**
	 * Se generan las plataformas donde el jugador
	 * puede moverse
	 * @param y1
	 */
	public void crearPlataformaCentral(int y1) {
		ArrayList<Plataforma> plat=new ArrayList<Plataforma>();
		int pos;
		int pos2;
		if (k==1) pos=0;
		else pos=32;
		int y=y1;
		pos2=pos+16;
		for (int i =0;i<15;i++) {			
			plat.add(new Plataforma(pos,y,pos2,k));
			pos=pos2;
			pos2=pos2+16;
			y+=k;
			
		}
		k=k*-1;
		plataformas.add(plat);
	}
	/**
	 * se genera la plataforma donde esta donkey 
	 * @param x1
	 * @param y1
	 */
	public void crearPlataformaAlta(int x1, int y1 ) {
		ArrayList<Plataforma> plat=new ArrayList<Plataforma>();
		int x=16;
		int x2=x1;
		int y=y1;
		for (int i=0;i<15;i++ ) {
			if(i<7) {
				plat.add(new Plataforma(x2,y,x,0));
				x2=x;
				x=x+16;
			}
			else {
				y=y+1;
				plat.add(new Plataforma(x2,y,x,1));
				x2=x;
				x=x+16;
			}
		}
		plataformas.add(plat);
	}
	/**
	 * mueve al personaje a la derecha
	 * que envia la señal dependiendo 
	 * de en que plataforma y 
	 * subplataforma este
	 * @param personaje
	 */
	public void moverDerecha(int personaje) {
		Jugador temp=jugadores.get(personaje-1);
		if(!temp.getInEscalera()) {
		if (plataformas.get(temp.getPlat()).get(temp.getSubPlat()).estaSobre(temp.getPosX(),temp.getPosY())&& (temp.getPosX()!=plataformas.get(temp.getPlat()).get(temp.getSubPlat()).getX2())) {
			temp.avanzar();		
			beneficio(personaje);	
			perderVida(personaje);
		}
		else {
			
			if ((temp.getSubPlat()+1<plataformas.get(temp.getPlat()).size()-1)){
				temp.avanzar();
				temp.sumSub();
				temp.sumY(plataformas.get(temp.getPlat()).get(temp.getSubPlat()).getTipo());
				}
			}
		}
	}
	/**
	 * mueve al personaje a la izquierda
	 * que envia la señal dependiendo 
	 * de en que plataforma y 
	 * subplataforma este
	 * @param personaje
	 */
	public void moverIzquieda(int personaje) {
		Jugador temp=jugadores.get(personaje-1);
		if(!temp.getInEscalera()) {
		if (plataformas.get(temp.getPlat()).get(temp.getSubPlat()).estaSobre2(temp.getPosX(),temp.getPosY())) {
			temp.retroceder();		
			beneficio(personaje);	
			perderVida(personaje);
		}
		else {		
			if (temp.getSubPlat()-1>-1){
				temp.resY(plataformas.get(temp.getPlat()).get(temp.getSubPlat()).getTipo());
				temp.retroceder();
				temp.resSub();
				}
			
			}	
		}
	}
	/**
	 * Genra un escalera el la capa 
	 * de aplicacion
	 * @param x
	 * @param yIni
	 * @param yFin
	 */
	public void generarEscaleras(int x, int plataforma1 , int plataforma2) {
		Plataforma plat1=buscarPlataforma(plataformas.get(plataforma1-1),x);
		Plataforma plat2=buscarPlataforma(plataformas.get(plataforma2-1),x);
		escaleras.add(new Escalera(x,plat1,plat2));
		
	}
	/**
	 * Busca la en una plataforam dada
	 * la subplataforma en la que 
	 * 
	 * @param plat ArrayList de plataformas
	 * @param x el punto en x donde se va a ubicar  
	 * @return retorna la plataforma en la que esta ese x 
	 */
	private Plataforma buscarPlataforma(ArrayList<Plataforma> plat,int x) {
		Plataforma f=null;
		for(int i=0;i<plat.size();i++) {
			if (plat.get(i).rangoX(x)) {
				f=plat.get(i);
			}
		}
		return f;
	}
	
	public void subirEscalera(int personaje) {
		boolean posible=false;
		Jugador temp=jugadores.get(personaje-1);
		
		
		int y=0;
		for (int i=0;i<escaleras.size() && posible==false ;i++) {
			posible=escaleras.get(i).posibleSubir(temp.getPosX(),temp.getPosY());
			if(posible) 
				{
					int p= escaleras.get(i).getY2()-escaleras.get(i).getY1();
					y=(p)/mindiv(p);
					temp.setInEscalera(posible);
				}
				
			else if (temp.getPosY()+12==escaleras.get(i).getY2()) {
					if (temp.getInEscalera()) {
					temp.setPlat(temp.getPlat()+1);
					temp.setSubPlat(plataformas.get(temp.getPlat()).indexOf(escaleras.get(i).getPlat2()));
					temp.setInEscalera(posible);
					}
					
			}
		}
		temp.subir(posible, y);	
	}
	
	private int mindiv(int s) {
		int res=0;
		for(int i=2;i<Math.abs(s) && res==0;i++) {
			if(Math.abs(s)%i==0)res=i;
		}
		return res;
	}
	

	
	
	
	
	
	
	
	
	
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
	public void mostrarPlat() {
		int p=3;
		ArrayList<Plataforma>AS=plataformas.get(p);
		for (Plataforma pas:AS) 
		{
			
			//System.out.println(pas.getX());
			//System.out.println(pas.getX2());
			//System.out.println(pas.getY());
			//System.out.println(pas.getTipo());
			
		}
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
	
	
	
	/*private void busSubPlat(int personaje) {
		int x=jugadores
		for (int i=0;i<plataforma)
	}*/


	public void bajarEscalera(int personaje) {
		boolean posible=false;
		int y=0;
		/*for (Escalera es: escaleras) {
			posible=es.posibleBajar(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY());
			if(posible) {y=(es.getY2()-es.getY1())/3;	
				}
		}
		jugadores.get(personaje-1).bajar(posible, y);*/
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

