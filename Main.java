import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        GameBoard Test = new GameBoard();
        System.out.println("Enter the row then the column and press enter. Eg: A1");
        while(Test.isOver == false) {
            Test.printBoard();
            Scanner myScan = new Scanner(System.in);
            String selectSpace = myScan.nextLine();
            if (Test.validInput(selectSpace) == false) {
                System.out.println("Please enter a valid input");
                continue;
            }

            if(!(Test.placePiece(selectSpace))){
                System.out.print("Please enter an unused space.");
                        continue;
            }
            else{
                Test.placePiece(selectSpace);
            }
            Test.Turns++;
            Test.whoWins();
            if(Test.XorO.equals("X")){
                Test.XorO = "O";
            }
            else {
                Test.XorO = "X";
            }

        }
        Test.printBoard();
    }
}
