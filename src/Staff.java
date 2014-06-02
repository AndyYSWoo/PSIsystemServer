
public class Staff {
	private String name=null;
	private String password=null;
	
	public void setName(String name){
		this.name=name;
	}
	public void setPassword(String pw){
		this.password=pw;
	}
	public String getName(){
		return this.name;
	}
	public String getPassword(){
		return this.password;
	}

}
class FinancialStaff extends Staff{
	
}
class SalesStaff extends Staff{
	
}
class StockStaff extends Staff{
	
}