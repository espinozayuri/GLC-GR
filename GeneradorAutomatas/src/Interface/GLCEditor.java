package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class GLCEditor extends javax.swing.JFrame {

    HashMap<String, ArrayList<String>> listaT;//lista principal
    //hashmap < Key(No terminal), AL < terminales/no terminal >
    StringBuffer bfIn;
    ArrayList<String> noTerminales;
    ArrayList<String> terminales;

    public GLCEditor() {
        initComponents();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnData.setText("DATA");
        btnData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataActionPerformed(evt);
            }
        });

        btnParser.setText("PARSER");

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
                .addGap(59, 59, 59)
                .addComponent(btnGrabar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecuperar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerificar)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(29, 29, 29)
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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

        //guardar en hashpmap
        String terminalAux = txtTerminal.getText().toString(); //agarra el texto del cuadro
        //Si existe la llave y tiene un AL no volver a crear un array list
        //sino crearlo        
        if (listaT.containsKey(terminalAux)) {
            //si contiene la llave entonces añadir los elemtos al AL correspondiente
            ArrayList<String> alAux = listaT.get(terminalAux);
            alAux.add(txtCadena.getText()); //añade al AL los nuevos elementos
            listaT.put(terminalAux, alAux);

        } else { //si el noTerminal no esta en el Hashmap, colocarlo y crear su AL

            ArrayList<String> cadena = new ArrayList<>();
            cadena.add(txtCadena.getText().toString());
            listaT.put(terminalAux, cadena);

        }
        //actualiza la parte grafica
        bfIn = bfIn.append(terminalAux + "---->" + txtCadena.getText() + "\n");
        txtMain.setText(bfIn.toString());

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
        // TODO add your handling code here:
        GuardarArchivo g = new GuardarArchivo();
        g.crearArchivo("Gramaticas Guardadas.txt", txtMain.getText());


    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        // TODO add your handling code here:
        //comprobar sintaxis


    }//GEN-LAST:event_btnVerificarActionPerformed

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

    }

    private void obtenerTerminales() {
        //obterner terminales y actualizar arraylist

    }

    private String generarLeng() {
    StringBuffer leng= new StringBuffer();
    leng.append("L(G):{");
    //metodo de generador
    
    leng.append("}");
    return leng.toString();
    
    }

}
