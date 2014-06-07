import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class Purchase {
	public void importAdd(String information) {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String date=sdf.format(c1.getTime());
		String[] info=information.split(";");
		String client=info[0];
		String name=info[1];
		String mode=info[2];
		int num=Integer.parseInt(info[3]);
		double averagePrice=Double.parseDouble(info[4]);
//================Create Entry================		
		ImportEntry ie=new ImportEntry();
		ie.setDate(date);
		ie.setClient(client);
		ie.setName(name);
		ie.setMode(mode);
		ie.setAP(averagePrice);
		ie.setNum(num);
		ie.setStatus("ADD");
		ie.setTP(num*averagePrice);
		PSIControl.importList.add(ie);
//================Change Stock================
		for(StockEntry se:PSIControl.stockList){
			if(se.getMode().equals(mode)){
				se.setInNum(se.getInNum()+num);
				se.setTIP(se.getTIP()+num*averagePrice);
				se.setAIP(se.getTIP()/se.getInNum());
				se.setNIS(se.getNIS()+num);
				se.setTPIS(se.getTPIS()+ie.getTP());
				se.setAPIS((se.getTIP()-se.getTOP())/(se.getInNum()-se.getOutNum()));
			}
		}
//================Change Commodity================
		for(Commodity com:PSIControl.commodityList){
			if(com.getMode().equals(mode)){
				com.setNum(com.getNum()+num);
				com.setLIP(averagePrice);
			}
		}
//================Change Customer================
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(client)){
				cus.setDueOut(cus.getDueOut()+num*averagePrice);
				cus.setTotal(cus.getDueIn()-cus.getDueOut());
			
//================Change Account================
			}
		}
		PSIControl.accounter.setTDO(PSIControl.accounter.getTDO()+num*averagePrice);
		

	}
/**
 * 
 * DEL is an undo
 */
	public void importDel(String information) {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String date=sdf.format(c1.getTime());
		String[] info=information.split(";");
		String client=info[0];
		String name=info[1];
		String mode=info[2];
		int num=Integer.parseInt(info[3]);
		double averagePrice=Double.parseDouble(info[4]);
//================Create Entry================
		ImportEntry ie=new ImportEntry();
		ie.setDate(date);
		ie.setClient(client);
		ie.setName(name);
		ie.setMode(mode);
		ie.setAP(averagePrice);
		ie.setNum(num);
		ie.setTP(num*averagePrice);
		ie.setStatus("DEL");
		PSIControl.importList.add(ie);
//================Change stock================
		for(StockEntry se:PSIControl.stockList){
			if(se.getMode().equals(mode)){
				se.setInNum(se.getInNum()-num);
				se.setTIP(se.getTIP()-num*averagePrice);
				se.setAIP(se.getTIP()/se.getInNum());
				se.setNIS(se.getNIS()-num);
				se.setTPIS(se.getTPIS()-ie.getTP());
				se.setAPIS((se.getTIP()-se.getTOP())/(se.getInNum()-se.getOutNum()));
					}
				}
//================Change commodity================
		for(Commodity com:PSIControl.commodityList){
			if(com.getMode().equals(mode)){
				com.setNum(com.getNum()-num);
				for(int i=PSIControl.importList.size()-1;i>=0;i--){
					ImportEntry iet=PSIControl.importList.get(i);
					if(iet.getStatus().equals("ADD")&&iet.getMode().equals(ie.getMode())&&(!(iet.getDate().equals(ie.getDate()))||!iet.getClient().equals(ie.getClient())||iet.getNum()!=ie.getNum()||iet.getAP()!=ie.getAP())){
						com.setLIP(iet.getAP());
						break;
					}else{
						com.setLIP(0);
					}
				}

				
					}
				}
//================Change customer================
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(client)){
				cus.setDueOut(cus.getDueOut()-ie.getTP());
				cus.setTotal(cus.getTotal()-cus.getDueIn());
					}
				}
//================Change Account================
		PSIControl.accounter.setTDO(PSIControl.accounter.getTDO()-num*averagePrice);
		
	}
	
	public void shoImportEntry(String information) throws ParseException {
		String[] info=information.split(";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String date1=info[0];
		String date2=info[1];
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));
		
		for(ImportEntry ie:PSIControl.importList){
			String date=ie.getDate();
			Calendar c0=Calendar.getInstance();
			c0.setTime(sdf.parse(date));
				if(c0.after(c1)&&c0.before(c2)||c0.equals(c1)||c0.equals(c2)){
					String status=ie.getStatus();
					String client=ie.getClient();
					String name=ie.getName();
					String mode=ie.getMode();
					int num=ie.getNum();
					double averagePrice=ie.getAP();
					double totalPrice=ie.getTP();
					System.out.println(date+":"+status+":"+client+name+";"+mode+";"+num+";"+averagePrice+";"+totalPrice);
				}
			}
	
	}
}
