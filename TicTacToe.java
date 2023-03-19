import java.util.Scanner;

class TicTacToe {

    private final int BOARD_LENGTH = 3;
    private final String emptyCell = " E ";
    private final String X = " X ";
    private final String O = " O "; 
    private String whoseTurn = " X ";
	private int winStatus = -1;		//	1/0 = X/O
    private String[][] board = new String[BOARD_LENGTH][BOARD_LENGTH];

    TicTacToe() {
        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                board[i][j] = emptyCell;
            }
        }

        whoseTurn = X;
    }

    private void changeTurn() {
        if (whoseTurn == X) {
            whoseTurn = O;
        } else {
            whoseTurn = X;
        }
    }

    public boolean updateBoard(int x, int y) {
        if (x >= BOARD_LENGTH
            || x < 0 
            || y >= BOARD_LENGTH 
            || y < 0) {
                System.out.println("invalid coordinate x: " + x + "y: " + y);
            } 

        if (board[x][y] != emptyCell) {
            System.out.println("invalid move. cell not empty");
			
        } else {
            board[x][y] = whoseTurn;
            changeTurn();
			return true;
			
        }

		return false;
    }

    public void initializeBoard() {
        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                board[i][j] = emptyCell;
            }
        }
        whoseTurn = X;
    }

    public void printBoard() {
        System.out.println("current turn: " + whoseTurn);
        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

	public boolean checkTie(){

		int xCell = 0, oCell = 0, noTie = 0;
		int i, j;

		
		//System.out.println("\ncheckTie start.");
		//row
        for (i=0; i< board.length; i++, xCell = 0, oCell = 0) {
            for (j=0; j< board[i].length; j++) {
               //System.out.print(board[i][j]);
				if(board[i][j].equals(X)){
					xCell ++;
				}else if(board[i][j].equals(O)){
					oCell ++;
				}
            }
            //System.out.printf("\t row (%d) xCell:%d oCell:%d\n",i, xCell, oCell);

			if(xCell == board.length){
				winStatus = 1;
				return false;
			}else if(oCell == board.length){
				winStatus = 0;
				return false;
			}else if(xCell == 0 || oCell == 0){	
				noTie = 1;			
			}

        }

		//column
        for (i=0; i< board.length; i++, xCell = 0, oCell = 0) {
            for (j=0; j< board[i].length; j++) {
                //System.out.print(board[j][i]);
				if(board[j][i].equals(X)){
					xCell ++;
					//System.out.printf("/t xCell:%d\n",xCell);
				}else if(board[j][i].equals(O)){
					oCell ++;
					//System.out.printf("/t oCell:%d\n",oCell);
				}
            }
            //System.out.printf("\t column (%d) xCell:%d oCell:%d\n",i, xCell, oCell);
			if(xCell == board.length){
				winStatus = 1;
				return false;
			}else if(oCell == board.length){
				winStatus = 0;
				return false;
			}else if(xCell == 0 || oCell == 0){	
				noTie = 1;			
			}			
        }
		
		//System.out.println("\nStart left check cross.");

		//cross
		for (i=0, xCell = 0, oCell = 0; i< board.length; i++) {

            //System.out.print(board[i][i]);
			if(board[i][i].equals(X)){
				xCell ++;
			}else if(board[i][i].equals(O)){
				oCell ++;
			}
        }
		//System.out.printf("\t left cross (%d) xCell:%d oCell:%d\n",i, xCell, oCell);
		if(xCell == board.length){
			winStatus = 1;
			return false;
		}else if(oCell == board.length){
			winStatus = 0;
			return false;
		}else if(xCell == 0 || oCell == 0){	
			noTie = 1;			
		}		

		for (i=0, xCell = 0, oCell = 0; i< board.length; i++) {
		
			//System.out.print(board[board.length - i -1][i]);
			if(board[board.length - i - 1][i].equals(X)){
				xCell ++;
			}else if(board[board.length - i -1][i].equals(O)){
				oCell ++;
			}
		
		}
		//System.out.printf("\t right cross (%d) xCell:%d oCell:%d\n",i, xCell, oCell);
		if(xCell == board.length){
			winStatus = 1;
			return false;
		}else if(oCell == board.length){
			winStatus = 0;
			return false;
		}else if(xCell == 0 || oCell == 0){	
			noTie = 1;			
		}		
		
		if(noTie == 1){
			return false;
		}

		return true;

	} 

	public boolean checkWin(){
		String winner = "";
		if(winStatus >= 0){
			winner = (winStatus > 0)? X  : O;
			System.out.printf("\nWinner is %s.\n", winner);
			return true;
		}else{
			System.out.println("\nThere is a change to win.");
		}

		
		return false;
	}

	public void waitPlacepiece(){

		final String COMMAND_INFO = 
			"\nPlease place piece or e(x)it. \n"+
			"  [row][SPACE][column] :\tPlace piece(MIN = 0, MAX = %d)  (exp: 0 2).\n"+
			"  X or x: 		\tExit.\n\n";
		
		final char CHAR01 ='1';		
		
		boolean setStatus = false;
		boolean quitStatus = false;
		String commandType = "";
		char charCommand;
		int xPos = 0, yPos = 0;
		
		String placeRegEx = "^[0-"+ (BOARD_LENGTH - 1) +"][ ][0-" + (BOARD_LENGTH - 1)+"]$";	
		
	    Scanner systemInScanner = new java.util.Scanner(System.in);
		while(quitStatus != true){
			commandType = "";

			System.out.printf(COMMAND_INFO, BOARD_LENGTH - 1);
		
			commandType = systemInScanner.nextLine();
			if(commandType.isEmpty()){
				System.out.println("\nerror: Command is empty");
			}else{

				charCommand = commandType.charAt(0);
				if(charCommand == 'X' ||charCommand == 'x'){
					
					quitStatus = true;
				}else if(commandType.matches(placeRegEx)){
					
					//System.out.println("Command foramt is valid. " + commandType);

					xPos = charCommand - (int)CHAR01 + 1;	
					yPos = commandType.charAt(2) - (int)CHAR01 + 1;	
					
					//System.out.printf("Command foramt xPos %d, yPos %d\n", xPos, yPos);
					setStatus = this.updateBoard(xPos, yPos);


				}else{
					System.out.println("error: Format of Place piece command  is invalid. ");
				}

				//print player info
				if (setStatus){
					this.printBoard();
					if(this.checkTie()){
						System.out.println("\nThe game ended in a tie.");
						
						quitStatus = true;
					}else {
						if(this.checkWin()){
							quitStatus = true;
						}
					}
					setStatus = false;
				}

			} 
			
		}
		
	}
}

class TicTacToeDemo {
    public static void main(String[] args) {
        TicTacToe board = new TicTacToe();
		/*
        board.printBoard();
        board.updateBoard(1, 1);
        board.printBoard();
        board.updateBoard(2, 1);
        board.printBoard();
		*/
		
        board.printBoard();		
		board.waitPlacepiece();

        //board.printBoard();		
			
    }
}