
public class AccountEntry {
	private String date;
	private String status;
	private String client;
	private double amount;

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
	public void setAmount(double amount){
		this.amount=amount;
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
	public double getAmount(){
		return amount;
	}
}
