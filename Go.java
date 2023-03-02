import java.util.Scanner;

class Go  {
	final int boardLength = 19;
	
	final int blackTurn = 1;
	final int whiteTurn = 0;
	private int stepFinished;
	private int currentTurn ;	
	
	final char charEmpty = '.';
	final char charBlack = '@';	
	final char charWhite = 'O';	
	final char charA = 'A';	
	
	private char charXaxis;
	private char[][] board = new char[boardLength+1][boardLength+1];
	
	public Go() {
		int i,j;
		
		charXaxis = charA;
		currentTurn = blackTurn;
		stepFinished = 0;

		//initialize the go board
		for(i=1; (i <= boardLength ); i++){
			for(j=1; (j <= boardLength ); j++){
				board[i][j] = charEmpty;
			}	
		}	
	}

	private boolean placePiece(char letter, int Number){

		int x = 0;

		//covert letter to number (x-axis index)
		x = letter - (int)charA + 1;
		
		//judge position status	, 	board[y-axis][x-axis]
		if (board[Number][x] == charEmpty){

			//update position status	
			if (currentTurn > whiteTurn){
				board[Number][x] = charBlack;
				currentTurn = whiteTurn;	
			}
			else{
				board[Number][x] = charWhite;
				currentTurn = blackTurn;	
			}

			stepFinished ++;
			return true;			
		}
		else{
			System.out.println("The position: " + letter + Number + " is not empty,  and the move is illegal.");	
			return false;			
		}
		
	}

	public boolean receivePieceXY(String xyCoordinate ){
		char xLetter;
		int yNumber = 0;
		String yString = "";
		boolean placeStatus = false;

		//covert String Coordinate to Letter and Number
		xLetter = xyCoordinate.charAt(0);
		yString = xyCoordinate.substring(1);
		yNumber = Integer.parseInt(yString);

		placeStatus = placePiece(xLetter, yNumber);

		if (placeStatus){
			return true;
		}else{
			return false;
		}

	}

	public void printBoard() {
		int i;
		byte j;

		String NextTurn;
		
		NextTurn = (currentTurn > whiteTurn)? "Black"  : "White";
		System.out.printf("\nFinished Step: %d, Next Turn: %s\n",stepFinished, NextTurn);
		
		for(i= boardLength; i >= -1 ; i--){	
			for(j=1, charXaxis = charA; j <= boardLength ; j++){
				if( i > 0){
					System.out.print(board[i][j] + " ");	
				}else if ( i == 0){
					System.out.print("--");
				}
				else if(i < 0){
					System.out.print(charXaxis + " ");
					charXaxis ++;
				}
			}	

			if (i > 0)
				System.out.printf("| %02d\n",i);
			else
				System.out.println(" ");	
		}

	}


}


class GoDemo {

	public static void main(String[] args) {

		String commandType = "";
		boolean placeStatus = false;
		char cmd = 'X';
		int quitFlag = 0;
		String regEx = "^[A-Sa-s][0-1][0-9]$";	
		String commandinfo = 
			"\nThis is demo of Go game board. Command Types:\n"+
			"[A-S][01-19]:\tplace piece in spec position (exp: j10).\n"+
			"X or x: \tQuit demo";

		//print demo instruction
		System.out.println(commandinfo);

		Go goObj = new Go();
		goObj.printBoard();

		//input command        
        Scanner inputScanner = new java.util.Scanner(System.in);

		do{
			System.out.println("\nPlease input the position where piece will be placed. Input position Format: A01-A19 to S01-S19");
			
			//input the position of piece placed
            commandType = inputScanner.nextLine();

			if(commandType.isEmpty()){
				System.out.println("Input position is empty, Format: A01-A19 to S01-S19:");				
			}
			else if(commandType.matches(regEx)){			//judge whether the XY is valid position format (match regEx)
				commandType = commandType.toUpperCase();
				//System.out.println("commandType: " + commandType);

				//covert position String and Place piece
				placeStatus = goObj.receivePieceXY(commandType);

				//print Borad
				if (placeStatus){
					goObj.printBoard();
				}

			}else{
				cmd = commandType.charAt(0);	
				quitFlag = (cmd == 'X' || cmd == 'x')?1:0;
				
				if(quitFlag == 0){
					//Beyond valid range
					System.out.printf("(%s) is invalid position. Correct Input position Range: A01-A19 to S01-S19.\n", commandType);
				}
				else{
					//Quit Command
					//System.out.println("Quit command" );
				}
			}
		}while(quitFlag == 0);

		inputScanner.close();
		System.out.println("demo end." );
				
	}

}

