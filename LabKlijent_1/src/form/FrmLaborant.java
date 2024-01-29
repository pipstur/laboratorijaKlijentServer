/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import domain.Eksperiment;
import domain.Rezultat;
import domain.User;
import domain.VrstaEksperimenta;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.TableModel;
import logic.Controller;
import tablemodel.EksperimentiTableModel;
import threads.Klijent;

/**
 *
 * @author vojislav
 */
public class FrmLaborant extends javax.swing.JFrame {

    /**
     * Creates new form FrmLaborant
     */
    User korisnik;
    public FrmLaborant(User user) {
        initComponents();
        this.korisnik  = user;
        try {
            Controller.getInstance().setFrmLaborant(this);
        } catch (Exception ex) {
            Logger.getLogger(FrmLaborant.class.getName()).log(Level.SEVERE, null, ex);
        }
        setUp();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
            Controller.getInstance().logout(korisnik);
            
            } catch (Exception ex) {
            
            }
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKreirajEksperiment = new javax.swing.JButton();
        btnBrisanjeEksperimenta = new javax.swing.JButton();
        btnPretraga = new javax.swing.JButton();
        btnIzmenaEksperimenta = new javax.swing.JButton();
        btnKreiranjeRezultata = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEksperimenti = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        lblWelcome = new javax.swing.JLabel();
        cbPretraga = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnOdjava = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnKreirajEksperiment.setText("Kreiraj eksperiment");
        btnKreirajEksperiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreirajEksperimentActionPerformed(evt);
            }
        });

        btnBrisanjeEksperimenta.setText("Brisanje eksperimenta");
        btnBrisanjeEksperimenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrisanjeEksperimentaActionPerformed(evt);
            }
        });

        btnPretraga.setText("Pretraga eksperimenta");
        btnPretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaActionPerformed(evt);
            }
        });

        btnIzmenaEksperimenta.setText("Izmena eksperimenta");
        btnIzmenaEksperimenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmenaEksperimentaActionPerformed(evt);
            }
        });

        btnKreiranjeRezultata.setText("Kreiranje rezultata");
        btnKreiranjeRezultata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKreiranjeRezultataActionPerformed(evt);
            }
        });

        tblEksperimenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEksperimenti);

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblWelcome.setText("lblWelcome");

        cbPretraga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Naziv", "Opis", "Koriscene supstance", "Vrsta eksperimenta" }));

        jLabel3.setText("Pretraga po:");

        btnOdjava.setText("Odjava");
        btnOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdjavaActionPerformed(evt);
            }
        });

        jButton1.setText("Detalji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(452, 452, 452)
                                .addComponent(jLabel1)
                                .addGap(0, 203, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnKreirajEksperiment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBrisanjeEksperimenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnIzmenaEksperimenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnKreiranjeRezultata, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPretraga, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(btnOdjava, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretraga)
                    .addComponent(cbPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnKreirajEksperiment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzmenaEksperimenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrisanjeEksperimenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKreiranjeRezultata)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOdjava)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaActionPerformed

        String kolona = (String) cbPretraga.getSelectedItem();
        String kriterijum = txtPretraga.getText();
        String[] argumenti = {kriterijum, kolona};
        
        try {
            Controller.getInstance().pretragaEksperimenata(argumenti);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    
            
        
        
    }//GEN-LAST:event_btnPretragaActionPerformed

    private void btnKreirajEksperimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreirajEksperimentActionPerformed
        JFrame frameKreiraj;
        try {
            frameKreiraj = new FrmEksperiment(new Eksperiment(), Controller.getInstance(), true);
            frameKreiraj.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FrmLaborant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnKreirajEksperimentActionPerformed

    private void btnIzmenaEksperimentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmenaEksperimentaActionPerformed
        int rowIndex = tblEksperimenti.getSelectedRow();
        EksperimentiTableModel model = (EksperimentiTableModel) tblEksperimenti.getModel();
        Eksperiment eksperiment = model.getEksperimentAt(rowIndex);
        if(eksperiment!=null){
            JFrame frmIzmena;
            try {
                frmIzmena = new FrmEksperiment(eksperiment, Controller.getInstance(), true);
                frmIzmena.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(FrmLaborant.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Niste selektovali nijedan eksperiment! ");
        }
        
    }//GEN-LAST:event_btnIzmenaEksperimentaActionPerformed

    private void btnOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdjavaActionPerformed
        try {
            Controller.getInstance().logout(korisnik);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
    }//GEN-LAST:event_btnOdjavaActionPerformed

    private void btnBrisanjeEksperimentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrisanjeEksperimentaActionPerformed
        int rowIndex = tblEksperimenti.getSelectedRow();
        EksperimentiTableModel model = (EksperimentiTableModel) tblEksperimenti.getModel();
        Eksperiment eksperiment = model.getEksperimentAt(rowIndex);
        
        if(eksperiment!=null){
            int vrednost = JOptionPane.showConfirmDialog(this, "Zelite li sigurno da obrisete eksperiment: "+eksperiment);
            if(vrednost==JOptionPane.YES_OPTION){
               try {
                Controller.getInstance().obrisiEksperiment(eksperiment);
                
            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(this, ex);
            } 
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Niste selektovali nijedan eksperiment!");
        }
    }//GEN-LAST:event_btnBrisanjeEksperimentaActionPerformed

    private void btnKreiranjeRezultataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKreiranjeRezultataActionPerformed
        int rowIndex = tblEksperimenti.getSelectedRow();
        EksperimentiTableModel model = (EksperimentiTableModel) tblEksperimenti.getModel();
        Eksperiment eksperiment = model.getEksperimentAt(rowIndex);
        if(eksperiment!=null){
            FrmRezultat frmRezultat = new FrmRezultat(eksperiment, new Rezultat(), true);
            frmRezultat.setVisible(true);
            
            
        }else{
            JOptionPane.showMessageDialog(this, "Niste selektovali nijedan eksperiment!");
        }
    }//GEN-LAST:event_btnKreiranjeRezultataActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowIndex = tblEksperimenti.getSelectedRow();
        EksperimentiTableModel model = (EksperimentiTableModel) tblEksperimenti.getModel();
        Eksperiment eksperiment = model.getEksperimentAt(rowIndex);
        if(eksperiment!=null){
            JFrame frmIzmena;
            try {
                frmIzmena = new FrmEksperiment(eksperiment, Controller.getInstance(), false);
                frmIzmena.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(FrmLaborant.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Niste selektovali nijedan eksperiment! ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrisanjeEksperimenta;
    private javax.swing.JButton btnIzmenaEksperimenta;
    private javax.swing.JButton btnKreirajEksperiment;
    private javax.swing.JButton btnKreiranjeRezultata;
    private javax.swing.JButton btnOdjava;
    private javax.swing.JButton btnPretraga;
    private javax.swing.JComboBox<String> cbPretraga;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JTable tblEksperimenti;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    public void setUp() {
        lblWelcome.setText("Dobrodošao/la korisniče pod imenom "+korisnik.getIme()+" "+korisnik.getPrezime()+"!");
        String argumenti[] = {"",""};
        try {
            Controller.getInstance().pretragaEksperimenata(argumenti);
            
        } catch (Exception ex) {
            Logger.getLogger(FrmLaborant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void tableSetup(List<Eksperiment> eksperimenti){
        if(!eksperimenti.isEmpty()){
                tblEksperimenti.setModel(new EksperimentiTableModel(eksperimenti));
        }else
            JOptionPane.showMessageDialog(this, "Nema odgovarajucih rezultata na osnovu parametara pretrage!");

    }
    public void odjava(boolean flag){
        if(flag){
                
                System.exit(0);
            }else{
                JOptionPane.showMessageDialog(this, "Neuspesno logoutovanje ?");
            }
    }
    public void obrisiEksperiment(boolean flag){
        if(flag){
            JOptionPane.showMessageDialog(this, "Eksperiment uspesno obrisan iz baze podataka! ");
        }else{
            JOptionPane.showMessageDialog(this, "Nije uspelo brisanje eksperimenta iz baze podataka! ");
        }
    }

    public void close() {
        JOptionPane.showMessageDialog(this, "Server zatvoren...");
        System.exit(0);
    }

    public void poruka(String poruka) {
        JOptionPane.showMessageDialog(this, "Poruka od servera: " + poruka);
        
    }
}