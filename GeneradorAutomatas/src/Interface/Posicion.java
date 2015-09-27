/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Graphics;

/**
 *
 * @author irvin
 */
public class Posicion{
    public int posx, posy;
    public int radio = 25;
    public String nombre;
    public Posicion() {
    }
        
    public Posicion(int posx, int posy, String nombre) {
        this.posx = posx;
        this.posy = posy;
        this.nombre = nombre;
    }               
        
    public void drawArista(Posicion pos1, Posicion pos2, Graphics g){
        g.drawLine(pos1.posx+radio,pos1.posy+radio, 
        pos2.posx+radio, pos2.posy+radio);
    }
}