package restaurant;

public class Restaurant {

	private double revenue;			//Revenue for this restaurant
	
	public Restaurant(){
		revenue = 0;
	}
	
	public double getRevenue(){
		
		return revenue;
	}
	
	public void addRevenue(double revenue){
		this.revenue += revenue;
	}
}
