
public class StockEntry {
	private String name=null;
	private String mode=null;
	private int inNum=0;
	private double averageInPrice=0;
	private double totalInPrice=0;
	private int outNum=0;
	private double outPrice=0;
	private double totalOutPrice=0;
	private int numInStock=0;
	private double averagePriceInStock=0;
	private double totalPriceInStock=0;

//setter
	public void setName(String name){
		this.name=name;
	}
	public void setMode(String mode){
		this.mode=mode;
	}
	public void setInNum(int inNum){
		this.inNum=inNum;
	}
	public void setAIP(double AIP){
		this.averageInPrice=AIP;
	}
	public void setTIP(double TIP){
		this.totalInPrice=TIP;
	}//TIP=AIP*INNUM
	public void setOutNum(int outNum){
		this.outNum=outNum;
	}
	public void setOutPrice(double outPrice){
		this.outPrice=outPrice;
	}
	public void setTOP(double TOP){
		this.totalOutPrice=TOP;
	}//TOP=OP*OUTNUM
	public void setNIS(int NIS){
		this.numInStock=NIS;
	}
	public void setAPIS(double APIS){
		this.averagePriceInStock=APIS;
	}
	public void setTPIS(double TPIS){
		this.totalPriceInStock=TPIS;
	}//TOIS=APIS*NIS
	
//getter
	public String getName(){
		return name;
	}
	public String getMode(){
		return mode;
	}
	public int getInNum(){
		return inNum;
	}
	public double getAIP(){
		return averageInPrice;
	}
	public double getTIP(){
		return totalInPrice;
	}
	public int getOutNum(){
		return outNum;
	}
	public double getOutPrice(){
		return outPrice;
	}
	public double getTOP(){
		return totalOutPrice;
	}
	public int getNIS(){
		return numInStock;
	}
	public double getAPIS(){
		return averagePriceInStock;
	}
	public double getTPIS(){
		return totalPriceInStock;
	}
}
