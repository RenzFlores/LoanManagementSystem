package com.ite012.dynamicgui;

public class TransactionEntryPanel extends javax.swing.JPanel {
    
    javax.swing.JPanel panelPadding = new javax.swing.JPanel();
    javax.swing.JPanel panelContent = new javax.swing.JPanel();
    javax.swing.JLabel dateTimeLabel = new javax.swing.JLabel();
    javax.swing.JLabel amountLabel = new javax.swing.JLabel();
    javax.swing.JLabel refIDLabel = new javax.swing.JLabel();
    javax.swing.JLabel statusLabel = new javax.swing.JLabel();

    public TransactionEntryPanel(String dateTime, String amount,
        String refID, String status) {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 60));
        setLayout(new java.awt.CardLayout(5, 5));
        
        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setPreferredSize(new java.awt.Dimension(900, 60));
        panelContent.setLayout(new java.awt.CardLayout(5, 5));

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setPreferredSize(new java.awt.Dimension(450, 60));
        panelContent.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        dateTimeLabel.setForeground(new java.awt.Color(0, 0, 0));
        dateTimeLabel.setText(dateTime);
        dateTimeLabel.setPreferredSize(new java.awt.Dimension(200, 16));
        panelContent.add(dateTimeLabel);
       
        insertSeparator();

        amountLabel.setForeground(new java.awt.Color(0, 0, 0));
        amountLabel.setText(amount);
        amountLabel.setPreferredSize(new java.awt.Dimension(210, 16));
        panelContent.add(amountLabel);
        
        insertSeparator();

        refIDLabel.setForeground(new java.awt.Color(0, 0, 0));
        refIDLabel.setText(refID);
        refIDLabel.setPreferredSize(new java.awt.Dimension(210, 16));
        panelContent.add(refIDLabel);
        
        insertSeparator();

        statusLabel.setBackground(new java.awt.Color(0, 255, 0));
        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(255, 255, 255));
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText(status);
        statusLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 0), 2, true), new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true)));
        statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        statusLabel.setOpaque(true);
        statusLabel.setPreferredSize(new java.awt.Dimension(70, 24));
        panelContent.add(statusLabel);

        add(panelContent, "card2");
    }
    
    private void insertSeparator() {
        javax.swing.JSeparator vertSeparator = new javax.swing.JSeparator();
        
        vertSeparator.setForeground(new java.awt.Color(204, 204, 204));
        vertSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        vertSeparator.setMinimumSize(new java.awt.Dimension(10, 100));
        vertSeparator.setPreferredSize(new java.awt.Dimension(5, 50));
        
        panelContent.add(vertSeparator);
    }
}
