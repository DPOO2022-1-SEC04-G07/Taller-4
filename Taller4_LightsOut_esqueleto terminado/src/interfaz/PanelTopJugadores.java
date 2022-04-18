package interfaz;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PanelTopJugadores extends JPanel implements ActionListener {

	private JLabel lablTop;
	
    private InterfazPrincipal ventana;

    public PanelTopJugadores() {
    	
        setPreferredSize(new Dimension(getHeight(),getWidth()));

        lablTop = new JLabel("Este es el top de jugadores");
        setLayout(new BorderLayout());

        add(lablTop);
    }

    public void actionPerformed(ActionEvent e) {

    }
}
