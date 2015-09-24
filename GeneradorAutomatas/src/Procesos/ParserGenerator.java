/*
something to push
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Procesos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author root
 */
public class ParserGenerator {
    HashMap<String, ArrayList<String>> listaT;
    List<String> documento;
    List<String> noTerminales;
    
    public ParserGenerator(HashMap<String, ArrayList<String>> listaT) {
        this.listaT = listaT;
        noTerminales = generarNoTerminales();
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
            documento.add("P"+e.getKey()+"=("+funcion(e.getValue())+"->"+e.getKey()+String.valueOf(1)+")<"+e.getValue()+"> symbol '"+e.getValue()+"'"+"\n");
            documento.add(generarData(e.getKey(), e.getValue()));
            System.out.println(noTerminales);
        }
        return documento;
    }
    
    public String generarData(String key, ArrayList<String> terminales){
        String resp="";
        int i =1;
        //resp="P"+key+"=("+funcion(terminales)+"->"+key+String.valueOf(i)+")<"+terminales+"> symbol '"+terminales +"'"+"\n";
        i++;
        for(String terminal : terminales){
            resp=generarValor(terminal,i,terminales,key)+"\n";
            i++;
        }
        return resp;
    }
    
    public String generarValor(String terminal,int i,ArrayList<String> terminales,String key){
        String resp="";
        String[] termi = terminal.split(" ");
        for(String Noterm:termi){
            if (noTerminales.contains(Noterm)) {
                resp="<|>("+funcion(terminales)+"->"+key+String.valueOf(i)+" "+terminales+")<"+"\n";
            }
        }
        return resp;
    }
    
    public String funcion(ArrayList<String> terminales){
        String resp="";
        int i=0;
        for(String terminal : terminales){
            i =(terminal.length()+1)/2;
        }    
        Abecedario aplicacion = new Abecedario();  
        resp="\\"+aplicacion.imprimir(i);
        return resp;
    }
}
