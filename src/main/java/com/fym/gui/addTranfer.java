/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fym.gui;

import com.fym.model.Account;
import java.util.HashMap;
import java.util.UUID;
import com.fym.model.*;
import java.time.ZoneId;


/**
 *
 * @author v
 */
public class addTranfer extends javax.swing.JPanel {
    private BudgetManager b;

    /**
     * Creates new form addTranfer
     */
    public addTranfer(BudgetManager b) {
        this.b =b;
        initComponents();
        showComboFrom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fromText = new javax.swing.JLabel();
        toText = new javax.swing.JLabel();
        amountText = new javax.swing.JLabel();
        dateTimeText = new javax.swing.JLabel();
        noteText = new javax.swing.JLabel();
        from = new javax.swing.JComboBox<>();
        to = new javax.swing.JComboBox<>();
        amount = new javax.swing.JTextField();
        dateTime = new com.toedter.calendar.JDateChooser();
        note = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        addNewFrom = new javax.swing.JButton();
        resetFrom = new javax.swing.JButton();

        fromText.setText("From:");

        toText.setText("To:");

        amountText.setText("Amount:");

        dateTimeText.setText("Date Time:");

        noteText.setText("Note:");

        from.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromActionPerformed(evt);
            }
        });

        note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteActionPerformed(evt);
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

        addNewFrom.setText("New");
        addNewFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewFromActionPerformed(evt);
            }
        });

        resetFrom.setText("O");
        resetFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFromActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromText)
                    .addComponent(toText)
                    .addComponent(amountText)
                    .addComponent(dateTimeText)
                    .addComponent(noteText))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(from, javax.swing.GroupLayout.Alignment.LEADING, 0, 93, Short.MAX_VALUE)
                            .addComponent(to, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dateTime, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(amount, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetFrom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addNewFrom)))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromText)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addNewFrom)
                        .addComponent(resetFrom)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toText)
                    .addComponent(to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountText)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateTimeText)
                    .addComponent(dateTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noteText)
                    .addComponent(note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noteActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:    
        clearText();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void fromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromActionPerformed
        // TODO add your handling code here:
        Account p = b.getAccounts().get((String)from.getSelectedItem());
        showComboTo(p);
        
    }//GEN-LAST:event_fromActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        b.addTranfer(b.getAccounts().get((String)from.getSelectedItem()),b.getAccounts().get((String)to.getSelectedItem()), Float.parseFloat(amount.getText()), note.getText(), true, dateTime.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        clearText();
    }//GEN-LAST:event_addButtonActionPerformed

    private void resetFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFromActionPerformed
        // TODO add your handling code here:
        showComboFrom();
    }//GEN-LAST:event_resetFromActionPerformed

    private void addNewFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewFromActionPerformed
        // TODO add your handling code here:
        addAccount addAccount = new addAccount(b);
        addAccount.setVisible(true);
    }//GEN-LAST:event_addNewFromActionPerformed

    private void showComboFrom(){
        from.removeAllItems();
        HashMap<String,Account> data = b.getAccounts();
        for(Account c: data.values()){
            from.addItem(c.getName());
        }
        
    }
    private void showComboTo(Account p){
        to.removeAllItems();
        HashMap<String,Account> data = b.getAccounts();
        for(Account c: data.values()){
            if(c.equals(p))
                continue;
            to.addItem(c.getName());
        }
        
    }
    private void clearText(){
        amount.setText(null);
        dateTime.setDate(null);
        note.setText(null);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addNewFrom;
    private javax.swing.JTextField amount;
    private javax.swing.JLabel amountText;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateTime;
    private javax.swing.JLabel dateTimeText;
    private javax.swing.JComboBox<String> from;
    private javax.swing.JLabel fromText;
    private javax.swing.JTextField note;
    private javax.swing.JLabel noteText;
    private javax.swing.JButton resetFrom;
    private javax.swing.JComboBox<String> to;
    private javax.swing.JLabel toText;
    // End of variables declaration//GEN-END:variables
}

