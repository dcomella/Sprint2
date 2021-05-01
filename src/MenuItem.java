
public class MenuItem {
	
	String id;
	String name;
	double cost;
	String desc;
	
	public MenuItem(String id, String name, double cost, String desc) {
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.desc = desc;
	}
	
	public String getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getDesc() {
		return desc;
	}
	
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
