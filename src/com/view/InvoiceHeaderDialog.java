package com.view;

import javax.swing.*;
import java.awt.*;

public class InvoiceHeaderDialog extends JDialog {
    //Attributes
    private JTextField customerNameField;
    private JTextField invoiceDateField;
    private JLabel customerNameLabel;
    private JLabel invoiceDateLabel;
    private JButton okButton;
    private JButton cancelButton;

    //Constructor
    public InvoiceHeaderDialog(InvoiceFrame frame)
    {
        customerNameLabel = new JLabel("Customer Name:");
        customerNameField = new JTextField(30);

        invoiceDateLabel = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(30);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        okButton.setActionCommand("Do Invoice Creation");
        cancelButton.setActionCommand("Cancel Invoice Creation");

        okButton.addActionListener(frame.getListener());
        cancelButton.addActionListener(frame.getListener());

        setLayout(new GridLayout(3,2));  // 3 2
        add(customerNameLabel);
        add(customerNameField);
        add(invoiceDateLabel);
        add(invoiceDateField);
        add(okButton);
        add(cancelButton);
        pack();
    }

    //getters of customer name and date
    public JTextField getCustNameField() {
        return customerNameField;
    }

    public JTextField getInvDateField() {
        return invoiceDateField;
    }


}
