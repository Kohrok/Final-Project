package restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private Scanner scan;							//Used for input of user choices
	private ArrayList<FoodItem> availableFoodItems;	//A list of each type of food that can be changed by the owner
	public static double orderPrice; 				//The current
	
	public Menu(){
		//Populate availableFoodItems with all FoodItem types as default. 
		//Insert them according to their foodID
		int numItems = 7;
		availableFoodItems = new ArrayList<FoodItem>(numItems);
		
		//Since java is ridiculous and I can't set the size on initialization (only capacity), populating with nothing
		for (int i = 0; i < numItems; i++){
			availableFoodItems.add(new FoodItem());			
		}
		HotDog hd = new HotDog();
		availableFoodItems.set(hd.getFoodID(), hd);
		Hamburger h = new Hamburger();
		availableFoodItems.set(h.getFoodID(), h);
		Pizza p = new Pizza();
		availableFoodItems.set(p.getFoodID(), p);
		Drink d = new Drink();
		availableFoodItems.set(d.getFoodID(), d);
		Dessert ds = new Dessert();
		availableFoodItems.set(ds.getFoodID(), ds);
		Salad s = new Salad();
		availableFoodItems.set(s.getFoodID(), s);
		scan = new Scanner(System.in); 				//instantialize the scanner
	}
	
	public void addFoodItem(int foodID){
		//add a food to the available menu, by foodID
	}
	
	public void removeFoodItem(int foodID){
		//remove a food to the available menu, by foodID
		//remember to change every item's foodID
	}
	
	public void displayOwnerMenu(){
		System.out.println("Hello Owner. Please press the number for what you would like to do:");
		System.out.println("1 - View Revenues for this Restaurant");
		System.out.println("2 - View Revenues for all Restaurants");
		System.out.println("3 - Change the Menu");
		int userChoice = scan.nextInt();
		
	}
	
	public void displayCustomerMenu(){
		int userChoice;
		do {
		System.out.println("Please press which food item you'd like to buy. Press 0 to checkout.");
		
		for (FoodItem fi : availableFoodItems){						//Print out the options
			System.out.println(fi.getMenuRepresentation());
		}
		
		userChoice = scan.nextInt();								//Get their choice
		} while (addItem(userChoice));
		
		checkout();
	}
	
	//Returns false if should checkout, true if should continue shopping
	public boolean addItem(int foodID) {
		
		if (foodID > availableFoodItems.size()){
			System.out.println("That's not a valid entry. Try again.");
			return true;
		}
		else if (foodID < 1) {
		return false;
		}
		else {
			availableFoodItems.get(foodID).purchase();
			return true;
		}
		
	}
	
	public void checkout(){
		//Display the price 
		System.out.println("Thanks for eating here. Your order total is " + orderPrice);
		
		//Display the food items purchased
		
		//Go to home screen.
	}
	
	
	
	
}
