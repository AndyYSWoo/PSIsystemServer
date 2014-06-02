import java.io.IOException;
import java.text.ParseException;
import java.util.*;


public class PSIControl {
	public static ArrayList<Commodity> commodityList=new ArrayList<Commodity>();
	public static ArrayList<Customer> customerList=new ArrayList<Customer>();
	public static ArrayList<ImportEntry> importList=new ArrayList<ImportEntry>();
	public static ArrayList<ExportEntry> exportList=new ArrayList<ExportEntry>();
	public static ArrayList<StockEntry> stockList=new ArrayList<StockEntry>();
	public static ArrayList<AccountEntry> accountList=new ArrayList<AccountEntry>();
	

	public static ArrayList<Double> inPriceList=new ArrayList<Double>();
	public static ArrayList<Double> outPriceList=new ArrayList<Double>();
	
	public static boolean isOver=false;

	public static Purchase purchase=new Purchase();
	public static Sell sell=new Sell();
	public static Inventory inventory=new Inventory();
	public static Stock stock=new Stock();
	public static CustomerRelationManager crm=new CustomerRelationManager();
	public static Accounter accounter=new Accounter();
	
	public static void main(String[] args) throws IOException, ParseException{
		FileOperation fo=new FileOperation();
		fo.fileReader();
		
		while(!isOver){
		Input ip=new Input();
		String input=ip.getInput();
		ip.analyseInput(input);
		fo.fileWriter();
		}
		
	}
}
