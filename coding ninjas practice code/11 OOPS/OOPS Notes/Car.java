public class Car extends Vehicle{
	private int numDoors;
	String company;
	//Constructor
	public Car(double price){
		super(price);
		numWheels = 4; 
		company = "";
	}
	public int numDoors(){
		return numDoors;
	}

	public void printDescription(){
		System.out.println("Cars Desciption");
		System.out.println("Car:"+company+" "+model+" "+getPrice()+" "+numDoors);

		 // super.printDescription();//This will call Vehicle's printDescription
	}
	public static void main(String[] args){
		Car c = new Car(10d);
		c.printDescription();//This will call car's printDescription
		c.numDoors = 5;
		c.company = "maruti";


		//Overriding ==> runtime polymorphism==>child method call
		Vehicle v1 = new Car(20d);
		v1.printDescription();//Calls Cars method
		int x = v.numDoors();
		// v1.numDoors = 5;	//Compile time error
		// v.company = "badi company";//Compile time error
	}
}