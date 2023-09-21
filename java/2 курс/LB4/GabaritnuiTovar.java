package Spusok;

class GabaritnuiTovar extends DataBaseZO {
	

	private String nameotdela;
	private String name;
	private String cuntry;
	private int retailPrice;
	private String namesource;
	private int h;
	private int x;
	private int y;

    GabaritnuiTovar ( String nameotdela, String name, String cuntry,
			int retailPrice, String namesource, int h, int x, int y) {

    	this.nameotdela = nameotdela;
    	this.name = name;
    	this.cuntry = cuntry;
    	this.retailPrice = retailPrice;
    	this.namesource = namesource;
    	this.h = h;
    	this.h = x;
    	this.h = y;
        
    }
 
    String getname() {
    	return name;
    }
    
    int getretailPrice() {
        return retailPrice;
    }
 
    String getnamesource() {
        return namesource;
    }
 
    @Override
    public String toString() {
        return "Gabaritnui Tovar. " + " Supermarket" + ". department name " + nameotdela +  
        		". product name " + name + ". country of origin " + cuntry + ". Retail price " + 
        		retailPrice + ". The supplier " + namesource + "." + ". Высота: " + h + 
        		", Ширина: " + x + ", Длина: " + y +"\n";
    }
 
}
