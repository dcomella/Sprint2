// MenuItem class


public class MenuItem {
	
	// object variables
	
	// the id of the menu item
	String id;
	
	// the name of the menu item
	String name;
	
	// the cost of the menu item
	double cost;
	
	// the description of the menu item
	String desc;
	
	// init function to create a menu item
	public MenuItem(String id, String name, double cost, String desc) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.desc = desc;
	}
	
	// get menu item id
	public String getID() {
		return id;
	}
	
	// get menu item name
	public String getName() {
		return name;
	}
	
	// get menu item cost
	public double getCost() {
		return cost;
	}
	
	// get menu item description
	public String getDesc() {
		return desc;
	}
	
	// so u can print out the menu item to console if needed (used for debugging)
	@Override
	public String toString() {
		String strItem = "";
		//strItem = "Menu Item Object\n";
		//strItem += "- ID: " + id + "\n";
		strItem += "- Name: " + name + "\n";
		//strItem += "- Cost: $" + cost + "\n";
		//strItem += "- Description: " + desc;
		
		return strItem;
	}
	
}
