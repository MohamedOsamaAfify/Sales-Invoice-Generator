package com.view;

import javax.swing.*;
import java.awt.*;

public class InvoiceLineDialog extends JDialog {
    //Attributes
    private JTextField itemNameField;
    private JTextField itemCountField;
    private JTextField itemPriceField;
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton okButton;
    private JButton cancelButton;

    //Constructor
    public InvoiceLineDialog(InvoiceFrame frame)
    {
        itemNameLabel = new JLabel("Item Name:");
        itemNameField = new JTextField(30);

        itemCountLabel = new JLabel("Item Count");
        itemCountField = new JTextField(30);

        itemPriceLabel = new JLabel("Item Price");
        itemPriceField = new JTextField(30);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("Do Line Creation");
        cancelButton.setActionCommand("Cancel Line Creation");

        okButton.addActionListener(frame.getListener());
        cancelButton.addActionListener(frame.getListener());

        setLayout(new GridLayout(4,2));   // 4 2
        add(itemNameLabel);
        add(itemNameField);
        add(itemCountLabel);
        add(itemCountField);
        add(itemPriceLabel);
        add(itemPriceField);
        add(okButton);
        add(cancelButton);
        pack();
    }

    //getters of item name count price
    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }
}
