import java.io.*;
import java.text.ParseException;

public class Input {
	String input;
	
	public String getInput() throws IOException{
		System.out.println("Please enter the order in proper format,");
		System.out.println("To exit the PSIsystem,please enter EXIT.");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String input = buffer.readLine();
		return input;
	}
	public void analyseInput(String input) throws ParseException{
		String[] inputArray=input.split(":");
		String order=inputArray[0];
		if(order.equals("EXIT")){
			PSIControl.isOver=true;
			System.out.println("SEE YOU!");
		}else if(order.equals("COMMODITY_SHO")){
			PSIControl.inventory.shoCommodity();
		}else if(order.equals("STOCK_SHO")){
			PSIControl.stock.shoStockEntry();
		}else if(order.equals("CUSTOMER_SHO")){
			PSIControl.crm.shoCustomer();
		}else if(order.equals("ACCOUNT_ALL")){
			PSIControl.accounter.allAccount();
		}else if(order.equals("ACCOUNT_DET")){
			PSIControl.accounter.detAccountEntry();
		}else{
			if(inputArray[1]==null){
		
			System.out.println("Wrong Input!Please Try Again.");
			}else{String information=inputArray[1];
		
					if(order.equals("COMMODITY_ADD")){
						PSIControl.inventory.addCommodity(information);
						PSIControl.stock.addItem(information);
						System.out.println("Commodity added successfully!");
			
					}else if(order.equals("COMMODITY_DEL")){
						PSIControl.inventory.delCommodity(information);
						PSIControl.stock.delItem(information);
						System.out.println("Commodity deleted successfully!");
			
					}else if(order.equals("COMMODITY_UPD")){
						PSIControl.inventory.updCommodity(information);
						System.out.println("Commodity updated successfully!");

					}else if(order.equals("COMMODITY_FIN")){
						PSIControl.inventory.finCommodity(information);
						
					}else if(order.equals("IMPORT_ADD")){
						PSIControl.purchase.importAdd(information);
						System.out.println("Import added successfully!");
						
					}else if(order.equals("IMPORT_DEL")){
						PSIControl.purchase.importDel(information);
						System.out.println("Import deleted successfully!");
						
					}else if(order.equals("EXPORT_ADD")){
						PSIControl.sell.exportAdd(information);
						System.out.println("Export added successfully!");
						
					}else if(order.equals("EXPORT_DEL")){
						PSIControl.sell.exportDel(information);
						System.out.println("Export deleted successfully!");
						
					}else if(order.equals("CUSTOMER_ADD")){
						PSIControl.crm.addCustomer(information);
						System.out.println("Customer added successfully!");
						
					}else if(order.equals("CUSTOMER_DEL")){
						PSIControl.crm.delCustomer(information);
						System.out.println("Customer deleted successfully!");
						
					}else if(order.equals("CUSTOMER_UPD")){
						PSIControl.crm.updCustomer(information);
						System.out.println("Customer updated successfully!");
						
					}else if(order.equals("CUSTOMER_FIN")){
						PSIControl.crm.finCustomer(information);
					}else if(order.equals("ACCOUNT_IN")){
						PSIControl.accounter.inAccountEntry(information);
						System.out.println("Account in successfully!");
						
					}else if(order.equals("ACCOUNT_OUT")){
						PSIControl.accounter.outAccountEntry(information);
						System.out.println("Account out successfully!");
						
					}else if(order.equals("ACCOUNT_INI")){
						PSIControl.accounter.iniAccount(information);
						System.out.println("Account initialized successfully!");
						
					}else if(order.equals("IMPORT_SHO")){
						PSIControl.purchase.shoImportEntry(information);
						
					}else if(order.equals("EXPORT_SHO")){
						PSIControl.sell.shoExportEntry(information);
						
					}else{
						System.out.println("Wrong Input! Please try again");
					}
			}
		}
	}
}
