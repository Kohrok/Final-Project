package restaurant;

import java.util.Scanner;

public class ProgramDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a username: ");
        String username = scan.nextLine();
        
        System.out.println("Please enter an ID: ");
        int userID = scan.nextInt();
        
        User currentUser = new User(username, userID);
        Menu menu = new Menu();		//May want this static once Owner comes into play
        
        if (currentUser.isOwner()){
        	menu.displayOwnerMenu();
        }
        else{
        	menu.displayCustomerMenu();
        }
		
	}

}
