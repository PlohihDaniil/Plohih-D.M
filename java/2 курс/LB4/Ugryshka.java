package Spusok;

class Ugryshka extends DataBaseZO {
	

	private String nameotdela;
	private String name;
	private String cuntry;
	private int retailPrice;
	private String namesource;
	private int vozrastgroup;
	private String typ;

    Ugryshka( String nameotdela, String name, String cuntry, int retailPrice,
    		String namesource, int vozrastgroup, String typ) {

    	this.nameotdela = nameotdela;
    	this.name = name;
    	this.cuntry = cuntry;
    	this.retailPrice = retailPrice;
    	this.namesource = namesource;
    	this.vozrastgroup = vozrastgroup;
    	this.typ = typ;
    }
 
    String getnameotdela() {
    	return nameotdela;
    }
    
    int getretailPrice() {
        return retailPrice;
    }
 
    String getnamesource() {
        return namesource;
    }
 
    @Override
    public String toString() {
        return "Ugryshka. " + " Supermarket" + ". department name " + nameotdela +  
        		". product name " + name + ". country of origin " + cuntry + ". Retail price " + 
        		retailPrice + ". The supplier " + namesource + "." +  " Vozrast groupa: " + vozrastgroup +
        		", “ËÔ: " + typ + "\n";
    }
 
}
