
public class Commodity {
	private String name=null;
	private String mode=null;
	private int num=0;
	private double defaultInPrice=0;
	private double defaultOutPrice=0;
	private double lastInPrice=0;
	private double lastOutPrice=0;
	
//¹¹ÔìÆ÷
	public Commodity(String name,String mode,double dip,double dop){
		this.name=name;
		this.mode=mode;
		this.num=0;
		this.defaultInPrice=dip;
		this.defaultOutPrice=dop;
		this.lastInPrice=0;
		this.lastOutPrice=0;
	}
	
//getter
	public String getName(){
		return name;
	}
	
	public String getMode(){
		return mode;
	}
	public int getNum(){
		return num;
	}

	public double getLIP(){
		return lastInPrice;
	}
	public double getLOP(){
		return lastOutPrice;
	}
	public double getDIP(){
		return defaultInPrice;
	}
	public double getDOP(){
		return defaultOutPrice;
	}
	
//setter
	public void setName(String name){
		this.name=name;
	}
	public void setMode(String mode){
		this.mode=mode;
	}
	public void setNum(int num){
		this.num=num;
	}
	public void setDIP(double dip){
		this.defaultInPrice=dip;
	}
	public void setDOP(double dop){
		this.defaultOutPrice=dop;
	}
	public void setLIP(double LIP){
		this.lastInPrice=LIP;
	}
	public void setLOP(double LOP){
		this.lastOutPrice=LOP;
	}


}
