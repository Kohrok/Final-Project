package restaurant;

import java.util.Scanner;

public class ProgramDriver {

	private static Menu menu;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		menu = new Menu();
		startProgram();
		
	}
	
	public static void startProgram(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter a username: ");
        String username = scan.nextLine();
        
        System.out.println("Please enter an ID: ");
        int userID = scan.nextInt();
        
        User currentUser = new User(username, userID);
                
        if (currentUser.isOwner()){
        	menu.displayOwnerMenu();
        }
        else{
        	menu.displayCustomerMenu();
        }
	}

}
