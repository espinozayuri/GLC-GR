
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel; 

/**
 *
 * @author CASPED
 */
public class Interface extends JFrame implements ActionListener {
    JPanel panel = new javax.swing.JPanel();
    
    public Interface(){  
        initComponents();
        setTitle("Generador");
        setBounds(600, 220, 435, 345);    
    } 
    
    private void initComponents() {
        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        panel= new Menu();
        getContentPane().add(panel);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent eventos){
        
      
    }
    
    
    
}
