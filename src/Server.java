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
			String outMessage="Failure";
			try{
				while((message=reader.readLine())!=null){
					System.out.println("read "+message);
					String[] clientIn=message.split(";");
					if(clientIn[0].equals("StockStaff")){
						for(StockStaff staff:PSIControl.stockSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								outMessage="Success";
								}
							}
						}
					else if(clientIn[0].equals("SalesStaff")){
						for(SalesStaff staff:PSIControl.salesSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								outMessage="Success";
								}
							}
						}
					else if(clientIn[0].equals("StockStaff")){
						for(StockStaff staff:PSIControl.stockSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								outMessage="Success";
								}
							}
						}
					else if(clientIn[0].equals("FinancialStaff")){
						for(FinancialStaff staff:PSIControl.fSList){
							if(staff.getName().equals(clientIn[1])&&staff.getPassword().equals(clientIn[2])){
								outMessage="Success";
								}
							}
						}
					outPut(outMessage);
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
	public void outPut(String message){
		try{
			writer.println(message);
			writer.flush();
			System.out.println(message);
			}catch(Exception ex){ex.printStackTrace();}
	}

}
