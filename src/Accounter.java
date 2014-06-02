import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Accounter {
	private double totalDueIn;
	private double totalDueOut;
	private double totalAmount;
	
//setter
	public void setTDI(double TDI){
		this.totalDueIn=TDI;
	}
	public void setTDO(double TDO){
		this.totalDueOut=TDO;
	}
	public void setTA(double TA){
		this.totalAmount=TA;
	}
	
//getter
	public double getTDI(){
		return totalDueIn;
	}
	public double getTDO(){
		return totalDueOut;
	}
	public double getTA(){
		return totalAmount;
	}
	public void inAccountEntry(String information) {
		String[] info=information.split(";");
		String client=info[0];
		double amount=Double.parseDouble(info[1]);
		
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date=sdf.format(c1.getTime());
//创建收款单
		AccountEntry ae=new AccountEntry();
		ae.setDate(date);
		ae.setClient(client);
		ae.setAmount(amount);
		ae.setStatus("ACCOUNT_IN");
		PSIControl.accountList.add(ae);
//修改客户信息
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(client)){
				cus.setDueIn(cus.getDueIn()-amount);
				cus.setTotal(cus.getDueIn()-cus.getDueOut());
				break;
			}
		}
//修改公司账目
		setTDI(getTDI()-amount);
		setTA(getTA()+amount);
	}
	public void outAccountEntry(String information) {
		String[] info=information.split(";");
		String client=info[0];
		double amount=Double.parseDouble(info[1]);
		
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String date=sdf.format(c1.getTime());
//创建收款单
		AccountEntry ae=new AccountEntry();
		ae.setDate(date);
		ae.setClient(client);
		ae.setAmount(amount);
		ae.setStatus("ACCOUNT_OUT");
		PSIControl.accountList.add(ae);
//修改客户信息
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(client)){
				cus.setDueOut(cus.getDueOut()-amount);
				break;
			}
		}
//修改公司账目
		setTDO(getTDO()-amount);
		setTA(getTA()-amount);
	}
	public void allAccount() {
		System.out.println(totalAmount+";"+totalDueIn+";"+totalDueOut);
	}
	public void detAccountEntry() {
		for(AccountEntry ae:PSIControl.accountList){
			String date=ae.getDate();
			String status=ae.getStatus();
			String client=ae.getClient();
			double amount=ae.getAmount();
			System.out.println(date+";"+status+";"+client+";"+amount);
		}
		
	}
	public void iniAccount(String information) {
		totalAmount=Double.parseDouble(information);
		
	}
	
}
