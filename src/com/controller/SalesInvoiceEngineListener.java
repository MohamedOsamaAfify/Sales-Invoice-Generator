package com.controller;

import com.model.InvoiceHeader;
import com.model.InvoiceHeaderTableModel;
import com.model.InvoiceLine;
import com.model.InvoiceLineTableModel;
import com.view.InvoiceFrame;
import com.view.InvoiceHeaderDialog;
import com.view.InvoiceLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class SalesInvoiceEngineListener implements ActionListener, ListSelectionListener {
    //Attributes
    private InvoiceFrame frame;
    private DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");

    //Constructor
    public SalesInvoiceEngineListener(InvoiceFrame frame)
    {
        this.frame = frame;
    }

    //Methods

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Create New Invoice":
                showNewInvoiceDialog();
                break;
            case "Delete Invoice":
                deleteCurrentInvoice();
                break;
            case "Create New Line":
                showNewLineDialog();
                break;
            case "Delete Line":
                deleteCurrentLine();
                break;
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
            case "Cancel invoice Creation":
                cancelInvoiceCreation();
                break;
            case "Do Invoice Creation":
                doInvoiceCreation();
                break;
            case "Do Line Creation" :
                doLineCreation();
                break;
            case "Cancel Line Creation":
                cancelLineCreation();
                break;
        }
    }
    private void loadFile()
    {
        JOptionPane.showMessageDialog(frame, "Please, select header file!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try {
                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader(headerFr);
                String headerLine = null;

                while ((headerLine = headerBr.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invNumStr = headerParts[0];
                    String invDateStr = headerParts[1];
                    String custName = headerParts[2];

                    int invNum = Integer.parseInt(invNumStr);
                    Date invDate = dateFormat.parse(invDateStr);

                    InvoiceHeader inv = new InvoiceHeader(invNum, custName, invDate);
                    frame.getInvoiceList().add(inv);
                }

                JOptionPane.showMessageDialog(frame, "Please, select lines file!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invNumStr = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];

                        int invNum = Integer.parseInt(invNumStr);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        int itemCount = Integer.parseInt(itemCountStr);
                        InvoiceHeader header = findInvoiceByNum(invNum);
                        InvoiceLine invLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invLine);
                    }
                    frame.setInvoiceHeaderTableModel(new InvoiceHeaderTableModel(frame.getInvoiceList()));
                    frame.getInvoiceTable().setModel(frame.getInvoiceHeaderTableModel());
                    frame.getInvoiceTable().validate();
                }
                System.out.println("Check");
            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Date Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Number Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "File Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Read Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        showInvoice();
    }
    private void saveFile()
    {
        String headers = "";
        String lines = "";
        for (InvoiceHeader header : frame.getInvoiceList()) {
            headers += header.getDataAsCSV();
            headers += "\n";
            for (InvoiceLine line : header.getLines()) {
                lines += line.getDataAsCSV();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(frame, "Please, select file to save header data!", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter hFW = new FileWriter(headerFile);
                hFW.write(headers);
                hFW.flush();
                hFW.close();

                JOptionPane.showMessageDialog(frame, "Please, select file to save lines data!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter lFW = new FileWriter(linesFile);
                    lFW.write(lines);
                    lFW.flush();
                    lFW.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(frame, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
    private void showNewInvoiceDialog()
    {
        frame.setHeaderDialog(new InvoiceHeaderDialog(frame));
        frame.getHeaderDialog().setVisible(true);
    }
    private void showNewLineDialog()
    {
        frame.setLineDialog(new InvoiceLineDialog(frame));
        frame.getLineDialog().setVisible(true);
    }
    private void cancelInvoiceCreation()
    {
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }
    private void doInvoiceCreation()
    {
        String custName = frame.getHeaderDialog().getCustNameField().getText();
        String invDateStr = frame.getHeaderDialog().getInvDateField().getText();
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
        try {
            Date invDate = dateFormat.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            InvoiceHeader invoiceHeader = new InvoiceHeader(invNum, custName, invDate);
            frame.getInvoiceList().add(invoiceHeader);
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        showInvoice();
    }
    private void doLineCreation()
    {
        String itemName = frame.getLineDialog().getItemNameField().getText();
        String itemCountStr = frame.getLineDialog().getItemCountField().getText();
        String itemPriceStr = frame.getLineDialog().getItemPriceField().getText();
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        int headerIndex = frame.getInvoiceTable().getSelectedRow();
        InvoiceHeader invoice = frame.getInvoiceHeaderTableModel().getInvoiceList().get(headerIndex);

        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
        invoice.addInvoiceLine(invoiceLine);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvoiceTotalLabel().setText("" + invoice.getInvoiceTotal());
        showInvoice();
    }
    private void cancelLineCreation()
    {
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
    }
    private void deleteCurrentInvoice()
    {
        int invIndex = frame.getInvoiceTable().getSelectedRow();
        InvoiceHeader header = frame.getInvoiceHeaderTableModel().getInvoiceList().get(invIndex);
        frame.getInvoiceHeaderTableModel().getInvoiceList().remove(invIndex);
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.setInvoiceLinesTableModel(new InvoiceLineTableModel(new ArrayList<InvoiceLine>()));
        frame.getInvoiceLineTable().setModel(frame.getInvoiceLinesTableModel());
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getCustomerNameTextField().setText("");
        frame.getInvoiceDateTextField().setText("");
        frame.getInvoiceNumberLabel().setText("");
        frame.getInvoiceTotalLabel().setText("");
        showInvoice();
    }
    private void deleteCurrentLine()
    {
        int lineIndex = frame.getInvoiceLineTable().getSelectedRow();
        InvoiceLine line = frame.getInvoiceLinesTableModel().getInvoiceLines().get(lineIndex);
        frame.getInvoiceLinesTableModel().getInvoiceLines().remove(lineIndex);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvoiceTotalLabel().setText("" + line.getHeader().getInvoiceTotal());
        showInvoice();
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        invoiceTableRowSelected();
    }
    private void invoiceTableRowSelected()
    {
        int selectedRowIndex = frame.getInvoiceTable().getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceHeader row = frame.getInvoiceHeaderTableModel().getInvoiceList().get(selectedRowIndex);
            frame.getCustomerNameTextField().setText(row.getCustomerName());
            frame.getInvoiceDateTextField().setText(dateFormat.format(row.getInvoiceDate()));
            frame.getInvoiceNumberLabel().setText("" + row.getInvoiceNumber());
            frame.getInvoiceTotalLabel().setText("" + row.getInvoiceTotal());
            ArrayList<InvoiceLine> lines = row.getLines();
            frame.setInvoiceLinesTableModel(new InvoiceLineTableModel(lines));
            frame.getInvoiceLineTable().setModel(frame.getInvoiceLinesTableModel());
            frame.getInvoiceLinesTableModel().fireTableDataChanged();
        }

    }
    private void showInvoice() {
        System.out.println("***************************");
        for (InvoiceHeader header : frame.getInvoiceList()) {
            System.out.println(header);
        }
        System.out.println("***************************");
    }
    private InvoiceHeader findInvoiceByNum(int invNum) {
        InvoiceHeader header = null;
        for (InvoiceHeader inv : frame.getInvoiceList()) {
            if (invNum == inv.getInvoiceNumber()) {
                header = inv;
                break;
            }
        }
        return header;
    }
    private int getNextInvoiceNum() {
        int max = 0;
        for (InvoiceHeader header : frame.getInvoiceList()) {
            if (header.getInvoiceNumber() > max) {
                max = header.getInvoiceNumber();
            }
        }
        return max + 1;
    }
}
