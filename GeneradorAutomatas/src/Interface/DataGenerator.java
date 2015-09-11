/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author root
 */
public class DataGenerator {
    HashMap<String, ArrayList<String>> listaT;
    List<String> documento;
    List<String> noTerminales;
    public DataGenerator(HashMap<String, ArrayList<String>> listaT) {
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
            documento.add("data "+e.getKey()+"=");
            documento.add(generarData(e.getKey(), e.getValue()));
        }
        return documento;
    }
    
    public String generarData(String key, ArrayList<String> terminales){
        String resp="";
        int i =1;
        for(String terminal : terminales){
            resp+="|"+key+String.valueOf(i)+" ";
            resp+=generarValor(terminal)+"\n";
            i++;
        }
        return resp;
    }
    
    public String generarValor(String terminal){
        String resp="";
        String[] terminales = terminal.split(" ");
        for(String Noterm:terminales){
            if (noTerminales.contains(Noterm)) {
                resp+= Noterm + " ";
            }
        }
        return resp;
    }
    
}
