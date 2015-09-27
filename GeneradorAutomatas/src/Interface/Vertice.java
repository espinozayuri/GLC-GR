/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Graphics;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author irvin
 */

public class Vertice{
    private String nombre;
    private Posicion posicion;
    private List<Vertice> aristas;
    private Line2D linea;

    public Vertice() {
        aristas = new ArrayList<Vertice>();
    }
    
   public Vertice(String nombre){
       aristas = new ArrayList<Vertice>(); 
       this.nombre = nombre;
   }

    public String getNombre() {
        return nombre;
    }
    
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public String mostrar(){
        String resp="";
        resp+="nombre: "+ nombre+" aristas=> {";
        for(Vertice i:aristas) {
            resp+=i.nombre+" "; //Muestra cada uno de los nombres dentro de listaDeNombres
        }
        return resp+"}";
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vertice> getAristas() {
        return aristas;
    }

    public void setAristas(List<Vertice> aristas) {
        this.aristas = aristas;
    }

    public Vertice(String nombre, List<Vertice> aristas) {
        this.nombre = nombre;
        this.aristas = aristas;
    }
    
    public Boolean agregarArista(Vertice vertice){
        if (!aristas.contains(vertice)) {
            aristas.add(vertice);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice other = (Vertice) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    public void drawVertice(Graphics g){
        g.fillOval(posicion.posx, posicion.posy, 
                posicion.radio*2, posicion.radio*2);
        g.drawString(nombre, posicion.posx, posicion.posy);
    }

    public Line2D getLinea() {
        return linea;
    }
    
    public Line2D crearLinea(Posicion pos){
        int centro = posicion.radio;
        linea = new Line2D.Float(posicion.posx+centro, posicion.posy+centro, 
                pos.posx+centro, pos.posy+centro);
        return linea;
    }
    
    public Boolean existeCoalision(Line2D linea2){
        return linea2.intersectsLine(linea);
    }
    
    
    public void drawArista(Graphics g, Posicion pos){
        int centro = posicion.radio;
        linea = new Line2D.Float(posicion.posx+centro, posicion.posy+centro, 
                pos.posx+centro, pos.posy+centro);
        g.drawLine(posicion.posx+centro, posicion.posy+centro, 
                pos.posx+centro, pos.posy+centro);
        //Line2D line1 = new Line2D.Float(100, 100, 200, 200);
        //Line2D line2 = new Line2D.Float(150, 150, 150, 200);
        //boolean result = line2.intersectsLine(line1);
    }
    
    public void updatePositiondrawVertice(Graphics g){
        posicion.posx+=10;
        posicion.posy+=10;
        g.fillOval(posicion.posx, posicion.posy, 
                posicion.radio*2, posicion.radio*2);
        g.drawString(nombre, posicion.posx, posicion.posy);
    }
    
    public Boolean esCompleto(Vertice v){
        if (aristas.contains(v)) {
            return true;
        }
        else{
            if (v.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }
}

