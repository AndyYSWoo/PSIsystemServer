import java.io.*;
import java.net.*;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Server {
	PrintWriter writer;
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket socket;
		
		public ClientHandler(Socket clientSocket){
			try{
				socket=clientSocket;
				InputStreamReader isReader=new InputStreamReader(socket.getInputStream());
				reader=new BufferedReader(isReader);
			}catch(Exception ex){ex.printStackTrace();}
		}
		@Override
		public void run() {
			String message;

			try{
				while((message=reader.readLine())!=null){
					System.out.println("read "+message);
					String[] clientIn=message.split(":");
					if(clientIn[0].equals("StockStaff")){
						for(StockStaff staff:PSIControl.stockSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								writer.println("Success");
								writer.flush();
								System.out.println(staff.getName()+" Login successfully");
								}
							}
						}
					else if(clientIn[0].equals("SalesStaff")){
						for(SalesStaff staff:PSIControl.salesSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								writer.println("Success");
								writer.flush();
								System.out.println(staff.getName()+" Login successfully");
								}
							}
						}
					else if(clientIn[0].equals("StockStaff")){
						for(StockStaff staff:PSIControl.stockSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								writer.println("Success");
								writer.flush();
								System.out.println(staff.getName()+" Login successfully");
								}
							}
						}
					else if(clientIn[0].equals("FinancialStaff")){
						for(FinancialStaff staff:PSIControl.fSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								writer.println("Login Successfully");
								writer.flush();
								}
							}
						}
					else if(clientIn[0].equals("COMMODITY_SHO")){
							PSIControl.inventory.shoCommodity();
						}else if(clientIn[0].equals("STOCK_SHO")){
							PSIControl.stock.shoStockEntry();
						}else if(clientIn[0].equals("CUSTOMER_SHO")){
							PSIControl.crm.shoCustomer();
						}else if(clientIn[0].equals("ACCOUNT_ALL")){
							PSIControl.accounter.allAccount();
						}else if(clientIn[0].equals("ACCOUNT_DET")){
							PSIControl.accounter.detAccountEntry();
						}else{
							if(clientIn[1]==null){
						
							System.out.println("Wrong Input!Please Try Again.");
							}else{String information=clientIn[1];
						
									if(clientIn[0].equals("COMMODITY_ADD")){
										PSIControl.inventory.addCommodity(information);
										PSIControl.stock.addItem(information);
										PSIControl.fo.writeCommodity();
										PSIControl.fo.writeStock();
										System.out.println("Commodity added successfully!");
										writer.println("Commodity added successfully!");
										writer.flush();
							
									}else if(clientIn[0].equals("COMMODITY_DEL")){
										PSIControl.inventory.delCommodity(information);
										PSIControl.stock.delItem(information);
										PSIControl.fo.writeCommodity();
										PSIControl.fo.writeStock();
										System.out.println("Commodity deleted successfully!");
										writer.println("Commodity deleted successfully!");
										writer.flush();
							
									}else if(clientIn[0].equals("COMMODITY_UPD")){
										PSIControl.inventory.updCommodity(information);
										PSIControl.fo.writeCommodity();
										System.out.println("Commodity updated successfully!");
										writer.println("Commodity updated successfully!");
										writer.flush();

									}else if(clientIn[0].equals("COMMODITY_FIN")){
										PSIControl.inventory.finCommodity(information);
										
									}else if(clientIn[0].equals("IMPORT_ADD")){
										PSIControl.purchase.importAdd(information);
										PSIControl.fo.writeImport();
										PSIControl.fo.writeCustomer();
										PSIControl.fo.writeAccount();
										PSIControl.fo.writeStock();
										PSIControl.fo.writeCommodity();
										System.out.println("Import added successfully!");
										writer.println("Import added successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("IMPORT_DEL")){
										PSIControl.purchase.importDel(information);
										PSIControl.fo.writeImport();
										PSIControl.fo.writeCustomer();
										PSIControl.fo.writeAccount();
										PSIControl.fo.writeStock();
										PSIControl.fo.writeCommodity();
										System.out.println("Import deleted successfully!");
										writer.println("Import deleted successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("EXPORT_ADD")){
										PSIControl.sell.exportAdd(information);
										PSIControl.fo.writeExport();
										PSIControl.fo.writeCustomer();
										PSIControl.fo.writeAccount();
										PSIControl.fo.writeStock();
										PSIControl.fo.writeCommodity();
										System.out.println("Export added successfully!");
										writer.println("Export added successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("EXPORT_DEL")){
										PSIControl.sell.exportDel(information);
										PSIControl.fo.writeExport();
										PSIControl.fo.writeCustomer();
										PSIControl.fo.writeAccount();
										PSIControl.fo.writeStock();
										PSIControl.fo.writeCommodity();
										System.out.println("Export deleted successfully!");
										writer.println("Export deleted successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("CUSTOMER_ADD")){
										PSIControl.crm.addCustomer(information);
										PSIControl.fo.writeCustomer();
										System.out.println("Customer added successfully!");
										writer.println("Customer added successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("CUSTOMER_DEL")){
										PSIControl.crm.delCustomer(information);
										PSIControl.fo.writeCustomer();
										System.out.println("Customer deleted successfully!");
										writer.println("Customer deleted successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("CUSTOMER_UPD")){
										PSIControl.crm.updCustomer(information);
										PSIControl.fo.writeCustomer();
										System.out.println("Customer updated successfully!");
										writer.println("Customer updated successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("CUSTOMER_FIN")){
										PSIControl.crm.finCustomer(information);
									}else if(clientIn[0].equals("ACCOUNT_IN")){
										PSIControl.accounter.inAccountEntry(information);
										PSIControl.fo.writeAccountEntry();
										PSIControl.fo.writeAccount();
										PSIControl.fo.writeCustomer();
										System.out.println("Account in successfully!");
										writer.println("Account in successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("ACCOUNT_OUT")){
										PSIControl.accounter.outAccountEntry(information);
										PSIControl.fo.writeAccountEntry();
										PSIControl.fo.writeAccount();
										PSIControl.fo.writeCustomer();
										System.out.println("Account out successfully!");
										writer.println("Account out successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("ACCOUNT_INI")){
										PSIControl.accounter.iniAccount(information);
										PSIControl.fo.writeAccount();
										System.out.println("Account initialized successfully!");
										writer.println("Account initialized successfully!");
										writer.flush();
										
									}else if(clientIn[0].equals("IMPORT_SHO")){
										PSIControl.purchase.shoImportEntry(information);
									}else if(clientIn[0].equals("EXPORT_SHO")){
										PSIControl.sell.shoExportEntry(information);

									}
							}
					
					}
							}
				}catch(Exception ex){ex.printStackTrace();}
			
		}
	}
	public  void go(){
		try{
			ServerSocket serverSocket=new ServerSocket(5000);
			while(true){
				Socket clientSocket=serverSocket.accept();
				writer=new PrintWriter(clientSocket.getOutputStream());
				
				Thread t=new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connnection");
			}
		}catch(Exception ex){ex.printStackTrace();}
	}
/*	public void outPut(String message){
		try{
			writer.println(message);
			writer.flush();
			System.out.println(message);
			}catch(Exception ex){ex.printStackTrace();}
	}*/

}
