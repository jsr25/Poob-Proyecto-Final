package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * @author BrayanAlexis-JuanRamos
 *
 */
public abstract class TableroJuego extends JPanel {
	private JLabel mono,sorpresa,escalera,pauline,logo;
	public String monoN,barrilN;
	private ArrayList<int[]> esca;
	private String paulineN,logoN;
	private int k;
	private Timer timer1,timer2,timer3;
	private ArrayList<ArrayList<JLabel>> plataformas=new ArrayList<ArrayList<JLabel>>();
	private ArrayList<JLabel> barriles;
	private ArrayList<JLabel> sorpresas;

	/**
	 * constructor del tablero
	 */
	public TableroJuego() {
		barriles=new ArrayList<JLabel>();
		prepararDecoracion();
	}
	public abstract void puntajeYVidas();
	/**
	 * prepara los elementos secundarios
	 */
	public void prepararDecoracion() {
		logo=new JLabel();		
		logo.setSize(20, 20);
		logo.setIcon(new ImageIcon("data/logoS1.png"));
		logoN="data/logoS1.png";
		logo.setBounds(0, 0,150, 150);
		logo.setLocation(300,-28);
		add(logo);
		mono=new JLabel();		
		mono.setSize(20, 20);
		mono.setIcon(new ImageIcon("data/monoBaile1.png"));
		monoN="data/monoBaile1.png";
		mono.setBounds(0, 0, 80, 110);
		mono.setLocation(0,40);
		add(mono);
		pauline=new JLabel();		
		pauline.setSize(20, 20);
		pauline.setIcon(new ImageIcon("data/paulineDerecha1.png"));
		paulineN="data/paulineDerecha1.png";
		pauline.setBounds(0, 0, 80, 110);
		pauline.setLocation(60,-15);
		add(pauline);
		preparaMono();
		preparaPrincesa();
		preparaLogo();
	}
	/**
	 * genera el timer de kong
	 */
	public void  preparaMono() {
		timer2=new Timer(500,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						if (monoN=="data/monoBaile1.png") {
							mono.setIcon(new ImageIcon("data/monoBaila4.png"));
							monoN="data/monoBaila4.png";
						}
						
						else {
							mono.setIcon(new ImageIcon("data/monoBaile1.png"));
							monoN="data/monoBaile1.png";
							}
					}
			
		});
		timer2.start();
}
	/**
	 * genera el timer de pauline
	 */
	public void  preparaPrincesa() {
		timer1=new Timer(1000,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
						if (paulineN=="data/paulineDerecha1.png") {
							pauline.setIcon(new ImageIcon("data/paulineDerecha2.png"));
							pauline.setLocation(75,-15);
							paulineN="data/paulineDerecha2.png";
						}
						else {
							pauline.setIcon(new ImageIcon("data/paulineDerecha1.png"));
							pauline.setLocation(60,-15);
							paulineN="data/paulineDerecha1.png";
							}
					}
			
		});
		timer1.start();
}
	/**
	 * genera el timer del logo
	 */
	public void  preparaLogo() {
		timer3=new Timer(500,new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (logoN=="data/logoS1.png") {
							logo.setIcon(new ImageIcon("data/logoS2.png"));
							logoN="data/logoS2.png";
						}
						else {
							logo.setIcon(new ImageIcon("data/logoS1.png"));
							logoN="data/logoS1.png";
							}
					}
			
		});
		timer3.start();
}
	
	public  void setVidas(String v) {}
	public  void setPuntos(String v) {}
	public abstract void addPersonaje(int x, int y, String img) ;
	public  abstract void moverPersonaje(int x,int y,String img,int i); 	
	/*public int [] getEscalera(int i) {
		int[] esc= esca.get(i-1);
		return esc;
		
	}*/
	/**
	 * crea la plataforma
	 * @param x posicion inicial en x
	 * @param y posicion en y
	 * @param x2 posicion final en x
	 * @param string ruta de la imagen
	 */
	public void addPlataforma(int x, int y, int x2, String string) {
		ArrayList<JLabel> pC=new ArrayList<JLabel>();
		for(int i=0;i<x2/16;i++) {
			JLabel plataforma=new JLabel();
			plataforma.setSize(10, 10);
			plataforma.setIcon(new ImageIcon(string));
			plataforma.setBounds(0, 0, 80, 110);
			plataforma.setLocation(x+(i*16),y);
			add(plataforma);
			pC.add(plataforma);
		}
		plataformas.add(pC);
	}
	/**
	 * crea la escalera
	 * @param x posicion en x
	 * @param y1 posicion inicial en y
	 * @param y2 posicion final en y
	 */
	public void crearEscalera(int x, int y1, int y2) {
		for (int i=0; i<((y1-y2)/7);i++) {
			escalera=new JLabel();
			escalera.setIcon(new ImageIcon("data/escalera.png"));
			escalera.setSize(8, 7);		
			escalera.setBounds(0, 0, 80, 110);
			escalera.setLocation(x,(y1-8)+(-i*7));
			add(escalera);
		
		}
	}
	/**
	 * crea un barrril
	 * @param x posicion en x
	 * @param y posicion en y
	 */
	public void crearBarril(int x , int y) {
		JLabel barril=new JLabel();
		barril.setIcon(new ImageIcon("data/barrilGirando1.png"));
		barrilN="data/barrilGirando1.png";
		barril.setSize(20,20);
		barril.setBounds(0, 0, 80, 110);
		barril.setLocation(x,y);
		add(barril);
		barriles.add(barril);
	}
	/**
	 * actualiza las imagenes del barril
	 * @param j numero del barril
	 * @param getbarx posicion en x
	 * @param getbary posicion en y
	 */
	public void actualizarbar(int j, int getbarx, int getbary) {
		barriles.get(j-1).setLocation(getbarx, getbary);
		
		if(barrilN.equals("data/barrilGirando1.png")) {
			barriles.get(j-1).setIcon(new ImageIcon("data/barrilgirando2.png"));
			barrilN="data/barrilgirando2.png";
		}
		else {
			barriles.get(j-1).setIcon(new ImageIcon("data/barrilGirando1.png"));
			barrilN="data/barrilGirando1.png";
		}
		repaint();
		
	}
	/**
	 * remueve un barril
	 * @param j numero del barril
	 */
	public void removebar(int j) {		
		barriles.get(j-1).setVisible(false);;
	}
	/**
	 * actualiza un barril segun su posicion
	 * @param getbarsx poscion en x
	 * @param getbarsy posicion en y
	 */
	public void actualizarbar2(int[] getbarsx, int[] getbarsy) {
		for(int i=0; i<barriles.size();i++){
			barriles.get(i).setLocation(getbarsx[i],getbarsy[i]);			
		}
		
	}
	public void setVidas(String v, String s) {}
	public void setPuntos(String v, String s) {}
	
	public void crearSorpresas(String [] sorpresas,int [][] coor) {
		for(int i=0;i<sorpresas.length;i++) {
			JLabel sor=new JLabel();
			sor.setIcon(new ImageIcon(sorpresas[i]));
			sor.setSize(8, 7);		
			sor.setBounds(0, 0, 80, 110);
			sor.setLocation(coor[i][0], coor[i][1]);
			add(sor);
			this.sorpresas.add(sor);
		}
	}
}
