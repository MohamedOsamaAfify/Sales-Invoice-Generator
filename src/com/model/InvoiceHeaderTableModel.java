package com.model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceHeaderTableModel extends AbstractTableModel {
    //Attributes
    private List<InvoiceHeader> invoiceList;
    private DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");

    //Construtor
    public InvoiceHeaderTableModel(List<InvoiceHeader> invoiceList)
    {
        this.invoiceList = invoiceList;
    }

    //Methods
    public List<InvoiceHeader> getInvoiceList() {
        return invoiceList;
    }
    @Override
    public int getRowCount() {
        return invoiceList.size();
    }
    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader row = invoiceList.get(rowIndex);
        switch (columnIndex){
            case 0 :
                return row.getInvoiceNumber();
            case 1 :
                return row.getCustomerName();
            case 2 :
                return dateFormat.format(row.getInvoiceDate());
            case 3 :
                return row.getInvoiceTotal();
            default:
                return "";
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Invoice Num";
            case 1:
                return "Customer Name";
            case 2:
                return "Invoice Date";
            case 3:
                return "Invoice Total";
            default:
                return "";
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Double.class;
            default:
                return Object.class;
        }
    }
}

