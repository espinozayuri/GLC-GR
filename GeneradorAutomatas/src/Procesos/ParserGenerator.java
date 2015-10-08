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
                 //documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> simbol '"+Terminales+"'"+"\n");
               if(Terminales.contains("E")){
                   documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> succeed "+e.getKey()+String.valueOf(i)+"\n");
               }
               else
                if(Terminales.contains(((e.getKey()+String.valueOf(i))+"*"))){
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> token '"+Terminales+"'<*> many P"+e.getKey()+"\n");
                }else {
                        if(Terminales.contains("A+")){
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> token '"+Terminales+"'<*> many1 PA"+"\n");
                            }else {if(Terminales.contains("A?")){
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> token '"+Terminales+"'<*> option PA"+"\n");
                            }
                            else{ if(Terminales.size() >1){
                                documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> token '"+Terminales+"'"+"\n");}
                            
                            else
                              documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+Terminales+")<$> symbol '"+Terminales+"'"+"\n");}
                i++;
            System.out.println(Terminales);
            }
        }
        System.out.println("lista "+listaT);
            }}
        return documento;
    }
    
    public String cabeza(int i,String key){
        String res="";
        if(i==1){
            res="P"+key+"=(";
        }else{
            res="<|>(";
        }
        return res;
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
        resp="\\"+aplicacion.imprimir(i);
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
        System.out.println("ter "+Terminales);
        return Terminales;
    }
   
    private boolean esGramaticaMinuscula(String ss)
    {
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
}
