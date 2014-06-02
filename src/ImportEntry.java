
public class ImportEntry {
	private String date;
	private String status;
	private String client;
	private String name;
	private String mode;
	private int num;
	private double averagePrice;
	private double totalPrice;
	
//setter
	public void setDate(String date){
		this.date=date;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public void setClient(String client){
		this.client=client;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setMode(String mode){
		this.mode=mode;
	}
	public void setNum(int num){
		this.num=num;
	}
	public void setAP(double AP){
		this.averagePrice=AP;
	}
	public void setTP(double TP){
		this.totalPrice=TP;
	}
	
//getter
	public String getDate(){
		return date;
	}
	public String getStatus(){
		return status;
	}
	public String getClient(){
		return client;
	}
	public String getName(){
		return name;
	}
	public String getMode(){
		return mode;
	}
	public int getNum(){
		return num;
	}
	public double getAP(){
		return averagePrice;
	}
	public double getTP(){
		return totalPrice;
	}
}
