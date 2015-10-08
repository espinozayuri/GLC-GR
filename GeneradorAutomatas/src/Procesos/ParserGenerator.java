/*
something to push
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import Interface.GLCEditor;
import static java.lang.Math.E;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author root
 */
public class ParserGenerator {
    HashMap<String, ArrayList<String>> listaT;
    List<String> documento;
    List<String> noTerminales;
    List<String> Terminales;
    //public String key;
    private char epsilon = 'E';
    
    public ParserGenerator(HashMap<String, ArrayList<String>> listaT) {
        this.listaT = listaT;
        noTerminales = generarNoTerminales();
       // Terminales = generarTerminales(key);
    }
    
    public List<String> generarNoTerminales(){
        noTerminales = new ArrayList<String>();
        for(Entry<String, ArrayList<String>> e : listaT.entrySet()) {
            noTerminales.add( e.getKey());
        }
        return noTerminales;
    }
    
    public String generarDocumento(){
        String resp="";
        generarDocumentoList();
        for(String value:documento){
            resp+=value+"\n";
        }
        return resp;
    }
    
    public List<String> generarDocumentoList(){
        documento = new ArrayList<String>();
        for(Entry<String, ArrayList<String>> e : listaT.entrySet()) {
            int i =1;
            for(String terminal : e.getValue()){
                terminales(terminal);
                if(Terminales.contains("E")){
                   documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+cola(terminal)+")<$> succeed "+e.getKey()+String.valueOf(i)+"\n");
                }else{   
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+cola(terminal)+")<$> "+AnalizadorLadoDerecho(listaT)+"\n");
                }            
                i++;
            System.out.println(Terminales);
            }
        }
        System.out.println("lista "+listaT);
        return documento;
    }
    
    public String cabeza(int i,String key){
        String resp="";
        if(i==1){
            resp="P"+key+"=(";
        }else{
            resp="<|>(";
        }
        return resp;
    }
    
    public String cola(String terminal){
        String resp="";
        int i=1;
        
        Abecedario aplicacion = new Abecedario(); 
        resp=aplicacion.imprimirUno(i);
        
        return resp;
    }
    
    public String funcion(String terminal){
        String resp;
        int i=0;
        if((terminal.length()%2)!=0){//impar
            i =(terminal.length()+1)/2;
        }else{
            if((terminal.length()%2)==0){//par
                i =(terminal.length())/2;
            }    
        } 
        Abecedario aplicacion = new Abecedario();  
        resp="\\"+aplicacion.imprimirTodo(i);
        return resp;
    }
    
    public List<String> terminales(String terminal){
        Terminales = new ArrayList<>();
        boolean res=false;
        terminal = terminal.trim();//elimina espacios adelante y atras de la cadena 
        String[] aux=terminal.split(" ");
        for (String sa : aux){//sa es elemento de aux, aux=[S,a,s,B] ---> sa=S   
            res=noTerminales.contains(sa);
            if(!res){
                res= Terminales.contains(sa);
                if(!res){                            
                    if(esGramaticaMinuscula(sa)){
                        Terminales.add(sa);                          
                    }
                }
            }
        }
        //System.out.println("ter "+Terminales);
        return Terminales;
    }
   
    private boolean esGramaticaMinuscula(String ss){
        boolean res=false;
        for(int i =0; i<ss.length();i++) //
        {
            if(!Character.isUpperCase(ss.charAt(i)) || ss.charAt(i)== epsilon)
            {    
                if(Character.isLowerCase(ss.charAt(i))||ss.charAt(i)== epsilon||ss.charAt(i)== ' '||ss.charAt(i)=='*'||ss.charAt(i)=='+'||ss.charAt(i)=='?')
                {
                    res = true;
                }
            }
          }    
        return res;
    }
    
    private String AnalizadorLadoDerecho(HashMap<String, ArrayList<String>> listaT){
        String resp = "";
        for(Entry<String, ArrayList<String>> e : listaT.entrySet()) {
            int i =1;
            for(String terminal : e.getValue()){
                
                
                
                
            i++;    
            }
        }
        
/*
        String letra = e.getKey()+String.valueOf(i);
        if(Terminales.contains(letra+"*")){
            token '"+Terminales+"'<*> many P"+e.getKey()+"\n");
        }else {
            if(Terminales.contains("T+")){
                many1 P"+e.getKey()+String.valueOf(i)+"\n");
            }else{
                if(Terminales.contains("A?")){
                    token '"+Terminales+"'<*> option PA"+"\n");
                }else{ 
                    if(Terminales.size() >1){
                        token '"+Terminales+"'"+"\n");}
                    else
                        symbol '"+Terminales+"'"+"\n");}
*/

        return resp;
    }
}
