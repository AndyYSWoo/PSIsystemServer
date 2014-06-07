import java.io.*;

public class FileOperation {
	
	public void writeCommodity(){
		try{
			FileWriter fw=new FileWriter("commodity.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(Commodity com: PSIControl.commodityList){
			bw.write(com.getName()+";"+com.getMode()+";"+com.getNum()+";"+com.getDIP()+";"+com.getDOP()+";"+com.getLIP()+";"+com.getLOP());
			bw.newLine();
			}
		bw.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	public void writeStock(){
		try{
			FileWriter fw=new FileWriter("stock.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(StockEntry se: PSIControl.stockList){
			bw.write(se.getName()+";"+se.getMode()+";"+se.getInNum()+";"+se.getAIP()+";"+se.getTIP()+";"+se.getOutNum()+";"+se.getOutPrice()+";"+se.getTOP()+";"+se.getNIS()+";"+se.getAPIS()+";"+se.getTPIS());
			bw.newLine();
			}
		bw.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	public void writeImport(){
		try{FileWriter fw=new FileWriter("import.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(ImportEntry ie: PSIControl.importList){
			bw.write(ie.getDate()+";"+ie.getStatus()+";"+ie.getClient()+";"+ie.getName()+";"+ie.getMode()+";"+ie.getNum()+";"+ie.getAP()+";"+ie.getTP());
			bw.newLine();
			}
		bw.close();}catch(IOException e){e.printStackTrace();}
	}
	
	public void writeExport(){
		try{FileWriter fw=new FileWriter("export.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(ExportEntry ee: PSIControl.exportList){
			bw.write(ee.getDate()+";"+ee.getStatus()+";"+ee.getClient()+";"+ee.getName()+";"+ee.getMode()+";"+ee.getNum()+";"+ee.getAP()+";"+ee.getTP());
			bw.newLine();
			}
		bw.close();}catch(IOException e){e.printStackTrace();}
	}

	public void writeCustomer(){
		try{FileWriter fw=new FileWriter("customer.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(Customer cus: PSIControl.customerList){
			bw.write(cus.getName()+";"+cus.getPhoneNum()+";"+cus.getDueIn()+";"+cus.getDueOut()+";"+cus.getTotal());
			bw.newLine();
			}
		bw.close();}catch(IOException e){e.printStackTrace();}
	}
	
	public void writeAccountEntry(){
		try{FileWriter fw=new FileWriter("accountentry.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(AccountEntry ae: PSIControl.accountList){
			bw.write(ae.getDate()+";"+ae.getStatus()+";"+ae.getClient()+";"+ae.getAmount());
			bw.newLine();
			}
		bw.close();}catch(IOException e){e.printStackTrace();}
	}
	
	public void writeAccount(){
		try{FileWriter fw=new FileWriter("accounter.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(Double.toString(PSIControl.accounter.getTDI())+";"+Double.toString(PSIControl.accounter.getTDO())+";"+Double.toString(PSIControl.accounter.getTA()));
		bw.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	public void writeStaff(){
		try{FileWriter fw=new FileWriter("staff.txt",false);
		BufferedWriter bw=new BufferedWriter(fw);
		for(StockStaff stockStaff: PSIControl.stockSList){
			bw.write("StockStaff;"+stockStaff.getName()+";"+stockStaff.getPassword());
			bw.newLine();
		}
		for(SalesStaff salesStaff: PSIControl.salesSList){
			bw.write("SalesStaff;"+salesStaff.getName()+";"+salesStaff.getPassword());
			bw.newLine();
		}
		for(FinancialStaff fiStaff: PSIControl.fSList){
			bw.write("FinancialStaff;"+fiStaff.getName()+";"+fiStaff.getPassword());
			bw.newLine();
		}
		bw.close();
		}catch(IOException e){e.printStackTrace();}
	}
	
	public void fileReader() throws NumberFormatException, IOException{
		{String fileInput;
		
		BufferedReader br = new BufferedReader( new FileReader(new File("commodity.txt")));
		
			while((fileInput=br.readLine())!=null){
				String[] fileArray=fileInput.split(";");
			
				String name=fileArray[0];
				String mode=fileArray[1];
				int num=Integer.parseInt(fileArray[2]);
				double dip=Double.parseDouble(fileArray[3]);
				double dop=Double.parseDouble(fileArray[4]);
				double lip=Double.parseDouble(fileArray[5]);
				double lop=Double.parseDouble(fileArray[6]);
				Commodity com=new Commodity(name,mode,dip,dop);
				com.setNum(num);
				com.setLIP(lip);
				com.setLOP(lop);
				PSIControl.commodityList.add(com);
			
		
			}
			br.close();
		}
		
		{String fileInput;
		
		BufferedReader br = new BufferedReader( new FileReader(new File("stock.txt")));
		
			while((fileInput=br.readLine())!=null){
				String[] fileArray=fileInput.split(";");
			
				String name=fileArray[0];
				String mode=fileArray[1];
				int inNum=Integer.parseInt(fileArray[2]);
				double aip=Double.parseDouble(fileArray[3]);
				double tip=Double.parseDouble(fileArray[4]);
				int outNum=Integer.parseInt(fileArray[5]);
				double aop=Double.parseDouble(fileArray[6]);
				double top=Double.parseDouble(fileArray[7]);
				int nis=Integer.parseInt(fileArray[8]);
				double apis=Double.parseDouble(fileArray[9]);
				double tpis=Double.parseDouble(fileArray[10]);
				StockEntry se=new StockEntry();
				se.setName(name);
				se.setMode(mode);
				se.setInNum(inNum);
				se.setAIP(aip);
				se.setTIP(tip);
				se.setOutNum(outNum);
				se.setOutPrice(aop);
				se.setTOP(top);
				se.setNIS(nis);
				se.setAPIS(apis);
				se.setTPIS(tpis);
				PSIControl.stockList.add(se);
			
			}
			br.close();
		}
		
		{String fileInput;
		
		BufferedReader br = new BufferedReader( new FileReader(new File("import.txt")));
		
			while((fileInput=br.readLine())!=null){
				String[] fileArray=fileInput.split(";");
			
				String date=fileArray[0];
				String status=fileArray[1];
				String client=fileArray[2];
				String name=fileArray[3];
				String mode=fileArray[4];
				int num=Integer.parseInt(fileArray[5]);
				double ap=Double.parseDouble(fileArray[6]);
				double tp=Double.parseDouble(fileArray[7]);
				
				ImportEntry ie=new ImportEntry();
				ie.setName(name);
				ie.setMode(mode);
				ie.setNum(num);
				ie.setAP(ap);
				ie.setTP(tp);
				ie.setDate(date);
				ie.setClient(client);
				ie.setStatus(status);
				PSIControl.importList.add(ie);
			
			}
			br.close();
		}
		
		{String fileInput;
		
		BufferedReader br = new BufferedReader( new FileReader(new File("export.txt")));
		
			while((fileInput=br.readLine())!=null){
				String[] fileArray=fileInput.split(";");
			
				String date=fileArray[0];
				String status=fileArray[1];
				String client=fileArray[2];
				String name=fileArray[3];
				String mode=fileArray[4];
				int num=Integer.parseInt(fileArray[5]);
				double ap=Double.parseDouble(fileArray[6]);
				double tp=Double.parseDouble(fileArray[7]);
				
				ExportEntry ee=new ExportEntry();
				ee.setName(name);
				ee.setMode(mode);
				ee.setNum(num);
				ee.setAP(ap);
				ee.setTP(tp);
				ee.setDate(date);
				ee.setClient(client);
				ee.setStatus(status);
				PSIControl.exportList.add(ee);
			
			}
			br.close();
		}
		
		{String fileInput;
		
		BufferedReader br = new BufferedReader( new FileReader(new File("customer.txt")));
		
			while((fileInput=br.readLine())!=null){
				String[] fileArray=fileInput.split(";");
			
				String name=fileArray[0];
				String phone=fileArray[1];
				double tdi=Double.parseDouble(fileArray[2]);
				double tdo=Double.parseDouble(fileArray[3]);
				double total=Double.parseDouble(fileArray[4]);
				
				Customer cus=new Customer();
				cus.setName(name);
				cus.setPhoneNum(phone);
				cus.setDueIn(tdi);
				cus.setDueOut(tdo);
				cus.setTotal(total);
				PSIControl.customerList.add(cus);
			
			}
			br.close();
		}
		
{String fileInput;
		
		BufferedReader br = new BufferedReader( new FileReader(new File("accountentry.txt")));
		
			while((fileInput=br.readLine())!=null){
				String[] fileArray=fileInput.split(";");
			
				String date=fileArray[0];
				String status=fileArray[1];
				String client=fileArray[2];
				double amount=Double.parseDouble(fileArray[3]);
								
				AccountEntry ae=new AccountEntry();

				ae.setDate(date);
				ae.setClient(client);
				ae.setStatus(status);
				ae.setAmount(amount);
				PSIControl.accountList.add(ae);
			
			}
			br.close();
		}
	

	
	{String fileInput;

		BufferedReader br = new BufferedReader( new FileReader(new File("accounter.txt")));
		fileInput=br.readLine();
		if(fileInput!=null){
			String[] inputArray=fileInput.split(";");
			double tdi=Double.parseDouble(inputArray[0]);
			double tdo=Double.parseDouble(inputArray[1]);
			double total=Double.parseDouble(inputArray[2]);
			PSIControl.accounter.setTDI(tdi);
			PSIControl.accounter.setTDO(tdo);
			PSIControl.accounter.setTA(total);
			br.close();
		}
	}
	
	{String fileInput;
	
	BufferedReader br = new BufferedReader( new FileReader(new File("staff.txt")));
	
		while((fileInput=br.readLine())!=null){
			String[] fileArray=fileInput.split(";");
		
			String ID=fileArray[0];
			String name=fileArray[1];
			String password=fileArray[2];
			if(ID.equals("StockStaff")){
				StockStaff staff=new StockStaff();
				staff.setName(name);
				staff.setPassword(password);
				PSIControl.stockSList.add(staff);
			}
			else if(ID.equals("SalesStaff")){
				SalesStaff staff=new SalesStaff();
				staff.setName(name);
				staff.setPassword(password);
				PSIControl.salesSList.add(staff);
			}
			else if(ID.equals("FinancialStaff")){
				FinancialStaff staff=new FinancialStaff();
				staff.setName(name);
				staff.setPassword(password);
				PSIControl.fSList.add(staff);
			}
		
		}
		br.close();
	}



	}
}
