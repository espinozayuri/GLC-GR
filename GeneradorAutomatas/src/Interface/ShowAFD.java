/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author irvin
 */
@SuppressWarnings("serial")
public class ShowAFD extends JPanel {
    //valores key como Noterminales y su AL de terminales
    HashMap<String, ArrayList<String>> listaPrincipal;
    ArrayList<String> noTerminales;
    ArrayList<String> terminales;
    int x,y;
    private Object g2d;
    public ShowAFD(HashMap<String, ArrayList<String>> listaPri,
            ArrayList<String> noTerm, ArrayList<String> term) {
        this.listaPrincipal = listaPri;
        this.noTerminales = noTerm;
        this.terminales = term;
        x = 50;
        y = 50;
    }
    
    void crearAtomata(Graphics g){
        for (String noTerminal : listaPrincipal.keySet()) {
            g.fillOval(x, y, 30, 30);
            x+=50;
            y+=50;
            System.out.println("->"+noTerminal);
        }
    }
    
    
    private void moveBall() {
	x = x + 1;
	y = y + 1;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
	super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        crearAtomata(g);
    }

    public void View() throws InterruptedException{
        JFrame frame = new JFrame("Dibujar Grafos");
        ShowAFD grafica = new ShowAFD(listaPrincipal, noTerminales, terminales);
	frame.add(grafica);
	frame.setSize(400, 400);
	frame.setVisible(true);
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearAtomata(grafica.getGraphics());
        Thread.sleep(10);
        grafica.repaint();
        
        /*while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
	}*/
    }
}