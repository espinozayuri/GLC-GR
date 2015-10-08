/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

/**
 *
 * @author CASPED
 */
public class Abecedario 
{ 
    int a = (int) 'a';
    public int num;
    char[] abecedario = new char[26]; 

    public Abecedario() {
        for(int i = 0; i < abecedario.length; i++) 
        { 
            abecedario[i] = (char) (a + i); 
        }
    } 
    
    public String imprimirTodo(int valor){ 
        this.num=valor;
        String resp = ""; 
        for(int i = 0; i < num; i++) 
        { 
            resp += abecedario[i]+" "; 
        } 
        return resp; 
    } 
    public String imprimirUno(int valor){ 
        this.num=valor-1; 
        return abecedario[num]+" "; 
    } 

    public static void main(String args[]) 
    { 
        Abecedario aplicacion = new Abecedario();  
        System.out.println("Orden: " + aplicacion.imprimirTodo(22)); 
        System.out.println("Orden: " + aplicacion.imprimirUno(22));
        System.exit(0); 
    } 
} 
