/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.GridPane;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


/**
 *
 * @author folgu
 */
public class Tablero1 extends javax.swing.JDialog {

    static int modo;
    static conexion cnx;
    JButton[][] MatrizBotones = new JButton[8][8];
    boolean turno = false;//false negras true blancas
    
    
    public Tablero1(java.awt.Frame parent, boolean modal,int modo) throws InterruptedException {
        super(parent, modal);
        this.modo = modo;
        String[] files = new String[1];
        files[0] = "./prolog/base.pl";
        cnx = new conexion(files);      
        
        initComponents();
        pnlTablero.setLayout(new GridLayout(8,8));
   int contadorX,contadorY;
   for (contadorX = 0; contadorX < 8; contadorX++){
    for (contadorY = 0; contadorY < 8; contadorY++){
        JButton btnNuevo = new JButton();
        btnNuevo.setSize(30, 30);
        btnNuevo.setToolTipText(Integer.toString(contadorX) + "," + Integer.toString(contadorY));
        MatrizBotones[contadorX][contadorY] = btnNuevo;
        MatrizBotones[contadorX][contadorY].addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) { 
                try {
                    Click(btnNuevo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tablero1.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        });
        pnlTablero.add(MatrizBotones[contadorX][contadorY]);
        pnlTablero.repaint();
        info.setText("Juegan las Negras");
       
    }
   }
   cnx.iniciarTablero();
    int coo[][] = procesar(cnx.colocarN());
    for(int i=0;i<coo.length-1;i++){
        botonAnegro(MatrizBotones[coo[i][0]][coo[i][1]]);
    }
    coo = procesar(cnx.colocarB());
    for(int i=0;i<coo.length-1;i++){
        botonAblanco(MatrizBotones[coo[i][0]][coo[i][1]]);
    }
     infoBlanca.setText("Blancas: "+cnx.cantBlancas());
     infoNegra.setText("Negras: "+cnx.cantNegras());
   }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        info = new javax.swing.JLabel();
        infoBlanca = new javax.swing.JLabel();
        infoNegra = new javax.swing.JLabel();
        pnlTablero = new javax.swing.JPanel();

        setTitle("A Jugar!");
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                closing(evt);
            }
        });

        info.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        info.setText("INFO");
        info.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        infoBlanca.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        infoBlanca.setText("INFO");
        infoBlanca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        infoNegra.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        infoNegra.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        infoNegra.setText("INFO");
        infoNegra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoBlanca, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(infoNegra, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoBlanca, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(infoNegra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlTableroLayout = new javax.swing.GroupLayout(pnlTablero);
        pnlTablero.setLayout(pnlTableroLayout);
        pnlTableroLayout.setHorizontalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTableroLayout.setVerticalGroup(
            pnlTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 816, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closing
        cnx.limpiarTablero();
    }//GEN-LAST:event_closing

    /**
     * @param args the command line arguments
     */
    
    private void Click(JButton btn) throws InterruptedException
   {
       String[] sr;
       if(turno){
           sr = cnx.jugadaIAB().split(",");
           //System.out.println(sr[0]+","+sr[1]);
           //System.out.println(cnx.validMovB(sr[0],sr[1]));
           if (cnx.validMovB(sr[0],sr[1])){
               info.setText("Juegan las Negras");
               //System.out.println("HOLAAAAAA");
               jugadaBlanca(sr[0]+","+sr[1]);
               turno = !turno;
           }
       }else{
           sr = btn.getToolTipText().split(",");
           if (cnx.validMovN(sr[0],sr[1])){
               info.setText("Juegan las Blancas");
               jugadaNegra(btn.getToolTipText());
               turno = !turno;
               if(cnx.cantMovsBlancos()){
                   btn.doClick();
                   return;
               }
           }    
       }
       infoBlanca.setText("Blancas: "+cnx.cantBlancas());
       infoNegra.setText("Negras: "+cnx.cantNegras());
       if(cnx.finJuego()){
           if(cnx.cantBlancas()>cnx.cantNegras()){
               JOptionPane.showMessageDialog(null, "Blancas ganan "+cnx.cantBlancas()+" a "+cnx.cantNegras());
           }else{
               if(cnx.cantBlancas()<cnx.cantNegras()){
                   JOptionPane.showMessageDialog(null, "Negras ganan "+cnx.cantNegras()+" a "+cnx.cantBlancas());
               }else{
                   JOptionPane.showMessageDialog(null, "Empate "+cnx.cantNegras()+" a "+cnx.cantBlancas());
               }
           }
           this.setVisible(false);
           cnx.limpiarTablero();
           return;
       }
       if(turno && !cnx.cantMovsBlancos() && !cnx.finJuego()){
           JOptionPane.showMessageDialog(null, "Blancas sin movimientos pasa el turno");
           info.setText("Juegan las Negras");
           turno=!turno;
       }
       if(!turno && !cnx.cantMovsNegros() && !cnx.finJuego()){
           JOptionPane.showMessageDialog(null, "Negras sin movimientos pasa el turno");
           info.setText("Juegan las Blancas");
           turno=!turno;
           btn.doClick();
       }
       
       
   }
    
   public void botonAnegro(JButton btn){
       btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/black50.png")));
   }
   public void botonAblanco(JButton btn){
       btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/white50.png")));
   }
   public int[][] procesar(String[] s){
       int coords[][] = new int[s.length][2];
       //System.out.println(s[0]);
       //System.out.println(s[1]);
       for(int i=1;i<s.length;i++){
           if(s[i]!=null){
            //System.out.println(s[i]);
            coords[i-1][0] =s[i].charAt(0)-'0';
            coords[i-1][1] =s[i].charAt(1)-'0';
           }
       }
       for(int i=0;i<coords.length-1;i++){
           for(int j=0;j<coords[i].length;j++){
               //System.out.println(""+coords[i][j]+" "+i+" "+j);
           }
       }
       return coords;
   }
   public void jugadaNegra(String s){
      String[] sr = s.split(",");
      //System.out.println("HOLAAAAAAAA "+sr[0]+" "+sr[1]);
      int coo[][] = procesar(cnx.movN(sr[0], sr[1]));
      for(int i=0;i<coo.length-1;i++){
        botonAnegro(MatrizBotones[coo[i][0]][coo[i][1]]);
      }
   }
   public void jugadaBlanca(String s) throws InterruptedException{
      String[] sr = s.split(",");
      //System.out.println("ADIOOOOOOOOOS "+sr[0]+" "+sr[1]);
      int coo[][] = procesar(cnx.movB(sr[0], sr[1]));
      for(int i=0;i<coo.length;i++){
          for(int j=0;j<coo[i].length;j++){
              System.out.print(""+coo[i][j]+" ");
          }
          System.out.println("");
      }
      for(int i=0;i<coo.length-1;i++){
        botonAblanco(MatrizBotones[coo[i][0]][coo[i][1]]);
      }
      
   }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel info;
    private javax.swing.JLabel infoBlanca;
    private javax.swing.JLabel infoNegra;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables

}
