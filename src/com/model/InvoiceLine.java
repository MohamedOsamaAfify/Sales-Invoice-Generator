package com.model;

public class InvoiceLine {
    //Attributes
    private String itemName;
    private double itemPrice;
    private int itemCount;
    private InvoiceHeader header;

    //Constructor
    public InvoiceLine(String itemName, double itemPrice, int itemCount, InvoiceHeader header)
    {
        this.itemName = itemName;
        this.itemCount = itemCount;
        this.itemPrice = itemPrice;
        this.header = header;
    }

    //Methods
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getItemCount() {
        return itemCount;
    }
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public InvoiceHeader getHeader() {return header;}
    public void setHeader(InvoiceHeader header) {this.header = header;}

    @Override
    public String toString() {
        return "InvoiceLine(" + "Item Name=" + itemName + ", Item Price=" + itemPrice +
                ", Item Count=" + itemCount + ')';
    }
    public double getLineTotal() {
        return itemCount * itemPrice;
    }
    public String getDataAsCSV() {
        return "" + getHeader().getInvoiceNumber() + "," + getItemName() + "," +
                getItemPrice() + "," + getItemCount();
    }
}
