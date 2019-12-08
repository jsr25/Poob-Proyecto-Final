package aplicacion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
/**
 * 
 * @author Juan Ramos-Brayan Jimenez
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
	
	/**
	 * 
	 * @return el MonkeyPoob
	 */
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
	 * @param posX valor en x
	 * @param posY valor en y
	 * @param name tipo de muñeco
	 */
	public void agregarJugadores(int posX, int posY, String name) {
		jugadores.add(new Real(posX,posY,name));
	}
	/**
	 * 
	 * @param j numero de jugador
	 * @return catidad de las vidas
	 */
	public String getVidas(int j) {
		return jugadores.get(j-1).getVidas()+"";
	}
	
	/**
	 * Metodo que permite salvar el proceso
	 * que se lleva en el juego
	 * @param f archivo
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
	 * se genera la plataforma donde inicia el jugador
	 * @param x1 valor en x
	 * @param y1 valor inicial en y
	 * @param x2 valor final en y
	 * @param tipo tipo de plataforma
	 */
	public void crearPlataforma(int x1, int y1,int x2,int tipo) {
		plataformas.add(new Plataforma(x1,y1,x2,tipo));
	}
	
	/**
	 * mueve al personaje a la derecha
	 * que envia la seÃ±al dependiendo 
	 * de en que plataforma y 
	 * subplataforma este
	 * @param personaje
	 */
	public void moverDerecha(int personaje) {
		Jugador temp=jugadores.get(personaje-1);
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
	
	/**
	 * 
	 * @param i numero del jugador 
	 * @return si esta muerto
	 */
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
	 * @param x valor en x
	 * @param yIni y inicial de la escalera 
	 * @param yFin y final de la escalera
	 */
	public void generarEscaleras(int x, int plataforma1 , int plataforma2) {
		escaleras.add(new Escalera(x,plataformas.get(plataforma1-1),plataformas.get(plataforma2-1)));
	}
	
	/**
	 * permite a un jugador subir la escalera 
	 * @param personaje numero del jugador
	 */
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
		
	/**
	 * busca el minim divisor
	 * @param s distancia
	 * @return valor de los movimientos necesarios 
	 */
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
	 * @param bar tipo del barril a generar
	 */
	public void generarBarriles(String bar) {
		if (bar.equals("Amarillo")) {barriles.add(new Amarillo());}
		else if(bar.equals("Rojo")) {barriles.add(new Rojo());}		
	}
	
	/**
	 * permite bajar las escaleras a un jugador 
	 * @param personaje numero del jugador
	 */
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
	
	/**
	 * mueve el barril
	 * @param j numero del barril
	 */
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
	 * Genera un sorpresa en la capa 
	 * de aplicacion
	 * @param posX valor en x
	 * @param posY valor en y
	 * @param tipo tipo de la sorpresa
	 */
	public void generarSorpresa(int posX, int posY,String tipo) {
		if(tipo.equals("Cereza")) {sorpresas.add(new Cereza(posX,posY));}
		else if(tipo.equals("Manzana")) {sorpresas.add(new Manzana(posX,posY));}
		else if(tipo.equals("Corazon")) {sorpresas.add(new Corazon(posX,posY));}
	}
	
	/**
	 * permite saltar a un jugador
	 * @param personaje numero del jugador 
	 */
	public void  saltar(int personaje) {
		(jugadores.get(personaje-1)).saltar();
		beneficio(personaje);	
		perderVida(personaje);
	}
	
	/**
	 * da el beneficio segun los tipos de sorpresas
	 * @param personaje numero del jugador
	 */
	public void beneficio(int personaje) {
		
		for(Sorpresa s:sorpresas) {
			if ((s.getPosX()==jugadores.get(personaje-1).getPosX())&&(s.getPosY()==jugadores.get(personaje-1).getPosY())) 
				{
					if (s.getTipo().equals("puntos")) {
						jugadores.get(personaje-1).setPuntos(s.beneficio());
						cambioP=true;					
					}
					else if (s.getTipo().equals("puntos")) {
						jugadores.get(personaje-1).setPuntos(s.beneficio());
						cambioP=true;	
						jugadores.get(personaje-1).setVida();
					}
			}
		}
	}
	
	/**
	 * @param cont numero de la plataforma
	 * @return coordenadas de la plataforma dada
	 */
	public int[] getPlataformas(int cont) {
		int[] vals=new int[3];
		vals[0]=(plataformas.get(cont-1).getX());
		vals[1]=(plataformas.get(cont-1).getY());
		vals[2]=(plataformas.get(cont-1).getX2());
		return vals;
	}
	
	/**
	 * evalua si se colisiona contra algo y pierde la vidas
	 * @param personaje numero de jugador 
	 */
	private void perderVida(int personaje) {
		boolean herido=false;
		for(int i=0;i<barriles.size() && herido==false;i++) {
			herido=barriles.get(i).colision(jugadores.get(personaje-1).getPosX(),jugadores.get(personaje-1).getPosY());
		}
		if (herido) {
			jugadores.get(personaje-1).resVidas();
		}
		else {
			jugadores.get(personaje-1).setMuerto(false);
		}
	}
	
	/**
	 * 
	 * @param personaje numero el jugador
	 * @return  ruta de la imagen actual del jugador
	 */
	public String getForma(int personaje) {		
		return jugadores.get(personaje-1).getForma();
	}
	
	/**
	 * 
	 * @param pesonaje numero del jugador 
	 * @return posicion en x
	 */
	public int getJugadorPosX(int pesonaje) {
		return jugadores.get(pesonaje-1).getPosX();
	}
	
	/**
	 * 
	 * @param pesonaje numero del jugador
	 * @return posicion en y
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
	 * imagen de mario a la derecha
	 * @param personaje numero del jugador 
	 */
	public void FormaEstaticaDer(int personaje) {
		jugadores.get(personaje-1).cambiarforma(1);
	}
	
	/**
	 * 
	 * @return si hubo un cabio enn los puntos
	 */
	public boolean cambioPuntos() {
		return cambioP;
	}
	
	/**
	 * remueve la sorpresa
	 * @param personaje numero del jugador 
	 */
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
	
	/**
	 * 
	 * @return la ruta de la imagen de la escalera
	 */
	public String getEscaleraIm() {
		return escaleras.get(0).getImagen();
	}
	
	/**
	 * 
	 * @param i  numero de la escalera
	 * @return coordenadas de la una escalera dada
	 */
	public int[] getEscalera(int i) {
		Escalera esc= escaleras.get(i-1);
		int[] a =new int[3];
		a[0]=esc.getX();
		a[1]=esc.getY1();
		a[2]=esc.getY2();
		return a;
	}
	
	
	/**
	 * 
	 * @param j numero el barril
	 * @return coordenadas de un barril dada
	 */
	public int[] getBarril(int j) {
		System.out.println(barriles.size());
		Barril bar=barriles.get(j-1);
		System.out.println(bar.getX()+" "+bar.getY());
		int[] a=new int[2];
		a[0]=bar.getX();
		a[1]=bar.getY();
		return a;
	}
	
	/**
	 * 
	 * @param j numero del barril
	 * @return valor en x de un barril dado
	 */
	public int getbarx(int j) {
		return barriles.get(j-1).getX();
	}

	/**
	 * 
	 * @param j numero del barril
	 * @return valor en y de un barril dado
	 */
	public int getbary(int j) {
		return barriles.get(j-1).getY();
	}
	
	/**
	 * 
	 * @param j numero dl jugador 
	 * @return cantidad de puntos
	 */
	public String getPuntos(int j) {		
		return jugadores.get(j-1).getPuntos()+"";
	}
	
	/**
	 * 
	 * @return si esta muerto
	 */
	public boolean jugadoresMuertos() {
		boolean estado=false;
		for(int i=0;i<jugadores.size() && estado==false;i++) {
			if (jugadores.get(i).getMuerto()) {}
			estado=true;
		}
		return estado;
	}
	
	/**
	 * reinicia un barril dado
	 * @param j numero del barril
	 */
	public void resetBarril(int j) {
		barriles.get(j-1).reiniciar();
	}
	
	/**
	 * 
	 * @param i
	 */	
	public void resetJugador(int i) {
		jugadores.get(i-1).reiniciar();
		jugadores.get(i-1).setMuerto(false);
		for(Barril b : barriles) {
			b.reiniciar();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPlatSize() {		
		return plataformas.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getEscSize() {
		return escaleras.size();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getBarSize() {	
		return barriles.size();
	}
	
	/**
	 * 
	 * @param j
	 */
	public void removerBarril(int j) {
		barriles.remove(j-1);		
	}
	
	/**
	 * 
	 */
	public void moverBarriles() {
		for(Barril b : barriles) {
			b.move();			
		}		
	}
	/**
	 * 
	 * @return
	 */
	public int[] getbarsx() {
		int []a =new int[barriles.size()];
		for (int i=0;i<barriles.size();i++) {
			a[i]=barriles.get(i).getX();			
		}
		return a;
	}
	/**
	 * 
	 * @return
	 */
	public int[] getbarsy() {
		int []a =new int[barriles.size()];
		for (int i=0;i<barriles.size();i++) {
			a[i]=barriles.get(i).getY();			
		}
		return a;	
		
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
	public ArrayList<Plataforma> getplata() {
		return plataformas;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public ArrayList<Sorpresa> getSorpresas() {
		return sorpresas;
	}

	public ArrayList<Escalera> getEscaleras() {
		
		return escaleras;
	}
	
	public void estructuraAleatoria() {
		monkey.crearPlataforma(0, 412,480,-1);			
		Random r = new Random();
		int valor =r.nextInt(3)+2;
		if(valor%2!=0) {valor+=1;}
		int k=1;
		int o=0;
		int h=412-60;
		for (int i =1 ; i<=valor;i++) {
			monkey.crearPlataforma(o,h,400,k);
			if(o==0) {o=80;}
			else {o=0;}
			k=k*-1;
			h=h-60;
		}
		
		monkey.crearPlataforma(0, 62, 400, 1);	
		monkey.crearPlataforma(60, 0, 160, 1);	
		monkey.generarEscaleras(120, monkey.getPlatSize()-1,monkey.getPlatSize());	
		monkey.generarEscaleras(140, monkey.getPlatSize()-1, monkey.getPlatSize());
		int lo=100;
		for (int i=1;i<valor+2;i++) {
			monkey.generarEscaleras(lo,i,i+1);
			if(lo==100) {lo=100+40;}
			else {lo=100;}
			
		}
		
	
		monkey.generarBarriles("Rojo");		
		monkey.generarBarriles("Amarillo");	
	
	}
	
	public int getVidas2(int j) {
		return jugadores.get(j-1).getVidas();
	}

	public static void restar() {
		monkey=new MonkeyPoob();
		
	}

}

