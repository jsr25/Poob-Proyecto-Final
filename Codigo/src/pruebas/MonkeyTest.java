package pruebas;

import aplicacion.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MonkeyTest {
	
	@Test
	public void deberiaCrearPlataforma() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.crearPlataforma(10,10,20,1);
		a.crearPlataforma(10,20,20,1);
		a.crearPlataforma(10,30,20,1);
		a.crearPlataforma(0,0,100,1);
		ArrayList<Plataforma> platas=a.getplata();		
		assertTrue(platas.size()==4);	}
	
	@Test
	public void deberiaCrearUnJugador() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(30, -12, "mario");
		assertTrue(a.getJugadores().size()==1);	}
	
	@Test
	public void deberiaMoverIzquierdaPersonaje() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.moverIzquieda(1);		
		a.moverIzquieda(1);		
		a.moverIzquieda(1);		
		assertTrue((a.getJugadorPosX(1))==0);
	}
	
	@Test
	public void deberiaMoverDerechaPersonaje() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.moverDerecha(1);
		a.moverDerecha(1);
		a.moverDerecha(1);		
		assertTrue((a.getJugadorPosX(1))==30);
	}
	
	@Test
	public void debreriaCrearManzana() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.generarSorpresa(40, 0,"Manzana");
		assertTrue((a.getSorpresas().size()==1) );
		}
	
	@Test
	public void debreriaCrearCorazon() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.generarSorpresa(40, 0,"Corazon");
		assertTrue((a.getSorpresas().size()==2) );
		}
	
	@Test
	public void deberiaCrearCereza() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.generarSorpresa(40, 0,"Cereza");
		assertTrue((a.getSorpresas().size()==3) );
		}
	
	

	@Test
	public void crearBarrilAmarillo() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.generarBarriles("Amarillo");	
		assertTrue((a.getBarSize()==1));
	}
	
	@Test
	public void crearBarrilRojo() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.generarBarriles("Rojo");	
		assertTrue((a.getBarSize()==2));
	}
	
	
	
	@Test
	public void deberiaBajarEscaleras() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.agregarJugadores(10, 8,"mario");	
		a.generarEscaleras(10, 1, 2);
		a.bajarEscalera(2);
		assertTrue(a.getJugadorPosY(2)==3);
	}
	
	@Test
	public void deberiaCrearEscaleras() {
		MonkeyPoob a= MonkeyPoob.getMonkey();
		a.generarEscaleras(0,1,2);	
		assertTrue(a.getEscaleras().size()==2);
	}
	
	
}
