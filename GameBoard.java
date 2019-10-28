public class GameBoard {
    public String[] values;
    public Boolean isOver;
    public String XorO = "X";
    public Integer Turns = 0;

    GameBoard() {
        values = new String[9];
        isOver = false;
        for (int i = 0; i < 9; i++) {
            values[i] = " ";
        }
    }

    public void printBoard() {
        System.out.println("   1   2   3 ");
        System.out.println("A  " + values[0] + " | " + values[1] + " | " + values[2] + " ");
        System.out.println("  ---+---+---");
        System.out.println("B  " + values[3] + " | " + values[4] + " | " + values[5] + " ");
        System.out.println("  ---+---+---");
        System.out.println("C  " + values[6] + " | " + values[7] + " | " + values[8] + " ");
    }

    public Boolean validInput(String checkString) {
        if (checkString.length() != 2) {
            return false;
        }
        String letter = checkString.substring(0, 1);
        String number = checkString.substring(1, 2);
        Integer numberInt = Integer.valueOf(number);
        letter = letter.toUpperCase();
        if (!(letter.equals("A") || letter.equals("B") || letter.equals("C"))) {
            return false;
        }
        if (numberInt < 1 || numberInt > 3) {
            return false;
        }
        return true;
    }

    public Boolean placePiece(String location) {
        Integer placeSpot = 1;
        String letter = location.substring(0, 1);
        String number = location.substring(1, 2);
        letter = letter.toUpperCase();
        Integer numberInt = Integer.valueOf(number);
        placeSpot = numberInt;
        if (letter.equals("B")) {
            placeSpot += 3;
        }
        if (letter.equals("C")) {
            placeSpot += 6;
        }
        if (values[placeSpot - 1] != " ") {
            return false;
        }
        values[placeSpot - 1] = XorO;
        return true;

    }
    public String whoWins(){
        for(int i=0; i<7; i+=3){
            if((values[i].equals(values[i+1])) && values[i+1].equals(values[i+2]) && values[i].equals(values[i+2])){
                if(!(values[i].equals(" "))) {
                    System.out.println(XorO + " wins!");
                    isOver=true;
                    return("Someone Wins");
                }
            }
        }
        for(int i=0; i<3; i++){
            if((values[i].equals(values[i+3])) && values[i+3].equals(values[i+6]) && values[i].equals(values[i+6])){
                if(!(values[i].equals(" "))) {
                    System.out.println(XorO + " wins!");
                    isOver=true;
                    return("Someone Wins");
                }
            }
        }
        if((values[0].equals(values[4])) && values[4].equals(values[8]) && values[0].equals(values[8])) {
            if (!(values[0].equals(" "))) {
                System.out.println(XorO + " wins!");
                isOver = true;
                return("Someone Wins");
            }
        }
        if((values[2].equals(values[4])) && values[4].equals(values[6]) && values[2].equals(values[6])) {
            if (!(values[2].equals(" "))) {
                System.out.println(XorO + " wins!");
                isOver = true;
                return("Someone Wins");
            }
        }
        else if(Turns==9){
            System.out.println("Tie Game!");
            isOver = true;
        }
        return("Someone wins");
    }
}
