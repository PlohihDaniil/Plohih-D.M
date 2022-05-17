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

public class TestPerson {
	public static void main(String[] args) {
		Person person = new Person("Молочный",6845324,"Молоко","Россия",254,"Кидалово");
		System.out.println(person.toString());
		//System.out.println(person);
		}
}
