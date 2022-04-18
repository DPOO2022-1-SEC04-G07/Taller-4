package interfaz;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
public class PanelMenu extends JPanel implements ActionListener{

	private InterfazPrincipal ventana;
	
	public JButton btnMenu;
	
	public JButton btnReiniciar;
	
	public JButton btnTop;
	
	public JButton btnCambiarJugador;
	
	
	public PanelMenu(InterfazPrincipal ventana) {
		
		setPreferredSize(new Dimension(100,340));
		
		btnMenu = new JButton("Nuevo Juego");
		btnMenu.setPreferredSize(new Dimension(100,10));
		btnMenu.addActionListener(ventana);
		
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setPreferredSize(new Dimension(100,10));
		btnReiniciar.addActionListener(ventana);
		
		
		btnTop = new JButton("Top-10");
		btnTop.setPreferredSize(new Dimension(100,10));
		btnTop.addActionListener(ventana);
		
		
		btnCambiarJugador = new JButton("Cambiar jugador");
		btnCambiarJugador.setActionCommand("CAMBIAR");

		
		btnCambiarJugador.setPreferredSize(new Dimension(100,10));
		btnCambiarJugador.addActionListener(ventana);
		
		GridLayout gl = new GridLayout(4,1,0,0);
		setLayout(gl);
		
		add(btnMenu);
		add(btnReiniciar);
		add(btnTop);
		add(btnCambiarJugador);
		
	}

	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		switch (comand) {
			case "CAMBIAR": {
				this.ventana.getPanelPuntaje().borrarTexto();
				break;
			}
			default: {
				break;
			}
		}
	}
}
