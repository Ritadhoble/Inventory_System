package bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdminBean implements Serializable
{
    private String uName,pWord,fName,lName,addr;
   
    public AdminBean() {}
    
    public String getuName(){
    	return uName;
    }
    public void setuName(String uName){
    	this.uName=uName;
    }

	public String getpWord(){
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
