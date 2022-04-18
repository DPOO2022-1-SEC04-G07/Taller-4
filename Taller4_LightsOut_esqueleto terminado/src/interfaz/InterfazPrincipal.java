package interfaz;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal extends JFrame implements ActionListener{
	private PanelDificultad panelDificultad;
	private PanelTablero panelTablero;
	private PanelMenu panelMenu;
	private PanelPuntaje panelPuntaje;
	private InterfazTop InterfazTop;
	private Tablero tablero;
	private RegistroTop10 registroTop10;
	public JRadioButton btnfacil;
	public JRadioButton btnmedio;
	public JRadioButton btndificil;
	public JButton btnjuegoNuevo;
	public JButton btnReiniciar;
	public JButton btntop10;
	public JButton btncambiarJugador;
	public JComboBox<String> btntamanio;
	
	int tamanio = 4;
	int dificultad = 1;
	
	public InterfazPrincipal () {

		tablero = new Tablero(5);
		setIconImage(new ImageIcon("./data/luz.png").getImage());
		

		setTitle("Lights Out");
		setSize(new Dimension(500,500));
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		panelDificultad = new PanelDificultad(this);
		panelTablero = new PanelTablero(this);
		panelMenu = new PanelMenu(this);
		panelPuntaje = new PanelPuntaje();
		
		BorderLayout borL = new BorderLayout();
		setLayout(borL);
		
		add(panelDificultad, BorderLayout.NORTH);
		add(panelTablero, BorderLayout.CENTER);
		add(panelMenu, BorderLayout.EAST);
		add(panelPuntaje, BorderLayout.SOUTH);
		

		int panelX = (getWidth() - panelTablero.getWidth() - getInsets().left - getInsets().right) / 2;
		int panelY = (getHeight() - panelTablero.getHeight() - getInsets().top - getInsets().bottom) / 2;
		
		panelTablero.setLocation(panelX, panelY);
		setVisible(true);
		nuevoJuego();
	}
	
	
	public void nuevoJuego() {
		tablero = new Tablero(tamanio);
		tablero.desordenar(dificultad);
		panelTablero.nuevoPanel(tablero);
	
	}
	

	public static void main(String[] args) 
	{
		new InterfazPrincipal();	
	}


	public void Jugar(int i, int j)
	{
		tablero.jugar(i, j);
	}

	public PanelMenu getPanelMenu() {
		return panelMenu;
	}

	public PanelPuntaje getPanelPuntaje() {
		return panelPuntaje;
	}

	public PanelTablero getPanelTablero() {
		return panelTablero;
	}

	
	public void actionPerformed(ActionEvent e) {
		btnjuegoNuevo = panelMenu.btnMenu;
		btnReiniciar = panelMenu.btnReiniciar;
		btntop10 = panelMenu.btnTop;
		btncambiarJugador = panelMenu.btnCambiarJugador;
		btnfacil = panelDificultad.btnFacil;
		btnmedio = panelDificultad.btnMedio;
		btndificil = panelDificultad.btnDificil;
		btntamanio = panelDificultad.tamaniosTablero;
		
		if (e.getSource() == btnjuegoNuevo)
		{
			nuevoJuego();
			panelPuntaje.borrarTexto();
			panelPuntaje.borarScore();
		}
		
		else if (e.getSource()==btnReiniciar)
		{
			tablero.reiniciar();
			panelTablero.nuevoPanel(tablero);
			panelPuntaje.borarScore();
		}
		
		else if (e.getSource()==btntop10)
		{
			//
			InterfazTop InterfazTop10 = new InterfazTop();
			InterfazTop10.setVisible(true);
			
		}
		
		else if (e.getSource()==btncambiarJugador)
		{
			//
			panelPuntaje.borrarTexto();
		}
		
		else if (e.getSource()==btnfacil)
		{
			dificultad = 1;
			nuevoJuego();
			
		}
		
		else if (e.getSource()==btnmedio)
		{
			dificultad = 2;
			nuevoJuego();
			
		}
		
		else if (e.getSource()==btndificil)
		{
			dificultad = 3;
			nuevoJuego();
			
		}
		
		else if (e.getSource() == btntamanio)
		{
			String selectedSize = (String) btntamanio.getSelectedItem();
			if (selectedSize.equals("4x4"))
			{
				tamanio = 4;
				nuevoJuego();
			}

			else if (selectedSize.equals("5x5"))
			{
				tamanio = 5;
				nuevoJuego();
			}

			else if (selectedSize.equals("6x6"))
			{
				tamanio = 6;
				nuevoJuego();
			}

			else if (selectedSize.equals("7x7"))
			{
				tamanio = 7;
				nuevoJuego();
			}

			else if (selectedSize.equals("8x8"))
			{
				tamanio = 8;
				nuevoJuego();
			}

			else if (selectedSize.equals("9x9"))
			{
				tamanio = 9;
				nuevoJuego();
			}

		}
	}

}
