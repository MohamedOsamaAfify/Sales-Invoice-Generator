package com.view;
import com.model.InvoiceHeader;
import com.model.InvoiceLine;
import javax.swing.*;
import com.model.InvoiceHeader;
import com.model.InvoiceHeaderTableModel;
import com.model.InvoiceLineTableModel;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.controller.SalesInvoiceEngineListener;


public class InvoiceFrame extends javax.swing.JFrame{
    //Attributes
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton createLineButton;
    private javax.swing.JTextField customerNameTextField;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JTextField invoiceDateTextField;
    private javax.swing.JTable invoiceLineTable;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;

    private List<InvoiceHeader> invoiceList = new ArrayList<>();
    private InvoiceHeaderTableModel invoiceHeaderTableModel;
    private InvoiceLineTableModel invoiceLineTableModel;
    private InvoiceHeaderDialog headerDialog;
    private InvoiceLineDialog lineDialog;
    private SalesInvoiceEngineListener listener = new SalesInvoiceEngineListener(this);

    //Constructor
    public InvoiceFrame()
    {
        initializeComponents();
    }

    //Methods
    private void initializeComponents()
    {
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(listener);
        createInvoiceButton = new javax.swing.JButton();
        createInvoiceButton.addActionListener(listener);
        deleteInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton.addActionListener(listener);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerNameTextField = new javax.swing.JTextField();
        invoiceDateTextField = new javax.swing.JTextField();
        invoiceNumberLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoiceLineTable = new javax.swing.JTable();
        createLineButton = new javax.swing.JButton();
        createLineButton.addActionListener(listener);
        deleteLineButton = new javax.swing.JButton();
        deleteLineButton.addActionListener(listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(listener);
        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(listener);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        jScrollPane1.setViewportView(invoiceTable);

        createInvoiceButton.setText("Create New Invoice");
        createInvoiceButton.setActionCommand("CreateNewInvoice");

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.setActionCommand("DeleteInvoice");

        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer name");

        jLabel4.setText("Invoice Total");

        invoiceLineTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        jScrollPane2.setViewportView(invoiceLineTable);

        createLineButton.setText("Create New Line");
        createLineButton.setActionCommand("CreateNewLine");

        deleteLineButton.setText("Delete Line");
        deleteLineButton.setActionCommand("DeleteLine");

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel3)
                                                                                        .addComponent(jLabel1)
                                                                                        .addComponent(jLabel2)
                                                                                        .addComponent(jLabel4))
                                                                                .addGap(18, 18, 18)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(customerNameTextField)
                                                                                        .addComponent(invoiceDateTextField)
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(invoiceNumberLabel)
                                                                                                        .addComponent(invoiceTotalLabel))
                                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(76, 76, 76)
                                                                .addComponent(createLineButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(deleteLineButton)
                                                                .addGap(113, 113, 113))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(createInvoiceButton)
                                                .addGap(87, 87, 87)
                                                .addComponent(deleteInvoiceButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(invoiceNumberLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(invoiceDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(customerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(invoiceTotalLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(createLineButton)
                                                        .addComponent(deleteLineButton))
                                                .addGap(44, 44, 44)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteInvoiceButton)
                                        .addComponent(createInvoiceButton))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public SalesInvoiceEngineListener getListener() {
        return listener;
    }

    public void setHeaderDialog(InvoiceHeaderDialog headerDialog) {
        this.headerDialog = headerDialog;
    }

    public void setLineDialog(InvoiceLineDialog lineDialog) {
        this.lineDialog = lineDialog;
    }

    public void setInvoiceHeaderTableModel(InvoiceHeaderTableModel invoiceHeaderTableModel) {
        this.invoiceHeaderTableModel = invoiceHeaderTableModel;
    }

    public void setInvoiceLinesTableModel(InvoiceLineTableModel invoiceLinesTableModel) {
        this.invoiceLineTableModel = invoiceLineTableModel;
    }

    public JButton getCreateInvoiceButton() {
        return createInvoiceButton;
    }

    public JButton getCreateLineButton() {
        return createLineButton;
    }

    public JTextField getCustomerNameTextField() {
        return customerNameTextField;
    }

    public JButton getDeleteInvoiceButton() {
        return deleteInvoiceButton;
    }

    public JButton getDeleteLineButton() {
        return deleteLineButton;
    }

    public JTextField getInvoiceDateTextField() {
        return invoiceDateTextField;
    }

    public JTable getInvoiceLineTable() {
        return invoiceLineTable;
    }

    public JLabel getInvoiceNumberLabel() {
        return invoiceNumberLabel;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public JMenuItem getLoadMenuItem() {
        return loadMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public List<InvoiceHeader> getInvoiceList() {
        return invoiceList;
    }

    public InvoiceHeaderTableModel getInvoiceHeaderTableModel() {
        return invoiceHeaderTableModel;
    }

    public InvoiceLineTableModel getInvoiceLinesTableModel() {
        return invoiceLineTableModel;
    }

    public InvoiceHeaderDialog getHeaderDialog() {
        return headerDialog;
    }

    public InvoiceLineDialog getLineDialog() {
        return lineDialog;
    }
}

