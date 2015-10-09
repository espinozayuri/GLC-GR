package Interface;

import Procesos.DataFrame;
import Procesos.ParserFrame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class GLCEditor extends javax.swing.JFrame {

    HashMap<String, ArrayList<String>> listaT;//lista principal
    //hashmap < Key(No terminal), AL < terminales/no terminal >
    StringBuffer bfIn;
    ArrayList<String> noTerminales;
    ArrayList<String> terminales;
    private char epsilon = 'E';

    public GLCEditor() {
        initComponents();
        setTitle("GLC");
        setBounds(700, 300, 435, 345);
        listaT = new HashMap<>(); // vacia
        bfIn = new StringBuffer();
        noTerminales = new ArrayList<>();
        terminales = new ArrayList<>();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnData = new javax.swing.JButton();
        btnParser = new javax.swing.JButton();
        btnGen = new javax.swing.JButton();
        btnTerminal = new javax.swing.JButton();
        btnNoTerminal = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        btnAniadir = new javax.swing.JButton();
        txtTerminal = new javax.swing.JTextField();
        txtCadena = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bttNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMain = new javax.swing.JTextPane();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnData.setText("DATA");
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });

        btnParser.setText("PARSER");
        btnParser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParserActionPerformed(evt);
            }
        });

        btnGen.setText("GEN");
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });

        btnTerminal.setText("TERMINAL");
        btnTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminalActionPerformed(evt);
            }
        });

        btnNoTerminal.setText("NO TERMINAL");
        btnNoTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoTerminalActionPerformed(evt);
            }
        });

        btnGrabar.setText("GRABAR");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnRecuperar.setText("RECUPERAR");
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });

        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnAniadir.setText("+");
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });

        txtTerminal.setText("T");
        txtTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTerminalActionPerformed(evt);
            }
        });

        txtCadena.setText("A b c d");
        txtCadena.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel1.setText("No terminal");

        jLabel2.setText("cadena (utilizar espacio)");

        jLabel3.setText("--->");

        bttNuevo.setText("Nuevo");
        bttNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttNuevoActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(txtMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAniadir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bttNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnTerminal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNoTerminal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGrabar)
                                .addGap(35, 35, 35)
                                .addComponent(btnRecuperar)
                                .addGap(27, 27, 27)
                                .addComponent(btnVerificar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(43, 43, 43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtTerminal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnParser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGen)))
                        .addContainerGap(56, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnData)
                    .addComponent(btnParser)
                    .addComponent(btnGen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTerminal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNoTerminal)
                        .addGap(70, 70, 70))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTerminal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAniadir)
                            .addComponent(jLabel3)
                            .addComponent(bttNuevo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnRecuperar)
                    .addComponent(btnVerificar))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton añadir
    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        String terminalAux = txtTerminal.getText().toString().trim().toUpperCase();
        String cadena = txtCadena.getText();
        anadir(terminalAux,cadena);
    }//GEN-LAST:event_btnAniadirActionPerformed

    private void txtTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTerminalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTerminalActionPerformed

    private void bttNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttNuevoActionPerformed
        // Borra todos los datos actuales
        bfIn = new StringBuffer();
        txtMain.setText(bfIn.toString());
        txtCadena.setText("");
        txtTerminal.setText("");
        listaT = new HashMap<>();
        terminales.clear();
        noTerminales.clear();
    }//GEN-LAST:event_bttNuevoActionPerformed

    private void btnNoTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoTerminalActionPerformed
        obtenerNoTerminales();

        ventanaNoTerminales ven = new ventanaNoTerminales(noTerminales);
        ven.setVisible(true);

        System.out.println(listaT.get("T"));

    }//GEN-LAST:event_btnNoTerminalActionPerformed

    private void btnTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminalActionPerformed
        // TODO add your handling code here:
        obtenerTerminales();
        ventanaTerminales ven1 = new ventanaTerminales(terminales);
        ven1.setVisible(true);

    }//GEN-LAST:event_btnTerminalActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        File crearArchivo;
        FileWriter escribirDatos;
        BufferedWriter bw;
        PrintWriter wr;
        
        try {
            crearArchivo=new File("Gramatica Guardadas1.txt");
            escribirDatos= new FileWriter(crearArchivo);
            bw= new BufferedWriter(escribirDatos);
            wr= new PrintWriter(crearArchivo);
            
            wr.write(txtMain.getText());
            wr.append("");
            
            wr.close();
            bw.close();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error "+ e);
        }
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        obtenerNoTerminales();
        obtenerTerminales();         
        boolean res = true;
        for (Map.Entry<String, ArrayList<String>> entrySet : listaT.entrySet()) {            
            String key = entrySet.getKey();
            res = verificarNT(key);
            if(res){
                ArrayList<String> value = entrySet.getValue();
                res = verificarTNT(value);
                if(!res){
                    break;
                }                
            }
            else{
                break;
            }
        }  
        if(res)
            JOptionPane.showMessageDialog(null,"Todo esta bien");
    }//GEN-LAST:event_btnVerificarActionPerformed

    private boolean verificarTNT(ArrayList<String> value) 
    {
        obtenerTerminales();
        boolean res = true;
        for (String e : value) 
        {
            e=e.trim();
            String aux[] = e.split(" ");            
            for (String e2 : aux) 
            {
                //if(esGramaticaMinuscula(e2))
                //{
                    res = terminales.contains(e2);
                    if(!res)
                    {
                        res = noTerminales.contains(e2);
                        if(!res)
                        {
                            res = false;
                            JOptionPane.showMessageDialog(null, "tnt no pertenece a la gramatica");
                            break;
                        }                
                    }                
                //}
            }
            if(!res)
            {
                break;
            }
        }        
        return res;
    }
        
   private boolean verificarNT(String termino) 
   {
       /*
        String path = "/imagenes/bien.png";  
        URL url = this.getClass().getResource(path);  
        ImageIcon icon = new ImageIcon(url);
        */
    
        boolean res = noTerminales.contains(termino);
        boolean res1= containsMayus(termino);
        if((!res)&&(!res1))
            JOptionPane.showMessageDialog(null, "nt no pertenece a la gramatica");
        //else
        //{
            //jbl4.setIcon(icon);
            //jbl4.setVisible(res1);
            //JOptionPane.showMessageDialog(null, "nt pertenece a la gramatica");
        //}
        return res; 
    }
   
    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
        //lenguaje generado
        String lengGen = generarLeng();
        JOptionPane.showOptionDialog(this,  lengGen, "Lenguaje Generado", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{" OK "}, "OK");
    }//GEN-LAST:event_btnGenActionPerformed

    private void btnDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataActionPerformed
        DataFrame data = new DataFrame(listaT);
        data.setVisible(true);
        //JOptionPane.showMessageDialog(this, "Operación realizada correctamente");
    }//GEN-LAST:event_btnDataActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        reiniciar();
        String direccion = "Gramatica Guardadas1.txt";
        File archivo = new File(direccion);
        //System.out.println(archivo.getAbsolutePath());
        
        try{
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea = leer.readLine();
            String aux="";
            while(linea!= null){
                String aux2[]= linea.split("---->");
                if(aux2.length>1){
                    anadir(aux2[0],aux2[1]);
                }
                aux+= linea+"\n";
                linea = leer.readLine();
            }
            txtMain.setText(aux);
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null,"Ha ocurrido un error "+ e);
        }
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void reiniciar() {
        // Borra todos los datos actuales
        bfIn = new StringBuffer();
        txtMain.setText(bfIn.toString());
        txtCadena.setText("");
        txtTerminal.setText("");
        listaT = new HashMap<>();
        terminales.clear();
        noTerminales.clear();
    }
    
    private void btnParserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParserActionPerformed
        ParserFrame parser = new ParserFrame(listaT);
        parser.setVisible(true);
        //System.out.print(listaT+"\n");
        //System.out.print(bfIn+"\n");
    }//GEN-LAST:event_btnParserActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GLCEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnData;
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnNoTerminal;
    private javax.swing.JButton btnParser;
    private javax.swing.JButton btnRecuperar;
    private javax.swing.JButton btnTerminal;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JButton bttNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCadena;
    private javax.swing.JTextPane txtMain;
    private javax.swing.JTextField txtTerminal;
    // End of variables declaration//GEN-END:variables

    private ArrayList<String> convertirEnCad(String cadIn) {
        ArrayList<String> listcad = new ArrayList<>();
        String cadAux = cadIn;

        for (int i = 0; i < cadIn.length(); i++) {
            listcad.add(cadAux.substring(cadAux.length() - 1));
            cadAux = cadAux.substring(cadAux.length() - 1);
        }
        return listcad;
    }

    private void obtenerNoTerminales() {
        //obtener Keys del hashmap
        noTerminales = new ArrayList<>(listaT.keySet());
        for (int i = 0; i < noTerminales.size(); i++) {
            if(noTerminales.get(i).equals(epsilon+""))
                noTerminales.remove(i);
        }
    }

    private void obtenerTerminales() {
        //obtenerNoTerminales();//con esto generamos los no terminales y ya no tomamos encuenta para los terminales
        for (Map.Entry<String, ArrayList<String>> entrySet : listaT.entrySet()) 
        {
            //String key = entrySet.getKey();
            ArrayList<String> value = entrySet.getValue();
            for (String e : value)//e contiene la cadena de texto 
            {
                String [] aux;
                boolean res=false;
                e = e.trim();//elimina espacios adelante y atras de la cadena 
                aux=e.split(" ");
                for (String sa : aux)//sa es elemento de aux, aux=[S,a,s,B] ---> sa=S 
                {
                    res=noTerminales.contains(sa);//
                    if(!res)
                    {
                        res= terminales.contains(sa);
                        if(!res)
                        {                            
                            if(esGramaticaMinuscula(sa)){
                                terminales.add(sa);
                            }                            
                        }
                    }
                }
            }
        }
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
    
    private String generarLeng() {
        StringBuffer leng= new StringBuffer();
        leng.append("L(G):{");
        obtenerNoTerminales();
        //metodo de generador

        //isUpperCasse()
        //ciclo para revisar todos los arrays de las keys
        for(String nt:noTerminales){
            for(String el: listaT.get(nt)){
                //recorre todos los terminales que tiene la key nt
                //si el tiene mayusculas remplazar, sino añadir al lg y diferente de E    
                if(!containsMayus(el.trim())){
                    leng.append(el);
                    leng.append(",");
                }            
            }
        } //borrar el ultimo come    
        leng.append("}");
        return leng.toString();  
    }

    private boolean containsMayus(String l) {
        
        boolean res=false;
        for(int i =0; i<l.length();i++){
       
        if(Character.isUpperCase(l.charAt(i))&&l.charAt(i)!= 'E') res = true;
          }    
        return res;
    }
    
    private void anadir(String terminalAux, String txtcadena) {
        //guardar en hashpmap
         //agarra el texto del cuadro NO TERMINAL
        //Si existe la llave y tiene un AL no volver a crear un array list
        //sino crearlo      
        if(!duplicado(terminalAux,txtcadena)){
            if (listaT.containsKey(terminalAux)) {
                //si contiene la llave entonces añadir los elemtos al AL correspondiente
                ArrayList<String> alAux = listaT.get(terminalAux);
                alAux.add(txtcadena); //añade al AL los nuevos elementos
                listaT.put(terminalAux, alAux);

            } else { //si el noTerminal no esta en el Hashmap, colocarlo y crear su AL

                ArrayList<String> cadena = new ArrayList<>();
                cadena.add(txtcadena.toString());
                listaT.put(terminalAux, cadena);

            }
            //actualiza la parte grafica
            bfIn = bfIn.append(terminalAux + "---->" + txtcadena + "\n");
            txtMain.setText(bfIn.toString());
        }
        else{
            JOptionPane.showMessageDialog(null,"Regla duplicada");
        }
    }
    
    private boolean duplicado(String nt, String tnt) {
        boolean res = false;
        for (Map.Entry<String, ArrayList<String>> entrySet : listaT.entrySet()) {
            String key = entrySet.getKey();
            if(key.equals(nt)){                
                ArrayList<String> value = entrySet.getValue();
                for (String e : value) {
                    if(e.equals(tnt))
                        res = true;
                }
            }
        }
        return res;        
    }
}
