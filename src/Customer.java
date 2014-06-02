
public class Customer {
	private String name=null;
	private String phoneNum=null;
	private double dueIn=0;
	private double dueOut=0;
	private double total=0;
	
//setter
	public void setName(String name){
		this.name=name;
	}
	public void setPhoneNum(String num){
		this.phoneNum=num;
	}
	public void setDueIn(double DI){
		this.dueIn=DI;
	}
	public void setDueOut(double DO){
		this.dueOut=DO;
	}
	public void setTotal(double total){
		this.total=total;
	}
	
//getter
	public String getName(){
		return name;
	}
	public String getPhoneNum(){
		return phoneNum;
	}
	public double getDueIn(){
		return dueIn;
	}
	public double getDueOut(){
		return dueOut;
	}
	public double getTotal(){
		return total;
	}
}
