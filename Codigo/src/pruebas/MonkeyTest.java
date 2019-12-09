package pruebas;

import aplicacion.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MonkeyTest {
	MonkeyPoob monk;
	@Before
	public final void setUp() {
		monk=MonkeyPoob.getMonkey();
	}
	
	@Test
	public void deberiaCrearPlataforma() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.crearPlataforma(10,10,20,1);
		monk.crearPlataforma(10,20,20,1);
		monk.crearPlataforma(10,30,20,1);
		monk.crearPlataforma(0,0,100,1);
		ArrayList<Plataforma> platas=monk.getplata();		
		assertTrue(platas.size()==4);	}
	
	@Test
	public void deberiaCrearUnJugador() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.agregarJugadores(30, -12, "mario");
		assertTrue(monk.getJugadores().size()==1);	}
	
	@Test
	public void deberiaMoverIzquierdaPersonaje() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.crearPlataforma(0,0,100,1);
		monk.agregarJugadores(30, -12, "mario");
		monk.moverIzquieda(1);		
		monk.moverIzquieda(1);		
		monk.moverIzquieda(1);		
		assertTrue((monk.getJugadorPosX(1))==0);
	}
	
	@Test
	public void deberiaMoverDerechaPersonaje() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.crearPlataforma(0,0,100,1);
		monk.agregarJugadores(0, -12, "mario");
		monk.moverDerecha(1);
		monk.moverDerecha(1);
		monk.moverDerecha(1);		
		assertTrue((monk.getJugadorPosX(1))==30);
	}
	
	@Test
	public void debreriaCrearManzana() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarSorpresa(40, 0,"Manzana");
		assertTrue((monk.getSorpresas().size()==1) );
		}
	
	@Test
	public void debreriaCrearCorazon() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarSorpresa(40, 0,"Corazon");
		assertTrue((monk.getSorpresas().size()==1) );
		}
	
	@Test
	public void deberiaCrearCereza() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarSorpresa(40, 0,"Cereza");
		assertTrue((monk.getSorpresas().size()==1) );
		}
	
	

	@Test
	public void crearBarrilAmarillo() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarBarriles("Amarillo");	
		assertTrue((monk.getBarSize()==1));
	}
	
	@Test
	public void crearBarrilRojo() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarBarriles("Rojo");	
		assertTrue((monk.getBarSize()==1));
	}
	
	
	
	@Test
	public void deberiaBajarEscaleras() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.crearPlataforma(10,10,20,1);
		monk.crearPlataforma(10,20,20,1);
		monk.agregarJugadores(10, 8,"mario");	
		monk.generarEscaleras(10, 1, 2);
		monk.bajarEscalera(1);
		assertTrue(monk.getJugadorPosY(1)==3);
	}
	
	@Test
	public void deberiaCrearEscaleras() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.crearPlataforma(10,10,20,1);
		monk.crearPlataforma(10,20,20,1);
		monk.generarEscaleras(0,1,2);	
		assertTrue(monk.getEscaleras().size()==1);
	}
	
	@Test
	public void deberiaDevolverVidasDelJugador() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.agregarJugadores(0, 10, "mario");
		assertTrue(monk.getVidas(1).equals("3"));
	}
	
	@Test
	public void deberiaMostrarQueElJugadorSigueConVida() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.agregarJugadores(0, 10, "mario");
		assertTrue(!monk.jugadorMuerto(1));
	}
	
	@Test
	public void deberiaDejarSubirEscaleras() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.crearPlataforma(10,20,20,1);//1
		monk.crearPlataforma(10,10,20,1);//2
		monk.generarEscaleras(10,1,2);
		monk.agregarJugadores(10, 12,"mario");
		monk.subirEscalera(1);
		assertTrue(monk.getJugadorPosY(1)==7);
	}
	
	@Test
	public void deberiamoverBarrilRojo() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarBarriles("Rojo");
		monk.moverBarril(1);
		int[] bar =monk.getBarril(1);
		assertTrue(bar[1]==55);		 
		
	}
	
	@Test
	public void deberiaMoverBarrilAmarillo() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.generarBarriles("Amarillo");
		monk.crearPlataforma(10,62,20,1);
		monk.moverBarril(1);
		int[] bar =monk.getBarril(1);
		assertTrue(bar[0]==10);	
	}
	
	@Test
	public void deberiaSaltar() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.agregarJugadores(0, -12, "mario");
		monk.crearPlataforma(0, 0, 30, 1);
		monk.saltar(1);
		assertTrue(monk.getJugadorPosX(1)==10);	
	}
	
	@Test
	public void deberiaTomarBeneficio() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.agregarJugadores(0, -12, "mario");
		monk.crearPlataforma(0, 0, 30, 1);
		monk.generarSorpresa(10,-12 , "Cereza");
		monk.moverDerecha(1);
		assertTrue(monk.getPuntos(1).equals("10"));
	}
	
	@Test
	public void deberiaPerderVida() {
		MonkeyPoob.restar();
		monk=MonkeyPoob.getMonkey();
		monk.agregarJugadores(10, 50, "mario");
		monk.crearPlataforma(0, 62, 30, 1);
		monk.generarBarriles("Amarillo");
		monk.moverIzquieda(1);
		assertTrue(monk.getVidas(1).equals("2"));
	}
	
	
	
	
	@After
	public final void after() {
		
	}
	
	
	
}
