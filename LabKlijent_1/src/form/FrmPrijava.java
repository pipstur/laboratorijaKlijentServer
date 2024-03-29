/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import domain.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logic.Controller;
import threads.Klijent;

/**
 *
 * @author vojislav
 */
public class FrmPrijava extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrijava
     */
    Klijent klijent;
    public FrmPrijava() {
       initComponents();
        try { 
            
            Controller.getInstance().setFrmPrijava(this);
            Klijent klijent = new Klijent(Controller.getInstance().socket);
            this.klijent = klijent;
            klijent.start();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Nemoguce uspostaviti konekciju sa serverom!");
            System.exit(0);
        }
       txtPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the authentication method when "Enter" is pressed
                
                prijava();
            }
        });
       addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            try {
                Controller.getInstance().cancelPrijava();
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

        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();
        txtPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Korisničko ime:");

        jLabel2.setText("Šifra:");

        btnPrijava.setText("Prijava");
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(btnPrijava, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnPrijava)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
        prijava();
    }//GEN-LAST:event_btnPrijavaActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
       
    }//GEN-LAST:event_txtPasswordActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
    private void prijava(){
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        
        User user = new User(username, password);
        
        try {
            
            Controller.getInstance().login(user);
        
        } catch (Exception ex) {
            Logger.getLogger(FrmPrijava.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    public void autentifikacija(User loginovan, Exception ex) throws Exception{
            if(loginovan!=null){
            String informacije = "Ime: "+loginovan.getIme()+"\nPrezime: "+loginovan.getPrezime()+"\nTip korisnika: "+loginovan.getTip();
                
            JOptionPane.showMessageDialog(this, informacije, "User Information", JOptionPane.INFORMATION_MESSAGE);
            if(loginovan.getTip().equals("laborant")){
                JFrame frmLaborant = new FrmLaborant(loginovan);
                frmLaborant.setVisible(true);
                Controller.getInstance().setFrmPrijava(null);
                dispose();
            }
            else if(loginovan.getTip().equals("nadlezni")){
                JFrame frmNadlezni = new FrmNadlezni(loginovan);
                frmNadlezni.setVisible(true);
                Controller.getInstance().setFrmPrijava(null);
                dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Admine ne treba ovde da se prijavljujete!");
            }
        }else{
            if(ex!=null) JOptionPane.showMessageDialog(this, ex);
            else JOptionPane.showMessageDialog(this, "Pogrešno korisničko ime ili šifra.");
        }
    }
    public void exit(){
        System.exit(0);
    }

}
