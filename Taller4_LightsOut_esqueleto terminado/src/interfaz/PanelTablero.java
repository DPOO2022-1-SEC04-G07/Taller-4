package interfaz;
import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

public class PanelTablero extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	
	private InterfazPrincipal ventana;
	
    private int[][] cantidades;
    
    private int largo;
    
    private boolean[][] tablero;
    
    private int numeroJugadas;



    public PanelTablero(InterfazPrincipal ventana){
        setSize(500,500);
        this.ventana = ventana;
        this.addMouseListener(this);
    }

    public void nuevoPanel(Tablero tableroo){
        this.removeAll();
        this.tablero = tableroo.darTablero();
        this.largo = tablero.length;
        this.cantidades = new int[largo][largo];
        GridLayout gl = new GridLayout(largo,largo);
        setLayout(gl);

        actualizarPanel();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int la = Math.min(this.getWidth()/largo, this.getHeight()/largo);
        int sdisx = (getWidth()-la*largo)/2;
        int sdisy = (getHeight()-la*largo)/2;
        for (int i = 0; i < largo; i++) {
            int disx = sdisx;
            for (int ii = 0; ii < largo; ii++) {
                GradientPaint gp;
                Color colorT;
                if (tablero[i][ii]) {
                    gp = new GradientPaint(disx, sdisy, new java.awt.Color(113, 164, 201), disx + la, sdisy + la, Color.YELLOW);
                    colorT = Color.BLACK;
                }else{
                    gp = new GradientPaint(disx, sdisy, Color.BLACK, disx + la, sdisy + la, new java.awt.Color(25, 40, 50));
                    colorT = Color.green;
                }

                g2d.setPaint(gp);
                g2d.fillRoundRect(disx,sdisy,la,la,20,20);
                g2d.setColor(colorT);
                g2d.drawString(String.valueOf(cantidades[i][ii]),disx +(int)(la*0.1),sdisy+(int)(la*0.1));
                

                disx += la;
            }
            sdisy += la;
        }
    }
    
    public void actualizarPanel(){
        repaint();
    }
    
    
    private int[] convertirCoordenadasACasilla(int x, int y)
    {
    	int ladoTablero = tablero.length;
    	int altoTablero = getHeight();
    	int anchoTablero = getWidth();
    	int altoCasilla = altoTablero / ladoTablero;
    	int anchoCasilla = anchoTablero / ladoTablero;
    	int fila = (int) (y / altoCasilla);
    	int columna = (int) (x / anchoCasilla);
    	return new int[] { fila, columna };
    }
	
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {

		 int click_x = e.getX();
         int click_y = e.getY();
         int[] casilla = convertirCoordenadasACasilla(click_x, click_y);

         cantidades[casilla[0]][casilla[1]]++;
         ventana.Jugar(casilla[0], casilla[1]);
         repaint();
		
         this.ventana.getPanelPuntaje().actualizarPuntaje();
	}
	
}
