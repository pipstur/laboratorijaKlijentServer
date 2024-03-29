/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import domain.Objava;
import domain.Rezultat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logic.Controller;

/**
 *
 * @author vojislav
 */
public class FrmObjava extends javax.swing.JFrame {

    /**
     * Creates new form FrmObjava
     */
    Rezultat rezultat;
    public FrmObjava(Rezultat rezultat) {
        initComponents();
        this.rezultat = rezultat;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            Controller.getInstance().setFrmObjava(this);
        } catch (Exception ex) {
            Logger.getLogger(FrmObjava.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtDigest.setLineWrap(true); 
        txtDigest.setWrapStyleWord(true);
        lblRez.setText("Objava se odnosi na rezultat: "+rezultat);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSacuvaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        lblRez = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNaslov = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDigest = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        lblRez.setText("jLabel1");

        jLabel2.setText("Naslov objave");

        jLabel3.setText("Digest");

        txtDigest.setColumns(20);
        txtDigest.setRows(5);
        jScrollPane1.setViewportView(txtDigest);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOtkazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSacuvaj))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                    .addComponent(txtNaslov)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRez))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblRez)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        Objava objava = new Objava();
        objava.setNaslov(txtNaslov.getText());
        objava.setDigest(txtDigest.getText());
        objava.setRezid(rezultat.getId());
        objava.setDatum(new Date());
        System.out.println(objava.getDatum());
        
        
        if(objava.getNaslov().isEmpty()||objava.getNaslov().length()>50){
            JOptionPane.showMessageDialog(this, "Naslov je neispravan");
        }
        else if(objava.getDigest().isEmpty()||objava.getDigest().length()>255){
            JOptionPane.showMessageDialog(this, "Digest je neispravan");
        }
        else{
            ubaciUBazu(objava);
        }
        
    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRez;
    private javax.swing.JTextArea txtDigest;
    private javax.swing.JTextField txtNaslov;
    // End of variables declaration//GEN-END:variables

    private void ubaciUBazu(Objava objava) {
        try {
                Controller.getInstance().Objavi(objava);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
    }
    public void objavi(boolean flag) throws Exception{
        if(flag){
                    JOptionPane.showMessageDialog(this, "Uspešno objavljivanje rezultata!");
                    Controller.getInstance().setFrmObjava(null);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Neuspešno objavljivanje rezultata!");
                    Controller.getInstance().setFrmObjava(null);
                    dispose();
                }
    }
}
