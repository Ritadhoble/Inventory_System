package bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable
{
    private String pcode,pname,brand;
    private int qty;
    private float sprice,cprice;

    public ProductBean() {}

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getCprice() {
        return cprice;
    }


    public void setCprice(float cprice) { 
        this.cprice=cprice;
    }
        
    public float getSprice() {
        return sprice;
    }

    public void setSprice(float sprice) {
        this.sprice = sprice;
    }
}
