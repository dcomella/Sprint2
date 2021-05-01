import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReader {
	

	FileInputStream stream;
	InputStreamReader streamReader;
	BufferedReader in;
	
	File menuFile;
	
	
	public FileReader() {
		this.menuFile = new File("./src/menu.yml");
	}
	
	public ArrayList<MenuItem> getMenu() {

		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		try {
			stream = new FileInputStream(menuFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		streamReader = new InputStreamReader(stream);
		in = new BufferedReader(streamReader);
			
		String line;
		try {
			while ((line = in.readLine()) != null) {
				if(line.startsWith("id-")) {
					String id = line.replace("id-", "").replace(":", "").strip();
					line = in.readLine();
					String name = line.replace("  name: ", "").strip();
					line = in.readLine();
					double cost = Double.parseDouble(line.replace("  cost: $", "").strip());
					line = in.readLine();
					String desc = line.replace("  description: ", "").strip();
					MenuItem item = new MenuItem(id, name, cost, desc);
					menuItems.add(item);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItems;

	}
}
