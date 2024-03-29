/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;


import domain.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import threads.Server;

/**
 *
 * @author vojislav
 */
public class FrmServer extends javax.swing.JFrame {

    

    /**
     * Creates new form FrmServer
     */
    Server server;
    public FrmServer() {
        initComponents();
        server = new Server(this);
        btnIskljuci.setEnabled(false);
        txtKorisnici.setLineWrap(true);
        txtKorisnici.setWrapStyleWord(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
            server.stopServer();
            
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

        btnUkljuci = new javax.swing.JButton();
        btnIskljuci = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        lblServerTrenutno = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtKorisnici = new javax.swing.JTextArea();
        txtPoruka = new javax.swing.JTextField();
        btnProslediPoruku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUkljuci.setText("Ukljuci");
        btnUkljuci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkljuciActionPerformed(evt);
            }
        });

        btnIskljuci.setText("Iskljuci");
        btnIskljuci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIskljuciActionPerformed(evt);
            }
        });

        lblStatus.setText("Ne radi");

        lblServerTrenutno.setText("Server trenutno:");

        jLabel1.setText("Lista prijavljenih korisnika");

        txtKorisnici.setColumns(20);
        txtKorisnici.setRows(5);
        jScrollPane2.setViewportView(txtKorisnici);

        btnProslediPoruku.setText("Prosledi poruku");
        btnProslediPoruku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProslediPorukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProslediPoruku))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 167, Short.MAX_VALUE)
                        .addComponent(lblServerTrenutno)
                        .addGap(35, 35, 35)
                        .addComponent(lblStatus)
                        .addGap(67, 67, 67)
                        .addComponent(btnUkljuci))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIskljuci)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUkljuci)
                            .addComponent(lblStatus)
                            .addComponent(lblServerTrenutno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIskljuci)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProslediPoruku))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUkljuciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkljuciActionPerformed
        // TODO add your handling code here:
        
        if(server==null||!server.isAlive()){
            server = new Server(this);
            server.start();
            btnIskljuci.setEnabled(true);
            btnUkljuci.setEnabled(false);
            lblStatus.setText("Ukljucen");
        }
        
    }//GEN-LAST:event_btnUkljuciActionPerformed

    private void btnIskljuciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIskljuciActionPerformed
        // TODO add your handling code here:
        if(server.isAlive()){
            try {
                server.stopServer();
                server = null;
                lblStatus.setText("Iskljucen");
                btnUkljuci.setEnabled(true);
                btnIskljuci.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(FrmServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FrmServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnIskljuciActionPerformed

    private void btnProslediPorukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProslediPorukuActionPerformed
        String poruka = txtPoruka.getText();
        if(!poruka.isEmpty()){
            try {
                server.proslediPoruku(poruka);
            } catch (Exception ex) {
                System.out.println("Greska u slanju");
            }
        }
    }//GEN-LAST:event_btnProslediPorukuActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIskljuci;
    private javax.swing.JButton btnProslediPoruku;
    private javax.swing.JButton btnUkljuci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblServerTrenutno;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextArea txtKorisnici;
    private javax.swing.JTextField txtPoruka;
    // End of variables declaration//GEN-END:variables
    public void updateUsers(List<User> korisnici) {
        txtKorisnici.setText("");
        for(User korisnik : korisnici){
            txtKorisnici.append(korisnik+"\n");
        }
        
        
    }
    public void greska(Exception ex){
        JOptionPane.showMessageDialog(this, ex);
    }
}
