package restaurant;

import java.util.Scanner;

public class FoodItem {

	protected String name;
	protected int foodID;
	protected double price;
	protected String notes;			//special requests for the item
	
	
	public  String getName() {
		return name;
	}

	public  void setName(String newName) {
		name = newName;
	}

	public  int getFoodID() {
		return foodID;
	}

	public  void setFoodID(int newFoodID) {
		foodID = newFoodID;
	}

	public  double getPrice() {
		return price;
	}

	public  void setPrice(double newPrice) {
		price = newPrice;
	}

	//This handles any special requests regarding the foodItem (toppings, condiments, etc.)
	public void purchase(){
		
		//Ask the user for notes about the item
		System.out.println("Please enter any special requests regarding your " +
							"food item for our staff to see while they prepare it.");
		Scanner scan = new Scanner(System.in);
		String foodNotes = scan.nextLine();
		notes = foodNotes;
		
		//Add this item's price to the order total
		Menu.orderPrice += price;
		
	}
	
	public String getMenuRepresentation(){
		
		return "" + foodID + " - " + name + " ($" + price + ")";
	}
	
	public String getCheckoutRepresentation(){
		
		return name + " ($" + ") \n\t" + notes; 
		
	}
	
}
