import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Sell {

	public void exportAdd(String information) {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String date=sdf.format(c1.getTime());
		String[] info=information.split(";");
		String client=info[0];
		String name=info[1];
		String mode=info[2];
		int num=Integer.parseInt(info[3]);
		double averagePrice=Double.parseDouble(info[4]);
//创建单子		
		ExportEntry ee=new ExportEntry();
		ee.setDate(date);
		ee.setClient(client);
		ee.setName(name);
		ee.setMode(mode);
		ee.setAP(averagePrice);
		ee.setNum(num);
		ee.setStatus("ADD");
		ee.setTP(num*averagePrice);
		PSIControl.exportList.add(ee);
//修改库存
		for(StockEntry se:PSIControl.stockList){
			if(se.getMode().equals(mode)){
				se.setOutNum(se.getOutNum()+num);
				se.setTOP(se.getTOP()+num*averagePrice);

				se.setNIS(se.getNIS()-num);
				se.setTPIS(se.getAIP()*se.getNIS());

			}
		}
//修改商品信息
		for(Commodity com:PSIControl.commodityList){
			if(com.getMode().equals(mode)){
				com.setNum(com.getNum()-num);
				com.setLOP(averagePrice);
			}
		}
//修改客户信息
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(client)){
				cus.setDueIn(cus.getDueIn()+ee.getTP());
				cus.setTotal(cus.getDueIn()-cus.getDueOut());
			}
		}
//修改账目应收总额
		PSIControl.accounter.setTDI(PSIControl.accounter.getTDI()+num*averagePrice);
	}

	public void exportDel(String information) {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String date=sdf.format(c1.getTime());
		String[] info=information.split(";");
		String client=info[0];
		String name=info[1];
		String mode=info[2];
		int num=Integer.parseInt(info[3]);
		double averagePrice=Double.parseDouble(info[4]);
//创建单子		
		ExportEntry ee=new ExportEntry();
		ee.setDate(date);
		ee.setClient(client);
		ee.setName(name);
		ee.setMode(mode);
		ee.setAP(averagePrice);
		ee.setNum(num);
		ee.setTP(num*averagePrice);
		ee.setStatus("DEL");
		PSIControl.exportList.add(ee);
//修改库存
		for(StockEntry se:PSIControl.stockList){
			if(se.getMode().equals(mode)){
				se.setOutNum(se.getOutNum()-num);
				se.setTOP(se.getTOP()-num*averagePrice);

				se.setNIS(se.getNIS()+num);
				se.setTPIS(se.getNIS()*se.getAPIS());

					}
				}
//修改商品信息
		for(Commodity com:PSIControl.commodityList){
			if(com.getMode().equals(mode)){
				com.setNum(com.getNum()-num);
				for(int i=PSIControl.importList.size()-1;i>=0;i--){
					ImportEntry iet=PSIControl.importList.get(i);
					if(iet.getStatus().equals("ADD")&&iet.getMode().equals(ee.getMode())&&(!(iet.getDate().equals(ee.getDate()))||!iet.getClient().equals(ee.getClient())||iet.getNum()!=ee.getNum()||iet.getAP()!=ee.getAP())){
						com.setLIP(iet.getAP());
						break;
					}else{
						com.setLIP(0);
					}
				}

				
					}
				}
//修改客户信息
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(client)){
				cus.setDueIn(cus.getDueIn()-ee.getTP());
				cus.setTotal(cus.getTotal()-cus.getDueIn());
					}
				}	
//修改账户应收总额
		PSIControl.accounter.setTDI(PSIControl.accounter.getTDI()+num*averagePrice);
		
	}

	public void shoExportEntry(String information) throws ParseException {
		String[] info=information.split(";");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String date1=info[0];
		String date2=info[1];
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));
		
		for(ExportEntry ee:PSIControl.exportList){
			String date=ee.getDate();
			Calendar c0=Calendar.getInstance();
			c0.setTime(sdf.parse(date));
				if(c0.after(c1)&&c0.before(c2)||c0.equals(c1)||c0.equals(c2)){
					String status=ee.getStatus();
					String client=ee.getClient();
					String name=ee.getName();
					String mode=ee.getMode();
					int num=ee.getNum();
					double averagePrice=ee.getAP();
					double totalPrice=ee.getTP();
					System.out.println(date+":"+status+":"+";"+client+name+";"+mode+";"+num+";"+averagePrice+";"+totalPrice);
				}
			}
	
		
	}

}
