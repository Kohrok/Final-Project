package restaurant;

public class User {

	private String username;
	private int userID;
	
	public User(String username, int userID){
		this.username = username;
		this.userID = userID;
		
	}
	
	public boolean isOwner(){		
		return (username.equals("OWNER") && userID == 0);		
	}
	
	
}
