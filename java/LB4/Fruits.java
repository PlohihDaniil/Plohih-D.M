package Spusok;

class Fruits extends DataBaseZO {
	

	private String nameotdela;
	private String name;
	private String cuntry;
	private int retailPrice;
	private String namesource;
	private int maxtime;
	private int temperatyra;
	
	

    Fruits( String nameotdela, String name, String cuntry, 
    		int retailPrice, String namesource, int maxtime, int temperatyra) {

    	this.nameotdela = nameotdela;
    	this.name = name;
    	this.cuntry = cuntry;
    	this.retailPrice = retailPrice;
    	this.namesource = namesource;
    	this.maxtime = maxtime;
    	this.temperatyra = temperatyra;
        
    }
 
    int getmaxtime() {
    	return maxtime;
    }
    
    int getretailPrice() {
        return retailPrice;
    }
 
    String getnamesource() {
        return namesource;
    }
 
    @Override
    public String toString() {
        return "Fruits. " + " Supermarket" + ". department name " + nameotdela +  
        		". product name " + name + ". country of origin " + cuntry + ". Retail price " + 
        		retailPrice + ". The supplier " + namesource + "." + " Max time xraneniy: "
        		+ maxtime + ", Temperatyra xraneniy: " + temperatyra + "\n";
    }
 
}
