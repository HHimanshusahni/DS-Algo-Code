public class Vehicle{
	public String brand;
	protected String model;
	private double price;
	int numWheels;
	int yearOfManufacotor;
	String color;
	//Constructor Example
	public Vehicle(Double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	// Good practice to make variable private and use getter and setter as we can add constraints to the functions 
	public void setPrice(double Price){
		if(price<5000){
			return;
		}
		this.price = price;
	}
	public void printDescription(){
		System.out.println("Vehicle :");
		System.out.println(brand+" "+model+" "+price+" "+numWheels);
	}
	public static void main(String[] args){
		Vehicle v = new Vehicle(5d);
		v.brand  = "Trucker";
		v.model = "800";
		v.numWheels = 8;
		v.setPrice(250000);
		v.price = 9d;
		v.printDescription();


	}

}
