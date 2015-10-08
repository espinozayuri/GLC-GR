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
        
    public void DibujarAristas(Graphics g){
        Posicion posi;
        int radio = 25;
        int pos;
        for(Vertice vertice : vertices){
            for(Vertice i : vertice.getAristas()){
                g.drawLine(vertice.getPosicion().posx+radio,
                        vertice.getPosicion().posy+radio, 
        i.getPosicion().posx+radio, i.getPosicion().posy+radio);
                //pos = vertices.indexOf(new Vertice(i.getNombre()));
                //posi = getVertice(pos).getPosicion();       
                //vertice.drawArista(g, posi);
            }
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
            i = vertices.indexOf(dest);
            dest = vertices.get(i);
            vertices.get(i).agregarArista(dest);
            i = vertices.indexOf(dest);
            vertices.get(i).agregarArista(ini);
            return true;
        }
        return false;
    }
}
