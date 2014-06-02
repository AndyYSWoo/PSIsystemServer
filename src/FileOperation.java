import java.io.*;







public class FileOperation {
	public void fileWriter(){
		try{
			FileWriter fw1=new FileWriter("commodity.txt",false);
			BufferedWriter bw1=new BufferedWriter(fw1);
			for(Commodity com: PSIControl.commodityList){
				bw1.write(com.getName()+";"+com.getMode()+";"+com.getNum()+";"+com.getDIP()+";"+com.getDOP()+";"+com.getLIP()+";"+com.getLOP());
				bw1.newLine();
				}
			bw1.close();

			FileWriter fw2=new FileWriter("stock.txt",false);
			BufferedWriter bw2=new BufferedWriter(fw2);
			for(StockEntry se: PSIControl.stockList){
				bw2.write(se.getName()+";"+se.getMode()+";"+se.getInNum()+";"+se.getAIP()+";"+se.getTIP()+";"+se.getOutNum()+";"+se.getOutPrice()+";"+se.getTOP()+";"+se.getNIS()+";"+se.getAPIS()+";"+se.getTPIS());
				bw2.newLine();
				}
			bw2.close();
			
			FileWriter fw3=new FileWriter("import.txt",false);
			BufferedWriter bw3=new BufferedWriter(fw3);
			for(ImportEntry ie: PSIControl.importList){
				bw3.write(ie.getDate()+";"+ie.getStatus()+";"+ie.getClient()+";"+ie.getName()+";"+ie.getMode()+";"+ie.getNum()+";"+ie.getAP()+";"+ie.getTP());
				bw3.newLine();
				}
			bw3.close();
			
			FileWriter fw4=new FileWriter("export.txt",false);
			BufferedWriter bw4=new BufferedWriter(fw4);
			for(ExportEntry ee: PSIControl.exportList){
				bw4.write(ee.getDate()+";"+ee.getStatus()+";"+ee.getClient()+";"+ee.getName()+";"+ee.getMode()+";"+ee.getNum()+";"+ee.getAP()+";"+ee.getTP());
				bw4.newLine();
				}
			bw4.close();
			
			FileWriter fw5=new FileWriter("customer.txt",false);
			BufferedWriter bw5=new BufferedWriter(fw5);
			for(Customer cus: PSIControl.customerList){
				bw5.write(cus.getName()+";"+cus.getPhoneNum()+";"+cus.getDueIn()+";"+cus.getDueOut()+";"+cus.getTotal());
				bw5.newLine();
				}
			bw5.close();
			
			FileWriter fw6=new FileWriter("accountentry.txt",false);
			BufferedWriter bw6=new BufferedWriter(fw6);
			for(AccountEntry ae: PSIControl.accountList){
				bw6.write(ae.getDate()+";"+ae.getStatus()+";"+ae.getClient()+";"+ae.getAmount());
				bw6.newLine();
				}
			bw6.close();
			

			FileWriter fw9=new FileWriter("accounter.txt",false);
			BufferedWriter bw9=new BufferedWriter(fw9);
			bw9.write(Double.toString(PSIControl.accounter.getTDI())+";"+Double.toString(PSIControl.accounter.getTDO())+";"+Double.toString(PSIControl.accounter.getTA()));
			bw9.close();
			
			}catch(IOException e){
			e.printStackTrace();
		}
		
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



	}
}
