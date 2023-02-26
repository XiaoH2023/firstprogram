import java.util.Scanner;

class Box  {
	private Double width; 
	private Double height; 
	private Double depth; 
	
	//private	String[] item;
	final int maxNumber = 10;

	private	int itemNumber = maxNumber;	
	private	String item[]={"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10"};

	public Box() {
		width = 10.0;
		height = 8.0;
		depth = 6.0;

		clearItem();
	}
	

	double volume(){
		Double volume;
		volume = width * height * depth;

		return volume;
	}

	void addItem(String itemName){
		int i;

		if (itemNumber < maxNumber){
			//Search empty place of items
			for(i=0; i< maxNumber; i++){
				if(item[i].isBlank()){
					item[i]	= itemName;
					itemNumber ++;
					i = 99;		
				}	
			}
		}
		else{
			System.out.println("Box is full. Can't Add new item. itemNumber:" + itemNumber);	
		}

	}

	void removeItem(String itemName){
		int i;

		if (itemNumber > 0){
			//Search spec name of items
			for(i=0; i< maxNumber; i++){
				if(item[i].equalsIgnoreCase(itemName)){
					item[i]	= "";
					itemNumber --;
					i = 99;		
				}
				else if(i ==(maxNumber-1)) {
					System.out.println("Can't find the item in Box. itemName inputed:\t" + itemName);

				}	
			}
		}
		else{
			System.out.println("Box is empty. Can't Remove any item. MAX itemNumber:\t" + itemNumber);	
		}

	}
	
	void printItems(){
		int i,invalidItem;
		System.out.println("Box width: " + width + "\theight: " + height +  "\tdepth: " + depth);
		System.out.println("Box volume:\t" + volume());
		System.out.println("Current itemNumber:\t" + itemNumber);
		
		invalidItem = 0;
		for(i=0; (invalidItem < itemNumber && i< maxNumber); i++){
			if(item[i].isEmpty()){
				//System.out.println("Old Item("+ (i+1) +"):  empty\t" + item[i]);
			}
			else{
				invalidItem ++;
				System.out.println("Item("+ invalidItem +"): " + item[i]);
			}	
		}	
	}

	void clearItem(){
		int i;	

		for(i=0; (i< maxNumber); i++){
			item[i]	= "";
		}
		itemNumber = 0;
	}

	boolean validItemName(String name){
		if(name.isEmpty()){
			System.out.println("Please input Valid Item Name and press ENTER:");	
			return false;
		}
		else{
			name = name.trim();	
			System.out.println("Valid Item Name:\t" + name);
			return true;
		}	
	}
}

class MainBoxClass{

	public static void main(String[] args) {
		Box boxObj = new Box();

		String commandType = "";
		char cmd = 'X';
		String itemName = "";
		int addFlag = 0;
		int removeFlag = 0;

		String commandinfo = 
			"Command Types:\n"+
			"A: Add Item \n"+
			"R: Remove Item\n"+
			"P: Print Current items\n"+
			"Q: Quit demo";
				
		//print demo instruction.
		System.out.println(commandinfo);

        //input command        
        Scanner inputScanner = new java.util.Scanner(System.in);

		do{
			System.out.println("\nPlease Input Command Types:");

            commandType = inputScanner.nextLine();
			if(commandType.isEmpty()){
				System.out.println(commandinfo);				
			}
			else {
				switch(commandType){

					case "A":	
						System.out.println("Please input Item name added");
						addFlag = 0;
						while(addFlag != 1){
							itemName = inputScanner.nextLine();
							if (boxObj.validItemName(itemName)){
								boxObj.addItem(itemName.trim());
								addFlag = 1;
							}
						}
						break;
					
					case "R":
						System.out.println("Please input Item name removed");
						removeFlag = 0;
						while(removeFlag != 1){
							itemName = inputScanner.nextLine();
							if (boxObj.validItemName(itemName)){
								boxObj.removeItem(itemName.trim());
								removeFlag = 1;
							}
						}
						break;	
					
					case "P":
						//System.out.println("print method");
						boxObj.printItems();
						break;	
						
					case "Q":
						//System.out.println("quit " );						
						break;
					default:
						System.out.println("Please input Valid CommandType again and press ENTER.");	

				}
				//System.out.println("while last " + commandType + commandType.charAt(0));
				cmd = commandType.charAt(0);
			}
		}while(cmd != 'Q');
			
		inputScanner.close();
		System.out.println("Demo end " );	

	}

}


