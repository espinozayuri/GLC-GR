/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;


import java.io.*;
import javax.swing.JOptionPane;
public class GuardarArchivo {
    
    public void crearArchivo(String nombre, String contenido){
        File crearArchivo;
        FileWriter escribirDatos;
        BufferedWriter bw;
        PrintWriter wr;
        
        try {
            crearArchivo=new File(nombre);
            escribirDatos= new FileWriter(crearArchivo);
            bw= new BufferedWriter(escribirDatos);
            wr= new PrintWriter(crearArchivo);
            
            wr.write(contenido);
            wr.append("");
            
            
            
            wr.close();
            bw.close();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error "+ e);
        }
    }
    
}