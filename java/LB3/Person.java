/*
 * Describe the properties, constructor, getters/setters methods, override 
 * the toString() method to output complete information about the object in formatted form:
 * supermarket
 * properties
 * nameotdela
 * productCode
 * name
 * cuntry
 * retailPrice
 * namesource
 */

package com.makotogroup.intro;

public class Person {
	private int productCode;
	private String nameotdela;
	private String name;
	private String cuntry;
	private int retailPrice;
	private String namesource;
	
	
	public Person(String nameotdela,int productCode , String name, String cuntry, int retailPrice, String namesource) {
	this.productCode = productCode;
	this.nameotdela = nameotdela;
	this.name = name;
	this.cuntry = cuntry;
	this.retailPrice = retailPrice;
	this.namesource = namesource;
	}
	
	
	public int getproductCode() {
	return productCode;
	}
	public void setId_studenta(int productCode) {
	this.productCode = productCode;
	}
	public String getnameotdela() {
	return nameotdela;
	}
	public void setFam(String nameotdela) {
	this.nameotdela = nameotdela;
	}
	public String getname() {
	return name;
	}
	public void setname(String name) {
	this.name = name;
	}
	public String getcuntry() {
	return cuntry;
	}
	public void setgroupa(String cuntry) {
	this.cuntry = cuntry;
	}
	public String getnamesource() {
		return namesource;
	}
	public void setpredmet(String namesource) {
		this.namesource = namesource;
	}
	public int getretailPrice() {
		return retailPrice;
	}
	public void setmark(int retailPrice) {
		this.retailPrice = retailPrice;
	}
	
	
	public String toString()
	{
	 return "Супермаркет" + ". Название отдела " + nameotdela + ". Код товара " + productCode + 
	". Наименование товара " + name + ". Страна-производитель " + cuntry + ". Розничная цена " + 
	retailPrice + ". Поставщик " + namesource + ".";
	}
}
