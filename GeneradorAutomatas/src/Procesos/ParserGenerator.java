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
    String Lambda="";
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
                if(terminal.contains("E")){
                   documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+calculoLambda(terminal)+")<$> succeed "+e.getKey()+String.valueOf(i)+"\n");
                }else{   if(terminal.length() <=1){
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+calculoLambda(terminal)+")<$> "+AnalizadorLadoDerecho(terminal)+"\n");
                }else{
                    String resM="";
                    for(int j=0; j<=(terminal.length()-1);j++){
                    char posC=terminal.charAt(j);
                    String pos=posC+"";
                    resM=resM.concat(AnalizadorLadoDerecho(pos));
                    resM=resM+" <*> ";
                    }
                   
                    System.out.println("resp "+resM);
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+calculoLambda(terminal)+")<$> "+resM+"\n");
                } }           
                i++;
            }
            /*for(String terminal : e.getValue()){
                terminales(terminal);
                if(Terminales.contains("E")){
                   documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+calculoLambda(terminal)+")<$> succeed "+e.getKey()+String.valueOf(i)+"\n");
                }else{   
                    documento.add(cabeza(i,e.getKey())+funcion(terminal)+"->"+e.getKey()+String.valueOf(i)+" "+calculoLambda(terminal)+")<$> "+AnalizadorLadoDerecho(terminal)+"\n");
                }            
                i++;
            //System.out.println(terminal);
            }*/
        }
        //System.out.println("lista "+listaT);
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
    
    public String calculoLambda(String terminal){
        boolean res=false;
        Lambda="";
        terminal = terminal.trim();
        terminal = terminal.replace(" ","");
        String aux = terminal;
        //System.out.println("cadena "+aux);
        if(Terminales.contains("E")){
            Lambda="";
        }else{
            for(int a = 0; a < aux.length(); a++){
                char caracter=terminal.charAt(a);
                //System.out.println("caracter "+caracter);
                int i=a+1;
                if(Character.isUpperCase(caracter)){
                    //System.out.println("posicion "+i);
                    Abecedario aplicacion = new Abecedario();
                    Lambda += aplicacion.imprimirUno(i);
                }
            }
        }
        //System.out.println("lamba "+Lambda);
        return Lambda;
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
    
   private String AnalizadorLadoDerecho(String terminal){
        String resp = "";
        
        for(int i=0; i<terminal.length(); i++){
            char act= terminal.charAt(i);
            String actt = act + "";
            char act2= terminal.charAt(i);
            String actt2 = act + "";
            boolean comp = esGramaticaMinuscula(actt);
            //char act3= terminal.charAt(i-1);
            //String actt3 = act + "";
            if(actt2.equals("+")){
                resp="many1 P"+actt;}
                else{
                    if(actt2.equals("*")){
                        resp="many P"+actt;
                    }
                    else{
                         if(actt2.equals("?")){
                             resp="option P"+actt;
                         }else{
                    if(!actt.equals(" ")){
                    if(comp){  
                    resp="symbol '"+act+"'";
                } else{resp="P"+actt;}
                    
                }}}
            }
        }
                
        return resp;
    }
}
