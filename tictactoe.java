import java.util.*;

class tictactoe {

    //This method serves as a driver for the game
    public static void main(String[] args) throws InterruptedException {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String name = scnr.nextLine();
        Thread.sleep(700);
        //ttt(name);
        tttGame game = new tttGame(name);
        game.intro(name);
    }
}









//This class keeps track of game info like the # of CPU wins, user wins, etc. 
//Also runs the game
class tttGame {

    private boolean hasWon;    //Has anyone won? If so, end game
    private int cpuWins;   //Num of CPU wins
    private int userWins;   //Num of user wins
    private String userName;    //Name
    
    public tttGame(String userName) {
        hasWon = false;
        cpuWins = 0;
        userWins = 0;
        userName = userName;
    }
        public String getUserName() {
        return userName;
    }

    public int getCpuWins() {
        return cpuWins;
    }

    public int getUserWins() {
        return userWins;
    }

    public boolean getHasWon() {
        return hasWon;
    }

    public static void generateNewBoard() {
        tttBoard gameBoard = new tttBoard();
    }


    //Introduction method for the user
    public static void intro(String name) throws InterruptedException {
        System.out.println("Welcome to tic tac toe, " + name + "!");
        Thread.sleep(1000);
        int[][] sampleBoard = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("The board is laid out like so: ");
        for (int i = 0; i < sampleBoard.length; i++) {
            
            for (int j = 0; j < sampleBoard.length; j++) {
                System.out.print(sampleBoard[i][j] + " ");
            }
            System.out.println("");
        }
        generateNewBoard();   //Game board has been created.
        Thread.sleep(2000);
        System.out.println("When it is your turn, simply input the number of the space you'd like to place your X on.");
        Thread.sleep(2000);
        System.out.println("Type yes if ready to play. If not, type anything else to quit.");
        Scanner scnr = new Scanner(System.in);
        String userAnswer = scnr.nextLine();
        if (userAnswer.equals("yes") || userAnswer.equals("Yes") || userAnswer.equals("YES")) {
            System.out.println("Perfect! Let's start..");
            //code for starting game
            Thread.sleep(1000);
            game(name);
        } else {
            System.out.println("Too bad. Starting game..");
            //code for starting game
            Thread.sleep(1000);
            game(name);
        }
    }


    //This method will run the game, until user decides they are done
    public static void game(String name) throws InterruptedException {
        tttGame myGame = new tttGame(name);
        myGame.hasWon = false;  //Nobody has won yet
        tttBoard myGameBoard = new tttBoard();  //The gameboard that we will use
        Scanner userMoveInput = new Scanner(System.in);
        //openSpots holds all spots of the board. If user places an X on a spot, we remove it from this list so that it cannot be referenced again this game.
        HashMap<Integer, Boolean> openSpots = new HashMap<>();
        openSpots.put(1, true);
        openSpots.put(2, true);
        openSpots.put(3, true);
        openSpots.put(4, true);
        openSpots.put(5, true);
        openSpots.put(6, true);
        openSpots.put(7, true);
        openSpots.put(8, true);
        openSpots.put(9, true);
        while (!myGame.getHasWon()) {

            myGameBoard.getBoard();
            boolean valid = false;  //In case user inputs non-int
            int input = 0;
        //Convert the user's input into the board's coords
            //This while block ensures that only valid inputs are used
            while (!valid) {
            System.out.println("Where would you like to place an X?");
            try {
                 input = Integer.parseInt(userMoveInput.nextLine());
                 if (input >= 1 && input <= 9) {
                    valid = true; //Input is valid, parseInt does not throw exception
                 } else {
                    System.out.println("Enter a number from 1-9.");
                 }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer from 1-9.");
            }
            
        }

        //In case user selects a spot that is already occupied
        while (openSpots.get(input) == false) {
            System.out.println("This spot is already taken. Please try another spot: ");
            input = Integer.parseInt(userMoveInput.nextLine()); 
        }


        switch(input) {
            case 1:
                myGameBoard.modifyBoard(0, 0, "X");
                myGameBoard.getBoard();
                openSpots.put(1, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }
                break;
            case 2:
                myGameBoard.modifyBoard(0, 1, "X");
                myGameBoard.getBoard();
                openSpots.put(2, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }                                
                break;
            case 3:
                myGameBoard.modifyBoard(0, 2, "X");
                myGameBoard.getBoard();
                openSpots.put(3, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }                
                break;                
            case 4:
                myGameBoard.modifyBoard(1, 0, "X");
                myGameBoard.getBoard();
                openSpots.put(4, false);   
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }
                break;                  
            case 5:
                myGameBoard.modifyBoard(1, 1, "X");
                myGameBoard.getBoard();
                openSpots.put(5, false);

                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }                
                break;                  
            case 6:
                myGameBoard.modifyBoard(1, 2, "X");
                myGameBoard.getBoard();
                openSpots.put(6, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }
                break;                  
            case 7:
                myGameBoard.modifyBoard(2, 0, "X");
                myGameBoard.getBoard();
                openSpots.put(7, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                } 
                break;                 
            case 8:
                myGameBoard.modifyBoard(2, 1, "X");
                myGameBoard.getBoard();
                openSpots.put(8, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }
                break;                  
            case 9:
                myGameBoard.modifyBoard(2, 2, "X");
                myGameBoard.getBoard();
                openSpots.put(9, false);
                if (myGameBoard.checkForWin() == 1) {
                    myGame.hasWon = true;
                }
                break;                  
        }

