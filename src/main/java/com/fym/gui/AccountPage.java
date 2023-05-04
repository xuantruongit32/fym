/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fym.gui;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import com.fym.model.*;
import java.util.HashMap;
import java.util.UUID;
import java.time.LocalDate;


/**
 *
 * @author v
 */
public class AccountPage extends javax.swing.JPanel {
    private BudgetManager b;
    /**
     * Creates new form AccountPage
     */
    public AccountPage(BudgetManager b) {
        this.b =b;
        initComponents();
        showComboAccount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        accountTree = new javax.swing.JTree();
        account = new javax.swing.JComboBox<>();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        resetAccount = new javax.swing.JButton();
        time = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(accountTree);

        account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        resetAccount.setText("O");
        resetAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetAccountActionPerformed(evt);
            }
        });

        time.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daily", "Weekly", "Monthly", "Yearly", "All" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(resetAccount)
                        .addGap(18, 18, 18)
                        .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(addButton)))))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetAccount)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void accountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountActionPerformed
        // TODO add your handling code here:
        System.out.println((String) time.getSelectedItem());
        if(account.getSelectedIndex() != -1)
            createTree(b.getAccounts().get(UUID.fromString((String)account.getSelectedItem())),(String) time.getSelectedItem());


    }//GEN-LAST:event_accountActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int i = account.getSelectedIndex();
        String s = (String)account.getSelectedItem();
        account.setSelectedIndex(-1);
        b.removeAccount(s);
        showComboAccount();

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        addAccount addAccount = new addAccount(b);
        addAccount.setVisible(true);

    }//GEN-LAST:event_addButtonActionPerformed

    private void resetAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetAccountActionPerformed
        // TODO add your handling code here:
        showComboAccount();
    }//GEN-LAST:event_resetAccountActionPerformed

private void createTree(Account a, String time){
    DefaultMutableTreeNode name = new DefaultMutableTreeNode("Name: "+a.getName());
    DefaultMutableTreeNode balance = new DefaultMutableTreeNode("Balance:       " + String.valueOf(a.getBalance()));
    DefaultMutableTreeNode UUID = new DefaultMutableTreeNode ("ID: " + String.valueOf(a.getID()));
    String totalIncome;
    String totalExpense;
    if(time.equals("Daily")){
        totalIncome = String.valueOf(b.totalIncomeDaily(LocalDate.now(),a));
        totalExpense = String.valueOf(b.totalExpenseDaily(LocalDate.now(),a));

    }
    else if (time.equals("Weekly")){
        totalIncome = String.valueOf(b.totalIncomeWeekly(LocalDate.now(),a));  
        totalExpense = String.valueOf(b.totalExpenseWeekly(LocalDate.now(),a));
    }
    else if (time.equals("Yearly")){
        totalIncome = String.valueOf(b.totalIncomeYearly(LocalDate.now(),a));
        totalExpense = String.valueOf(b.totalExpenseYearly(LocalDate.now(),a));
    }
    else {
        totalIncome = String.valueOf(b.totalIncomeAll(a));
        totalExpense = String.valueOf(b.totalExpenseAll(a));
    }
    DefaultMutableTreeNode totalIncomeNode = new DefaultMutableTreeNode("Total Income:  "+ totalIncome);
    DefaultMutableTreeNode totalExpenseNode = new DefaultMutableTreeNode("Total Expense:  "+ totalExpense);

    name.add(balance);
    name.add(UUID);
    name.add(totalIncomeNode);
    name.add(totalExpenseNode);
    JTree tree = new JTree(name);
    accountTree.setModel(new DefaultTreeModel(name));   
}
private void showComboAccount(){
        account.removeAllItems();
        HashMap<UUID,Account> data = b.getAccounts();
        for(Account c: data.values()){
            account.addItem(c.getID().toString());
        }

        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> account;
    private javax.swing.JTree accountTree;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetAccount;
    private javax.swing.JComboBox<String> time;
    // End of variables declaration//GEN-END:variables
}
