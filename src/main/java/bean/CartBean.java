package bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartBean implements Serializable
{
	  private String cid, pcode,pname,brand;
	  private int qty;
	  private double sprice;
		

	    public CartBean() {}

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

	        
	    public double getSprice() {
	        return sprice;
	    }

	    public void setSprice(double sprice) {
	        this.sprice = sprice;
	    }

		public String getCid() {
			return cid;
		}

		public void setCid(String cid) {
			this.cid = cid;
		}
}
