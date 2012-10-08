package restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	private Scanner scan;							//Used for input of user choices
	private ArrayList<FoodItem> availableFoodItems;	//A list of each type of food that can be changed by the owner
	public static double orderPrice; 				//The current order's price
	private Restaurant restaurant;
	
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
		
		restaurant = new Restaurant();
	}
	
	public void addFoodItem(int foodID){
		//add a food to the available menu, by foodID
		for (FoodItem fi : availableFoodItems){
			if (fi.getFoodID() == foodID){
				fi.setAvailable(true);
			}
		}
		
	}
	
	public void removeFoodItem(int foodID){
		//remove a food to the available menu, by foodID
		//remember to change every item's foodID
		for (FoodItem fi : availableFoodItems){
			if (fi.getFoodID() == foodID){
				fi.setAvailable(false);
			}
		}
	}
	
	public void displayOwnerMenu(){
		
		boolean continueOperations = true;
		while (continueOperations){
		System.out.println("Please press the number for what you would like to do:");
		System.out.println("1 - View revenues for this restaurant");
		System.out.println("2 - View the currently available menu");
		System.out.println("3 - Change the menu");
		int ownerChoice = scan.nextInt();
		
		continueOperations = handleOwnerChoice(ownerChoice);
		}
		
		ProgramDriver.startProgram();
		
	}
	
	public boolean handleOwnerChoice(int ownerChoice){
		
		switch (ownerChoice){
		case 0:
			return false;
		case 1:
			System.out.println("This restaurant's revenue is " + restaurant.getRevenue());
			return true;
		case 2:
			displayAvailableFoodItems();
			return true;
		case 3:
			System.out.println("First, select 1 to add, 2 to remove an item");
			int addRemoveChoice = scan.nextInt();
			System.out.println("Second, select which food item to remove/add");
			displayAllFoodItems();
			int foodItemChoice = scan.nextInt();
			if (addRemoveChoice == 1){
				addFoodItem(foodItemChoice);
			}
			else{
				removeFoodItem(foodItemChoice);
			}
			return true;
			
		}
		return false;
		
	}
	
	public void displayCustomerMenu(){
		
		int userChoice;
		do {
		System.out.println("Please press which food item you'd like to buy. Press 0 to checkout.");
		
		displayAvailableFoodItems();
		
		userChoice = scan.nextInt();								//Get their choice
		} while (addItemToOrder(userChoice));
		
		checkout();
	}
	
	public void displayAvailableFoodItems(){
		
		for (int i = 1; i < availableFoodItems.size(); i++){						
			if (availableFoodItems.get(i).isAvailable())
				System.out.println(availableFoodItems.get(i).getMenuRepresentation());
		}
		
	}
	
	public void displayAllFoodItems(){
		
		for (int i = 1; i < availableFoodItems.size(); i++){						
			System.out.println(availableFoodItems.get(i).getMenuRepresentation());
		}
		
	}
	
	//Returns false if should checkout, true if should continue shopping
	public boolean addItemToOrder(int foodID) {
		
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
		restaurant.addRevenue(orderPrice);
			
		//Start Over
		ProgramDriver.startProgram();
	}
	
	
	
	
}
