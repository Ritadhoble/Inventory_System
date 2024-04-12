package bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable
{
	private String cid,pWord,fName,lName,addr;
    private long phNo;
    public CustomerBean() {}
    
   	public String getpWord()
	{
		return pWord;
	}

	public void setpWord(String pWord) 
	{
		this.pWord = pWord;
	}

	public String getfName() 
	{
		return fName;
	}

	public void setfName(String fName) 
	{
		this.fName = fName;
	}

	public String getlName() 
	{
		return lName;
	}

	public void setlName(String lName) 
	{
		this.lName = lName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	public long getPhNo() {
		return phNo;
	}

	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
