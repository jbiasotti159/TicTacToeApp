import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author relkharboutly
 * Author: Jillian Biasotti
 * @date 1/31/2019
 */
public class TTTConsole  {
                                                     
      public static Scanner in = new Scanner(System.in); // the input Scanner
      public static final int HUMAN_PLAYER = 1, COMPUTER_PLAYER = 2;
 
   public static TicTacToe TTTboard = new TicTacToe();
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
      
	   int currentState = TicTacToe.PLAYING;
	   //String userInput;
	   //game loop
	   do {
         TTTboard.printBoard();
         // Print message if game-over
         currentState = TTTboard.checkForWinner();
         /**
          * get player input here and call setMove(). user should input a number between 0-8
          */
         
         if (currentState == ITicTacToe.PLAYING) {
        	 System.out.println("Please enter a position 0-8: ");
             int location = in.nextInt();
             if(location > 8 || location < 0)
             {
            	 System.out.println("Invalid Entry");
             }
             TTTboard.setMove(HUMAN_PLAYER, location);
             
             TTTboard.setMove(COMPUTER_PLAYER, TTTboard.getComputerMove());
         }
         
         if (currentState == ITicTacToe.CROSS_WON) {
            System.out.println("'X' won! Bye!");
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
         } else if (currentState == ITicTacToe.TIE) {
            System.out.println("It's a TIE! Bye!");
            TTTboard.clearBoard();
         }
         
      } while (currentState == ITicTacToe.PLAYING) ; // repeat if not game-over
   }
 
     
}