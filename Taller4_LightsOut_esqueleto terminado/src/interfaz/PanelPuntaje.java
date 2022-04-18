package interfaz;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;


public class PanelPuntaje extends JPanel implements ActionListener{
	
	private JLabel etiquetaJugador;
	
	private JTextField campoJugador;
	
	private JLabel etiquetaJugadas;
	
	private JTextField campoJugadas;

	private int numeroJugadas;
	
	
	public PanelPuntaje() {
		
		setPreferredSize(new Dimension(300,30));
		
		etiquetaJugadas = new JLabel("Jugadas: ");
		etiquetaJugadas.setPreferredSize(new Dimension(100,20));
		
		
		etiquetaJugador = new JLabel("Jugador: ");
		etiquetaJugador.setPreferredSize(new Dimension(100,20));
		
		
		campoJugadas = new JTextField("0");
		campoJugadas.setPreferredSize(new Dimension(100,20));
		campoJugadas.setEditable(false);
		
		
		campoJugador = new JTextField();
		campoJugador.setPreferredSize(new Dimension(100,20));
		
		setLayout(new FlowLayout());
		
		
		add(etiquetaJugadas);
		add(campoJugadas);
		add(etiquetaJugador);
		add(campoJugador);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("PP: Se oprimio el boton: " + e.getActionCommand());
		
	}


	public void borrarTexto() {
		this.campoJugador.setText("");
	}

	public void borarScore() {
		numeroJugadas = 0;
		this.campoJugadas.setText("");
	}

	public void actualizarPuntaje() {
		numeroJugadas += 1;
		String s = String.valueOf(numeroJugadas);
		this.campoJugadas.setText(s);
	}

	public String setJugadas(int i) {
		numeroJugadas += i;
		String s = String.valueOf(numeroJugadas);
		return s;
	}

}