        Thread.sleep(1000);
        System.out.println("Bot is thinking...");
        Thread.sleep(900);
        //TODO: Write code for Bot to make plays (using random number). Also make code for winning
        int min = 1;
        int max = 9;
        int botPick = (int) (Math.random() * (max - min + 1) + min);
        //If the bot picks a spot that is already occupied
        while (openSpots.get(botPick) == false) {
            botPick = (int) (Math.random() * (max - min + 1) + min);
        }
        switch(botPick) {
            case 1:
                myGameBoard.modifyBoard(0, 0, "O");
                myGameBoard.getBoard();
                openSpots.put(1, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;
            case 2:
                myGameBoard.modifyBoard(0, 1, "O");
                myGameBoard.getBoard();
                openSpots.put(2, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                                
                break;
            case 3:
                myGameBoard.modifyBoard(0, 2, "O");
                myGameBoard.getBoard();
                openSpots.put(3, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;                
            case 4:
                myGameBoard.modifyBoard(1, 0, "O");
                myGameBoard.getBoard();
                openSpots.put(4, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                    
                break;                  
            case 5:
                myGameBoard.modifyBoard(1, 1, "O");
                myGameBoard.getBoard();
                openSpots.put(5, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;                  
            case 6:
                myGameBoard.modifyBoard(1, 2, "O");
                myGameBoard.getBoard();
                openSpots.put(6, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;                  
            case 7:
                myGameBoard.modifyBoard(2, 0, "O");
                myGameBoard.getBoard();
                openSpots.put(7, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;                 
            case 8:
                myGameBoard.modifyBoard(2, 1, "O");
                myGameBoard.getBoard();
                openSpots.put(8, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;                  
            case 9:
                myGameBoard.modifyBoard(2, 2, "O");
                myGameBoard.getBoard();
                openSpots.put(9, false);
                if (myGameBoard.checkForWin() == -1) {
                    myGame.hasWon = true;
                }                
                break;                  
        }        

        //If all spots are taken up and nobody has won, it is a draw
        if (!openSpots.containsValue(true)) {
            myGame.hasWon = true;
        }
        
        //myGameBoard.getBoard();

    }

    if (myGameBoard.checkForWin() == 1) {
        System.out.println(name + " wins!");
    }
    if (myGameBoard.checkForWin() == -1) {
        System.out.println("Bot wins!");
    }
    if (myGameBoard.checkForWin() == 0) {
        System.out.println("Draw!");
    }
}
}










class tttBoard {

    private String[][] board;

    public tttBoard() {
        board = new String[][] {
            {"_", "_", "_"},
            {"_", "_", "_"},
            {"_", "_", "_"}
        };
    }

    public void getBoard() {
        System.out.println("Current board: ");
        for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void clearBoard() {
         for (int i = 0; i < board.length; i++) {
            
            for (int j = 0; j < board.length; j++) {
                board[i][j] = "_";
            }
            System.out.println("");
        }       
    }

    public int checkForWin() {
        //-1 means bot win, 0 means no win, 1 means user win
        int whoWins = 0;
        
        //Check for User win (X)
        if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")) {
            whoWins = 1;
        } 
        
        if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")) { 
            whoWins = 1;
        } 
        if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")) {
            whoWins = 1;
        }  

        if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")) {
            whoWins = 1;
        }
        if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")) {
            whoWins = 1;
        }
        if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")) {
            whoWins = 1;
        } 
        if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
            whoWins = 1;
        } 
        if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
            whoWins = 1;
        }

        //Check for Bot win (O)
        if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")) {
            whoWins = -1;
        } 
        
        if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")) { 
            whoWins = -1;
        } 
        if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")) {
            whoWins = -1;
        }  

        if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")) {
            whoWins = -1;
        }
        if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")) {
            whoWins = -1;
        }
        if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")) {
            whoWins = -1;
        } 
        if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
            whoWins = -1;
        } 
        if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
            whoWins = -1;
        }

        return whoWins;
    }

    public void modifyBoard(int pos1, int pos2, String letter) {
        board[pos1][pos2] = letter;
    }

    }

