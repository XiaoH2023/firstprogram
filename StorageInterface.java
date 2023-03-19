//package storage_example;
import java.util.ArrayList;

interface Storage{
	public void addItem(String itemName);
	public void removeItem(String itemName);
	public void printItems();
	public int getNumItems();
}

class DoraemonStorage implements Storage{
	ArrayList<String> items = new ArrayList<String>();
	
	public void addItem(String itemName){
    	
	    if(items.contains(itemName)){
			
			System.out.printf("Error: The Item (%s) exists. so you can't add it.\n", itemName);
		}else{
		
			items.add(itemName);
		}
	}

	public void removeItem(String itemName){

	    if(items.contains(itemName)){
			
			items.remove(itemName);
			
		}else{
		
			System.out.printf("Error: The Item (%s) don't exist. so you can't remove it.\n", itemName);
		}
	}
	
	public void printItems(){
		if(this.getNumItems() > 0){
			System.out.printf("\nCurrent Number of items is %d. List is as follows.\n", items.size());	
			for(int i = 0; i < items.size(); i++) {
				System.out.println(items.get(i));
			}
	
		}else{
			System.out.printf("\nCurrent Number of items is %d. List is empty.\n\n", items.size());	
		}
	}
	
	public int getNumItems(){
		return items.size();
	}

}

public class StorageInterface{
	public static void main(String[] args) {
		
		DoraemonStorage dStore = new DoraemonStorage();
		/*		*/
		dStore.printItems();

		dStore.removeItem("a01");		//no exit

		//add Items        
		dStore.addItem("a01");
		dStore.addItem("a02");
		dStore.addItem("a03");
		dStore.addItem("a02");		//already exit
		
		//remove Items
		dStore.removeItem("a01");
		dStore.removeItem("a07");		//no exit
		
		dStore.printItems();

		System.out.println("Doraemon Store demo end." );
	}
}