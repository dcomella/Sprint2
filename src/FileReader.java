import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Reads the menu.yml file to populate the menu

public class FileReader {
	

	FileInputStream stream;
	InputStreamReader streamReader;
	BufferedReader in;
	
	File menuFile;
	
	// init function that uses the menu.yml stored in src folder
	public FileReader() {
		this.menuFile = new File("./src/menu.yml");
	}
	
	// get the list of menu items
	public ArrayList<MenuItem> getMenu() {
		
		// creates empty menu item list
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		// tries to locate the menu file, catches an exception if not found
		try {
			stream = new FileInputStream(menuFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// begins to read the file
		streamReader = new InputStreamReader(stream);
		in = new BufferedReader(streamReader);
			
		String line;
		
		// reads one line at a time
		try {
			
			// steps thru each line until end of file
			while ((line = in.readLine()) != null) {
				
				//loops thru each line that starts with id
				if(line.startsWith("id-")) {
					
					//gets the id of the item
					String id = line.replace("id-", "").replace(":", "").strip();
					line = in.readLine();
					
					// gets the name of the item
					String name = line.replace("  name: ", "").strip();
					line = in.readLine();
					
					// gets the cost of the item
					double cost = Double.parseDouble(line.replace("  cost: $", "").strip());
					line = in.readLine();
					
					// gets the description of the item
					String desc = line.replace("  description: ", "").strip();
					
					// creates menu item object with the data from file
					MenuItem item = new MenuItem(id, name, cost, desc);
					
					// adds it to the menu item
					menuItems.add(item);
					
					// cycles loop until end of file ^
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// after end of file has been reached, returns the array list of menu items
		return menuItems;

	}
}
