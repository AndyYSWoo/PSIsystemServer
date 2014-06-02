
public class Stock {

	public void addItem(String information) {
		String info[] = information.split(";");
		StockEntry se=new StockEntry();
		String name=info[0];
		String mode=info[1];
		
		se.setName(name);
		se.setMode(mode);
		PSIControl.stockList.add(se);
		
	}

	public void delItem(String information) {
		String[] info=information.split(";");
		//String name=info[0];
		String mode=info[1];
		for(StockEntry se:PSIControl.stockList){
			if(se.getMode().equals(mode)){
				PSIControl.stockList.remove(se);
				break;
			}
		}
		
	}

	public void shoStockEntry() {
		for(StockEntry se:PSIControl.stockList){
			String name=se.getName();
			String mode=se.getMode();
			
			int inNum=se.getInNum();
			double aip=se.getAIP();
			double tip=se.getTIP();

			
			int outNum=se.getOutNum();
			double op=se.getOutPrice();
			double top=se.getTOP();
			int nis=se.getNIS();
			double apis=se.getAPIS();
			double tpis=se.getTPIS();
			
			System.out.println(name+";"+mode+";"+inNum+";"+aip+";"+tip+";"+outNum+";"+op+";"+top+";"+nis+";"+apis+";"+tpis);
			
		}

		
	}





}
