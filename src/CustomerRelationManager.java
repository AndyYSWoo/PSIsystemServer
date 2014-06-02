
public class CustomerRelationManager {

	public void addCustomer(String information) {
		String[] info=information.split(";");
		String name=info[0];
		String phone=info[1];
		Customer nc=new Customer();
		nc.setName(name);
		nc.setPhoneNum(phone);
		PSIControl.customerList.add(nc);
	}

	public void delCustomer(String information) {
		String name=information;
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(name)){
				PSIControl.customerList.remove(cus);
				break;
			}
		}
		
	}

	public void updCustomer(String information) {
		String[] info=information.split(";");
		String name=info[0];
		String phone=info[1];
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(name)){
				cus.setPhoneNum(phone);
				break;
			}
		
		}

	}

	public void finCustomer(String information) {
		String name=information;
		for(Customer cus:PSIControl.customerList){
			if(cus.getName().equals(name)){
				System.out.println(name+";"+cus.getPhoneNum()+";"+cus.getDueIn()+";"+cus.getDueOut()+";"+cus.getTotal());

				break;
			}
		}
		
	}

	public void shoCustomer() {
		for(Customer cus:PSIControl.customerList){
			System.out.println(cus.getName()+";"+cus.getPhoneNum()+";"+cus.getDueIn()+";"+cus.getDueOut()+";"+cus.getTotal());
		}
		
	}
	
}
