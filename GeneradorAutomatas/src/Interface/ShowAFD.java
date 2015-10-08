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
    ArrayList<String> circulares;
    Grafo grafo;
    int x,y;
    private Object g2d;
    public ShowAFD(HashMap<String, ArrayList<String>> listaPri) {
        this.listaPrincipal = listaPri;
        circulares = new ArrayList<String>();
        grafo = new Grafo();
        x = 0;
        y = 50;
    }
    
    void DestinoNoTerminal(ArrayList<String> lista){
        String noTerminal;
        for (String item : lista) {
            if (item.contains(" ")) {
                noTerminal = item.split(" ")[1];
                grafo.agregarVertice(noTerminal);
            }
        }
    }
    
    void crearAtomata(Graphics g){
        for (String noTerminal : listaPrincipal.keySet()) {
            grafo.agregarVertice(noTerminal);
            DestinoNoTerminal(listaPrincipal.get(noTerminal));
        }
        crearPosiciones();
        dibujarAutomata(g);
    }
    
    void dibujarAutomata(Graphics g){
        for (Vertice ver: grafo.getVertices()) {
            ver.drawVertice(g);
        }
    }
    
    void crearPosiciones(){
        for (Vertice ver: grafo.getVertices()) {
            x+=125;
            if (x>=350) {
                x=125;
                y+=125;
            }
            ver.setPosicion(new Posicion(x, y, ver.getNombre()));
        }
    }
    
    void crearAristas(){
        ArrayList<String> value;
        for (String key: listaPrincipal.keySet()) {
             value = listaPrincipal.get(key);
             crearArista(key, value);
        }
    }
    
    void crearArista(String clave, ArrayList<String> vertice){
        for (String item: vertice) {
            if (!item.contains(" ")) {
                circulares.add(clave+"->"+item);
            }
            else{
                String[] terminales = item.split(" ");    
                grafo.agregarArista(clave, terminales[1], terminales[0]);
            }
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
        x=0;
        y=50;
        crearAtomata(g);
        crearAristas();
        grafo.DibujarAristas(g);
        grafo.dibujarCirculares(g, circulares);
    }

    public void View() throws InterruptedException{
        JFrame frame = new JFrame("Dibujar Grafos");
        ShowAFD grafica = new ShowAFD(listaPrincipal);
	frame.add(grafica);
	frame.setSize(400, 400);
	frame.setVisible(true);
	//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        crearAtomata(grafica.getGraphics());
        crearAristas();
        grafo.DibujarAristas(grafica.getGraphics());
        Thread.sleep(10);
        grafica.repaint();
        
        /*while (true) {
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
	}*/
    }
}