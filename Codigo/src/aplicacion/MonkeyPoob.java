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
	private ArrayList<Plataforma> plataformas;
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
		plataformas=new ArrayList<Plataforma>();
		barriles= new ArrayList<Barril>();
		jugadores = new ArrayList<Jugador>();
		sorpresas = new ArrayList<Sorpresa>();
		escaleras = new ArrayList<Escalera>();
		cambioP=false;
		k=1;
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
	public String getVidas(int j) {
		return jugadores.get(j-1).getVidas()+"";
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
	public void crearPlataforma(int x1, int y1,int x2,int tipo) {
		plataformas.add(new Plataforma(x1,y1,x2,tipo));
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
		//System.out.println("Posicion x jugador"+"  "+temp.getPosX());
		//if(!temp.getInEscalera()) {
		boolean posibleMov=false;
		for (int i=0;i<plataformas.size( ) && posibleMov==false ;i++) {
			if(plataformas.get(i).estaSobre(temp.getPosX(),temp.getPosY())) {
				posibleMov=true;
			}
		}
		
		if (posibleMov) {
			temp.avanzar();		
			beneficio(personaje);	
			perderVida(personaje);
		}
		
	}
	//}
	public boolean jugadorMuerto(int i) {
		return jugadores.get(i-1).getMuerto();
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
		boolean posibleMov=false;
		for (int i=0;i<plataformas.size( ) && posibleMov==false ;i++) {
			if(plataformas.get(i).estaSobre2(temp.getPosX(),temp.getPosY())) {
				posibleMov=true;
			}
		}
		if (posibleMov) {
			temp.retroceder();		
			beneficio(personaje);	
			perderVida(personaje);
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
		escaleras.add(new Escalera(x,plataformas.get(plataforma1-1),plataformas.get(plataforma2-1)));
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
			}
			temp.subir(posible, y);

		}
		
	
	private int mindiv(int s) {
		int res=0;
		for(int i=2;i<Math.abs(s) && res==0;i++) {
			if(Math.abs(s)%i==0) {res=i;}
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
	
	public void bajarEscalera(int personaje) {
		Jugador temp=jugadores.get(personaje-1);
		boolean posible=false;
		int y=0;
		for (int i=0;i<escaleras.size() && posible==false ;i++) {
			posible=escaleras.get(i).posibleBajar(temp.getPosX(),temp.getPosY()+12);
			if(posible) 
				{
					
					int p= escaleras.get(i).getY2()-escaleras.get(i).getY1();
					y=(p)/mindiv(p);
					temp.setInEscalera(posible);
				}
		}
		jugadores.get(personaje-1).bajar(posible, y);
	}
	
	public void moverBarril(int j) {
		Barril b=barriles.get(j-1);
		b.move();
		for(int i=0;i<jugadores.size();i++) {
			if(b.colision(jugadores.get(i).getPosX(), jugadores.get(i).getPosY())) {
				perderVida(i+1);
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
	/*public void generarEscaleras(int x, int plataforma1 , int plataforma2) {
		/*Plataforma plat1=buscarPlataforma(plataforma1,x);
		Plataforma plat2=buscarPlataforma(plataforma2,x);
		escaleras.add(new Escalera(x,plat1,plat2));*/
		
	//}
	/**
	 * Busca la en una plataforam dada
	 * la subplataforma en la que 
	 * 
	 * @param plat ArrayList de plataformas
	 * @param x el punto en x donde se va a ubicar  
	 * @return retorna la plataforma en la que esta ese x 
	 */
	/*private Plataforma buscarPlataforma(int plat,int x) {
		Plataforma f=null;
		for(int i=0;i<plataformas.get(plat-1).size() && f==null;i++) {
			if (plataformas.get(plat-1).get(i).rangoX(x)) {
				f=plataformas.get(plat-1).get(i);
			}
		}
		return f;
	}*/
	
	
	
	
	private void getEscalera() {
		//System.out.println(escaleras.get(2).getY1());
		//System.out.println(escaleras.get(2).getY2());
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
	 * Dado el personaje lo mueve a la 
	 * derecha en la capa de aplicacion
	 * @param personaje
	 */
	/*public void mostrarPlat() {
		int p=3;
	//	ArrayList<Plataforma>AS=plataformas.get(p);
		for (Plataforma pas:AS) 
		{
			
			//System.out.println(pas.getX());
			//System.out.println(pas.getX2());
			//System.out.println(pas.getY());
			//System.out.println(pas.getTipo());
			
		}
	}
	
	*/
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
		int[] vals=new int[3];
		vals[0]=(plataformas.get(cont-1).getX());
		vals[1]=(plataformas.get(cont-1).getY());
		vals[2]=(plataformas.get(cont-1).getX2());
		return vals;
	}
	/**
	 * 
	 * @param personaje
	 */
	private void perderVida(int personaje) {
		boolean herido=false;
		for(int i=0;i<barriles.size() && herido==false;i++) {
			herido=barriles.get(i).colision(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY());
		}
		if (herido) {
			System.out.println("Me hirieron");
			jugadores.get(personaje-1).resVidas();
			System.out.println(jugadores.get(personaje-1).getVidas());
		}
		else {
			jugadores.get(personaje-1).setMuerto(false);
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

	public int[] getEscalera(int i) {
		Escalera esc= escaleras.get(i-1);
		int[] a =new int[3];
		a[0]=esc.getX();
		a[1]=esc.getY1();
		a[2]=esc.getY2();
		return a;
	}

	public int[] getBarril(int j) {
		Barril bar=barriles.get(j-1);
		System.out.println(bar.getX()+" "+bar.getY());
		int[] a=new int[2];
		a[0]=bar.getX();
		a[1]=bar.getY();
		return a;
	}

	public ArrayList<Plataforma> getplata() {		
		return plataformas;
	}

	public int getbarx(int j) {
		return barriles.get(j-1).getX();
	}

	public int getbary(int j) {
		return barriles.get(j-1).getY();
	}

	public String getPuntos(int j) {
		
		return jugadores.get(j-1).getPuntos()+"";
	}

	public boolean jugadoresMuertos() {
		boolean estado=false;
		for(int i=0;i<jugadores.size() && estado==false;i++) {
			if (jugadores.get(i).getMuerto()) {}
			estado=true;
		}
		return estado;
	}

	public void resetJugador(int i) {
		jugadores.get(i-1).reiniciar();
		jugadores.get(i-1).setMuerto(false);
	}

	
	
	
}

