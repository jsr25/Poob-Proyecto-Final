package presentacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class PantallaOptions extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton music,controls,credits,back;
	JSlider brigth;
	JPanel options,eleccion;
	JLabel brightess;
	public PantallaOptions() {
		super();
		prepareElementos();
		prepareElementosMenu();
	}
	public void prepareElementos() {
		this.setLayout(new BorderLayout());
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		setSize(ancho/2,alto/2);
		setLocationRelativeTo(null);
	}
	public void prepareElementosMenu() {
		Border blueLine = BorderFactory.createLineBorder(Color.BLUE);
		options= new JPanel();
		options.setLayout(new GridLayout(5,1));
		eleccion=new JPanel();
		eleccion.setLayout(new GridLayout(1,1));
		brightess=new JLabel("bright");
		brightess.setForeground(Color.yellow);
		brightess.setHorizontalTextPosition(JLabel.CENTER);
		brigth=new JSlider(100,200,150);
		brigth.setMinorTickSpacing(5);
	    brigth.setMajorTickSpacing(25);
	    brigth.setPaintLabels(true);
	    brigth.setOrientation(SwingConstants.HORIZONTAL);
	    brigth.setPaintTicks(true);
	    brigth.setBackground(Color.black);
	    controls= new JButton("controls");
	    music= new JButton("music");
	    credits= new JButton("credits");
	    back= new JButton("back");
	    controls.setBackground(Color.black);
	    music.setBackground(Color.black);
	    credits.setBackground(Color.black);
	    back.setBackground(Color.black);
	    controls.setForeground(Color.yellow);
	    credits.setForeground(Color.yellow);
	    music.setForeground(Color.yellow);
	    back.setForeground(Color.yellow);
	    controls.setBorder(blueLine);
	    music.setBorder(blueLine);
	    credits.setBorder(blueLine);
	    back.setBorder(blueLine);
	    eleccion.add(back);
	    options.add(brightess);
	    options.add(brigth);
	    options.add(controls);
	    options.add(music);
	    options.add(credits);

		this.add(options,BorderLayout.CENTER);
		this.add(eleccion,BorderLayout.SOUTH);
		
	}
}