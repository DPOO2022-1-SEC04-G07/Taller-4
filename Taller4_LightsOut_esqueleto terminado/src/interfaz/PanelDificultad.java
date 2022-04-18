package interfaz;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PanelDificultad extends JPanel{
	
	private JLabel etiquetaTamanio;
	
	private InterfazPrincipal ventana;
	
	public JComboBox<String> tamaniosTablero;
	
	
	private JLabel etiquetaDificultad;
	
	public JRadioButton btnFacil;
	
	public JRadioButton btnMedio;
	
	public JRadioButton btnDificil;

	
	public PanelDificultad(InterfazPrincipal ventana) {
		
		setPreferredSize(new Dimension(600,30));
		
		etiquetaTamanio = new JLabel("Tamanio: ");
		
		String[] opcionesTamanio = {"4x4","5x5","6x6","7x7","8x8","9x9"};
		tamaniosTablero = new JComboBox<> (opcionesTamanio);
		tamaniosTablero.addActionListener(ventana);
		
		
		etiquetaDificultad = new JLabel("Dificultad: ");
		etiquetaDificultad.setPreferredSize(new Dimension(70,30));
		
		btnFacil = new JRadioButton("Facil", true);
		btnFacil.addActionListener(ventana);
	
		btnMedio = new JRadioButton("Medio", false);
		btnMedio.addActionListener(ventana);
		
		btnDificil = new JRadioButton("Dificil", false);
		btnDificil.addActionListener(ventana);
		

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(btnFacil);
		grupo.add(btnMedio);
		grupo.add(btnDificil);
		
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		
		add(etiquetaTamanio);
		add(tamaniosTablero);
		add(etiquetaDificultad);
		add(btnFacil);
		add(btnMedio);
		add(btnDificil);
		
	}

}
