/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fym.gui;
import com.fym.model.*;
import java.awt.Color;



/**
 *
 * @author v
 */
public class editAccount extends javax.swing.JFrame {
    private BudgetManager b;
    private String previousName;
    /**
     * Creates new form addAccount
     */
    public editAccount(BudgetManager b, String previousName) {
        this.previousName = previousName;
        this.b =b;
        initComponents();
        hideLabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameText = new javax.swing.JLabel();
        balanceText = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        balance = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        checkName = new javax.swing.JLabel();
        checkError = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nameText.setText("Name:");

        balanceText.setText("Balance:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        balance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        checkName.setText("Name exist");

        checkError.setText("Error type");

        error.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameText)
                    .addComponent(balanceText))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(balance))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkName)
                    .addComponent(checkError))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(error)
                .addGap(18, 18, 18)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameText)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkName)))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(balanceText)
                    .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkError))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton)
                    .addComponent(error))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        if(b.checkNameAccount(name.getText(),previousName) && checkNull() && checkError()){
            error.setVisible(false);
            b.editAccount(previousName, name.getText(), Float.parseFloat(balance.getText()));
            setVisible(false);
    }
        else{
            error.setVisible(true);
            clearText();
        }
        
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
        if(!b.checkNameAccount(name.getText(),previousName)){
            checkName.setVisible(true);
            addButton.setEnabled(false);
            addButton.setFocusable(false);
        }
        else{
            checkName.setVisible(false);
            if(checkNull()){
            addButton.setEnabled(true);
            addButton.setFocusable(true);
            }
            else{
                addButton.setEnabled(false);
                addButton.setFocusable(false);
            }
        }
            
        
            
    }//GEN-LAST:event_nameActionPerformed

    private void balanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceActionPerformed
        // TODO add your handling code here:
        if(checkNull() && checkError()){
            addButton.setEnabled(true);
            addButton.setFocusable(true);
            checkError.setVisible(false);
            }
        else{
            if(!checkError())
                checkError.setVisible(true);
            else
                checkError.setVisible(false);
            addButton.setEnabled(false);
            addButton.setFocusable(false);
        }
    }//GEN-LAST:event_balanceActionPerformed
    private void hideLabel(){
        addButton.setEnabled(false);
        addButton.setFocusable(false);
        checkName.setVisible(false);
        checkName.setForeground(Color.RED);
        checkError.setVisible(false);
        checkError.setForeground(Color.RED);
        error.setVisible(false);
        error.setForeground(Color.RED);
    }
    private boolean checkNull(){
        if(name.getText().equals(""))
            return false;
        if(balance.getText().equals(""))
            return false;
        return true;
    }
    private boolean checkError(){
        return b.isFloat(balance.getText());
    }
    private void clearText(){
        name.setText("");
        balance.setText("");
    }
    public javax.swing.JTextField getTextName(){
        return name;
    }
    public javax.swing.JTextField getTextBalance(){
        return balance;
    }
    


    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField balance;
    private javax.swing.JLabel balanceText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel checkError;
    private javax.swing.JLabel checkName;
    private javax.swing.JLabel error;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameText;
    // End of variables declaration//GEN-END:variables
}
