/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.util.List;

/**
 *
 * @author irvin
 */

public class Grafo {
    List<Vertice> vertices;
    int contadorAristas;
    Posicion posicion;

    public Grafo(List<Vertice> vertices, int contadorAristas) {
        this.vertices = vertices;
        this.contadorAristas = contadorAristas;
    }    

    public Grafo() {
        vertices = new ArrayList<Vertice>();
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }

    public int getContadorAristas() {
        return contadorAristas;
    }

    public void setContadorAristas(int contadorAristas) {
        this.contadorAristas = contadorAristas;
    }
    
    public Boolean agregarVertice(String nombre){
        Vertice nuevo = new Vertice(nombre);
        if (!vertices.contains(nuevo)) {
            vertices.add(nuevo);
            contadorAristas++;
            return true;
        }
        return false;
    }
    
    public int calculatex(int x1, int x2){
        return (x1+x2)/2;
    }
    
    public int calculatey(int y1, int y2){
        return (y1+y2)/2;
    }
        
    public void DibujarAristas(Graphics g){
        Posicion posi;
        int x,y;
        int radio = 25;
        for(Vertice vertice : vertices){
            for(Vertice i : vertice.getAristas()){
                g.drawLine(vertice.getPosicion().posx+radio,
                vertice.getPosicion().posy+radio, 
                i.getPosicion().posx+radio, i.getPosicion().posy+radio);
                x = calculatex(vertice.getPosicion().posx, i.getPosicion().posx);
                y = calculatey(vertice.getPosicion().posy, i.getPosicion().posy);
                g.drawString(i.camino,x,y);
            }
        }
    }
    
    public void dibujarCirculares(Graphics g, ArrayList<String> circulares){
        String[] cadena;
        Vertice ver;
        int index;
        for (String item:circulares) {
            cadena = item.split("->");
            index = vertices.indexOf(new Vertice(cadena[0]));
            ver = vertices.get(index);
            g.drawArc(ver.getPosicion().posx+5,ver.getPosicion().posy-15, 
                    40,60, -180, -180);
            g.drawString(ver.camino,ver.getPosicion().posx+25,
                    ver.getPosicion().posy-15);
        }        
    }
    
    public Vertice getVertice(int index){
        return vertices.get(index);
    }
    
    public Boolean agregarArista(String inicio, String destino, String nombre){
        Vertice ini = new Vertice(inicio);
        Vertice dest = new Vertice(destino);
        int i = vertices.indexOf(ini);
        if (i != -1) {
            ini = vertices.get(i);
            ini.camino = nombre;
            i = vertices.indexOf(dest);
            dest = vertices.get(i);
            dest.camino = nombre;
            vertices.get(i).agregarArista(dest);
            i = vertices.indexOf(dest);
            vertices.get(i).agregarArista(ini);
            return true;
        }
        return false;
    }
}
