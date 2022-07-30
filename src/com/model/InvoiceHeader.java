package com.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceHeader {
    //Attributes
    private int invoiceNumber;
    private String customerName;
    private Date invoiceDate;
    private ArrayList<InvoiceLine> lines;

    //Constructor
    public InvoiceHeader(int invoiceNumber, String customerName, Date invoiceDate)
    {
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
    }

    //Methods
    public int getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Date getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String toString()
    {
        String string ="Invoice Header(" + "Invoice Number = " + invoiceNumber + " Customer Name:" + customerName
                + "Invoice Date: " + invoiceDate + ")";
        for (InvoiceLine line : getLines())
        {
            string += "\n" + line;
        }
        return string;
    }

    public ArrayList<InvoiceLine> getLines()
    {
        if (lines == null)
        {lines = new ArrayList<>();}
        return lines;
    }
    public void setLines(ArrayList<InvoiceLine> lines)
    {
        this.lines = lines;
    }
    public double getInvoiceTotal()
    {
        double result = 0.0;
        for(InvoiceLine line : getLines())
        {result += line.getLineTotal();}
        return result;
    }
    public void addInvoiceLine(InvoiceLine line)
    {
        getLines().add(line);
    }
    public String getDataAsCSV()
    {
        DateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
        return "" + getInvoiceNumber() + "," + dateFormat.format(getInvoiceDate()) + ","
                + getCustomerName();
    }
}

