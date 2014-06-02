
public class Inventory {

	public void addCommodity(String information) {
		String[] info=information.split(";");
		String name=info[0];
		String mode=info[1];
		double dip=Double.parseDouble(info[2]);
		double dop=Double.parseDouble(info[3]);
		
		Commodity com=new Commodity(name,mode,dip,dop);
		PSIControl.commodityList.add(com);
	}

	public void delCommodity(String information) {
		String[] info=information.split(";");
		//String name=info[0];
		String mode=info[1];
		for(Commodity com:PSIControl.commodityList){
			if(com.getMode().equals(mode)){
				PSIControl.commodityList.remove(com);
				break;
			}
		}
		
	}

	public void finCommodity(String information) {
		for(Commodity com:PSIControl.commodityList){
			String[] info=information.split(";");
			String name=info[0];
			String mode=info[1];
			if(com.getMode().equals(mode)){
				int num=com.getNum();
				double dip=com.getDIP();
				double dop=com.getDOP();
				double lip=com.getLIP();
				double lop=com.getLOP();
			System.out.println(name+";"+mode+";"+num+";"+dip+";"+dop+";"+lip+";"+lop);
			break;
			}
		}
	}

	public void updCommodity(String information) {
		for(Commodity com:PSIControl.commodityList){
			String[] info=information.split(";");
			//String name=info[0];
			String mode=info[1];
			double dip=Double.parseDouble(info[2]);
			double dop=Double.parseDouble(info[3]);
			if(com.getMode().equals(mode)){
				com.setDIP(dip);
				com.setDOP(dop);
				


			break;
			}
		}
	}

	public void shoCommodity() {
		for(Commodity com:PSIControl.commodityList){
				String name=com.getName();
				String mode=com.getMode();
				int num=com.getNum();
				double dip=com.getDIP();
				double dop=com.getDOP();
				double lip=com.getLIP();
				double lop=com.getLOP();
				
			System.out.println(name+";"+mode+";"+num+";"+dip+";"+dop+";"+lip+";"+lop);
			
			}
		}
	}
	

