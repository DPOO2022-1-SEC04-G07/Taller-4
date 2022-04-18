package interfaz;

import javax.swing.WindowConstants;

import uniandes.dpoo.taller4.modelo.Top10;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InterfazTop extends JFrame implements ActionListener {

	private PanelTopJugadores panelTop10;
	
	private Top10 top10;
	
	public InterfazTop() {

		setTitle("Top 10 de jugadores.");
		setSize(new Dimension(200,400));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		panelTop10 = new PanelTopJugadores();
		
		setLayout(new BorderLayout());
		
		add(panelTop10);
		

	}

	public void actionPerformed(ActionEvent e) {

    }
	
}
