// to check if each row contains the user imputed word
public void search(String inWord){
    //loop through the arrays row length
    for(int i = 0; i < wordPuzzle.length; i++) {
        // loop through the column length in terms of array length
        for(int j = 0; j < wordPuzzle[i].length; j++) {
            if (wordPuzzle[i][j] == inWord.charAt(0)) {
                findRight(wordPuzzle[i]);
                    if(findRight(wordPuzzle[i])){
                        System.out.println(word+" found horizontally at row "+i+" and column "+j+"!");
                    }
                findDown();
                    //if(findRight(wordPuzzle[i])){
                    //    System.out.println(word+" found vertically at row "+i+" and column "+j+"!");
                    //}
                findDiagonal();
                    //if(){
                    //    System.out.println(word+" found diagonally at row "+i+" and column "+j+"!");
                    //}
                // needs to print if the word has been found in the directions
            }
        }
    }
}

public boolean findRight(char[] inArray) {
    String row = new String(inArray);
    boolean wordFlag = false;
    for(int i = 0; i < word.length(); i++){
        if(row.contains(word)) {
           for(int j = 0; j < row.length(); j++){
               if(row.charAt(j) == (word.charAt(0))){
                  String subRow = new String(inArray, j, word.length());
                  if(subRow.contains(word)) {
                     wordFlag = true;
                    } 
                }
            }
        }
    }
    return wordFlag;
} 
Share Improve this question  Follow
asked
Mar 28 '14 at 14:52

user3113722
5●33 bronze badges
Where is word defined? – Mehdi Karamosly Mar 28 '14 at 15:11
In some code above that I didn't include, but basically the code asks the user to input a word that they want to search for, then their input is stored in the word variable. – user3113722 Mar 28 '14 at 17:04 
Add a comment
1 Answer
order by  
Up vote
0
Down vote
Here is example of word search on MxN board in Java. Words can be placed in any direction: Horizontally (from left to righ, from right to left), Vertically(from top to bottom, from bottom to top), Diagonally (any direction).

import java.util.InputMismatchException;

/**
 * Created on 1/21/17.
 */
public class WordSearchPuzzle {

    private int currentChar; // Index of current character searched in word array
    private char word[]; //Searched word

    public boolean wordExists(char board[][], String word) {

        if (word.isEmpty()) {
            throw new InputMismatchException("Searched word can not be empty!");
        }
        this.word = new char[word.length()];
        currentChar = 0;

        for (int a = 0; a < word.length(); a++) {
            word.getChars(0, word.length(), this.word, 0);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (this.word.length != 0 && board[i][j] == this.word[currentChar]) {
                    if (this.word.length == 1) {
                        return true;
                    }

                    if (letterExists(board, i, j, this.word[++currentChar], "N")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "NE")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "E")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "SE")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "S")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "SW")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "W")) {
                        return true;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "NW")) {
                        return true;
                    }
                    //otherwise continue to search from first letter of given word,
                    //starting with some another position in the board
                    currentChar = 0;
                }
            }
        }
        return false;
    }

    public boolean letterExists(char board[][], int i, int j, char letter, String direction) {

        if (i < 0 || i > board.length || j < 0 || j > board.length) {
            throw new IndexOutOfBoundsException("Unable to search for letter " + letter + " with coordinates (" + i + ", " + j + ")");
        }

        currentChar++;//advance search character to next letter in word

        if (i - 1 >= 0 && board[i - 1][j] == letter && direction.equals("N")) { //search N
            if (currentChar == word.length)
                return true;
            return letterExists(board, i - 1, j, word[currentChar], "N");
        } else if (i - 1 >= 0 && j + 1 < board[i].length && board[i - 1][j + 1] == letter && direction.equals("NE")) {//search NE
            if (currentChar == word.length)
                return true;
            return letterExists(board, i - 1, j + 1, word[currentChar], "NE");
        } else if (j + 1 < board[i].length && board[i][j + 1] == letter && direction.equals("E")) { //search E
            if (currentChar == word.length)
                return true;
            return letterExists(board, i, j + 1, word[currentChar], "E");
        } else if (i + 1 < board.length && j + 1 < board[i + 1].length && board[i + 1][j + 1] == letter && direction.equals("SE")) { //search SE
            if (currentChar == word.length)
                return true;
            return letterExists(board, i + 1, j + 1, word[currentChar], "SE");
        } else if (i + 1 < board.length && board[i + 1][j] == letter && direction.equals("S")) {//search S
            if (currentChar == word.length)
                return true;
            return letterExists(board, i + 1, j, word[currentChar], "S");
        } else if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == letter && direction.equals("SW")) { //search SW
            if (currentChar == word.length)
                return true;
            return letterExists(board, i + 1, j - 1, word[currentChar], "SW");
        } else if (j - 1 >= 0 && board[i][j - 1] == letter && direction.equals("W")) { //search W
            if (currentChar == word.length)
                return true;
            return letterExists(board, i, j - 1, word[currentChar], "W");
        } else if (j - 1 >= 0 && i - 1 >= 0 && board[i - 1][j - 1] == letter && direction.equals("NW")) { //search NW
            if (currentChar == word.length)
                return true;
            return letterExists(board, i - 1, j - 1, word[currentChar], "NW");
        }
        return false;
    }

    public static void main(String[] args) {
        char row1[] = {'a', 'm', 'e', 'r' };
        char row2[] = {'m', 'i', 'z', 'g' };
        char row3[] = {'k', 'l', 'b', 'f' };
        char row4[] = {'s', 't', 'o', 'c' };
        char row5[] = {'b', 'a', 'y', 'a' };

        char board[][] = new char[5][4];
        board[0] = row1;
        board[1] = row2;
        board[2] = row3;
        board[3] = row4;
        board[4] = row5;

        WordSearchPuzzle puzzle = new WordSearchPuzzle();
        if (puzzle.wordExists(board, "ezb")) {
            System.out.println("Word exists!");
        } else {
            System.out.println("Word doesn't exist!");
        }
    }
}