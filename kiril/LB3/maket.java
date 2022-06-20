

package LB3;

public class maket {
	private String nameCar;
	private int god;
	private int sell;
	private String complex;
	private String strana;
	private int dataSell;
	private String nameMen;
	
	
	public maket(String nameCar, int god, int sell, String complex, String strana, 
			int dataSell, String nameMen) {
	this.nameCar=nameCar;
	this.god=god;
	this.sell=sell;
	this.complex=complex;
	this.strana=strana;
	this.dataSell=dataSell;
	this.nameMen=nameMen;
	
	}
	
	
	public String getnameCar() {
	return nameCar;
	}
	public void setnameCar(String nameCar) {
	this.nameCar = nameCar;
	}
	public int getgod() {
	return god;
	}
	public void setgod(int god) {
	this.god = god;
	}
	public int getsell() {
	return sell;
	}
	public void setsell(int sell) {
	this.sell = sell;
	}
	public String getcomplex() {
	return complex;
	}
	public void setcomplex(String complex) {
	this.complex = complex;
	}
	public String getstrana() {
	return strana;
	}
	public void setstrana(String strana) {
	this.strana = strana;
	}
	public int getdataSell() {
	return dataSell;
	}
	public void setdataSell(int dataSell) {
	this.dataSell = dataSell;
	}
	public String getnameMen() {
		return nameMen;
	}
	public void setnameMen(String nameMen) {
		this.nameMen = nameMen;
	}
	
	public String toString()
	{
	 return "Car" + ". Marka car " + nameCar + ". God vupyska " + god + 
	". Cena prodashu " + sell + ". Komplektaciy " + complex + ". Strana prouzvodstva " + 
	strana + ". Data sell " + dataSell + ". Name pokypately " + nameMen + ".";
	}
}
