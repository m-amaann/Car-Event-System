
import java.util.*;

public class Car {

	private String sponsor;
	private int compnum;
	private String brand;
	private Driver driver;
	private Car next;


	//intializing the values
	public Car(Driver driver, String sponsor,int competenumber, String brand)
	{
		this.driver = driver;
		this.compnum = competenumber;
		this.brand = brand;
		this.sponsor= sponsor;
	}
	
	//returns next node
	public Car getNext() {

		return this.next;
	}
	
	//set next
	public void setNext(Car next) {

		this.next=next;
	}
	
	//set and get methods for change the objects initial state 
	public void setBrand(String name) {

		this.brand = name;
	}
	
	public String getBrand() {

		return this.brand;
	}
	
	public void setDriver(Driver driver) {

		this.driver = driver;
	}
	
	public Driver getDriver() {

		return this.driver;
	}
	
	public void setSponsor(String spon) {

		this.sponsor = spon;
	}
	
	public String getSponsor() {

		return this.sponsor;
	}
	
	public void setID(Integer id) {

		this.compnum = id;
	}
	
	public Integer getId() {

		return this.compnum;
	}
	
	
	public void displayCar()
	{
		System.out.println("---------------------------------");
		System.out.println("========= CAR DETAILS ===========");
		System.out.println("BRAND : "+this.getBrand());
		System.out.println("ID : "+this.getId().toString());
		System.out.println("SPONSOR : "+this.getSponsor());
		System.out.println("");
	}

}
