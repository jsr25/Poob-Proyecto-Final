package presentacion;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaControls extends JDialog {
	private static final long serialVersionUID = 1L;
	JButton back;
	JLabel w,a,s,d,p,space,up,left,right,down;
	public PantallaControls() {
		super();
		prepareElementos();
	}
	public void prepareElementos() {
		w=new JLabel();
		a=new JLabel();
		s=new JLabel();
		d=new JLabel();
		p=new JLabel();
		space=new JLabel();
		up=new JLabel();
		left=new JLabel();
		right=new JLabel();
		down=new JLabel();
		
	}

}
