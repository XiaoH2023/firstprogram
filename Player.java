import java.util.Scanner;
import java.util.Arrays;

class Player{

	final int MAX_EXTRA_POINTS = 50;
	final int FIRST_SKILL_POINT = 10;
	
	final int MAX_SKILL_TYPES = 5;
	final int SKILL_STRENGTH = 1;
	final int SKILL_WILLPOWER = 2;
	final int SKILL_DEXTERITY = 3;
	final int SKILL_CONSTITUTION = 4;
	final int SKILL_LUCK = 5;
	
	private String name;
	private int hunger;
	private String role;
	
	private int extraPoint;
	private int skills[] = new int[MAX_SKILL_TYPES];

	private Scanner systemInScanner;


	public Player(){
		
		name = "";
		role = "fighter";
		hunger = 0;		
		
		extraPoint = MAX_EXTRA_POINTS;
		Arrays.fill(skills, FIRST_SKILL_POINT);	
		
		systemInScanner = new java.util.Scanner(System.in);
	}

	public void printPlayerInfo(){
	
		System.out.println("\nPlayer information ------ \t");
		System.out.println("Name: \t" + name);
		System.out.println("Role: \t" + role);
		System.out.printf("Hunger status: \t%d %%\n", hunger);

		System.out.printf("(%d) Strength: \t\t%d\n",SKILL_STRENGTH, skills[SKILL_STRENGTH-1]);
		System.out.printf("(%d) Willpower: \t\t%d\n",SKILL_WILLPOWER, skills[SKILL_WILLPOWER-1]);
		System.out.printf("(%d) Dexterity: \t\t%d\n" ,SKILL_DEXTERITY, skills[SKILL_DEXTERITY-1]);
		System.out.printf("(%d) Constitution: \t%d\n",SKILL_CONSTITUTION,  skills[SKILL_CONSTITUTION-1]);
		System.out.printf("(%d) Luck: \t\t%d\n" ,SKILL_LUCK,  skills[SKILL_LUCK -1]);
		System.out.println("\nSkill point left: \t" + this.extraPoint);
		/*
		if (extraPoint > 0)
			System.out.println("Skill point left: \t" + this.extraPoint);
		else
			System.out.println();
		*/
	}

	private boolean setName(String name){
				this.name = name;
				return true;

	}

	public void waitSetName(){

		String commandType = "";
		boolean creatNameStatus = false;
		String nameRegEx = "^[A-Za-z0-9]+$";	
		
		while(creatNameStatus == false){
			System.out.println("\nPlease input Player name:");
		
			commandType = systemInScanner.nextLine();
			if(commandType.isEmpty()){
				System.out.println("\nerror: Command is empty.");
			}

			if(commandType.matches(nameRegEx)){
				
				//System.out.println("name:	" + commandType);
				this.setName(commandType);
				this.printPlayerInfo();
				creatNameStatus = true;
				
			}else{
				System.out.println("error: Name foramt is invalid. it should be only letter or number");
			}
			
		}
		
	}
	private boolean setSkillPoint(int skilltype, int point){

		int diff = 0;
	
		if (point < FIRST_SKILL_POINT){
			System.out.printf("error: SkillPoint can not litter than %d\n", FIRST_SKILL_POINT);
			return false;
		}else if(skilltype > MAX_SKILL_TYPES || skilltype <= 0){
			System.out.printf("error: Skilltype %d is invalid\n", skilltype);
			return false;
		}else{
			diff = point - skills[skilltype -1];

			if(diff > extraPoint){
				System.out.printf("error: Current skilltype ( %d ) can not more than (%d + %d)\n", skilltype, skills[skilltype -1] , extraPoint);
				return false;
			}else{
				extraPoint = extraPoint - (point - skills[skilltype -1] );
				skills[skilltype -1] = point;
				return true;
			}		
		}

	}

	public void waitSetSkillPoint(){

		final String COMMAND_INFO = 
			"\nAdjust skill point or E(x)it. Please input Command :\n"+
			"\t[Skill type][SPACE][skill point] :\tAdjust skill point(MIN = %d, MAX = %d)  (exp: 1 15).\n"+
			"\tD or d: 			\tSet to default value.\n"+
			"\tX or x: 			\tQuit.\n\n";
		
		final char CHAR01 ='1';		
		
		boolean setStatus = false;
		boolean quitStatus = false;
		String commandType = "";
		char charCommand;
		int skillType = 0;
		int skillPoint = 0;
		String skillPointString;
		String skillRegEx = "^[1-5][ ][1-" + (MAX_EXTRA_POINTS + FIRST_SKILL_POINT )/10 + "][0-9]$";	
		
	    //Scanner systemInScanner = new java.util.Scanner(System.in);
		while(quitStatus != true){
			commandType = "";

			System.out.printf(COMMAND_INFO, FIRST_SKILL_POINT, FIRST_SKILL_POINT + MAX_EXTRA_POINTS);
		
			commandType = systemInScanner.nextLine();
			if(commandType.isEmpty()){
				System.out.println("\nerror: Command of adjust skill command is empty");
			}else{

				charCommand = commandType.charAt(0);
				if(charCommand == 'X' ||charCommand == 'x'){
					
					quitStatus = true;
				}else if (charCommand == 'D' ||charCommand == 'd'){

					Arrays.fill(skills, FIRST_SKILL_POINT);
					this.extraPoint = MAX_EXTRA_POINTS;
					setStatus = true;
					
				}else if(commandType.matches(skillRegEx)){
					
					//System.out.println("skill command foramt is valid. " + commandType);

					skillType = charCommand - (int)CHAR01 + 1;	

					skillPointString = commandType.substring(2);
					skillPoint = Integer.parseInt(skillPointString);
					setStatus = this.setSkillPoint(skillType, skillPoint);


				}else{
					System.out.println("error: Format of adjust skill command  is invalid. ");
				}

				//print player info
				if (setStatus){
					this.printPlayerInfo();
					setStatus = false;
				}

			} 
			
		}
		
	}

	public void closeSystemInScanner(){
		systemInScanner.close();
	}
	
	public void fight(){
	
	}
	
	public void storeItem(){
	
	}
	
	public void removeItem(){
	
	}

	public void displayItem(){
	
	}
}

class PlayerCreatDemo{
    public static void main(String[] args) {
		
		Player player01 = new Player();
		player01.printPlayerInfo();

		//input name        
		player01.waitSetName();
		
		//adjust skill point
		player01.waitSetSkillPoint();

		player01.closeSystemInScanner();
	
		System.out.println("player create demo end." );
    }
}

